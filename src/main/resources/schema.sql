CREATE TABLE IF NOT EXISTS Content(
    id INTEGER AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    desc text,
    status varchar(20) NOT NULL,
    content_type varchar(50) NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    url varchar(255),
    primary key(id)
);

INSERT INTO Content(title,desc,status,content_type,date_created)
VALUES('My first Spring database','A post about Spring data','IDEA','ARTICLE',CURRENT_TIMESTAMP)