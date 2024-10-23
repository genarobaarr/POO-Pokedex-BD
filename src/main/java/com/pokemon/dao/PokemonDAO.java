package com.pokemon.dao;

import com.pokemon.model.Pokemon;

import java.sql.SQLException;
import java.util.List;

public interface PokemonDAO {

    public void create(Pokemon pokemon) throws SQLException;
    public Pokemon read(int id) throws SQLException;
    public void update(Pokemon pokemon) throws SQLException;
    public void delete(int id) throws SQLException;
    public List<Pokemon> readAll() throws SQLException;

}
