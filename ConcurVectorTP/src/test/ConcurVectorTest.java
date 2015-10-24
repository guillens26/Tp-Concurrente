package test;

import static org.junit.Assert.assertEquals;
import model.ConcurVector;

import org.junit.Before;
import org.junit.Test;

public class ConcurVectorTest {
	
	private static final double DELTA = 1e-15;
	private static final double nil = 0;
	private ConcurVector concurVector;
	private ConcurVector anotherConcurVector;
	private ConcurVector anotherConcurVector2;
	private ConcurVector maskConcurVector;
	
	@Before
	public void setUp() {
		concurVector = new ConcurVector(2);
		
		anotherConcurVector = new ConcurVector(2);
		anotherConcurVector.set(0,1);
		anotherConcurVector.set(1,2);
		
		maskConcurVector = new ConcurVector(2);
		maskConcurVector.set(0, 1);
		maskConcurVector.set(1,-1);
		
		anotherConcurVector2 = new ConcurVector(2);
		anotherConcurVector2.set(0,3);
		anotherConcurVector2.set(1,0);
	}

	@Test
	public void dimensionConcurVectorTest() {
		double expected = 2; // El size de concurVector es 2 xq se creo asi.
		double actual = concurVector.dimension();
		assertEquals(expected, actual, DELTA);
	}
	
	@Test
	public void getAndSetTest() {
		concurVector.set(5);
		double expected = 5;
		double actual = concurVector.get(0);
		assertEquals(expected, actual, DELTA);		
	}
	
	@Test
	public void setInPositionTest() {
		concurVector.set(1,5);
		double expected = 5;
		double actual = concurVector.get(1);
		assertEquals(expected, actual, DELTA);		
	}
	
	@Test
	public void assignAnotherVectorTest() {
		//Verifico que en la pos 1 de concurVector se aya cambiado el valor de 2 a 0
		anotherConcurVector.assign(anotherConcurVector2);
		double expected = 0;
		double actual = concurVector.get(1);
		assertEquals(expected, actual, DELTA);	
	}
	
	@Test
	public void assignMaskChangeTest() {
		concurVector.assign(maskConcurVector, anotherConcurVector);
		double expected = 1;
		double actual = concurVector.get(0);
		assertEquals(expected, actual, DELTA);		
	}
	
	@Test
	public void assignMaskNotChangeTest() {
		concurVector.assign(maskConcurVector, anotherConcurVector);
		double expected = nil; // Esta en nil y al ser neg la mask no cambia. 
		double actual = concurVector.get(1);
		assertEquals(expected, actual, DELTA);		
	}
	
	
	@Test
	public void absTest() {
		maskConcurVector.abs();
		double expected = 1; // El abs de -1.
		double actual = maskConcurVector.get(1);
		assertEquals(expected, actual, DELTA);

	}
	
	@Test
	public void addTest() {
		anotherConcurVector.add(anotherConcurVector2);
		double expected = 4;//Los vlores de las pos 0 de cada arreglo  1+3
		double actual = anotherConcurVector.get(0);
		assertEquals(expected, actual, DELTA);

	}
	
	@Test
	public void subTest() {
		anotherConcurVector.sub(anotherConcurVector2);
		double expected = -2;// 1-3
		double actual = anotherConcurVector.get(0);
		assertEquals(expected, actual, DELTA);
	}
	
	@Test
	public void mulTest() {
		anotherConcurVector.mul(anotherConcurVector2);
		double expected = 3; // 1*3	
		double actual = anotherConcurVector.get(0);
		assertEquals(expected, actual, DELTA);
	}
	
	@Test
	public void divTest() {
		anotherConcurVector2.div(anotherConcurVector);
		double expected = 1; // 3/1
		double actual = anotherConcurVector.get(0);
		assertEquals(expected, actual, DELTA);
	}
	
	@Test
	public void sumOfTheVectorTest() {
		double expected = 3; // 1+2
		double actual = anotherConcurVector.sum();
		assertEquals(expected, actual, DELTA);
	}
	
	@Test
	public void prodTest() {
		double expected = 3; // Hago el producto entre las pos y luego los sumo: 3*1 + 0*2 
		double actual =  anotherConcurVector.prod(anotherConcurVector2);	
		assertEquals(expected, actual, DELTA);
	}
	
	@Test
	public void normTest() {
		double expected = 3; // sqrt (3*3 + 0*0)
		double actual = anotherConcurVector2.norm();
		assertEquals(expected, 3, DELTA);
	}
	
	@Test
	public void normalizeTest() {
		anotherConcurVector2.normalize();
		double expected = 1; // 3/3
		double actual = anotherConcurVector.get(0);
		assertEquals(expected, actual, DELTA);
	}
	
	@Test
	public void maxChangeTest() {
		anotherConcurVector.max(anotherConcurVector2);
		double expected = 3; // 3 es mas grande que 1 en la pos 0;
		double actual = anotherConcurVector.get(0);
		assertEquals(expected, actual, DELTA);
	}
	
	@Test
	public void minChangeTest() {
		anotherConcurVector.min(maskConcurVector);
		double expected = -1; // -1 es mas chico que 2 en la pos 1
		double actual =anotherConcurVector.get(1);
		assertEquals(expected, actual, DELTA);
	}	
	
}
