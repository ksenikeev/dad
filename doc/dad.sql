CREATE DATABASE dad;

CREATE SEQUENCE contact_seq;
CREATE TABLE contact
(
    id bigint NOT NULL DEFAULT nextval('contact_seq'),
    fullname character varying(255) NOT NULL,
    lastname character varying(255),
    firstname character varying(255),
    inblacklist boolean NOT NULL DEFAULT false,
    CONSTRAINT contact_pkey PRIMARY KEY (id)
);

CREATE TABLE dict_phonetype
(
    id bigint NOT NULL,
    code character varying(255),
    name character varying(255),
    fullname character varying(255),
    CONSTRAINT dict_phonetype_pkey PRIMARY KEY (id)
);

insert into dict_phonetype (id, code, name, fullname) values (1, '1', 'Домашний', 'Домашний');
insert into dict_phonetype (id, code, name, fullname) values (2, '2', 'Мобильный', 'Мобильный');
insert into dict_phonetype (id, code, name, fullname) values (3, '3', 'Рабочий', 'Рабочий');
CREATE SEQUENCE phone_seq;
CREATE TABLE phone
(
    contact_id bigint NOT NULL,
    id bigint NOT NULL DEFAULT nextval('phone_seq'),
    phonetype_id bigint,
    phonenumber character varying(50) NOT NULL,
    CONSTRAINT phone_pkey PRIMARY KEY (id),
    CONSTRAINT fk_contact FOREIGN KEY (contact_id)
        REFERENCES contact (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT fk_phonetype FOREIGN KEY (phonetype_id)
        REFERENCES dict_phonetype (id)
        ON UPDATE CASCADE
        ON DELETE NO ACTION
);
