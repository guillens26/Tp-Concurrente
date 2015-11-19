package model;

//La clase vector inicia todos los trabajadores a los que va a enviar trabajo cuando se invoque un método. 
//Parece que quieren enviar una unidad de trabajo por cada elemento del vector.
//Esto es diferente a la solución que yo presenté y es sub-óptimo, pero es una solución válida igual.


//Podriamos cambiarle el nombre lo dejo asi por la referencia de daniel
public class Vector extends Thread{
	private int cantThreads;
	public Acum bag;
	
	Vector(int nThreads, Acum acum) {
		this.cantThreads = nThreads;
		this.bag= acum;
		
	}
	
	public synchronized void initilizeWorker() throws InterruptedException{
		int nThreads = cantThreads;
		while(nThreads > 0){
			System.out.print("creo 1 thread\n");
			Worker worker = new Worker(this.bag);
			nThreads--;
			worker.run();
		}
	}
	
	
}
