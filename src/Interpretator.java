package src;


import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Interpretator {

    private Map<Character, String> hashMapToMorze = new HashMap<>();
    private Map<String, Character> hashMapToCyrillic = new HashMap<>();


    void initMap() {
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,:; ";
        String[] alphabetMorze = new String[]{"·−", "−···", "·−−", "−−·", "−··", "·", "·", "···−", "−−··", "··", "·−−−", "−·−",
                "·−··", "−−", "−·", "−−−", "·−−·", "·−·", "···", "−", "··−", "··−·", "····", "−·−·", "−−−·", "−−−−", "−−·−",
                "−−·−−", "−·−−", "−··−", "··−··", "··−−", "·−·−", "······", "·−·−·−", "−−−···", "−·−·−·", ""};

        for (int i = 0; i < alphabet.length(); i++) {
            hashMapToMorze.put(alphabet.charAt(i), alphabetMorze[i]);
            hashMapToCyrillic.put(alphabetMorze[i], alphabet.charAt(i));
        }

    }

    void userInterface() {
        System.out.println("Введите текст: ");
        Scanner in = new Scanner(System.in);
        String inputText = in.nextLine();
        System.out.println("Вы ввели: " + inputText);

        if (inputText != null) {
            for (int i = 0; i < inputText.length(); i++) {
                if (inputText.charAt(i) != '·'
                        || inputText.charAt(i) != '−'
                        || inputText.charAt(i) != ' ')
                {
                    System.out.println("Результат: " + toMorze(inputText));
                }

            }

            System.out.println("Результат: " + toCyrillic(inputText));

        }


    }

    private StringBuilder toMorze(@NotNull String inputText) {
        StringBuilder outputString = new StringBuilder();
        for (int i = 0; i < inputText.length(); i++) {
            outputString.append(hashMapToMorze.get(inputText.charAt(i)));
            outputString.append(" ");
        }
        return outputString;
    }

    private StringBuilder toCyrillic(@NotNull String inputText) {
       String[] encodeWords;
        StringBuilder outputString = new StringBuilder();
        encodeWords = inputText.split(" ");
        String[] decodeWords = new String[encodeWords.length];

        for (int i = 0; i < encodeWords.length; i++) {
                decodeWords[i] = String.valueOf(hashMapToCyrillic.get(encodeWords[i]));

               outputString.append(decodeWords[i]);
        }
            return outputString;

    }

    }


