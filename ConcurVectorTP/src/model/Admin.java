package model;

public class Admin {
private Integer num;
// CLASE PARA LLEVAR CONTROL DE CUANDO SE TERMINA DE ANALIZAR UN VECTOR.

	public Admin(int n) {
		this.num = n;
	}
	
	public synchronized void update() {
		this.num--;
		notifyAll();
	}
	
	public synchronized void waiting() throws InterruptedException {
		while(num > 0)
			wait();
	}
}
