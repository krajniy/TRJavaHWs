package TRJavaHWs.lesson20.HW;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * First level: 1. Реализовать свой кастомный класс CustomStringBuilder,
 * который будет хранить в себе массив char, будет immutable и будет поддерживать операци
 * toString, charAt, length, append
 * Заимплементить Iterable этим классом и сделать реализацию итератора
 * без перевода данных в массиве в строку
 */

public final class CustomStringBuilder implements Iterable<Character> {
    private char[] chars;
    private final int defaultCapacity = 10;
    private final double toEnsure = 0.75;
    private int length = 0;


    public CustomStringBuilder() {
        this.chars = new char[defaultCapacity];
    }

    public CustomStringBuilder(int capacity) {
        this.chars = new char[capacity];
    }

    public CustomStringBuilder(String s) {
        this.chars = new char[s.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = s.charAt(i);
        }
        length += s.length();
    }

    public char charAt(int i) {
        return chars[i];
    }

    public int length() {
        return length;
    }

    public void append(String string) {
        if (string == null) {
            return;
        }
        ensureCapacity(string.length() + length);
        for (int i = 0; i < string.length(); i++) {
            chars[i + length] = string.charAt(i);
        }

        length += string.length();
    }

    private void ensureCapacity(double minCapacity) {
        if (minCapacity > chars.length * toEnsure) {
            chars = Arrays.copyOf(chars, (int) (minCapacity * 2));
        }

    }


    @Override
    public String toString() {
        char[] trimmed = Arrays.copyOf(chars, length);

        return String.valueOf(trimmed);
    }

    @Override
    public Iterator<Character> iterator() {
        return new Iterator<Character>() {
            private int i = 0;

            @Override
            public boolean hasNext() {
                return (i < length && chars[i] != '\0');
            }

            @Override
            public Character next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return chars[i++];
            }
        };


    }

    @Override
    public void forEach(Consumer<? super Character> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Character> spliterator() {
        return Iterable.super.spliterator();
    }
}
