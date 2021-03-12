ALTER TABLE if EXISTS file
    ADD CONSTRAINT documentFilesId FOREIGN KEY (files_id) REFERENCES document;