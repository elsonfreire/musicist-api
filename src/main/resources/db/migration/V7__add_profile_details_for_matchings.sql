
CREATE TYPE music_genre_type AS ENUM (
    'ROCK', 'POP', 'METAL', 'JAZZ', 'CLASSICAL', 'BLUES', 
    'ELECTRONIC', 'HIP_HOP', 'RNB', 'COUNTRY', 'REGGAE', 
    'FUNK', 'INDIE', 'OTHER'
);

CREATE TYPE interest_type AS ENUM (
    'FORM_A_BAND', 'CASUAL_JAM', 'LEARN_TOGETHER', 
    'PRODUCE', 'MAKE_FRIENDS'
);

ALTER TABLE users ADD COLUMN city VARCHAR(100);
ALTER TABLE users ADD COLUMN state VARCHAR(100);
ALTER TABLE users ADD COLUMN favorite_genre music_genre_type;

CREATE TABLE user_interests (
    user_id INT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    interest interest_type NOT NULL,
    
    CONSTRAINT pk_user_interests PRIMARY KEY (user_id, interest)
);