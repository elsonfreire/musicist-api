CREATE TYPE friendship_status_type AS ENUM ('PENDING', 'ACCEPTED', 'BLOCKED');

CREATE TABLE friendships (
     id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
     requester_id INT NOT NULL REFERENCES users(id),
     receiver_id INT NOT NULL REFERENCES users(id),
     status friendship_status_type NOT NULL DEFAULT 'PENDING',
     created_at TIMESTAMP NOT NULL,
     CONSTRAINT check_no_self_friendship CHECK (requester_id <> receiver_id)
);

CREATE UNIQUE INDEX unique_friendship_pair
    ON friendships (LEAST(requester_id, receiver_id), GREATEST(requester_id, receiver_id));