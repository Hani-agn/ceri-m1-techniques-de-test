package fr.univavignon.pokedex.api;
import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setUp() {
        // Initialisation des mocks
        pokedexFactory = mock(IPokedexFactory.class);
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokedex() {

        // Configuration du mock de pokedexFactory pour retourner une instance de pokedex
        // lors de l'appel à createPokedex avec les mocks de metadataProvider et pokemonFactory
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(mock(IPokedex.class));

        // Appel de la méthode à tester
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        // Vérification que l'instance de pokedex retournée n'est pas null
        assertNotNull(pokedex, "La factory doit retourner une instance non nulle de IPokedex");

        // Ici, vous pouvez ajouter des vérifications supplémentaires si nécessaire,
        // par exemple, vérifier que les méthodes de l'instance retournée peuvent être appelées
        // et retournent des valeurs ou comportements attendus.
    }
}
