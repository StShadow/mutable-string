package me.anatoli.mutable;

public interface Mutator {
    /**
     * Adds 'mutated!' to the middle of the string
     * 
     * @param input
     * @return mutated input
     */
    String mutate(final String input);
}
