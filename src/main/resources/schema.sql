CREATE TABLE IF NOT EXISTS post(
    id identity,
    title varchar(255) not null,
    image_url varchar(255) not null,
    post_text TEXT(1000) not null,
    rating integer not null,
    author varchar(25) not null
);

CREATE TABLE IF NOT EXISTS comment(
    id identity,
    author varchar(25) not null,
    content TEXT(1000) not null,
    post_id int default 0,
    foreign key (post_id) references post(id)
);
