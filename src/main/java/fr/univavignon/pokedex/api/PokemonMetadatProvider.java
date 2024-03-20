package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the IPokemonMetadataProvider interface.
 * @see IPokemonMetadataProvider
 * list of pokemons metadata
 */

public class PokemonMetadatProvider implements IPokemonMetadataProvider{

    List<PokemonMetadata> pokemonsMetadata;
    public PokemonMetadatProvider() {
        pokemonsMetadata = new ArrayList<>();
        pokemonsMetadata.add(new PokemonMetadata(0, "Bulbasaur", 126, 126,
                90));

    }
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if(index < 0 || index >= pokemonsMetadata.size()){
            throw new PokedexException("Invalid index");
        }
        return pokemonsMetadata.get(index);
    }
}
