package com.pokemon.dao;

import com.pokemon.connection.DatabaseConnetion;
import com.pokemon.model.PokemonAbility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PokemonAbilityDAOImp  implements PokemonAbilityDAO{

    private String tableName;

    public PokemonAbilityDAOImp(){
        tableName = "PokemonAbility";
    }

    @Override
    public void create(PokemonAbility pokemonAbility) throws SQLException {
        Connection conn = DatabaseConnetion.getInstance().getConnection();
        String insertQuery = "INSERT INTO "+tableName+" (ability_name ) VALUES (?)";
        PreparedStatement ps = conn.prepareStatement(insertQuery);
        ps.setString(1, pokemonAbility.getAbilityName());
        ps.execute();
    }

    @Override
    public PokemonAbility read(int id) throws SQLException {
        Connection conn = DatabaseConnetion.getInstance().getConnection();
        String query = "SELECT id, ability_name FROM "+tableName+" WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        PokemonAbility pokemonAbility = new PokemonAbility();
        if(rs.next()){
            pokemonAbility.setId(rs.getInt(1));
            pokemonAbility.setAbilityName(rs.getString(2));
        }
        return pokemonAbility;
    }

    @Override
    public void update(PokemonAbility pokemonAbility) throws SQLException {
        Connection conn = DatabaseConnetion.getInstance().getConnection();
        String query = "UPDATE "+tableName+" SET ability_name = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, pokemonAbility.getAbilityName());
        ps.setInt(2, pokemonAbility.getId());
        ps.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection conn = DatabaseConnetion.getInstance().getConnection();
        String query = "DELETE FROM "+tableName+" WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public List<PokemonAbility> readAll() throws SQLException {
        List<PokemonAbility> pokemonAbilities = new ArrayList();
        Connection conn = DatabaseConnetion.getInstance().getConnection();
        String query = "SELECT id, ability_name FROM "+tableName;
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            pokemonAbilities.add(new PokemonAbility(
                    rs.getInt(1),
                    rs.getString(2)
            ));
        }
        return pokemonAbilities;
    }
}
