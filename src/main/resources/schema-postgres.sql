CREATE TABLE link_mapping (
  unique_id BIGINT NOT NULL,
   created_by VARCHAR(255) NOT NULL,
   created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
   key_url VARCHAR(7),
   value_url VARCHAR(1000) NOT NULL,
   CONSTRAINT pk_link_mapping PRIMARY KEY (unique_id)
);

ALTER TABLE link_mapping ADD CONSTRAINT uc_link_mapping_keyurl UNIQUE (key_url);