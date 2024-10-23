package com.pokemon.dao;

import com.pokemon.model.PokemonAbility;

import java.sql.SQLException;
import java.util.List;

public interface PokemonAbilityDAO {

    public void create(PokemonAbility pokemonAbility) throws SQLException;
    public PokemonAbility read(int id) throws SQLException;
    public void update(PokemonAbility pokemonAbility) throws SQLException;
    public void delete(int id) throws SQLException;
    public List<PokemonAbility> readAll() throws SQLException;

}
