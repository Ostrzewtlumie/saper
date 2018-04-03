package com.pitch;
import java.util.Random;


public class Field implements FieldInterface {
    private int fieldStand;
    private int fieldCount;

    public Field()
    {
        fieldCount = 0;
        Random generator = new Random();
        fieldStand = generator.nextInt(2);
    }
    public int getStand()
    {
        return fieldStand;
    }
    public void setStand(int aStand)
    {
        fieldStand = aStand;
    }
    public int getCount()
    {
        return fieldCount;
    }
    public void setCount()
    {
        fieldCount+=1;

    }
}

