CREATE TYPE instrument_type AS ENUM ('electric_guitar', 'piano', 'bass', 'drums', 'guitar', 'violin', 'other');
CREATE TYPE level_type AS ENUM ('beginner', 'intermediate', 'advanced', 'pro');

CREATE TABLE users (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password_hash TEXT NOT NULL,  
    instrument instrument_type,
    level level_type,
    bio TEXT,
    created_at TIMESTAMP NOT NULL
);