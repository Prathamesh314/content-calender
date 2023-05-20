package com.spring.contentcalender.controller;

import com.spring.contentcalender.model.Content;
import com.spring.contentcalender.repository.ContentCollectionRepository;
import com.spring.contentcalender.repository.ContentRepository;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {
//    private final ContentCollectionRepository repository;
	private final ContentRepository repository;
    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }
    @GetMapping("")
    public List<Content> findall(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findbyid(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Content Not Found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content){
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id){
            if(!repository.existsById(id))
            {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found! ");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer Id){
        repository.deleteById(Id);
    }
}
