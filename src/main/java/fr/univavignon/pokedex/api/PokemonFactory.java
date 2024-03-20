package fr.univavignon.pokedex.api;

/**
 * Implementation of the IPokemonFactory interface.
 * create a half created Pokemon object.
 * @see IPokemonFactory
 */

public class PokemonFactory implements IPokemonFactory{
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return new Pokemon(index, "", 0, 0, 0, cp, hp, dust,candy ,0);
    }
}
