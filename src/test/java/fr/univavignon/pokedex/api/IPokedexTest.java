package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IPokedexTest {

    private IPokedex pokedex;
    private PokemonMetadata pokemonMetadata;

    @BeforeEach
    public void setUp() throws PokedexException {
        IPokemonMetadataProvider pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
        pokemonMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
    }

    @Test
    public void testSize() throws PokedexException {
        assertEquals(0, pokedex.size());
    }

    @Test
    public void testAddPokemon() throws PokedexException {
        Pokemon pokemon = new Pokemon(
                0, // index
                "Bulbizarre", // name
                126, // attack
                126, // defense
                90, // stamina
                613, // cp
                64, // hp
                4000, // dust
                4, // candy
                56 // iv
        );
        assertEquals(0, pokedex.addPokemon(pokemon));
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon expectedPokemon = new Pokemon(
                0, // index
                "Bulbizarre", // name
                126, // attack
                126, // defense
                90, // stamina
                613, // cp
                64, // hp
                4000, // dust
                4, // candy
                56 // iv
        );
        pokedex.addPokemon(expectedPokemon);
        assertEquals(expectedPokemon, pokedex.getPokemon(0));
    }

    @Test
    public void testGetPokemons() throws PokedexException {
        List<Pokemon> pokemonList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Pokemon pokemon = new Pokemon(
                    i+1, // index
                    "Bulbizarre", // name
                    126, // attack
                    126, // defense
                    90, // stamina
                    613, // cp
                    64, // hp
                    4000, // dust
                    4, // candy
                    56 // iv
            );
            pokemonList.add(pokemon);
            pokedex.addPokemon(pokemon);
        }
        assertEquals(pokemonList, pokedex.getPokemons());
    }

    @Test
    public void testGetPokemonsSorted() throws PokedexException {
        List<Pokemon> pokemonList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Pokemon pokemon = new Pokemon(
                    i + 1,
                    "Bulbizarre", // name
                    126, // attack
                    126, // defense
                    126, // stamina
                    613, // cp
                    64, // hp
                    4000, // dust
                    4, // candy
                    56 // iv
            );
            pokemonList.add(pokemon);
            pokedex.addPokemon(pokemon);
        }
        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getName);
        pokemonList.sort(comparator);
        assertEquals(pokemonList, pokedex.getPokemons(comparator));
    }
}