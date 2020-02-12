package ru.text.main;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class Interpretator {

    private Map<String, String> hashMapToMorze = new HashMap<>();
    private Map<String, String> hashMapToCyrillic = new HashMap<>();

    void readFromFile() throws IOException {

        String filePath = "src/main/resources/";
        String fileName = "Dictionary.csv";
        File file = new File(filePath + fileName);

        try (BufferedReader rd = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {

            String s;
            String a, b;
            String UTF8_BOM = "\uFEFF";
            while ((s = rd.readLine()) != null) {
                int i = s.contains(UTF8_BOM) ? 1 : 0;
                a = Character.toString(s.charAt(i));
                b = s.substring(i + 2, (s.lastIndexOf(";")));
                hashMapToMorze.put(a, b);
                hashMapToCyrillic.put(b, a);
            }
        }

    }

    void runUserInterface() {
        System.out.println("Введите текст: ");
        Scanner in = new Scanner(System.in);
        String inputText = in.nextLine().replace('·', '.');
        System.out.println("Вы ввели: " + inputText);
        int counter = 0;
        for (int i = 0; i < inputText.length(); i++) {
//
//            if (inputText.charAt(i) == '.')
//                counter += 1;
//            else if (inputText.charAt(i) == ' ')
//                counter += 1;
//            else if (inputText.charAt(i) == '−')
//                counter += 1;
//
//        }

            switch (inputText.charAt(i)) {

                case '.':
                case 32:
                case 45:
                    counter++;
                    break;
                default:
                    break;
            }
        }

        if (inputText.length() <= counter) {
            System.out.println("Результат: " + toCyrillic(inputText));
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


