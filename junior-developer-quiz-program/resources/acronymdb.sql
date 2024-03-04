BEGIN TRANSACTION;

DROP TABLE IF EXISTS acronym;

CREATE TABLE acronym (
  id serial PRIMARY KEY,
  letters varchar(15) NOT NULL,   -- acronym
  meaning varchar(200) NOT NULL,       -- letters stand for
  caption varchar(1000) NOT NULL    -- description of what this is
);

COMMIT TRANSACTION;