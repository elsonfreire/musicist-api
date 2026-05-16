CREATE TYPE learning_status_type AS ENUM ('to_learn', 'learning', 'learned');
CREATE TYPE difficulty_type AS ENUM ('easy', 'medium', 'hard');

CREATE TABLE songs
(
    id         UUID                 NOT NULL PRIMARY KEY,
    user_id    UUID                 NOT NULL,
    status     learning_status_type NOT NULL,
    title      VARCHAR(100)         NOT NULL,
    artist     VARCHAR(100)         NOT NULL,
    difficulty difficulty_type      NOT NULL,
    created_at TIMESTAMP            NOT NULL
)