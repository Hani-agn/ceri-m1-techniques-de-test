package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonTrainerFactory;
import fr.univavignon.pokedex.api.PokemonTrainer;
import fr.univavignon.pokedex.api.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;
    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;

    @BeforeEach
    public void setUp() {
        // Création des mocks pour IPokedexFactory et IPokedex
        trainerFactory = new PokemonTrainerFactory();
        pokedexFactory = new PokedexFactory();
        pokedex = new Pokedex(new PokemonMetadatProvider(), new PokemonFactory());

        // Configuration du mock pokedexFactory pour retourner un pokedex mocké
        //when(pokedexFactory.createPokedex(any(), any())).thenReturn(pokedex);
    }

    @Test
    public void testCreateTrainer() {
        // Nom et équipe pour le PokemonTrainer à créer
        String expectedName = "Ash";
        Team expectedTeam = Team.MYSTIC;

        // Configuration du mock trainerFactory pour retourner un PokemonTrainer
       // when(trainerFactory.createTrainer(eq(expectedName), eq(expectedTeam), any(IPokedexFactory.class)))
       //         .thenReturn(new PokemonTrainer(expectedName, expectedTeam, pokedex));

        // Création du PokemonTrainer via la factory
        PokemonTrainer trainer = trainerFactory.createTrainer(expectedName, expectedTeam, pokedexFactory);

        // Assertions pour vérifier si le trainer retourné a les bonnes propriétés
        assertNotNull(trainer, "Le trainer ne devrait pas être null");
        assertEquals(expectedName, trainer.getName(), "Le nom du trainer ne correspond pas");
        assertEquals(expectedTeam, trainer.getTeam(), "L'équipe du trainer ne correspond pas");
        assertNotNull(trainer.getPokedex(), "Le Pokédex du trainer ne devrait pas être null");
    }
}
