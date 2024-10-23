package com.pokemon;

import com.pokemon.connection.DatabaseConnetion;
import com.pokemon.dao.PokemonTypeDAO;
import com.pokemon.dao.PokemonTypeDAOImp;
import com.pokemon.model.PokemonType;
import com.pokemon.dao.PokemonAbilityDAO;
import com.pokemon.dao.PokemonAbilityDAOImp;
import com.pokemon.model.PokemonAbility;
import com.pokemon.dao.PokemonDAO;
import com.pokemon.dao.PokemonDAOImp;
import com.pokemon.model.Pokemon;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {

            // TIPO DE POKEMON (PokemonType)
            /*PokemonTypeDAO typeDAO = new PokemonTypeDAOImp();*/

            // Imprimir PokemonType
            /*List<PokemonType> types = typeDAO.readAll();
            System.out.println("\nLista de tipos de pokemons (PokemonType): ");
            int i = 1;
            for (PokemonType type : types){
                System.out.print(i + " ");
                i++;
                System.out.println(type.getTypeName());

            }*/

            // Crear PokemonType
            /*PokemonType nuevoTipo = new PokemonType(0, "Steel");
            typeDAO.create(nuevoTipo);*/

            // Actualizar PokemonType y leer PokemonType
            /*PokemonType tipo = typeDAO.read(12);
            System.out.println("Tipo de Pokemon: "+tipo.getTypeName());*/
            /*tipo.setTypeName("tipo actualizado");
            typeDAO.update(tipo);*/

            // Eliminar PokemonType
            /*typeDAO.delete(7);*/


            //_______________________________________________________________________________________________


            // HABILIDAD DE POKEMON (PokemonAbility)
            /*PokemonAbilityDAO abilityDAO = new PokemonAbilityDAOImp();*/

            // Imprimir PokemonAbility
            /*List<PokemonAbility> abilities = abilityDAO.readAll();
            System.out.println("\nLista de habilidades de pokemons (PokemonAbility): ");
            int i = 1;
            for (PokemonAbility ability : abilities){
                System.out.print(i + " ");
                i++;
                System.out.println(ability.getAbilityName());

            }*/

            // Crear PokemonAbility
            /*PokemonAbility nuevaHabilidad = new PokemonAbility(0, "Aftermath");
            abilityDAO.create(nuevaHabilidad);*/

            // Actualizar PokemonAbility y Leer PokemonAbility
            /*PokemonAbility habilidad = abilityDAO.read(12);
            System.out.println("Habilidad de Pokemon: "+habilidad.getAbilityName());*/
            /*habilidad.setAbilityName("habilidad actualizado");
            abilityDAO.update(habilidad);*/

            // Eliminar PokemonAbility
            /*abilityDAO.delete(8);*/


            //_______________________________________________________________________________________________


            // POKEMON (Pokemon)
            PokemonDAO pokemonDAO = new PokemonDAOImp();

            // Imprimir Pokemon
            /*List<Pokemon> pokemons = pokemonDAO.readAll();
            System.out.println("\nLista de pokemons (Pokemon): ");
            int i = 1;
            for (Pokemon pokemon : pokemons){
                System.out.print(i + " ");
                i++;
                System.out.print(pokemon.getPokemonName());
                System.out.print(" | Altura: " + pokemon.getHeight());
                System.out.print(" | Peso: " + pokemon.getWeight());
                System.out.print(" | Experiencia Base: " + pokemon.getBaseExperience());
                System.out.println(" | Tipo de Pokemon: " + pokemon.getType());

            }*/

            // Crear Pokemon
            /*Pokemon nuevoPokemon = new Pokemon(6, "Gardevoir", 1.6, 48.4, 233, 6);
            pokemonDAO.create(nuevoPokemon);*/

            // Actualizar Pokemon y Leer Pokemon*
            /*Pokemon pokemon = pokemonDAO.read(4);
            System.out.println("Pokemon: " + pokemon.getPokemonName() +
                    " | Altura: " + pokemon.getHeight() +
                    " | Peso: " + pokemon.getWeight() +
                    " | Experiencia Base: " + pokemon.getBaseExperience() +
                    " | Tipo de Pokemon: " + pokemon.getType());*/
            /*pokemon.setPokemonName("nombre actualizado");
            pokemonDAO.update(pokemon);*/

            // Eliminar Pokemon
            /*pokemonDAO.delete(6);*/

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}