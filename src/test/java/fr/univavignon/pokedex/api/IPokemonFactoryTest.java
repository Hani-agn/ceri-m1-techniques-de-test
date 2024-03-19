package fr.univavignon.pokedex.api;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;
    private IPokemonMetadataProvider metadataProvider;

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


    /*@Test
    public void testCreatePokemonWithAttributesOutOfBounds() {
        // Configuration du mock pour simuler une validation des attributs
        when(pokemonFactory.createPokemon(anyInt(), anyInt(), anyInt(), anyInt(), anyInt())).thenAnswer(invocation -> {
            int attack = invocation.getArgument(2); // Simulant l'attaque
            int defense = invocation.getArgument(3); // Simulant la défense
            int stamina = invocation.getArgument(4); // Simulant l'endurance

            // Validation de l'attaque, la défense et l'endurance
            if (attack < 0 || attack > 15 || defense < 0 || defense > 15 || stamina < 0 || stamina > 15) {
                throw new IllegalArgumentException("Attribute value out of bounds");
            }

            // Retourner un objet Pokémon mocké si les attributs sont valides
            return new Pokemon(1, "Pikachu", attack, defense, stamina, 500, 60, 1000, 50, 0.8);
        });

        // Vérification que l'exception est bien lancée pour chaque attribut hors des limites
        assertThrows(IllegalArgumentException.class,
                () -> pokemonFactory.createPokemon(1, 500, 60, -1, 11), "Attribute value out of bounds");
        assertThrows(IllegalArgumentException.class,
                () -> pokemonFactory.createPokemon(1, 500, 60, 10, -1), "Attribute value out of bounds");
        assertThrows(IllegalArgumentException.class,
                () -> pokemonFactory.createPokemon(1, 500, 60, 10, 16), "Attribute value out of bounds");
    }*/


}
