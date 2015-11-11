package model;

public class ThreadAbs extends CreadorThreads{

	public ThreadAbs(ConcurVector vector, int num) {
		super(vector, num);
	}

	@Override
	public void run() {
		while (this.vector.cantFinalizados!= this.vector.dimension()
				&& this.maxPosiciones != 0);
		int posicion= this.vector.posicionSiguiente;
		this.vector.posicionSiguiente++;
		this.vector.set(posicion, Math.abs(this.vector.get(posicion)));
		this.vector.cantFinalizados++;
		this.notify();
	}
	
}
