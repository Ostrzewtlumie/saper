package com.pitch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;





public class FieldTest {

	@Test
	public void shouldBeZeroOrOne() {
		Field field = new Field();
		assertTrue(field.getFieldStand() == 0 || field.getFieldStand() == 1);
	}
	
	@Test
	public void shoulSetCount() {
		Field field = new Field();
		field.setFieldCount();
		assertEquals(1,field.getFieldCount());
	}
}
