--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

-- Started on 2022-04-07 18:03:50

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
-- TOC entry 214 (class 1259 OID 16430)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 209 (class 1259 OID 16395)
-- Name: personal_plant_progress; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.personal_plant_progress (
    progress_id bigint NOT NULL,
    created_at timestamp without time zone,
    last_updated_at timestamp without time zone,
    user_id character varying(255),
    plant_id character varying(255)
);


ALTER TABLE public.personal_plant_progress OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16402)
-- Name: plant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.plant (
    plant_id character varying(255) NOT NULL,
    common_name character varying(255),
    description character varying(255),
    family character varying(255) NOT NULL,
    native_continent character varying(255) NOT NULL,
    scientific_name character varying(255) NOT NULL,
    type integer NOT NULL
);


ALTER TABLE public.plant OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 16409)
-- Name: plant_document; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.plant_document (
    document_id character varying(255) NOT NULL,
    author character varying(255),
    date_added timestamp without time zone NOT NULL,
    document_path character varying(255),
    is_trusted_author boolean,
    last_modified timestamp without time zone,
    title character varying(255) NOT NULL,
    plant_id character varying(255)
);


ALTER TABLE public.plant_document OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16416)
-- Name: plant_requirements; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.plant_requirements (
    requirements_id bigint NOT NULL,
    climate character varying(255),
    max_temperature_celsius integer,
    min_temperature_celsius integer,
    soil character varying(255),
    watering_days integer,
    watering_requirement_liters real,
    plant_id character varying(255)
);


ALTER TABLE public.plant_requirements OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 16423)
-- Name: progress_step; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.progress_step (
    progress_step_id bigint NOT NULL,
    created_at timestamp without time zone,
    description character varying(255),
    progress_id bigint
);


ALTER TABLE public.progress_step OWNER TO postgres;

--
-- TOC entry 3335 (class 0 OID 16395)
-- Dependencies: 209
-- Data for Name: personal_plant_progress; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.personal_plant_progress (progress_id, created_at, last_updated_at, user_id, plant_id) FROM stdin;
\.


--
-- TOC entry 3336 (class 0 OID 16402)
-- Dependencies: 210
-- Data for Name: plant; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.plant (plant_id, common_name, description, family, native_continent, scientific_name, type) FROM stdin;
\.


--
-- TOC entry 3337 (class 0 OID 16409)
-- Dependencies: 211
-- Data for Name: plant_document; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.plant_document (document_id, author, date_added, document_path, is_trusted_author, last_modified, title, plant_id) FROM stdin;
\.


--
-- TOC entry 3338 (class 0 OID 16416)
-- Dependencies: 212
-- Data for Name: plant_requirements; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.plant_requirements (requirements_id, climate, max_temperature_celsius, min_temperature_celsius, soil, watering_days, watering_requirement_liters, plant_id) FROM stdin;
\.


--
-- TOC entry 3339 (class 0 OID 16423)
-- Dependencies: 213
-- Data for Name: progress_step; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.progress_step (progress_step_id, created_at, description, progress_id) FROM stdin;
\.


--
-- TOC entry 3346 (class 0 OID 0)
-- Dependencies: 214
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- TOC entry 3181 (class 2606 OID 16401)
-- Name: personal_plant_progress personal_plant_progress_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personal_plant_progress
    ADD CONSTRAINT personal_plant_progress_pkey PRIMARY KEY (progress_id);


--
-- TOC entry 3187 (class 2606 OID 16415)
-- Name: plant_document plant_document_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plant_document
    ADD CONSTRAINT plant_document_pkey PRIMARY KEY (document_id);


--
-- TOC entry 3183 (class 2606 OID 16408)
-- Name: plant plant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plant
    ADD CONSTRAINT plant_pkey PRIMARY KEY (plant_id);


--
-- TOC entry 3189 (class 2606 OID 16422)
-- Name: plant_requirements plant_requirements_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plant_requirements
    ADD CONSTRAINT plant_requirements_pkey PRIMARY KEY (requirements_id);


--
-- TOC entry 3191 (class 2606 OID 16427)
-- Name: progress_step progress_step_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.progress_step
    ADD CONSTRAINT progress_step_pkey PRIMARY KEY (progress_step_id);


--
-- TOC entry 3185 (class 2606 OID 16429)
-- Name: plant uk_624wifni04rywerlvto520967; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plant
    ADD CONSTRAINT uk_624wifni04rywerlvto520967 UNIQUE (scientific_name);


--
-- TOC entry 3194 (class 2606 OID 16441)
-- Name: plant_requirements fk3qpdk7s9l8gybqiy8iltfjtbg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plant_requirements
    ADD CONSTRAINT fk3qpdk7s9l8gybqiy8iltfjtbg FOREIGN KEY (plant_id) REFERENCES public.plant(plant_id);


--
-- TOC entry 3193 (class 2606 OID 16436)
-- Name: plant_document fkmjpoy6amfp2ruayb6ojownkpj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plant_document
    ADD CONSTRAINT fkmjpoy6amfp2ruayb6ojownkpj FOREIGN KEY (plant_id) REFERENCES public.plant(plant_id);


--
-- TOC entry 3195 (class 2606 OID 16446)
-- Name: progress_step fknxqw7fw2v5cilscsw76nayych; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.progress_step
    ADD CONSTRAINT fknxqw7fw2v5cilscsw76nayych FOREIGN KEY (progress_id) REFERENCES public.personal_plant_progress(progress_id);


--
-- TOC entry 3192 (class 2606 OID 16431)
-- Name: personal_plant_progress fkrubmpjomulx9ee35eus7yyrpl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personal_plant_progress
    ADD CONSTRAINT fkrubmpjomulx9ee35eus7yyrpl FOREIGN KEY (plant_id) REFERENCES public.plant(plant_id);


-- Completed on 2022-04-07 18:03:50

--
-- PostgreSQL database dump complete
--

