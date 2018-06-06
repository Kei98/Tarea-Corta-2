package com.AyJK.tree;


/**
 * Clase pila, naturaleza LIFO, implementada con listas simples
 * 
 * @author AyJK
 *
 * @param <T>
 */
public class Stack<T> {
	
	/*
	 * Se definen los atributos de la clase
	 */
	private int top = -1;

	@SuppressWarnings("rawtypes")
	private SimpleLL list;
	
	/*
	 * Constructor de la clase
	 */
	public Stack(){
		this.list = new SimpleLL<>();
	}
	
	/*
	 * Método para eliminar el elemento que se encuentra en el tope
	 */
	public void pop() {
		list.deleteValue(top);
		top--;
	}
	
	/**
	 * Método para agregar un elemento a la pila
	 * @param value:
	 * 				elemento que se desea agregar a la pila
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void push(T value) {
		top++;
		list.add((Comparable) value);
	}
	
	
	/**
	 * Método para obtener el "valor" del elemento que se encuentra en el tope
	 * 
	 * @return
	 */
	
	@SuppressWarnings("unchecked")
	public T peek() {
		return (T) this.list.getDatai(top);		
	}
	
	/*
	 * Getter para el tope
	 */
	public int getTop() {
		return top;
	}
	
//	public static void main(String[] args) {
//		Stack stack = new Stack<>();
//		stack.push(86);
//		stack.push(234);
//		stack.push(90);
//		stack.push("hola");
//		System.out.println("Tope: ");
//		stack.peek();
//		stack.pop();
//		System.out.println("Nuevo tope: ");
//		stack.peek();
//		stack.push("arhfc");
//		System.out.println("Nuevo tope: ");
//		stack.peek();
//	}
}
