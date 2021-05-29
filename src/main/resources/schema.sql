CREATE TABLE IF NOT EXISTS post(
    id identity,
    title varchar(25) not null,
    post_text TEXT(1000) not null
);
