package ru.text.main;


import java.io.IOException;

class Main {

        public static void main(String[] args) throws IOException {
            Interpretator interpretator = new Interpretator();
            interpretator.readFromFile();
            interpretator.userInterface();
        }
}
