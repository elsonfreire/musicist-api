CREATE TYPE goal_status_type AS ENUM ('pending', 'completed', 'rejected', 'expired');

CREATE TABLE goals
(
    id           UUID             NOT NULL PRIMARY KEY,
    user_id      UUID             NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    title        VARCHAR(255)     NOT NULL,
    status       goal_status_type NOT NULL DEFAULT 'pending',
    created_at   TIMESTAMP        NOT NULL,
    concluded_at TIMESTAMP,
    updated_at   TIMESTAMP        NOT NULL
)