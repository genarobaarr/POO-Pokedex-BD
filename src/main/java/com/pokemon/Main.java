package com.pokemon;

import com.pokemon.dao.PokemonTypeDAO;
import com.pokemon.dao.PokemonTypeDAOImp;
import com.pokemon.model.PokemonType;
import com.pokemon.dao.PokemonAbilityDAO;
import com.pokemon.dao.PokemonAbilityDAOImp;
import com.pokemon.model.PokemonAbility;
import com.pokemon.dao.PokemonDAO;
import com.pokemon.dao.PokemonDAOImp;
import com.pokemon.model.Pokemon;


import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            int lecturaPrincipal;

            //Lectura
            /*caracterJOpt = JOptionPane.showInputDialog("Escribe un caracter:").charAt(0);
            numeroJOpt = Double.parseDouble(JOptionPane.showInputDialog("Escribe un numero con decimales:"));*/

            // MENÚ
            do {
                lecturaPrincipal = Integer.parseInt(JOptionPane.showInputDialog("<<<MENU PRINCIPAL>>>\n1. Pokémon Type" +
                        "\n2. Pokémon Ability" + "\n3. Pokémon" + "\n4. Salir del programa."));

                switch (lecturaPrincipal) {
                    case 1:
                        // POKÉMON TYPE
                        int lecturaPKT;
                        do {
                            lecturaPKT = Integer.parseInt(JOptionPane.showInputDialog("<<<MENU Pokémon Type>>>" +
                                    "\n1. Imprimir todos los Pokémon Type" + "\n2. Crear nuevo Pokémon Type" +
                                    "\n3. Imprimir un Pokémon Type específico" + "\n4. Actualizar un Pokémon Type" +
                                    "\n5. Eliminar un Pokémon Type" + "\n6. Regresar al menú principal"));
                            PokemonTypeDAO typeDAO = new PokemonTypeDAOImp();

                            switch (lecturaPKT) {

                                case 1:
                                    JOptionPane.showMessageDialog(null, "<<<Imprimiendo todos los Pokémon Types>>>\n");
                                    List<PokemonType> types = typeDAO.readAll();
                                    int i = 1;
                                    for (PokemonType type : types){
                                        System.out.print(i + ". ");
                                        i++;
                                        System.out.println(type.getTypeName());

                                    }
                                    break;

                                case 2:
                                    String lecturaNewPKT;
                                    lecturaNewPKT = JOptionPane.showInputDialog("<<<Creando nuevo Pokémon Type>>>\n" +
                                            "Escribe el nuevo Pokémon Type:");

                                    PokemonType nuevoTipo = new PokemonType(0, lecturaNewPKT);
                                    typeDAO.create(nuevoTipo);

                                    JOptionPane.showMessageDialog(null, "Pokémon Type creado");
                                    break;

                                case 3:
                                    int lecturaReadPKT;
                                    lecturaReadPKT = Integer.parseInt(JOptionPane.showInputDialog(
                                            "<<<Leyendo Pokémon Type específico>>>\n" + "Escribe el ID del Pokémon Type:"));

                                    PokemonType tipo1 = typeDAO.read(lecturaReadPKT);
                                    JOptionPane.showMessageDialog(null, "Pokémon Type: " + tipo1.getTypeName());
                                    break;

                                case 4:
                                    int lecturaUpdPKT;
                                    String lecturaUpdatePKT;
                                    lecturaUpdPKT = Integer.parseInt(JOptionPane.showInputDialog(
                                            "<<<Actualizando Pokémon Type>>>\n" + "Escribe el ID del Pokémon Type:"));

                                    PokemonType tipo2 = typeDAO.read(lecturaUpdPKT);

                                    lecturaUpdatePKT = JOptionPane.showInputDialog("Pokémon Type actual: " + tipo2.getTypeName() +
                                            "\nEscribe el nuevo Pokémon Type:");
                                    tipo2.setTypeName(lecturaUpdatePKT);
                                    typeDAO.update(tipo2);

                                    JOptionPane.showMessageDialog(null, "Pokémon Type actualizado: " + tipo2.getTypeName());
                                    break;

                                case 5:
                                    int lecturaDelPKT;
                                    lecturaDelPKT = Integer.parseInt(JOptionPane.showInputDialog(
                                            "<<<Eliminando Pokémon Type>>>\n" + "Escribe el ID del Pokémon Type:"));

                                    typeDAO.delete(lecturaDelPKT);
                                    JOptionPane.showMessageDialog(null, "Pokémon Type eliminado");
                                    break;

                                case 6:
                                    JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
                                    break;

                                default:
                                    JOptionPane.showMessageDialog(null, "Introduce una opción válida...");
                                    break;
                            }
                        } while (lecturaPKT != 6);
                        break;
                    case 2:
                        // POKÉMON ABILITY
                        int lecturaPKA;
                        do {
                            lecturaPKA = Integer.parseInt(JOptionPane.showInputDialog("<<<MENU Pokémon Ability>>>" +
                                    "\n1. Imprimir todos los Pokémon Ability" + "\n2. Crear nuevo Pokémon Ability" +
                                    "\n3. Imprimir un Pokémon Ability específico" + "\n4. Actualizar un Pokémon Ability" +
                                    "\n5. Eliminar un Pokémon Ability" + "\n6. Regresar al menú principal"));
                            PokemonAbilityDAO abilityDAO = new PokemonAbilityDAOImp();

                            switch (lecturaPKA) {

                                case 1:
                                    JOptionPane.showMessageDialog(null, "<<<Imprimiendo todas las Pokémon Abilities>>>\n");
                                    List<PokemonAbility> abilities = abilityDAO.readAll();
                                    int i = 1;
                                    for (PokemonAbility ability : abilities){
                                        System.out.print(i + ". ");
                                        i++;
                                        System.out.println(ability.getAbilityName());

                                    }
                                    break;

                                case 2:
                                    String lecturaNewPKA;
                                    lecturaNewPKA = JOptionPane.showInputDialog("<<<Creando nueva Pokémon Ability>>>\n" +
                                            "Escribe la nueva Pokémon Ability:");

                                    PokemonAbility nuevaHabilidad = new PokemonAbility(0, lecturaNewPKA);
                                    abilityDAO.create(nuevaHabilidad);

                                    JOptionPane.showMessageDialog(null, "Pokémon Ability creada");
                                    break;

                                case 3:
                                    int lecturaReadPKA;
                                    lecturaReadPKA = Integer.parseInt(JOptionPane.showInputDialog(
                                            "<<<Leyendo Pokémon Ability específica>>>\n" + "Escribe el ID de la Pokémon Ability:"));

                                    PokemonAbility habilidad1 = abilityDAO.read(lecturaReadPKA);
                                    JOptionPane.showMessageDialog(null, "Pokémon Ability: " + habilidad1.getAbilityName());
                                    break;

                                case 4:
                                    int lecturaUpdPKA;
                                    String lecturaUpdatePKA;
                                    lecturaUpdPKA = Integer.parseInt(JOptionPane.showInputDialog(
                                            "<<<Actualizando Pokémon Ability>>>\n" + "Escribe el ID de la Pokémon Ability:"));

                                    PokemonAbility habilidad2 = abilityDAO.read(lecturaUpdPKA);

                                    lecturaUpdatePKA = JOptionPane.showInputDialog("Pokémon Ability actual: " + habilidad2.getAbilityName() +
                                            "\nEscribe la nueva Pokémon Ability:");
                                    habilidad2.setAbilityName(lecturaUpdatePKA);
                                    abilityDAO.update(habilidad2);

                                    JOptionPane.showMessageDialog(null, "Pokémon Ability actualizada: " + habilidad2.getAbilityName());
                                    break;

                                case 5:
                                    int lecturaDelPKA;
                                    lecturaDelPKA = Integer.parseInt(JOptionPane.showInputDialog(
                                            "<<<Eliminando Pokémon Ability>>>\n" + "Escribe el ID de la Pokémon Ability:"));

                                    abilityDAO.delete(lecturaDelPKA);
                                    JOptionPane.showMessageDialog(null, "Pokémon Ability eliminada");
                                    break;

                                case 6:
                                    JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
                                    break;

                                default:
                                    JOptionPane.showMessageDialog(null, "Introduce una opción válida...");
                                    break;
                            }
                        } while (lecturaPKA != 6);
                        break;
                    case 3:
                        // POKÉMON
                        int lecturaPK;
                        do {
                            lecturaPK = Integer.parseInt(JOptionPane.showInputDialog("<<<MENU Pokémon>>>" +
                                    "\n1. Imprimir todos los Pokémon" + "\n2. Crear nuevo Pokémon" +
                                    "\n3. Imprimir un Pokémon específico" + "\n4. Actualizar un Pokémon" +
                                    "\n5. Eliminar un Pokémon" + "\n6. Regresar al menú principal"));
                            PokemonDAO pokemonDAO = new PokemonDAOImp();

                            switch (lecturaPK) {

                                case 1:
                                    JOptionPane.showMessageDialog(null, "<<<Imprimiendo todos los Pokémon>>>\n");
                                    List<Pokemon> pokemons = pokemonDAO.readAll();
                                    int i = 1;
                                    for (Pokemon pokemon : pokemons){
                                        System.out.print(i + ". ");
                                        i++;
                                        System.out.print(pokemon.getPokemonName());
                                        System.out.print(" | Altura: " + pokemon.getHeight());
                                        System.out.print(" | Peso: " + pokemon.getWeight());
                                        System.out.print(" | Experiencia Base: " + pokemon.getBaseExperience());
                                        System.out.println(" | Tipo de Pokémon: " + pokemon.getType());

                                    }
                                    break;

                                case 2:
                                    int lecturaNewPKID;
                                    String lecturaNewPKName;
                                    double lecturaNewPKHeight;
                                    double lecturaNewPKWeight;
                                    int lecturaNewPKBE;
                                    int lecturaNewPKTypeID;

                                    lecturaNewPKID = Integer.parseInt(JOptionPane.showInputDialog("<<<Creando nuevo Pokémon>>>\n" +
                                            "Escribe el ID del nuevo Pokémon:"));
                                    lecturaNewPKName = JOptionPane.showInputDialog("<<<Creando nuevo Pokémon>>>\n" +
                                            "Escribe el nombre del nuevo Pokémon:");
                                    lecturaNewPKHeight = Double.parseDouble(JOptionPane.showInputDialog("<<<Creando nuevo Pokémon>>>\n" +
                                            "Escribe la altura del nuevo Pokémon:"));
                                    lecturaNewPKWeight = Double.parseDouble(JOptionPane.showInputDialog("<<<Creando nuevo Pokémon>>>\n" +
                                            "Escribe el peso del nuevo Pokémon:"));
                                    lecturaNewPKBE = Integer.parseInt(JOptionPane.showInputDialog("<<<Creando nuevo Pokémon>>>\n" +
                                            "Escribe la experiencia base del nuevo Pokémon:"));
                                    lecturaNewPKTypeID = Integer.parseInt(JOptionPane.showInputDialog("<<<Creando nuevo Pokémon>>>\n" +
                                            "Escribe el ID del tipo de Pokémon del nuevo Pokémon:"));

                                    Pokemon nuevoPokemon = new Pokemon(lecturaNewPKID, lecturaNewPKName,
                                            lecturaNewPKHeight, lecturaNewPKWeight, lecturaNewPKBE, lecturaNewPKTypeID);
                                    pokemonDAO.create(nuevoPokemon);

                                    JOptionPane.showMessageDialog(null, "Pokémon creado");
                                    break;

                                case 3:
                                    int lecturaReadPK;
                                    lecturaReadPK = Integer.parseInt(JOptionPane.showInputDialog(
                                            "<<<Leyendo Pokémon específico>>>\n" + "Escribe el ID del Pokémon:"));

                                    Pokemon pokemon1 = pokemonDAO.read(lecturaReadPK);
                                    JOptionPane.showMessageDialog(null, "Pokémon: " + pokemon1.getPokemonName() +
                                            "\nAltura: " + pokemon1.getHeight() +
                                            "\nPeso: " + pokemon1.getWeight() +
                                            "\nExperiencia Base: " + pokemon1.getBaseExperience() +
                                            "\nTipo de Pokemon: " + pokemon1.getType());
                                    break;

                                case 4:
                                    int lecturaUpdPKID;
                                    int lecturaUpdPKOpc;
                                    String lecturaUpdPKName;
                                    double lecturaUpdPKHeight;
                                    double lecturaUpdPKWeight;
                                    int lecturaUpdPKEB;
                                    int lecturaUpdPKTypeID;

                                    lecturaUpdPKID = Integer.parseInt(JOptionPane.showInputDialog(
                                            "<<<Actualizando Pokémon>>>\n" + "Escribe el ID del Pokémon:"));

                                    Pokemon pokemon2 = pokemonDAO.read(lecturaUpdPKID);

                                    lecturaUpdPKOpc = Integer.parseInt(JOptionPane.showInputDialog(
                                            "<<<Actualizando Pokémon>>>\n" +
                                            "Escribe la opción que quieras actualizar del Pokémon con ID " + lecturaUpdPKID +
                                            "." + "\n1. Nombre" + "\n2. Altura" + "\n3. Peso" + "\n4. Experiencia base" +
                                            "\n5. Tipo de Pokémon"));

                                    switch (lecturaUpdPKOpc) {
                                        case 1:
                                            lecturaUpdPKName = JOptionPane.showInputDialog(
                                                    "Pokémon actual: " + pokemon2.getPokemonName() +
                                                    "\nAltura actual: " + pokemon2.getHeight() +
                                                    "\nPeso actual: " + pokemon2.getWeight() +
                                                    "\nExperiencia base actual: " + pokemon2.getBaseExperience() +
                                                    "\nTipo de Pokémon actual: " + pokemon2.getType() +
                                                    "\nEscribe el nuevo nombre del Pokémon:");
                                            pokemon2.setPokemonName(lecturaUpdPKName);
                                            break;
                                        case 2:
                                            lecturaUpdPKHeight = Double.parseDouble(JOptionPane.showInputDialog(
                                                    "Pokémon actual: " + pokemon2.getPokemonName() +
                                                    "\nAltura actual: " + pokemon2.getHeight() +
                                                    "\nPeso actual: " + pokemon2.getWeight() +
                                                    "\nExperiencia base actual: " + pokemon2.getBaseExperience() +
                                                    "\nTipo de Pokémon actual: " + pokemon2.getType() +
                                                    "\nEscribe la nueva altura del Pokémon:"));
                                            pokemon2.setHeight(lecturaUpdPKHeight);
                                            break;
                                        case 3:
                                            lecturaUpdPKWeight = Double.parseDouble(JOptionPane.showInputDialog(
                                                    "Pokémon actual: " + pokemon2.getPokemonName() +
                                                    "\nAltura actual: " + pokemon2.getHeight() +
                                                    "\nPeso actual: " + pokemon2.getWeight() +
                                                    "\nExperiencia base actual: " + pokemon2.getBaseExperience() +
                                                    "\nTipo de Pokémon actual: " + pokemon2.getType() +
                                                    "\nEscribe el nuevo peso del Pokémon:"));
                                            pokemon2.setWeight(lecturaUpdPKWeight);
                                            break;
                                        case 4:
                                            lecturaUpdPKEB = Integer.parseInt(JOptionPane.showInputDialog(
                                                    "Pokémon actual: " + pokemon2.getPokemonName() +
                                                    "\nAltura actual: " + pokemon2.getHeight() +
                                                    "\nPeso actual: " + pokemon2.getWeight() +
                                                    "\nExperiencia base actual: " + pokemon2.getBaseExperience() +
                                                    "\nTipo de Pokémon actual: " + pokemon2.getType() +
                                                    "\nEscribe la nueva Experiencia base del Pokémon:"));
                                            pokemon2.setBaseExperience(lecturaUpdPKEB);
                                            break;
                                        case 5:
                                            lecturaUpdPKTypeID = Integer.parseInt(JOptionPane.showInputDialog(
                                                    "Pokémon actual: " + pokemon2.getPokemonName() +
                                                    "\nAltura actual: " + pokemon2.getHeight() +
                                                    "\nPeso actual: " + pokemon2.getWeight() +
                                                    "\nExperiencia base actual: " + pokemon2.getBaseExperience() +
                                                    "\nTipo de Pokémon actual: " + pokemon2.getType() +
                                                    "\nEscribe el nuevo Tipo de Pokémon del Pokémon:"));
                                            pokemon2.setType(lecturaUpdPKTypeID);
                                            break;
                                    }

                                    pokemonDAO.update(pokemon2);

                                    JOptionPane.showMessageDialog(null, "Pokémon" +
                                            pokemon2.getPokemonName() + "actualizado");
                                    break;

                                case 5:
                                    int lecturaDelPK;
                                    lecturaDelPK = Integer.parseInt(JOptionPane.showInputDialog(
                                            "<<<Eliminando Pokémon>>>\n" + "Escribe el ID del Pokémon:"));

                                    pokemonDAO.delete(lecturaDelPK);
                                    JOptionPane.showMessageDialog(null, "Pokémon eliminado");
                                    break;

                                case 6:
                                    JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
                                    break;

                                default:
                                    JOptionPane.showMessageDialog(null, "Introduce una opción válida...");
                                    break;
                            }
                            break;
                        } while (lecturaPK != 6);
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Introduce una opción válida...");
                        break;

                }
            } while (lecturaPrincipal != 4);

//_____________________________________________________IGNORE_____________________________________________________

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
                /*PokemonDAO pokemonDAO = new PokemonDAOImp();*/

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
//_____________________________________________________END_IGNORE_____________________________________________________

        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}