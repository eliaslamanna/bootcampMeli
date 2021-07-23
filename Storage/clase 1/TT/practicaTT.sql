USE movies_db;

/*2 Mostrar todos los registros de la tabla de movies.*/
select * from movies;

/*3 Mostrar el nombre, apellido y rating de todos los actores.*/
select first_name,last_name,rating from actors;

/*4 Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla
como el campo estén en español*/
select title as titulo from series as series;

/*5 Aplicarle a la consulta anterior un filtro por type en donde este sea igual a income.*/


/*6 Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.*/
select first_name,last_name from actors where rating > 7.5;

/*7 Mostrar el título de las películas, el rating y los premios de las películas con un rating
mayor a 7.5 y con más de dos premios.*/
select title,rating,awards from movies where rating > 7.5 and awards > 2;

/*8 Mostrar el título de las películas y el rating ordenadas por rating en forma
ascendente.*/
select title,rating from movies order by rating;

/*9 Mostrar los títulos de las primeras tres películas en la base de datos.*/
select title from movies limit 3;

/*10 Mostrar el top 5 de las películas con mayor rating.*/
select * from movies order by rating desc limit 5;

/*11 Mostrar las top 5 a 10 de las películas con mayor rating.*/
select * from movies order by rating desc limit 5,5;

/*12 Listar los primeros 10 actores (sería la página 1)*/
select * from actors limit 10;

/*13 Luego usar offset para traer la página 3*/
select * from actors limit 20,10;

/*14 Hacer lo mismo para traer la pagina 5*/
select * from actors limit 40,10;

/*15 Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.*/
select title,rating from movies where title like '%Toy Story%';

/*16 Mostrar a todos los actores cuyos nombres empiecen con Sam.*/
select * from actors where first_name like 'Sam%';

/*17 Mostrar el título de las películas que salieron entre el 2004 y 2008.*/
select * from movies where release_date between '2004-01-01 00:00:00' and '2008-12-31 23:59:59';

/*18 Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con
fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.*/
select title from movies where rating > 3 and awards > 1 and release_date between '1988-01-01 00:00:00' and '2009-12-31 23:59:59' order by rating;

/*19 Traer el top 3 a partir del registro 10 de la consulta anterior.*/
select title from movies where rating > 3 and awards > 1 and release_date between '1988-01-01 00:00:00' and '2009-12-31 23:59:59' order by rating limit 10,3;