package src;

import java.util.HashMap;
import java.util.Map;

class Interpretator {

    private Map<Character, String> hashMap = new HashMap<>();
    private String InputText;


     void initMap() {
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщьыъэюя.,:;";
        String[] alphabetMorze = new String[]{"·−", "−···", "·−−", "−−·", "−··", "·", "·", "···−", "−−··", "··", "·−−−", "−·−",
                "·−··", "−−", "−·", "−−−", "·−−·", "·−·", "···", "−", "··−", "··−·", "····", "−·−·", "−−−·", "−−−−", "−−·−",
                "−−·−−", "−·−−", "−··−", "··−··", "··−−", "·−·−", "······", "·−·−·−", "−−−···", "−·−·−·"};

        for (int i = 0; i < alphabet.length(); i++) {
            hashMap.put(alphabet.charAt(i), alphabetMorze[i]);


        }

    }

       public void userInterface() {
            System.out.println("Введите текст: ");
            InputText = System.in.toString();
            if (InputText != null) {
                toMorze(InputText);
            }
        }





    private void toMorze(String InputText) {


    }


}
