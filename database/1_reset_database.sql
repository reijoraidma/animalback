-- Kustutab animal schema (mis põhimõtteliselt kustutab kõik tabelid)
DROP SCHEMA animal CASCADE;
-- Loob uue animal schema vajalikud õigused
CREATE SCHEMA animal
-- taastab vajalikud andmebaasi õigused
    GRANT ALL ON SCHEMA animal TO postgres;
GRANT ALL ON SCHEMA animal TO PUBLIC;