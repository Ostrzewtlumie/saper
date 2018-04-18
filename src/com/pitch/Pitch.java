package com.pitch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pitch {

    private List<ArrayList<Field>> pitch;

    public Pitch() {
    	super();
    }
    void initializePitch(int rows, int cols)
    {
    	 pitch = createPitch(rows, cols);
         showPitch(pitch);
    }
    private void getLifeStatus(int field)
    {
        String liveStatusMessage;

        if (field == 10) {

            liveStatusMessage = "Nieżyjesz!";
        }
        else if (field == 11)
            liveStatusMessage = "Żyjesz!";

        else
            liveStatusMessage = "-";


        System.out.println(liveStatusMessage);

        if(liveStatusMessage.equals( "Nieżyjesz!" )){
            showPitch( pitch );
            System.exit( 1 );
        }


    }
    void checkFieldStatus(){

        while (true) {
            getFieldFromPitch(pitch);
            showPitch(pitch);

        }
    }

    private void getFieldFromPitch(List<ArrayList<Field>> pitch)
    {
        String rowMessage = "Wprowadz pierwsza wartość: ";
        System.out.print(rowMessage);
        
        @SuppressWarnings("resource")
		Scanner inputRow = new Scanner(System.in);
        int pitchRow = inputRow.nextInt();

        String colMessage = "Wprowadz druga wartość: ";
        System.out.print(colMessage);
        
        @SuppressWarnings("resource")
		Scanner inputCol = new Scanner(System.in);
        int pitchCol = inputCol.nextInt();

        List<Field>rowArray = pitch.get(pitchRow);
        FieldInterface field = rowArray.get(pitchCol);
        if(field.getFieldStand() == 1)	field.setFieldStand(11);//podstawiam 11 zeby dzialalo dla jednego pola gdy zyjesz
        else if (field.getFieldStand() == 0)	field.setFieldStand(10);//podstawiam 10 zeby dzialalo dla jednego pola gdy umierasz
        
        updateFieldCount(pitch,pitchRow,pitchCol,field);
        getLifeStatus(field.getFieldStand());

    }

    void getStatusMessage()
    {
        String statusMessage = "Jeśli pole, które wybierzesz bedzie rowne 0, to umierasz. Jeśli 1, zyjesz dalej.\nWybierz pole np.[4][4]. Uwaga! maksymalna zakres to [4][4], a minimalny [0][0]";
        System.out.println(statusMessage);


    }

    private void showPitch(List<ArrayList<Field>> pitch)
    {
        for(ArrayList<Field> row : pitch)
        {
            for(Field field : row) {
            if(field.getFieldStand() == 11)
                System.out.print(field.getFieldCount() + " ");
            else if(field.getFieldStand() == 10)
                System.out.print(0 + " ");
            else
                System.out.print("X ");
            }
            System.out.println("");
        }
    }

    private List<ArrayList<Field>> createPitch(int rows, int cols)
    {
        List<ArrayList<Field>> pitch = new ArrayList<ArrayList<Field>>();
        for (int i = 0 ; i < rows ; i++)
        {
            ArrayList<Field> row = new ArrayList<Field>();
            for (int j = 0 ; j < cols ; j++)
            {
                 row.add(new Field());
            }
            pitch.add(row);
        }
        return pitch;
    }
    
    private void updateFieldCount(List<ArrayList<Field>> pitch, int row, int col, FieldInterface field)
    {
        for(int i = -1 ; i<2 ; i++ )
        {
            ArrayList<Field> newRow = pitch.get(row+i);
            for(int j = -1 ; j<2 ; j++)
            {
                Field newField = newRow.get(col+j);
                if(newField.getFieldStand() == 0)
                {
                    field.setFieldCount();
                }
            }
        }
    }

    void getStartMessage()
    {
        String startMessage = "Generuje plansze!";
        System.out.println(startMessage);
    }
}
