CREATE TABLE users (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password_hash TEXT NOT NULL,  
    instrument VARCHAR(100),
    level SMALLINT,
    bio TEXT,
    created_at TIMESTAMP NOT NULL
);