package me.anatoli.mutable;

import me.anatoli.mutable.impl.DefaultMutator;

public class Runner {

    public static void main(String[] args) {
        if (args == null || args.length != 1 || args[0] == null) {
            System.out.println("Please provide a string to mutate");
            return;
        }
        String input = args[0];
        int inputLenght = input.length();
        System.out.println("Input string:\t" + input);
        andHereWhereMagicIsInvoked(input);
        System.out.println("Mutated string:\t" + input);
        if (inputLenght == input.length()) {
            System.out.println("\nUuups... No can do, man!");
        } else {
            System.out.println("\nHow is it possible if string is immutable?\n");
        }
        System.out.println(";)");
    }

    /**
     * Try to guess before going to sources
     * 
     * @param input
     */
    private static void andHereWhereMagicIsInvoked(String input) {
        Mutator mutator = new DefaultMutator();
        mutator.mutate(input);
    }

}
