package fr.univavignon.pokedex.api;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;
    private IPokemonMetadataProvider metadataProvider;

    private RocketPokemonFactory rocketPokemonFactory;

    @BeforeEach
    public void setUp() {
        pokemonFactory = new PokemonFactory();
        metadataProvider = mock(IPokemonMetadataProvider.class);
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon pokemon = this.pokemonFactory.createPokemon(0, 613, 64,
                4000, 4);

        // Vérification des valeurs récupérées
        assertEquals(0, pokemon.getIndex());
        assertEquals(613, pokemon.getCp());
        assertEquals(64, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());

    }



}
