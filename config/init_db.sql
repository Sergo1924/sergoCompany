CREATE TABLE resume
(
  uuid      CHAR(36) NOT NULL
    CONSTRAINT resume_pkey
    PRIMARY KEY,
  full_name TEXT
);

CREATE UNIQUE INDEX resume_uuid_uindex
  ON resume (uuid);

CREATE TABLE contacts
(
  id          SERIAL   NOT NULL
    CONSTRAINT contacts_pkey
    PRIMARY KEY,
  type        TEXT     NOT NULL,
  value       TEXT     NOT NULL,
  resume_uuid CHAR(36) NOT NULL
    CONSTRAINT contacts_uuid_type_index
    REFERENCES resume
    ON DELETE CASCADE
);

