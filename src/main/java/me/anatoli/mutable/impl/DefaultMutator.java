package me.anatoli.mutable.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.AccessControlException;

import me.anatoli.mutable.Mutator;

public class DefaultMutator implements Mutator {

    @Override
    public String mutate(String input) {
        Field value = getField("value", String.class);
        makeAccessible(value);

        char[] comboChars = extendCharsArray(input);

        try {
            value.set(input, comboChars);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            // going nasty... and hide this exception also
        }
        return input;
    }

    private char[] extendCharsArray(String input) {
        char[] chars = input.toCharArray();
        char[] mutateChars = Mutator.MUTANT.toCharArray();
        char[] comboChars = new char[chars.length + mutateChars.length];
        System.arraycopy(mutateChars, 0, comboChars, 0, mutateChars.length);
        System.arraycopy(chars, 0, comboChars, mutateChars.length, chars.length);
        return comboChars;
    }

    private void makeAccessible(Field value) {
        if (value == null) {
            return;
        }
        value.setAccessible(true);
        Field modifiersField = getField("modifiers", Field.class);
        modifiersField.setAccessible(true);
        try {
            modifiersField.setInt(value, value.getModifiers() & ~Modifier.FINAL);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private Field getField(String fieldName, Class<?> clazz) {
        Field value = null;
        try {
            value = clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            String javaVersion = Runtime.class.getPackage().getImplementationVersion();
            String javaVendor = Runtime.class.getPackage().getImplementationVendor();
            throw new IllegalStateException(
                    String.format("It seems that you have java version %s, vendor %s, where class %s has other, than %s, field name",
                            javaVersion, javaVendor, clazz.getName(), fieldName),
                    e);
        } catch (AccessControlException e) {
            // hide exception
        }
        return value;
    }

}
