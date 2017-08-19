package me.anatoli.mutable;

public interface Mutator {

    String MUTANT = "mutated!";

    /**
     * Adds 'mutated!' to the middle of the string
     *
     * @param input
     * @return mutated input
     */
    String mutate(final String input);
}
