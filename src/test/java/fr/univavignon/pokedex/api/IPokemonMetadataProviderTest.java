package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider mockMetadataProvider;

    @BeforeEach
    public void setUp() {
        // Création d'un mock pour IPokemonMetadataProvider
        mockMetadataProvider = mock(IPokemonMetadataProvider.class);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        // Configuration du mock pour retourner des métadonnées spécifiques quand un index spécifique est demandé
        when(mockMetadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90   ));

        // Exécution de la méthode testée
        PokemonMetadata metadata = mockMetadataProvider.getPokemonMetadata(0);

        // Assertions pour vérifier le comportement attendu
        assertEquals(0, metadata.getIndex());
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());
    }
    @Test
    public void testGetPokemonMetadataThrowsExceptionWhenIndexIsInvalid() throws PokedexException {
        // Configuration du mock pour lancer une exception quand un index invalide est demandé
        int invalidIndex = 151;
        Mockito.when(mockMetadataProvider.getPokemonMetadata(invalidIndex))
                .thenThrow(new PokedexException("Invalid index: " + invalidIndex));

        // Vérification que l'exception est bien lancée avec cet index
        assertThrows(PokedexException.class, () -> {
            mockMetadataProvider.getPokemonMetadata(invalidIndex);
        });
    }

}
