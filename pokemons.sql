-- Creación de la base de datos
CREATE DATABASE IF NOT EXISTS PokemonDB;
USE PokemonDB;

CREATE TABLE IF NOT EXISTS PokemonType (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Pokemon (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    height DECIMAL(4,2) NOT NULL,
    weight DECIMAL(5,2) NOT NULL,
    base_experience INT NOT NULL,
    type_id INT,
    FOREIGN KEY (type_id) REFERENCES PokemonType(id)
);

CREATE TABLE IF NOT EXISTS PokemonAbility (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ability_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS PokemonAbilityMap (
    pokemon_id INT,
    ability_id INT,
    PRIMARY KEY (pokemon_id, ability_id),
    FOREIGN KEY (pokemon_id) REFERENCES Pokemon(id),
    FOREIGN KEY (ability_id) REFERENCES PokemonAbility(id)
);

INSERT INTO PokemonType (type_name) VALUES 
('Fire'),
('Water'),
('Grass'),
('Electric'),
('Flying'),
('Psychic');

INSERT INTO PokemonAbility (ability_name) VALUES
('Overgrow'),
('Blaze'),
('Torrent'),
('Static'),
('Keen Eye'),
('Run Away');

INSERT INTO Pokemon (name, height, weight, base_experience, type_id) VALUES
('Bulbasaur', 0.7, 6.9, 64, 3),
('Charmander', 0.6, 8.5, 62, 1),
('Squirtle', 0.5, 9.0, 63, 2),
('Pikachu', 0.4, 6.0, 112, 4),
('Pidgey', 0.3, 1.8, 50, 5);

INSERT INTO PokemonAbilityMap (pokemon_id, ability_id) VALUES
(1, 1), 
(2, 2), 
(3, 3), 
(4, 4), 
(5, 5), 
(5, 6);