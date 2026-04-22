CREATE TABLE comments (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    content TEXT NOT NULL,
    author_id INT NOT NULL,
    topic_id INT NOT NULL,
    created_at TIMESTAMP NOT NULL
);