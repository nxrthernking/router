ALTER TABLE if EXISTS file
    ADD CONSTRAINT documentFilesId FOREIGN KEY (file_id) REFERENCES document;