package com.pokemon.model;

import java.io.Serializable;

public class PokemonAbility implements Serializable {
    private int id;
    private String abilityName;

    public PokemonAbility() {

    }

    public PokemonAbility(int id, String abilityName) {
        this.id = id;
        this.abilityName = abilityName;
    }

    public String getAbilityName() {
        return abilityName;
    }

    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
