--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

-- Started on 2022-04-07 18:02:17

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

SET default_table_access_method = heap;

--
-- TOC entry 211 (class 1259 OID 16460)
-- Name: discussion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.discussion (
    discussion_id bigint NOT NULL,
    date_added timestamp without time zone,
    is_locked boolean,
    section integer,
    text_content text,
    title character varying(255),
    author character varying
);


ALTER TABLE public.discussion OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16459)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16452)
-- Name: message; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.message (
    message_id bigint NOT NULL,
    content text,
    date_posted timestamp without time zone,
    discussion_id bigint,
    poster character varying
);


ALTER TABLE public.message OWNER TO postgres;

--
-- TOC entry 3314 (class 0 OID 16460)
-- Dependencies: 211
-- Data for Name: discussion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.discussion (discussion_id, date_added, is_locked, section, text_content, title, author) FROM stdin;
0	2022-03-29 00:32:41.918227	f	0	Hello, and welcome to the Botaniac Forums.\n\t\tThis is a place where you can discuss stuff about gardening","Welcome to the forums!	Botaniac Forums just opened!	\N
1	2022-03-29 00:32:41.918227	f	0	This section is dedicated to any news related to gardening or plants in general	Section guidelines	\N
2	2022-03-29 00:38:20.899294	f	1	This section is dedicated to discussing anything about gardening or plants in general	Section guidelines	\N
\.


--
-- TOC entry 3312 (class 0 OID 16452)
-- Dependencies: 209
-- Data for Name: message; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.message (message_id, content, date_posted, discussion_id, poster) FROM stdin;
3	Proba	2022-04-06 23:52:21.854997	0	0
4	mesaj fain	2022-04-07 00:03:35.287176	0	0
5	ok hai macar	2022-04-07 03:23:53.443238	0	0
6	sa testez alte functionalitati	2022-04-07 03:24:05.208533	0	0
7	sa testez alte functionalitati	2022-04-07 03:25:28.724836	0	0
8	sa testez alte functionalitati	2022-04-07 08:00:37.20381	0	0
9	proba de microfon	2022-04-07 08:11:09.139253	0	0
10	de ce imi face asta? plang	2022-04-07 08:11:33.115887	0	0
11	de ce nu vrei sa-mi faci nimic?	2022-04-07 08:16:09.130031	0	0
12	bun, oare merge asa?	2022-04-07 08:18:51.034594	0	0
13	yay merge!!!! dar acum de ce ma uraste si nu imi face chestia din beforeMount?	2022-04-07 08:19:15.237247	0	0
14	ALSO, DE CE NAIBA NU IMI FORMATEAZA DATA CAND EU AM FACUT EXACT CA SI PT DISCUTII??????	2022-04-07 08:23:58.328838	0	0
15	nvm partea cu data. eram doar eu proasta\r\n	2022-04-07 08:26:46.007191	0	0
16	nvm si partea cu mount-ul\r\nil puneam in partea de methods ca o dobitoaca	2022-04-07 08:30:36.797805	0	0
17	ramane doar sa fac sa imi si arata username-ul pt ca mi-l ia bine de la microserviciu dar nu stiu de ce imi returneaza un promise chiar daca eu il fac cu await	2022-04-07 08:55:56.24044	0	0
18	deci efectiv daca il afisez imi rezolva promise-ul, dar daca il returnez imi da tot un promise\r\n	2022-04-07 08:56:18.364858	0	0
19	si nu stiu de ce vue.js ma uraste	2022-04-07 08:56:37.426747	0	0
20	nvm, eram retardata, trebuia sa arate observable, dar acum iar nu imi mai merge beforeMount for some reason. also, nu am reusit sa fac cu map si am facut mai ineficient si poate de aia nu imi mai incarca din prima	2022-04-07 11:24:13.514397	0	0
21	ok, deci am reusit sa preiau user-ul din microserviciul de conturi, dar imi ramane tot timpul in urma cu un event probabil	2022-04-07 11:58:32.193441	0	0
22	SI ACUM IAR NU MERGE BEFOREMOUNT-UL SI IL AM PUS BINE. DE CE VUE.JS MA URASTE?\r\n	2022-04-07 12:10:55.88769	0	0
23	Sper ca inca merge minunea asta ca altfel plang	2022-04-07 15:32:29.375828	0	0
24	OK ACUM S-A DECIS CA VREA SA MEARGA BEFOREMOUNT WHAT EVEN IS LIFE ANYMORE?	2022-04-07 15:36:20.509013	0	0
25	hai sa facem o proba	2022-04-07 17:06:21.603967	0	0
26	alta proba	2022-04-07 17:13:38.912481	0	0
\.


--
-- TOC entry 3320 (class 0 OID 0)
-- Dependencies: 210
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 26, true);


--
-- TOC entry 3171 (class 2606 OID 16466)
-- Name: discussion discussion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.discussion
    ADD CONSTRAINT discussion_pkey PRIMARY KEY (discussion_id);


--
-- TOC entry 3169 (class 2606 OID 16458)
-- Name: message message_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT message_pkey PRIMARY KEY (message_id);


--
-- TOC entry 3172 (class 2606 OID 16467)
-- Name: message fk3nr1t44itdoagqs1w2bo21ho7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.message
    ADD CONSTRAINT fk3nr1t44itdoagqs1w2bo21ho7 FOREIGN KEY (discussion_id) REFERENCES public.discussion(discussion_id);


-- Completed on 2022-04-07 18:02:17

--
-- PostgreSQL database dump complete
--

