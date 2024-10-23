package com.pokemon.dao;

import com.pokemon.model.PokemonType;

import java.sql.SQLException;
import java.util.List;

public interface PokemonTypeDAO {

    public void create(PokemonType pokemonType) throws SQLException;
    public PokemonType read(int id) throws SQLException;
    public void update(PokemonType pokemonType) throws SQLException;
    public void delete(int id) throws SQLException;
    public List<PokemonType> readAll() throws SQLException;

}
