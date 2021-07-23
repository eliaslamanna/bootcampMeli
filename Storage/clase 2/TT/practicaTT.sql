use movies_db;

/*2 Agregue una película a la tabla movies.*/
INSERT INTO movies VALUES (22,NULL,NULL,'Constantine',8.0,2,'2005-10-04 00:00:00',122,4);

/*3 Agregué un géneró a la tabla genres.*/
INSERT INTO genres VALUES (13,'2017-07-04 03:00:00',NULL,'Nuevo',13,1);

/*4 Asocie a la película del Ej 2. con el género creado en el Ej. 3.*/
UPDATE movies SET genre_id = 13 where id = 22;

/*5 Modifique la tabla actors para que al menos un actor tenga como favorita la película agregada en el Ej.2.*/
UPDATE actors SET favorite_movie_id = 22 where id = 1;

/*6 Cree una tabla temporal copia de la tabla movies.*/
CREATE TEMPORARY TABLE tabla_temporal (select * from movies);

/*7 Elimine de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.*/
DELETE FROM tabla_temporal WHERE awards < 5;

/*8 Obtenga la lista de todas los géneros que tengan al menos una película.*/
select genres.* from genres join movies on genres.id = movies.genre_id group by genres.id having count(movies.genre_id) >= 1;

/*9 Obtenga la lista de actores cuya película favorita haya ganado más de 3 awards.*/
select actors.* from actors join actor_movie on actors.id = actor_movie.actor_id join movies on actor_movie.movie_id = movies.id where movies.awards > 3;

/*10 Utilice el explain plan para analizar las consultas del Ej.6 y 7.*/
EXPLAIN DELETE FROM tabla_temporal WHERE awards < 5;
/*EXPLAIN CREATE TEMPORARY TABLE tabla_temporal (select * from movies);  ->  No funciona*/

/*12 Cree un índice sobre el nombre en la tabla movies.*/
CREATE INDEX movie_title ON movies (title);

/*13 Chequee que el indice fue creado correctamente.*/
SHOW INDEX FROM movies;

