package ru.text.main;


import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Interpretator {

    private Map<String, String> hashMapToMorze = new HashMap<>();
    private Map<String, String> hashMapToCyrillic = new HashMap<>();

    void readFromFile() {

        String filePath = "src/main/resources/";
        String fileName = "Dictionary.csv";


        try(Reader rd = new FileReader(filePath + fileName);
                BufferedReader reader = new BufferedReader(rd)) {
            String s;
            String a, b;
            while ((s = reader.readLine()) != null) {
                a = Character.toString(s.charAt(0));
                b = s.substring(2);
                hashMapToMorze.put(a, b);
                hashMapToCyrillic.put(b, a);
            }
        }

        catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }




    void userInterface() {
        System.out.println("Введите текст: ");
        Scanner in = new Scanner(System.in);
        String inputText = in.nextLine();
        System.out.println("Вы ввели: " + inputText);
//        if (inputText != null) {
//            boolean isText = true;
//            for (int i = 0; i < inputText.length(); i++) {
//                if (inputText.charAt(i) == '·'
//                        || inputText.charAt(i) == '−'
//                        && inputText.charAt(i) == ' ') {
//                    isText = false;
//                    break;
//                }
//            }

            if (!inputText.matches("[А-Я а-я0-9]+")) {
                System.out.println("Результат: " + toCyrillic(inputText.replace(".", "·")));
            } else {
                System.out.println("Результат: " + toMorze(inputText));
            }
        }


    @NotNull
    private StringBuilder toMorze(String inputText) {
        StringBuilder outputString = new StringBuilder();
        for (int i = 0; i < inputText.length(); i++) {
            outputString.append(hashMapToMorze.get(Character.toString(inputText.charAt(i))));
            outputString.append(" ");
        }
        return outputString;
    }

    @NotNull
    private StringBuilder toCyrillic(String inputText) {
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


