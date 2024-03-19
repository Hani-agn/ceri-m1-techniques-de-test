package fr.univavignon.pokedex.api;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Pokedex implements IPokedex{
    private  List<Pokemon> pokemons;
    private  IPokemonMetadataProvider pokemonMetadaProvider;
    private  IPokemonFactory pokemonFactory;

    public Pokedex( IPokemonMetadataProvider pokemonMetadaProvider, IPokemonFactory pokemonFactory) {
        this.pokemons=new ArrayList<>();
        this.pokemonMetadaProvider = pokemonMetadaProvider;
        this.pokemonFactory = pokemonFactory;
    }

    @Override
    public int size() {
        return this.pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemon.getIndex();
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        return pokemons.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> result = pokemons;
        result.sort(order);
        return result;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pokemonMetadaProvider.getPokemonMetadata(index);
    }
}
