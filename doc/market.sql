--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.1
-- Dumped by pg_dump version 10.4

-- Started on 2019-02-07 10:52:03 MSK

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2417 (class 1262 OID 218571)
-- Name: market; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE market ;


ALTER DATABASE market OWNER TO postgres;

\connect market

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12655)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2419 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 185 (class 1259 OID 218572)
-- Name: basket_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.basket_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.basket_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 188 (class 1259 OID 218583)
-- Name: basket; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.basket (
    id bigint DEFAULT nextval('public.basket_seq'::regclass) NOT NULL,
    client_id bigint,
    price_id bigint,
    price_count integer DEFAULT 1,
    basketdate timestamp without time zone DEFAULT now()
);


ALTER TABLE public.basket OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 218574)
-- Name: clients_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.clients_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.clients_seq OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 218593)
-- Name: clients; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clients (
    id bigint DEFAULT nextval('public.clients_seq'::regclass) NOT NULL,
    name character varying(255),
    clientid character varying(255)
);


ALTER TABLE public.clients OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 218576)
-- Name: price; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.price (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    pricevalue double precision DEFAULT 0,
    available boolean DEFAULT true
);


ALTER TABLE public.price OWNER TO postgres;

--
-- TOC entry 2410 (class 0 OID 218583)
-- Dependencies: 188
-- Data for Name: basket; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.basket (id, client_id, price_id, price_count, basketdate) VALUES (1, 1, 2, 1, '2018-12-13 09:27:10.043579');


--
-- TOC entry 2411 (class 0 OID 218593)
-- Dependencies: 189
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.clients (id, name, clientid) VALUES (1, 'Клиент 1', '1');


--
-- TOC entry 2409 (class 0 OID 218576)
-- Dependencies: 187
-- Data for Name: price; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.price (id, name, pricevalue, available) VALUES (1, 'Пылесос', 3500, true);
INSERT INTO public.price (id, name, pricevalue, available) VALUES (2, 'Холодильник', 11200, true);
INSERT INTO public.price (id, name, pricevalue, available) VALUES (3, 'Микроволновая печь', 2300, true);
INSERT INTO public.price (id, name, pricevalue, available) VALUES (4, 'Телевизор', 7000, true);
INSERT INTO public.price (id, name, pricevalue, available) VALUES (5, 'Газовая плита', 15000, true);
INSERT INTO public.price (id, name, pricevalue, available) VALUES (6, 'Фотоаппарат', 2200, true);
INSERT INTO public.price (id, name, pricevalue, available) VALUES (7, 'Наушники', 450, true);


--
-- TOC entry 2420 (class 0 OID 0)
-- Dependencies: 185
-- Name: basket_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.basket_seq', 1, true);


--
-- TOC entry 2421 (class 0 OID 0)
-- Dependencies: 186
-- Name: clients_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.clients_seq', 1, true);


--
-- TOC entry 2287 (class 2606 OID 218589)
-- Name: basket basket_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.basket
    ADD CONSTRAINT basket_pkey PRIMARY KEY (id);


--
-- TOC entry 2289 (class 2606 OID 218601)
-- Name: clients clients_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- TOC entry 2285 (class 2606 OID 218582)
-- Name: price price_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.price
    ADD CONSTRAINT price_pkey PRIMARY KEY (id);


-- Completed on 2019-02-07 10:52:03 MSK

--
-- PostgreSQL database dump complete
--

