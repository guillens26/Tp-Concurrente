package model;

//La clase vector inicia todos los trabajadores a los que va a enviar trabajo cuando se invoque un método. 
//Parece que quieren enviar una unidad de trabajo por cada elemento del vector.
//Esto es diferente a la solución que yo presenté y es sub-óptimo, pero es una solución válida igual.


//Podriamos cambiarle el nombre lo dejo asi por la referencia de daniel
public class Vector {
	private ConcurVector cv;
	
	public Vector(ConcurVector acv) {
		this.cv = acv;
		
	}
	
	public void initilizeWorker(Acum bag) throws InterruptedException{
		int nThreads = this.cv.getThreads();
		while(nThreads > 0){
			Worker worker = new Worker(bag);
			nThreads--;
			worker.work();
		}
	}
	
	
}
