USE movies_db;

/*1 Mostrar el título y el nombre del género de todas las series.*/
select title,genres.name from series join genres on series.genre_id = genres.id;

/*2 Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en
cada uno de ellos.*/
select episodes.title,actors.first_name,actors.last_name from episodes join actor_episode on episodes.id = actor_episode.episode_id join actors on actor_episode.actor_id = actors.id;

/*3 Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.*/
select series.title,count(seasons.serie_id) from series join seasons on series.id = seasons.serie_id group by seasons.serie_id;

/*4 Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.*/
select genres.name,count(movies.genre_id) as genre_count from genres join movies on genres.id = movies.genre_id group by movies.genre_id having genre_count > 3;

/*5 Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.*/
select distinct actors.first_name,actors.last_name from actors join actor_movie on actors.id = actor_movie.actor_id join movies on actor_movie.movie_id = movies.id where movies.title like '%guerra de las galaxias%';