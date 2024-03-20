package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {
    PokemonMetadatProvider pokemonMetadatProvider;

    @BeforeEach
    public void setUp() {
       pokemonMetadatProvider = new PokemonMetadatProvider();

    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        // Vérification des informations récupérées pour Bulbizarre
        PokemonMetadata pokemonMetadata = this.pokemonMetadatProvider.getPokemonMetadata(0);
        assertEquals("Bulbasaur", pokemonMetadata.getName());
        assertEquals(126, pokemonMetadata.getAttack());
        assertEquals(126, pokemonMetadata.getDefense());
        assertEquals(90, pokemonMetadata.getStamina());
    }
    @Test
    public void testGetPokemonMetadataThrowsExceptionWhenIndexIsInvalid() throws PokedexException {
        // Configuration du mock pour lancer une exception quand un index invalide est demandé
        int invalidIndex = 151;
        //when(mockMetadataProvider.getPokemonMetadata(invalidIndex))
        //        .thenThrow(new PokedexException("Invalid index: " + invalidIndex));

        // Appel de la méthode pour obtenir les métadonnées du Pokémon avec un index invalide
        // Ceci doit lancer une exception
        assertThrows(PokedexException.class, () -> {
            pokemonMetadatProvider.getPokemonMetadata(invalidIndex);
        });
    }
    @Test
    public void testGetPokemonMetadataThrowsExceptionWhenIndexIsInvalid2() throws PokedexException {
        // Configuration du mock pour lancer une exception quand un index invalide est demandé
        int invalidIndex = -1;
        //when(pokemonMetadatProvider.getPokemonMetadata(invalidIndex))
        //        .thenThrow(new PokedexException("Invalid index: " + invalidIndex));

        // Appel de la méthode pour obtenir les métadonnées du Pokémon avec un index invalide
        // Ceci doit lancer une exception
        assertThrows(PokedexException.class, () -> {
            pokemonMetadatProvider.getPokemonMetadata(invalidIndex);
        });
    }




}
