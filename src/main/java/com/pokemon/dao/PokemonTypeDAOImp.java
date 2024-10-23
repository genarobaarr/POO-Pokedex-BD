package com.pokemon.dao;

import com.pokemon.connection.DatabaseConnetion;
import com.pokemon.model.PokemonType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PokemonTypeDAOImp implements PokemonTypeDAO{

    private String tableName;

    public PokemonTypeDAOImp(){
        tableName = "PokemonType";
    }

    @Override
    public void create(PokemonType pokemonType) throws SQLException {
        Connection conn = DatabaseConnetion.getInstance().getConnection();
        String insertQuery = "INSERT INTO "+tableName+" (type_name ) VALUES (?)";
        PreparedStatement ps = conn.prepareStatement(insertQuery);
        ps.setString(1, pokemonType.getTypeName());
        ps.execute();
    }

    @Override
    public PokemonType read(int id) throws SQLException {
        Connection conn = DatabaseConnetion.getInstance().getConnection();
        String query = "SELECT id, type_name FROM "+tableName+" WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        PokemonType pokemonType = new PokemonType();
        if(rs.next()){
            pokemonType.setId(rs.getInt(1));
            pokemonType.setTypeName(rs.getString(2));
        }
        return pokemonType;
    }

    @Override
    public void update(PokemonType pokemonType) throws SQLException {
        Connection conn = DatabaseConnetion.getInstance().getConnection();
        String query = "UPDATE "+tableName+" SET type_name = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, pokemonType.getTypeName());
        ps.setInt(2, pokemonType.getId());
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
    public List<PokemonType> readAll() throws SQLException {
        List<PokemonType> pokemonTypes = new ArrayList();
        Connection conn = DatabaseConnetion.getInstance().getConnection();
        String query = "SELECT id, type_name FROM "+tableName;
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            pokemonTypes.add(new PokemonType(
                    rs.getInt(1),
                    rs.getString(2)
            ));
        }
        return pokemonTypes;
    }
}