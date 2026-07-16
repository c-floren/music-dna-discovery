-- Prereq: boot the app once (ddl-auto=update creates the `tracks` table + 6 indexes
-- on the empty schema), THEN run this script to load the CSV.
CREATE TEMPORARY TABLE staging (
    idx text, track_id text, artists text,
    album_name text, track_name text, popularity text,
    duration_ms text, explicit text, danceability text,
    energy text, key text, loudness text,
    mode text, speechiness text, acousticness text,
    instrumentalness text, liveness text, valence text,
    tempo text, time_signature text, track_genre text);

-- Windows Encoding may be WIN1252
\encoding UTF8

-- replace {DATASET_PATH} with your local CSV path
\copy staging FROM '{DATASET_PATH}' WITH (FORMAT csv, HEADER true)

INSERT INTO tracks (id, name, artist, tempo, valence, energy, danceability, acousticness)
SELECT DISTINCT ON (track_id)
        track_id, track_name, artists,
        tempo::real, valence::real, energy::real, danceability::real, acousticness::real 
FROM staging
WHERE track_name IS NOT NULL AND artists IS NOT NULL AND track_name <> '' AND artists <> ''
ORDER BY track_id;
