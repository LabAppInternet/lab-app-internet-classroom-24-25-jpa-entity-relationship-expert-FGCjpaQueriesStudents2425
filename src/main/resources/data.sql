insert into user_fcg(username, name, second_name, email)
values('joanra', 'Joan Ramon', 'Roca', 'joanra@gmail.com'),
('tina', 'Cristina', 'Garcia', 'tina@gmail.com'),
('maria', 'Maria', 'Garcia', 'maria@gmail.com'),
('marcos', 'Marcos', 'Francisco', 'marcos@gmail.com');


insert into station(latitud, longitud, name) values('41.65434', '0.685766', 'Lleida-Pirineus');
insert into station(latitud, longitud, name) values('41.654221', '0.685937', 'Alcoletge');
insert into station(latitud, longitud, name) values('41.687383', '0.72789', 'Vilanova de la Barca');
insert into station(latitud, longitud, name) values('41.716451', '0.76295', 'Térmens');
insert into station(latitud, longitud, name) values('41.65434', '0.685766', 'Vallfogona de Balaguer');
insert into station(latitud, longitud, name) values('41.65434', '0.685766', 'Balaguer');
insert into station(latitud, longitud, name) values('41.65434', '0.685766', 'Gerb');
insert into station(latitud, longitud, name) values('41.65434', '0.685766', 'Sant Llorenç de Montgai');
insert into station(latitud, longitud, name) values('41.65434', '0.685766', 'Vilanova de la Sal');
insert into station(latitud, longitud, name) values('41.65434', '0.685766', 'Santa Linya');
insert into station(latitud, longitud, name) values('41.65434', '0.685766', 'Àger');
insert into station(latitud, longitud, name) values('41.65434', '0.685766', 'Cellers-Llimiana');
insert into station(latitud, longitud, name) values('41.65434', '0.685766', 'Guàrdia de Tremp');
insert into station(latitud, longitud, name) values('41.65434', '0.685766', 'Palau de Noguera');
insert into station(latitud, longitud, name) values('41.65434', '0.685766', 'Tremp');
insert into station(latitud, longitud, name) values('41.65434', '0.685766', 'Salàs de Pallars');
insert into station(latitud, longitud, name) values('41.65434', '0.685766', 'La Pobla de Segur');


insert into journey(origin_name, origin_station, destination_name, destination_station) values('Lleida-Pirineus', 'Lleida-Pirineus', 'La Pobla de Segur', 'La Pobla de Segur');
insert into journey(origin_name, origin_station, destination_name, destination_station) values('Lleida-Pirineus', 'Lleida-Pirineus', 'Tremp', 'Tremp');
insert into journey(origin_name, origin_station, destination_name, destination_station) values('Balaguer', 'Balaguer', 'Gerb', 'Gerb');
insert into journey(origin_name, origin_station, destination_name, destination_station) values('Gerb', 'Gerb', 'Balaguer', 'Balaguer');

insert into favorite_journey(id, journey_destination_name, journey_origin_name, user_username) values('1', 'La Pobla de Segur', 'Lleida-Pirineus', 'tina');
insert into day_time_start (id, time_start, day_of_week) values ('1', '12:51', 'Monday');
insert into day_time_start (id, time_start, day_of_week) values ('2', '12:30', 'Tuesday');
insert into favorite_journey_day_time_starts (favorite_journey_id, day_time_starts_id) values ('1', '1');
insert into favorite_journey_day_time_starts (favorite_journey_id, day_time_starts_id) values ('1', '2');

insert into favorite_journey(id, journey_origin_name, journey_destination_name, user_username) values('2', 'Gerb', 'Balaguer', 'tina');
insert into day_time_start (id, time_start, day_of_week) values ('3', '12:51', 'Monday');
insert into day_time_start (id, time_start, day_of_week) values ('4', '12:30', 'Tuesday');
insert into favorite_journey_day_time_starts (favorite_journey_id, day_time_starts_id) values ('2', '3');
insert into favorite_journey_day_time_starts (favorite_journey_id, day_time_starts_id) values ('2', '4');

insert into favorite_journey(id, journey_origin_name, journey_destination_name, user_username) values('3', 'Balaguer', 'Gerb', 'maria');
insert into day_time_start (id, time_start, day_of_week) values ('5', '12:51', 'Monday');
insert into day_time_start (id, time_start, day_of_week) values ('6', '12:30', 'Wednesday');
insert into favorite_journey_day_time_starts (favorite_journey_id, day_time_starts_id) values ('3', '5');
insert into favorite_journey_day_time_starts (favorite_journey_id, day_time_starts_id) values ('3', '6');



insert into friend(username, user_username, friend) values('tina', 'tina', 'maria');
insert into friend(username, user_username, friend) values('tina', 'tina', 'pepe');
insert into friend(username, user_username, friend) values('tina', 'tina', 'pepa');
insert into friend(username, user_username, friend) values('joanra', 'joanra', 'pepa');



