package com.miage.altea.tp.pokemon_type_api.controller;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon-types")
public class PokemonTypeController {

    protected PokemonTypeService pokemonTypeService;

    @Autowired
    public PokemonTypeController(PokemonTypeService pokemonTypeService ) {
        this.pokemonTypeService = pokemonTypeService;
    }

    @GetMapping("/{id}")
    PokemonType getPokemonTypeFromId(@PathVariable int id){
        return pokemonTypeService.getPokemonType(id);
    }

    @GetMapping("/")
    public List<PokemonType> getAllPokemonTypes() {
        return pokemonTypeService.getAllPokemonTypes();
    }

    @GetMapping(value = "/", params = "name")
    public PokemonType getPokemonTypeFromName (@RequestParam String name){ return pokemonTypeService.getPokemonName(name);}
}
