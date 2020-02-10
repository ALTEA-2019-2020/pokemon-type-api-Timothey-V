package com.miage.altea.tp.pokemon_type_api.service;

import com.fasterxml.jackson.databind.node.POJONode;
import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.repository.PokemonTypeRepository;
import com.miage.altea.tp.pokemon_type_api.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{
    @Autowired
    protected PokemonTypeRepository pokemonTypeRepository;
    protected TranslationRepository translationRepository;

    public PokemonTypeServiceImpl(PokemonTypeRepository pokemonTypeRepository){
        this.pokemonTypeRepository = pokemonTypeRepository;

    }

    public PokemonTypeServiceImpl() {
    }

    @Override
    public PokemonType getPokemonType(int id) {
        PokemonType p = pokemonTypeRepository.findPokemonTypeById(id);
        p.setName(translationRepository.getPokemonName(id, LocaleContextHolder.getLocale()));
        return p;

    }

    @Override
    public List<PokemonType> getAllPokemonTypes(){
        List<PokemonType> listPoke = pokemonTypeRepository.findAllPokemonType();
        for (PokemonType pokemon:listPoke) {
           pokemon.setName(translationRepository.getPokemonName(pokemon.getId(),LocaleContextHolder.getLocale()));
        }
        listPoke.sort(Comparator.comparingInt(PokemonType::getId));
        return listPoke;
    }


   @Override
    public PokemonType getPokemonName (String name){
        return pokemonTypeRepository.findPokemonTypeByName(name);}

    public void setPokemonTypeRepository(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    public PokemonTypeRepository getPokemonTypeRepository() {
        return pokemonTypeRepository;
    }

    public TranslationRepository getTranslationRepository() {
        return translationRepository;
    }

    @Autowired
    public void setTranslationRepository(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }
}