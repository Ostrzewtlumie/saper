package com.pitch;

import java.util.ArrayList;

import java.util.Scanner;

public class Pitch {

    private ArrayList<ArrayList<Field>> pitch;

    public Pitch() {
    	super();
    }
    void initializePitch()
    {
    	 pitch = getPitch();
         showPitch(pitch);
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
    void checkFieldStatus(){

        while (true) {
            getFieldFromPitch(pitch);
            showPitch(pitch);

        }
    }

    private void getFieldFromPitch(ArrayList<ArrayList<Field>> arrayPitch)
    {
        String rowMessage="Wprowadz pierwsza wartość: ";
        System.out.print(rowMessage);
        Scanner inRow=new Scanner(System.in);
        int pitchRow=inRow.nextInt();

        String colMessage="Wprowadz druga wartość: ";
        System.out.print(colMessage);
        Scanner inCol=new Scanner(System.in);
        int pitchCol=inCol.nextInt();

        ArrayList<Field> field=arrayPitch.get(pitchRow);
        Field afield = field.get(pitchCol);
        if(afield.getStand()==1)
            afield.setStand(11);//podstawiam 10 zeby dzialalo dla jednego pola gdy zyjesz
        else if (afield.getStand()==0)
            afield.setStand(10);//podstawiam 10 zeby dzialalo dla jednego pola gdy umierasz
        else
            ;
        updateFieldCount(arrayPitch,pitchRow,pitchCol,afield);
        getLifeStatus(afield.getStand());



    }

    void getStatusMessage()
    {
        String statusMessage="Jeśli pole, które wybierzesz bedzie rowne 0, to umierasz. Jeśli 1, zyjesz dalej.\nWybierz pole np.[4][4]. Uwaga! maksymalna zakres to [4][4], a minimalny [0][0]";
        System.out.println(statusMessage);


    }

    private void showPitch(ArrayList<ArrayList<Field>> arrayPitch )
    {
        for(ArrayList<Field> i:arrayPitch)
        {
            for(Field j:i) {
            if(j.getStand()==11)
                System.out.print(j.getCount() + " ");
            else if(j.getStand()==10)
                System.out.print(0 + " ");
            else
                System.out.print("X ");
            }
            System.out.println("");
        }
    }

    private ArrayList<ArrayList<Field>> getPitch()
    {
        ArrayList<ArrayList<Field>> aPitch=new ArrayList<ArrayList<Field>>();
        for (int i=0;i<5;i++)
        {
            ArrayList<Field> bPitch = new ArrayList<Field>();
            for (int j=0;j<5;j++)
            {
                 bPitch.add(new Field());
            }
            aPitch.add(bPitch);
        }
        return aPitch;
    }
    
    private void updateFieldCount(ArrayList<ArrayList<Field>> aPitch, int aRow, int aCol, Field aaField)
    {
        for(int i = -1;i<2;i++)
        {
            ArrayList<Field> field=aPitch.get(aRow+i);
            for(int j = -1;j<2;j++)
            {
                Field afield = field.get(aCol+j);
                if(afield.getStand()==0)
                {
                    aaField.setCount();
                }
            }
        }
    }

    void getStartMessage()
    {
        String startMessage="Generuje plansze!";
        System.out.println(startMessage);
    }
}
