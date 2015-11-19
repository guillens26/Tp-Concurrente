package model;

import java.util.ArrayList;

// ACUMULADOR DE TRABAJO
// TODOS LOS WORKERS LE PIDEN UN WORK A ESTA CLASE

public class Acum extends Thread {
private ArrayList<Work> works;
	
	public Acum(){
		this.works = new ArrayList<Work>();
	}
	
	public Boolean isEmpty() {
		return this.works.isEmpty();
	}
	
	public synchronized void addWork(Work w) {
		this.works.add(w);
		this.notify();
	}
		
	public synchronized Work getWork() throws InterruptedException {
		while(this.works.isEmpty()){
			System.out.print("entro en while del getWork en ACUM");
			this.wait();
		}
		Work w = this.works.get(this.works.size() - 1);
		this.works.remove(this.works.size() - 1);
		notifyAll();
		return w;
	}
}