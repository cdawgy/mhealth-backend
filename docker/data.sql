create DATABASE IF NOT EXISTS MHEALTH;

USE MHEALTH;

create TABLE accounts(
    id int NOT NULL AUTO_INCREMENT,
    google_id VARCHAR(255) NOT NULL,
    account_type VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

create TABLE therapists(
    id int NOT NULL AUTO_INCREMENT,
    google_id VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

create TABLE children(
    id int NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    points int NOT NULL,
    parent_id int REFERENCES parents(id),
    PRIMARY KEY(id)
);

create TABLE parents(
    id int NOT NULL AUTO_INCREMENT,
    google_id VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    child_id int REFERENCES children(id),
    therapist_id int REFERENCES therapists(id),
    PRIMARY KEY(id)
);

create TABLE awards(
    id int NOT NULL AUTO_INCREMENT,
    parent_id int REFERENCES parents(id),
    title VARCHAR (255) NOT NULL,
    cost int NOT NULL,
    PRIMARY KEY(id)
);

-- Need to revisit this for storage of content, 255 is too small
-- Think I will break each topic into its own block to store?
create TABLE resources(
    id int NOT NULL AUTO_INCREMENT,
    title VARCHAR (255) NOT NULL,
    content LONGTEXT NOT NULL,
    PRIMARY KEY(id)
);

create TABLE sounds(
    id int NOT NULL AUTO_INCREMENT,
    child_id int REFERENCES children(id),
    sound VARCHAR (255) NOT NULL,
    word VARCHAR (255) NOT NULL,
    location_url VARCHAR (255) NOT NULL,
    date_created datetime default NOW(),
    PRIMARY KEY(id)
);

create TABLE messages(
    id int NOT NULL AUTO_INCREMENT,
    parent_id int REFERENCES parents(id),
    resource_id int REFERENCES resources(id),
    message_body VARCHAR(255) NOT NULL,
    read_state VARCHAR(10) default "notRead",
    PRIMARY KEY(id)
);

create TABLE words(
    id int NOT NULL AUTO_INCREMENT,
    word VARCHAR(255) NOT NULL,
    phonemes VARCHAR(255) NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

create TABLE prescriptions(
    id int NOT NULL AUTO_INCREMENT,
    parent_id int REFERENCES parents(id),
    therapist_id int REFERENCES therapists(id),
    session_time int NOT NULL,
    session_word_count int NOT NULL,
    session_word_set VARCHAR(255) NOT NULL,
    session_word_set_title VARCHAR(255) NOT NULL,
    date_created datetime default NOW(),
    PRIMARY KEY(id)
);

-- conorloughran99 account
insert into accounts(google_id, account_type) values ("117961479542614585037", "parent");
-- mhealth account
insert into accounts(google_id, account_type) values ("109020841686505071523", "therapist");

-- Data for therapist account
insert into therapists(google_id, first_name, surname) values ("109020841686505071523", "Dylan", "McDonnell");

-- Child account for above parent
insert into children(first_name, points, parent_id) values ("Sam", 2, 1);

-- Parent account
insert into parents(google_id, first_name, surname, child_id, therapist_id) values ("117961479542614585037", "Conor", "Loughran", 1, 1);

-- Resources
insert into resources(title, content) values ("Some Resource 1", "This is the content of the resource");
insert into resources(title, content) values ("Some Resource 2", "This is the content of the resource");

-- Sound Clips
insert into sounds(child_id, sound, word, location_url) values (1, "ee", "Tea", "https://mhealthstorageaccount.blob.core.windows.net/sound-store/d720ca41-d80c-4afa-8414-5a46ec234590");
insert into sounds(child_id, sound, word, location_url) values (1, "ee", "Pea", "https://mhealthstorageaccount.blob.core.windows.net/sound-store/d720ca41-d80c-4afa-8414-5a46ec234590");
insert into sounds(child_id, sound, word, location_url) values (1, "ø", "Soap", "https://mhealthstorageaccount.blob.core.windows.net/sound-store/d720ca41-d80c-4afa-8414-5a46ec234590");
insert into sounds(child_id, sound, word, location_url) values (1, "ø", "Pope", "https://mhealthstorageaccount.blob.core.windows.net/sound-store/d720ca41-d80c-4afa-8414-5a46ec234590");

-- Awards
insert into awards(parent_id, title, cost) values (1, "Go to cinema", 7);
insert into awards(parent_id, title, cost) values (1, "Go to toy store", 7);
insert into awards(parent_id, title, cost) values (1, "Go to park", 5);
insert into awards(parent_id, title, cost) values (1, "1 hour on games", 3);
insert into awards(parent_id, title, cost) values (1, "coca cola & chocolate", 3);

-- Words
-- Velar Fronting
-- /k/ vs /t/
insert into words(word, phonemes, image_url) values ("call", "/k/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/call.jpg");
insert into words(word, phonemes, image_url) values ("tall", "/t/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/tall.jpg");
insert into words(word, phonemes, image_url) values ("can", "/k/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/can.jpg");
insert into words(word, phonemes, image_url) values ("tan", "/t/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/tan.jpg");
insert into words(word, phonemes, image_url) values ("cape", "/k/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/cape.jpg");
insert into words(word, phonemes, image_url) values ("tape", "/t/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/tape.jpg");
insert into words(word, phonemes, image_url) values ("cap", "/k/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/cap.jpg");
insert into words(word, phonemes, image_url) values ("tap", "/t/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/tap.jpg");
insert into words(word, phonemes, image_url) values ("car", "/k/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/car.jpg");
insert into words(word, phonemes, image_url) values ("tar", "/t/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/tar.jpg");
insert into words(word, phonemes, image_url) values ("cool", "/k/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/cool.jpg");
insert into words(word, phonemes, image_url) values ("tool", "/t/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/tool.jpg");
insert into words(word, phonemes, image_url) values ("core", "/k/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/core.jpg");
insert into words(word, phonemes, image_url) values ("tore", "/t/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/tore.jpg");
insert into words(word, phonemes, image_url) values ("key", "/k/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/key.jpg");
insert into words(word, phonemes, image_url) values ("tea", "/t/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/tea.jpg");
insert into words(word, phonemes, image_url) values ("kick", "/k/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/kick.jpg");
insert into words(word, phonemes, image_url) values ("tick", "/t/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/tick.jpg");
insert into words(word, phonemes, image_url) values ("kite", "/k/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/kite.jpg");
insert into words(word, phonemes, image_url) values ("tight", "/t/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/tight.jpg");

-- /k/ and /g/ vs /d/ and /g/
insert into words(word, phonemes, image_url) values ("bad", "/d/", "");
insert into words(word, phonemes, image_url) values ("bag", "/g/", "");
insert into words(word, phonemes, image_url) values ("bike", "/k/", "");
insert into words(word, phonemes, image_url) values ("bite", "/t/", "");
insert into words(word, phonemes, image_url) values ("coat", "/k/", "");
insert into words(word, phonemes, image_url) values ("coke", "/k/", "");

-- Stopping of Fricatives
-- /f/ vs /b/
insert into words(word, phonemes, image_url) values ("fair", "/f/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/fair.jpg");
insert into words(word, phonemes, image_url) values ("bear", "/b/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/bear.jpg");
insert into words(word, phonemes, image_url) values ("fig", "/f/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/tight.jpg");
insert into words(word, phonemes, image_url) values ("big", "/b/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/big.jpg");
insert into words(word, phonemes, image_url) values ("phone", "/f/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/phone.jpg");
insert into words(word, phonemes, image_url) values ("bone", "/b/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/bone.jpg");
insert into words(word, phonemes, image_url) values ("fox", "/f/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/fox.jpg");
insert into words(word, phonemes, image_url) values ("box", "/b/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/box.jpg");
insert into words(word, phonemes, image_url) values ("fun", "/f/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/fun.jpg");
insert into words(word, phonemes, image_url) values ("bun", "/b/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/bun.jpg");
insert into words(word, phonemes, image_url) values ("foal", "/f/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/foal.jpg");
insert into words(word, phonemes, image_url) values ("bowl", "/b/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/bowl.jpg");
insert into words(word, phonemes, image_url) values ("fat", "/f/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/fat.jpg");
insert into words(word, phonemes, image_url) values ("bat", "/b/", "https://mhealthstorageaccount.blob.core.windows.net/image-store/bat.jpg");

-- /f/ vs /p/
insert into words(word, phonemes, image_url) values ("pig", "/p/", "");
insert into words(word, phonemes, image_url) values ("fin", "/f/", "");
insert into words(word, phonemes, image_url) values ("pin", "/p/", "");
insert into words(word, phonemes, image_url) values ("fan", "/f/", "");
insert into words(word, phonemes, image_url) values ("pan", "/p/", "");
insert into words(word, phonemes, image_url) values ("pole", "/p/", "");
insert into words(word, phonemes, image_url) values ("fur", "/f/", "");
insert into words(word, phonemes, image_url) values ("purr", "/p/", "");

-- /s/ vs /d/
insert into words(word, phonemes, image_url) values ("sore", "/s/", "");
insert into words(word, phonemes, image_url) values ("door", "/d/", "");
insert into words(word, phonemes, image_url) values ("sea", "/s/", "");
insert into words(word, phonemes, image_url) values ("dee", "/d/", "");
insert into words(word, phonemes, image_url) values ("sew", "/s/", "");
insert into words(word, phonemes, image_url) values ("dough", "/d/", "");
insert into words(word, phonemes, image_url) values ("suck", "/s/", "");
insert into words(word, phonemes, image_url) values ("duck", "/d/", "");
insert into words(word, phonemes, image_url) values ("sock", "/s/", "");
insert into words(word, phonemes, image_url) values ("dock", "/d/", "");
insert into words(word, phonemes, image_url) values ("cee", "/s/", "");
insert into words(word, phonemes, image_url) values ("dee", "/d/", "");

-- /s/ vs /t/
insert into words(word, phonemes, image_url) values ("toe", "/t/", "");
insert into words(word, phonemes, image_url) values ("tail", "/t/", "");
insert into words(word, phonemes, image_url) values ("tower", "/t/", "");

-- Dummy prescription
insert into prescriptions(parent_id, therapist_id, session_time, session_word_count, session_word_set, session_word_set_title) values (1, 1, 15, 35, "1+2,3+4", "some title");