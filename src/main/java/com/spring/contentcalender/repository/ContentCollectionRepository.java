package com.spring.contentcalender.repository;

import com.spring.contentcalender.model.Content;
import com.spring.contentcalender.model.Status;
import com.spring.contentcalender.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentlist = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findall(){
        return contentlist;
    }

    public Optional<Content> findby(Integer Id){
        return contentlist.stream().filter(c -> c.Id().equals(Id)).findFirst();
    }

    public void save(Content content){
        contentlist.removeIf(c->c.Id().equals(content.Id()));
        contentlist.add(content);
    }
    @PostConstruct
    public void init(){
        Content c = new Content(1,
                "My first blog post",
                "My first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");
        contentlist.add(c);
    }
    public boolean existbyId(Integer id) {
        return contentlist.stream().filter(c -> c.Id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contentlist.removeIf(c->c.Id().equals(id));
    }
}