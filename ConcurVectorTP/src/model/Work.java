package model;

// La clase Work que representa el trabajo a realizar está muy incompleta, tiene que tener en cuenta todos 
// los casos posibles (operaciones con 1, 2 o 3 vectores y operaciones con un double). 
// Además necesitan una forma de decir qué operación hay que ejecutar (por ejemplo yo usé un enum).

public class Work {
	private ConcurVector vector;
	private ConcurVector vector2;
	private ConcurVector vector3;
	private double num;
	private Operation op;
	
	public Work(Operation operation ,ConcurVector v, ConcurVector v2, ConcurVector v3 , double n){
		this.vector = v;
		this.vector2 = v2;
		this.vector3 = v3;
		this.num = n; 
		this.op = operation;
		
	}
	
	public enum Operation {
	    ABS,
	    ADD,
	    MUL,
	    DIV,
	    SUB,
	    SUM,
	    PROD,
	    NORMALIZE,
	    NORM,
	    MIN,
	    MAX;

	}
	
	//No agregue todos
	public void realizarOperation() throws InterruptedException{
		switch(this.op){
		case ABS:
			this.vector.absOriginal();
			break;
		case ADD:
			this.vector.add(vector2);
			break;
		}
	}
	
	
}

