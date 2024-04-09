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
    public class RocketPokemonFactoryTest {

        private RocketPokemonFactory rocketPokemonFactory;

        @BeforeEach
        public void setUp() {
            rocketPokemonFactory = new RocketPokemonFactory();
        }

        @Test
        public void testCreatePokemonWithValidIndex() {
            // On utilise l'index de Bulbasaur qui est 1.
            Pokemon bulbasaur = rocketPokemonFactory.createPokemon(1, 613, 64, 4000, 4);

            // Vérifications des valeurs récupérées.
            assertEquals(1, bulbasaur.getIndex());
            assertEquals("Bulbasaur", bulbasaur.getName());
            assertEquals(613, bulbasaur.getCp());
            assertEquals(64, bulbasaur.getHp());
            assertEquals(4000, bulbasaur.getDust());
            assertEquals(4, bulbasaur.getCandy());
            assertEquals(1, bulbasaur.getIv(), "L'IV doit être de 1 pour un index valide.");
        }

        @Test
        public void testCreatePokemonWithInvalidIndex() {
            // On utilise un index invalide, par exemple -2.
            Pokemon missingno = rocketPokemonFactory.createPokemon(-2, 613, 64, 4000, 4);

            // Vérifications des valeurs récupérées.
            assertEquals("MISSINGNO", missingno.getName(), "Le nom doit être MISSINGNO pour un index invalide.");
            assertEquals(0, missingno.getIv(), "L'IV doit être de 0 pour un index invalide.");
        }

    }




}
