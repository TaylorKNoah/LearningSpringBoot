ALTER TABLE users
    DROP COLUMN state;

 ALTER TABLE addresses
    ADD state VARCHAR(255) not null;