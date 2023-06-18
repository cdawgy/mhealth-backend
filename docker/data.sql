CREATE DATABASE IF NOT EXISTS MHEALTH;

USE MHEALTH;

CREATE TABLE accounts(
    id int NOT NULL AUTO_INCREMENT,
    google_id VARCHAR(255) NOT NULL,
    account_type VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE therapists(
    id int NOT NULL AUTO_INCREMENT,
    google_id VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE children(
    id int NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    points int NOT NULL,
    parent_id int REFERENCES parents(id),
    PRIMARY KEY(id)
);

CREATE TABLE parents(
    id int NOT NULL AUTO_INCREMENT,
    google_id VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    child_id int REFERENCES children(id),
    therapist_id int REFERENCES therapists(id),
    PRIMARY KEY(id)
);

CREATE TABLE awards(
    id int NOT NULL AUTO_INCREMENT,
    parent_id int REFERENCES parents(id),
    title VARCHAR (255) NOT NULL,
    cost int NOT NULL,
    PRIMARY KEY(id)
);

-- Need to revisit this for storage of content, 255 is too small
-- Think I will break each topic into its own block to store?
CREATE TABLE resources(
    id int NOT NULL AUTO_INCREMENT,
    title VARCHAR (255) NOT NULL,
    content VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE sounds(
    id int NOT NULL AUTO_INCREMENT,
    child_id int REFERENCES children(id),
    sound VARCHAR (255) NOT NULL,
    word VARCHAR (255) NOT NULL,
    location_url VARCHAR (255) NOT NULL,
    date_created datetime default NOW(),
    PRIMARY KEY(id)
);

CREATE TABLE messages(
    id int NOT NULL AUTO_INCREMENT,
    parent_id int REFERENCES parents(id),
    resource_id int REFERENCES resources(id),
    message_body VARCHAR(255) NOT NULL,
    read_state VARCHAR(10) default "notRead",
    PRIMARY KEY(id)
);

CREATE TABLE words(
    id int NOT NULL AUTO_INCREMENT,
    word VARCHAR(255) NOT NULL,
    phonemes VARCHAR(255) NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

-- conorloughran99 account
INSERT INTO accounts(google_id, account_type) VALUES ("117961479542614585037", "parent");
-- mhealth account
INSERT INTO accounts(google_id, account_type) VALUES ("109020841686505071523", "therapist");

-- Data for therapist account
INSERT INTO therapists(google_id, first_name, surname) VALUES ("109020841686505071523", "Dylan", "McDonnell");

-- Child account for above parent
INSERT INTO children(first_name, points, parent_id) VALUES ("Sam", 2, 1);

-- Parent account
INSERT INTO parents(google_id, first_name, surname, child_id, therapist_id) VALUES ("117961479542614585037", "Conor", "Loughran", 1, 1);

-- Resources
INSERT INTO resources(title, content) VALUES ("Some Resource 1", "This is the content of the resource");
INSERT INTO resources(title, content) VALUES ("Some Resource 2", "This is the content of the resource");

-- Sound Clips
INSERT INTO sounds(child_id, sound, word, location_url) VALUES (1, "ee", "Tea", "https://mhealthstorageaccount.blob.core.windows.net/sound-store/d720ca41-d80c-4afa-8414-5a46ec234590");
INSERT INTO sounds(child_id, sound, word, location_url) VALUES (1, "ee", "Pea", "https://mhealthstorageaccount.blob.core.windows.net/sound-store/d720ca41-d80c-4afa-8414-5a46ec234590");
INSERT INTO sounds(child_id, sound, word, location_url) VALUES (1, "ø", "Soap", "https://mhealthstorageaccount.blob.core.windows.net/sound-store/d720ca41-d80c-4afa-8414-5a46ec234590");
INSERT INTO sounds(child_id, sound, word, location_url) VALUES (1, "ø", "Pope", "https://mhealthstorageaccount.blob.core.windows.net/sound-store/d720ca41-d80c-4afa-8414-5a46ec234590");

-- Awards
INSERT INTO awards(parent_id, title, cost) VALUES (1, "Go to cinema", 7);
INSERT INTO awards(parent_id, title, cost) VALUES (1, "Go to toy store", 7);
INSERT INTO awards(parent_id, title, cost) VALUES (1, "Go to park", 5);
INSERT INTO awards(parent_id, title, cost) VALUES (1, "1 hour on games", 3);
INSERT INTO awards(parent_id, title, cost) VALUES (1, "coca cola & chocolate", 3);

-- Words
-- Velar Fronting
-- /k/ vs /t/
INSERT INTO words(word, phonemes, image_url) VALUES ("call", "/k/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("tall", "/t/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("can", "/k/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("tan", "/t/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("cape", "/k/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("tape", "/t/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("cap", "/k/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("tap", "/t/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("car", "/k/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("tar", "/t/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("cool", "/k/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("tool", "/t/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("core", "/k/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("tore", "/t/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("key", "/k/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("tea", "/t/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("kick", "/k/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("tick", "/t/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("kite", "/k/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("tight", "/t/", "");

-- /k/ and /g/ vs /d/ and /g/
INSERT INTO words(word, phonemes, image_url) VALUES ("bad", "/d/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("bag", "/g/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("bike", "/k/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("bite", "/t/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("coat", "/k/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("coke", "/k/", "");

-- Stopping of Fricatives
-- /f/ vs /b/
INSERT INTO words(word, phonemes, image_url) VALUES ("fair", "/f/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("bear", "/b/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("fig", "/f/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("big", "/b/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("phone", "/f/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("bone", "/b/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("fox", "/f/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("box", "/b/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("fun", "/f/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("bun", "/b/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("foal", "/f/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("bowl", "/b/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("fat", "/f/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("bat", "/b/", "");

------ /f/ vs /p/
INSERT INTO words(word, phonemes, image_url) VALUES ("pig", "/p/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("fin", "/f/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("pin", "/p/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("fan", "/f/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("pan", "/p/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("pole", "/p/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("fur", "/f/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("purr", "/p/", "");

-- /s/ vs /d/
INSERT INTO words(word, phonemes, image_url) VALUES ("sore", "/s/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("door", "/d/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("sea", "/s/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("dee", "/d/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("sew", "/s/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("dough", "/d/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("suck", "/s/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("duck", "/d/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("sock", "/s/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("dock", "/d/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("cee", "/s/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("dee", "/d/", "");

-- /s/ vs /t/
INSERT INTO words(word, phonemes, image_url) VALUES ("toe", "/t/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("tail", "/t/", "");
INSERT INTO words(word, phonemes, image_url) VALUES ("tower", "/t/", "");