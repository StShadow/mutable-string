package me.anatoli.mutable.impl;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import me.anatoli.mutable.Mutator;

public class DefaultMutatorTest {

    @Test
    public void shouldReturnTheSameInstance() {
        // given
        final String input = "blablabla";
        DefaultMutator mutator = new DefaultMutator();
        // when
        System.out.println(input);
        String mutated = mutator.mutate(input);
        // then
        assertThat(mutated, equalTo(input));
        assertThat(input, containsString(Mutator.MUTANT));
        assertThat(input, sameInstance(mutated));
        assertThat(input == mutated, equalTo(true));
        System.out.println(input);
    }
}
