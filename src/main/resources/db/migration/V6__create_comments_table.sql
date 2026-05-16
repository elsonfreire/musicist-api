CREATE TABLE comments
(
    id         UUID      NOT NULL PRIMARY KEY,
    content    TEXT      NOT NULL,
    author_id  INT       NOT NULL,
    topic_id   INT       NOT NULL,
    created_at TIMESTAMP NOT NULL
);