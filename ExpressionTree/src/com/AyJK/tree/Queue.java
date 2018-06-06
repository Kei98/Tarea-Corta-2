package com.AyJK.tree;


/**
 * Clase cola, naturaleza FIFO, implementada con una lista simplemente enlazada
 * @author AyJK
 *
 * @param <T>
 */
public class Queue<T> {
	
	/*
	 * Atributos de la clase
	 */
	@SuppressWarnings("rawtypes")
	private SimpleLL list;
	private int lenght;

	/*
	 * Constructor de la clase
	 */
	
	public Queue() {
		this.list = new SimpleLL<>();
	}
	
	
	
	/**
	 * Método para desencolar o eliminar elementos de la cola (al inicio)
	 */
	public void dequeue() {
		this.list.deleteValue(0);
		this.lenght--;
	}
	
	
	/**
	 * Método para encolar o agregar elementos a la cola (final)
	 * 
	 * @param value:
	 * 				dato que se busca agregar a la cola
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void enqueue(T value) {
		this.list.add((Comparable) value);
		this.lenght++;
	}
	
	
	/**
	 * Método para obtener el "valor" del primer elemento o bien del que se eliminaría
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T peek() {
		return (T) this.list.getDatai(0);		
	}
	
	/**
	 * Método para imprimir la cola, prueba 
	 */
	public void print() {
		System.out.print("[");
		for(int i = 0; i < this.list.getSize() -1; i++){
			System.out.print(this.list.getDatai(i)+ ", ");
		}
		System.out.print(this.list.getDatai(this.list.getSize() - 1) + "]");
	}

	/*
	 * Getters y setters de los atributos
	 */
	
	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}
	
//	public static void main(String[] args) {
//		Queue queue = new Queue<>();
//		queue.enqueue(86);
//		queue.enqueue(234);
//		queue.enqueue(90);
//		queue.enqueue("hola");
//		System.out.println("Tope: ");
//		queue.peek();
//		queue.dequeue();
//		System.out.println("Nuevo tope: ");
//		queue.peek();
//		queue.dequeue();
//		System.out.println("Nuevo tope: ");
//		queue.peek();
//		queue.enqueue(913);
//	}
}
