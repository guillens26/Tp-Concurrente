package model;

public class Worker extends Thread{
	Acum bag; // Bolsa de works para ir agarrando y analizando.
	int cantMax; //Maximo que puede analizar 
	
	public Worker(Acum acum, int load){
		this.bag= acum;
		this.cantMax= load;
	}
	
	
}
