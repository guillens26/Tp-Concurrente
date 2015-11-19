package model;

//La clase Worker representa los threads que ejecutan las operaciones. 
//La clase worker por siempre consume trabajo y lo lleva a cabo (while (true)). 
//Ojo con el load balancing porque no está claro dónde van a 
//tener que poner la operación que extrae una unidad de trabajo de la cola. Dado que piensan 
//procesar un trabajo para cada elemento del vector probablemente necesiten OTRO ciclo
//interno que itere entre 0 y la cantidad de elementos que debe procesar este trabajador.

public class Worker extends Thread{
	Acum bag; // Bolsa de works para ir agarrando y analizando.
	
	public Worker(Acum acum){
		this.bag= acum;
	}

	@Override
	public synchronized void run(){
		while (true){
			System.out.print("entro a en el while true del RUN de WORKER\n");
			Work w;
			try {
				w = this.bag.getWork();
				System.out.print("obtuve el work\n");
				w.realizarOperation();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}
