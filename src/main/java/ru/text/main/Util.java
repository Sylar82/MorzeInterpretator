package ru.text.main;

public final class Util {
    private Util() {

    }

    public static boolean isMorze(String input) {

        return !input.matches("[А-Я а-я0-9]+");
    }

 //   public static
}
