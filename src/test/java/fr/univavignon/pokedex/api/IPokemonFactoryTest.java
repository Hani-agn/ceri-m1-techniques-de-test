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
        pokemonFactory = mock(IPokemonFactory.class);
        metadataProvider = mock(IPokemonMetadataProvider.class);
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        // Configuration des métadonnées pour un Pokémon spécifique
        int index = 0; // Index pour Bulbasaur, par exemple
        String name = "Bulbizarre";
        int baseAttack = 126;
        int baseDefense = 126;
        int baseStamina = 90;
        int cp = 613;
        int hp = 64;
        int dust = 4000;
        int candy = 4;
        double iv = 56;

        // Configurer les métadonnées à renvoyer par le metadataProvider mock
        PokemonMetadata metadata = new PokemonMetadata(index, name, baseAttack, baseDefense, baseStamina);
        when(metadataProvider.getPokemonMetadata(index)).thenReturn(metadata);

        // Calculer les statistiques réelles du Pokémon en fonction de ses métadonnées et des valeurs données
        int actualAttack = baseAttack + (cp / 10);
        int actualDefense = baseDefense + (cp / 10);
        int actualStamina = baseStamina + (hp / 10);

        // Configurer le pokemonFactory mock pour créer un nouveau Pokémon avec les attributs donnés
        when(pokemonFactory.createPokemon(index, cp, hp, dust, candy))
                .thenReturn(new Pokemon(index, name, actualAttack, actualDefense, actualStamina, cp, hp, dust, candy, iv));

        // Créer un Pokémon à l'aide de la factory mockée
        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        // Assertions pour vérifier si le Pokémon créé possède les bons attributs
        assertAll("pokemon",
                () -> assertEquals(index, pokemon.getIndex()),
                () -> assertEquals(name, pokemon.getName()),
                () -> assertEquals(actualAttack, pokemon.getAttack()),
                () -> assertEquals(actualDefense, pokemon.getDefense()),
                () -> assertEquals(actualStamina, pokemon.getStamina()),
                () -> assertEquals(cp, pokemon.getCp()),
                () -> assertEquals(hp, pokemon.getHp()),
                () -> assertEquals(dust, pokemon.getDust()),
                () -> assertEquals(candy, pokemon.getCandy()),
                () -> assertEquals(iv, pokemon.getIv(), 0.01) // La marge d'erreur permet des variations mineures dans les calculs à virgule flottante
        );
    }

    @Test
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
    }


}
