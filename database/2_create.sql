-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2024-04-10 11:33:03.604

-- tables
-- Table: animal
CREATE TABLE animal (
                        id serial  NOT NULL,
                        animal_type_id int  NOT NULL,
                        gender_id int  NULL,
                        breed_id int  NULL,
                        size varchar(255)  NULL,
                        age varchar(255)  NULL,
                        color varchar(255)  NULL,
                        CONSTRAINT id PRIMARY KEY (id)
);

-- Table: animal_image
CREATE TABLE animal_image (
                              id serial  NOT NULL,
                              animal_id int  NOT NULL,
                              image_data bytea  NOT NULL,
                              CONSTRAINT animal_image_pk PRIMARY KEY (id)
);

CREATE INDEX animal_image_idx_1 on animal_image (animal_id ASC);

-- Table: animal_type
CREATE TABLE animal_type (
                             id serial  NOT NULL,
                             name varchar(255)  NOT NULL,
                             image_data bytea  NOT NULL,
                             status char(1)  NOT NULL,
                             CONSTRAINT animal_type_pk PRIMARY KEY (id)
);

-- Table: breed
CREATE TABLE breed (
                       id serial  NOT NULL,
                       type varchar(255)  NULL,
                       animal_type_id int  NOT NULL,
                       status char(1)  NOT NULL,
                       CONSTRAINT breed_pk PRIMARY KEY (id)
);

-- Table: gender
CREATE TABLE gender (
                        id serial  NOT NULL,
                        type varchar(50)  NOT NULL,
                        CONSTRAINT gender_pk PRIMARY KEY (id)
);

-- Table: location
CREATE TABLE location (
                          id serial  NOT NULL,
                          post_id int  NOT NULL,
                          location_name int  NOT NULL,
                          latitude decimal(14,12)  NOT NULL,
                          longitude decimal(14,12)  NOT NULL,
                          date date  NOT NULL,
                          comment varchar(255)  NOT NULL,
                          CONSTRAINT location_pk PRIMARY KEY (id)
);

-- Table: post
CREATE TABLE post (
                      id serial  NOT NULL,
                      user_id int  NOT NULL,
                      animal_id int  NOT NULL,
                      type char(1)  NOT NULL,
                      status char(1)  NOT NULL,
                      timestamp int  NOT NULL,
                      city varchar(255)  NULL,
                      county varchar(255)  NULL,
                      address varchar(255)  NULL,
                      info varchar(255)  NULL,
                      CONSTRAINT post_pk PRIMARY KEY (id)
);

-- Table: profile
CREATE TABLE profile (
                         id serial  NOT NULL,
                         user_id int  NOT NULL,
                         name varchar(255)  NOT NULL,
                         image_data bytea  NULL,
                         CONSTRAINT profile_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      name varchar(50)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        role_id int  NOT NULL,
                        email varchar(255)  NOT NULL,
                        password varchar(255)  NOT NULL,
                        CONSTRAINT user_ak_1 UNIQUE (email) NOT DEFERRABLE  INITIALLY IMMEDIATE,
                        CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: animal_animal_type (table: animal)
ALTER TABLE animal ADD CONSTRAINT animal_animal_type
    FOREIGN KEY (animal_type_id)
        REFERENCES animal_type (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: animal_breed (table: animal)
ALTER TABLE animal ADD CONSTRAINT animal_breed
    FOREIGN KEY (breed_id)
        REFERENCES breed (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: animal_gender (table: animal)
ALTER TABLE animal ADD CONSTRAINT animal_gender
    FOREIGN KEY (gender_id)
        REFERENCES gender (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: animal_image_animal (table: animal_image)
ALTER TABLE animal_image ADD CONSTRAINT animal_image_animal
    FOREIGN KEY (animal_id)
        REFERENCES animal (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: breed_animal_type (table: breed)
ALTER TABLE breed ADD CONSTRAINT breed_animal_type
    FOREIGN KEY (animal_type_id)
        REFERENCES animal_type (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: location_post (table: location)
ALTER TABLE location ADD CONSTRAINT location_post
    FOREIGN KEY (post_id)
        REFERENCES post (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: post_animal (table: post)
ALTER TABLE post ADD CONSTRAINT post_animal
    FOREIGN KEY (animal_id)
        REFERENCES animal (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: post_user (table: post)
ALTER TABLE post ADD CONSTRAINT post_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: profile_user (table: profile)
ALTER TABLE profile ADD CONSTRAINT profile_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.

