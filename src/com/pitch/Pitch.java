package com.pitch;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Pitch {

    private ArrayList<Integer[]> pitch;

    public Pitch() {

            getStartMessage();

            pitch = getPitch();
            showPitch(pitch);

            getStatusMessage();

           checkFieldStatus();
    }
    private void getLifeStatus(int aField)
    {
        String liveStatusMessage;

        if (aField == 10) {

            liveStatusMessage = "Nieżyjesz!";
        }
        else if (aField == 11)
            liveStatusMessage = "Żyjesz!";

        else
            liveStatusMessage = "-";


        System.out.println(liveStatusMessage);

        if(liveStatusMessage=="Nieżyjesz!") {
            showPitch(pitch);
            System.exit(1);
        }


    }
    private void checkFieldStatus(){

        while (true) {
            getFieldFromPitch(pitch);
            showPitch(pitch);

        }
    }

    private void getFieldFromPitch(ArrayList<Integer[]> arrayPitch)
    {
        String rowMessage="Wprowadz pierwsza wartość: ";
        System.out.print(rowMessage);
        Scanner inRow=new Scanner(System.in);
        int pitchRow=inRow.nextInt();

        String colMessage="Wprowadz druga wartość: ";
        System.out.print(colMessage);
        Scanner inCol=new Scanner(System.in);
        int pitchCol=inCol.nextInt();

        Integer[] field=arrayPitch.get(pitchRow);
        if(field[pitchCol]==1)
            field[pitchCol]=11;//podstawiam 10 zeby dzialalo dla jednego pola gdy zyjesz
        else if (field[pitchCol]==0)
            field[pitchCol]=10;//podstawiam 10 zeby dzialalo dla jednego pola gdy umierasz
        else
            ;
        getLifeStatus(field[pitchCol]);



    }

    private void getStatusMessage()
    {
        String statusMessage="Jeśli pole, które wybierzesz bedzie rowne 0, to umierasz. Jeśli 1, zyjesz dalej.\nWybierz pole np.[4][4]. Uwaga! maksymalna zakres to [4][4], a minimalny [0][0]";
        System.out.println(statusMessage);


    }

    private void showPitch(ArrayList<Integer[]> arrayPitch )
    {
        for(Integer[] i:arrayPitch)
        {
            for(Integer j:i) {
            if(j==11)
                System.out.print(1 + " ");
            else if(j==10)
                System.out.print(0 + " ");
            else
                System.out.print("X" + " ");
            }
            System.out.println("");
        }
    }

    public ArrayList<Integer[]> getPitch()
    {
        ArrayList<Integer[]> aPitch=new ArrayList<Integer[]>(5);
        for (int i=0;i<5;i++)
        {
           aPitch.add(new Integer[]{0,0,1,1,0});
           
        }
        return aPitch;
    }

    private void getStartMessage()
    {
        String startMessage="Generuje plansze!";
        System.out.println(startMessage);
    }
}
