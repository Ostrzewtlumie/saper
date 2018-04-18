package com.pitch;

import java.util.Scanner;

public class app {
    private static int pitchRows = 0;
    private static int pitchCols = 0;
    public static void main(String[] args) {

        printBeginMessage();
        getDimensions();
        Pitch pitch = new Pitch();
        pitch.initializePitch(pitchRows, pitchCols);
        pitch.getStartMessage();
        pitch.getStatusMessage();
        pitch.checkFieldStatus();

    }
	
    public static void getDimensions() {
    	String message = "Podaj wymiary planszy";
        System.out.println(message);
        
        @SuppressWarnings("resource")
		Scanner inputRow = new Scanner(System.in);
        pitchRows = inputRow.nextInt();
	
    	@SuppressWarnings("resource")
		Scanner inputCol = new Scanner(System.in);
        pitchCols = inputCol.nextInt();
	
    }
	public static void  printBeginMessage()
    {
        String message = "Witaj w grze!";
        System.out.println(message);
    }
}
