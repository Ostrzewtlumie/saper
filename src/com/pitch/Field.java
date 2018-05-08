package com.pitch;
import java.util.Random;


public class Field implements FieldInterface {


	private int fieldStand;
	private int fieldCount;

	public Field() {
		fieldCount = 0;
		Random generator = new Random();
		fieldStand = generator.nextInt(2);
	}

	public int getFieldStand() {
		return fieldStand;
	}

	public void setFieldStand(int fieldStand) {
		this.fieldStand = fieldStand;
	}

	public int getFieldCount() {
		return fieldCount;
	}

	public void setFieldCount() {
		this.fieldCount = 1;
	}
}

