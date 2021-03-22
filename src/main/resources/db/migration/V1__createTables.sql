CREATE TABLE document (
    id BIGINT NOT NULL ,
    date TIMESTAMP,
    sender VARCHAR (255),
    PRIMARY KEY (id));
CREATE TABLE file (
    id BIGINT NOT NULL ,
    content oid,
    file_extension VARCHAR (255),
    file_name VARCHAR (255),
    file_id BIGINT,
    PRIMARY KEY (id));

