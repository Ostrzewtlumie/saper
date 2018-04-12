package com.pitch;

public class main {

    public static void main(String[] args) {

        printBeginMessage();
        Pitch pitch =new Pitch();
        pitch.initializePitch();
        pitch.getStartMessage();
        pitch.getStatusMessage();
        pitch.checkFieldStatus();

    }
    private static void  printBeginMessage()
    {
        String message="Witaj w grze!";
        System.out.println(message);
    }
}
