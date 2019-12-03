package src;


import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Interpretator {

    private Map<Character, String> hashMapToMorze = new HashMap<>();


    void initMap() {
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,:; ";
        String[] alphabetMorze = new String[]{"·−", "−···", "·−−", "−−·", "−··", "·", "·", "···−", "−−··", "··", "·−−−", "−·−",
                "·−··", "−−", "−·", "−−−", "·−−·", "·−·", "···", "−", "··−", "··−·", "····", "−·−·", "−−−·", "−−−−", "−−·−",
                "−−·−−", "−·−−", "−··−", "··−··", "··−−", "·−·−", "······", "·−·−·−", "−−−···", "−·−·−·", ""};

        for (int i = 0; i < alphabet.length(); i++) {
            hashMapToMorze.put(alphabet.charAt(i), alphabetMorze[i]);
        }

    }

    void userInterface() {
        System.out.println("Введите текст: ");
        Scanner in = new Scanner(System.in);
        String inputText = in.nextLine();
        System.out.println("Вы ввели: " + inputText);
        if (inputText != null) {
           System.out.println("Результат: " + toMorze(inputText));

        }


    }




    private StringBuilder toMorze(@NotNull String inputText) {
        StringBuilder outputString = new StringBuilder();
        for (int i = 0; i < inputText.length(); i++) {
            outputString.append(hashMapToMorze.get(inputText.charAt(i)));
            outputString.append(" ");
          /*  if(inputText.charAt(i) == ' ' && inputText.charAt(i) < inputText.length() ){
                OutputString.append(" ");

            }
            */

        }

            return outputString;
    }



}

//