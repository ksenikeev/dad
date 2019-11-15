--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.1
-- Dumped by pg_dump version 12.0

-- Started on 2019-11-01 10:54:51 MSK

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2450 (class 1262 OID 1462064)
-- Name: centraldb; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE centraldb;


ALTER DATABASE centraldb OWNER TO postgres;

\connect centraldb

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

--
-- TOC entry 185 (class 1259 OID 1462065)
-- Name: contract; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contract (
    id bigint NOT NULL,
    offer_id bigint NOT NULL,
    budgetofcontract bigint,
    dataofcontract date,
    request_id bigint NOT NULL,
    progressofcontract boolean,
    nomenclature_id bigint,
    unitofproduct character varying(255),
    cost double precision,
    count double precision
);


ALTER TABLE public.contract OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 1462071)
-- Name: contract_id_contract_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.contract_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.contract_seq OWNER TO postgres;

--
-- TOC entry 2451 (class 0 OID 0)
-- Dependencies: 186
-- Name: contract_id_contract_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.contract_seq OWNED BY public.contract.id;


--
-- TOC entry 187 (class 1259 OID 1462073)
-- Name: nomenclature; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nomenclature (
    id bigint NOT NULL,
    name character varying(1024),
    createdate timestamp with time zone,
    modifydate timestamp with time zone,
    uid uuid
);


ALTER TABLE public.nomenclature OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 1462079)
-- Name: nomenclature_id_nomenclature_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.nomenclature_seq
    START WITH 5
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.nomenclature_seq OWNER TO postgres;

--
-- TOC entry 2452 (class 0 OID 0)
-- Dependencies: 188
-- Name: nomenclature_id_nomenclature_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.nomenclature_seq OWNED BY public.nomenclature.id;


--
-- TOC entry 189 (class 1259 OID 1462081)
-- Name: offer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.offer (
    id bigint NOT NULL,
    organization_id bigint NOT NULL,
    nomenclature_id bigint NOT NULL,
    priceofproduct bigint,
    countofproduct int,
    unitofproduct character varying(255),
    dateofexpiration timestamp with time zone
);


ALTER TABLE public.offer OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 1462087)
-- Name: offer_id_offer_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.offer_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.offer_seq OWNER TO postgres;

--
-- TOC entry 2453 (class 0 OID 0)
-- Dependencies: 190
-- Name: offer_id_offer_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.offer_seq OWNED BY public.offer.id;


--
-- TOC entry 191 (class 1259 OID 1462089)
-- Name: organization; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.organization (
    id bigint NOT NULL,
    nameoforg character varying(255),
    addressoforg character varying(1024),
    inn character varying(255),
    kpp character varying(255),
    ogrn character varying(255)
);


ALTER TABLE public.organization OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 1462095)
-- Name: organization_id_org_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.organization_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.organization_seq OWNER TO postgres;

--
-- TOC entry 2454 (class 0 OID 0)
-- Dependencies: 192
-- Name: organization_id_org_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.organization_seq OWNED BY public.organization.id;


--
-- TOC entry 193 (class 1259 OID 1462097)
-- Name: request; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.request (
    id bigint NOT NULL,
    organization_id bigint NOT NULL,
    nomenclature_id bigint NOT NULL,
    requestdate timestamp with time zone,
    detail character varying(1024),
    countofproduct int,
    deadlineofrequest date,
    isstatus boolean,
    unitofproduct character varying(255),
    price double precision
);


ALTER TABLE public.request OWNER TO postgres;

--
-- TOC entry 194 (class 1259 OID 1462103)
-- Name: request_id_request_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.request_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.request_seq OWNER TO postgres;

--
-- TOC entry 2455 (class 0 OID 0)
-- Dependencies: 194
-- Name: request_id_request_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.request_seq OWNED BY public.request.id;



--
-- TOC entry 2434 (class 0 OID 1462065)
-- Dependencies: 185
-- Data for Name: contract; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2436 (class 0 OID 1462073)
-- Dependencies: 187
-- Data for Name: nomenclature; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.nomenclature (id, name, createdate, modifydate, uid) VALUES (1, 'Уголь антрацит', '2018-01-01 12:01:00+03', '2018-01-01 12:01:00+03', '36123d4b-f8ae-418c-b604-b3dcf654015f');
INSERT INTO public.nomenclature (id, name, createdate, modifydate, uid) VALUES (2, 'Нефть "ЮРАЛС', '2019-10-01 10:48:55.145+03', '2019-10-01 10:48:55.145+03', '36142d4b-f8ae-498c-b604-b3dcf654015f');


--
-- TOC entry 2438 (class 0 OID 1462081)
-- Dependencies: 189
-- Data for Name: offer; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2440 (class 0 OID 1462089)
-- Dependencies: 191
-- Data for Name: organization; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2442 (class 0 OID 1462097)
-- Dependencies: 193
-- Data for Name: request; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2456 (class 0 OID 0)
-- Dependencies: 186
-- Name: contract_id_contract_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.contract_seq', 1, false);


--
-- TOC entry 2457 (class 0 OID 0)
-- Dependencies: 188
-- Name: nomenclature_id_nomenclature_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.nomenclature_seq', 1, false);


--
-- TOC entry 2458 (class 0 OID 0)
-- Dependencies: 195
-- Name: nomenclature_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.nomenclature_seq', 2, true);


--
-- TOC entry 2459 (class 0 OID 0)
-- Dependencies: 190
-- Name: offer_id_offer_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.offer_seq', 1, false);


--
-- TOC entry 2460 (class 0 OID 0)
-- Dependencies: 192
-- Name: organization_id_org_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.organization_seq', 1, false);


--
-- TOC entry 2461 (class 0 OID 0)
-- Dependencies: 194
-- Name: request_id_request_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.request_seq', 1, false);


--
-- TOC entry 2304 (class 2606 OID 1462111)
-- Name: contract contract_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contract
    ADD CONSTRAINT contract_pkey PRIMARY KEY (id);


--
-- TOC entry 2306 (class 2606 OID 1462113)
-- Name: nomenclature nomenclature_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nomenclature
    ADD CONSTRAINT nomenclature_pkey PRIMARY KEY (id);


--
-- TOC entry 2308 (class 2606 OID 1462115)
-- Name: offer offer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.offer
    ADD CONSTRAINT offer_pkey PRIMARY KEY (id);


--
-- TOC entry 2310 (class 2606 OID 1462117)
-- Name: organization organization_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.organization
    ADD CONSTRAINT organization_pkey PRIMARY KEY (id);


--
-- TOC entry 2312 (class 2606 OID 1462119)
-- Name: request request_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.request
    ADD CONSTRAINT request_pkey PRIMARY KEY (id);


--
-- TOC entry 2313 (class 2606 OID 1462120)
-- Name: contract r_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contract
    ADD CONSTRAINT r_1 FOREIGN KEY (request_id) REFERENCES public.request(id);


--
-- TOC entry 2315 (class 2606 OID 1462125)
-- Name: offer r_5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.offer
    ADD CONSTRAINT r_5 FOREIGN KEY (organization_id) REFERENCES public.organization(id);


--
-- TOC entry 2316 (class 2606 OID 1462130)
-- Name: offer r_6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.offer
    ADD CONSTRAINT r_6 FOREIGN KEY (nomenclature_id) REFERENCES public.nomenclature(id);


--
-- TOC entry 2314 (class 2606 OID 1462135)
-- Name: contract r_7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contract
    ADD CONSTRAINT r_7 FOREIGN KEY (offer_id) REFERENCES public.offer(id);


-- Completed on 2019-11-01 10:54:51 MSK

--
-- PostgreSQL database dump complete
--

