CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  name varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  profile varchar(25) NOT NULL
);

CREATE TABLE collaborators (
  id SERIAL PRIMARY KEY,
  name varchar(255) NOT NULL,
  local varchar(255),
  team varchar(25) NOT NULL,
  role varchar(25) NOT NULL,
  updated_at timestamp NOT NULL,
  created_at timestamp NOT NULL
);

CREATE TABLE contacts (
  id SERIAL PRIMARY KEY,
  value varchar(255) NOT NULL,
  type varchar(25) NOT NULL
);

CREATE TABLE professional_experiences (
  id SERIAL PRIMARY KEY,
  description varchar(255) NOT NULL,
  skills varchar(255),
  collaborator_id int NOT NULL,
  updated_at timestamp NOT NULL,
  created_at timestamp NOT NULL
);

ALTER TABLE professional_experiences
ADD CONSTRAINT professional_experiences_collaborator FOREIGN KEY (collaborator_id) REFERENCES collaborators(id);
