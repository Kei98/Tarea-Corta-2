package com.AyJK.tree;


/**
 * Clase nodo del árbol de expresión
 * 
 * @author AyJK
 *
 * @param <T>
 */
public class ExpressionNode<T extends Comparable<T>> {
	
	/*
	 * Variables de la clase
	 */
	private T data;
	private ExpressionNode<T> right;
	private ExpressionNode<T> left;

	
	/**
	 * Constructor de la clase
	 * 
	 * @param data:
	 * 				valor que se desea guardar en el nodo
	 */
	public ExpressionNode(T data) {
		this.data = data;
		this.right = null;
		this.left = null;
	}


	/**
	 * Constructor de la clase
	 * 
	 * @param data
	 * 
	 * @param right:
	 * 				hijo derecho
	 * @param left:
	 * 				hijo izquierdo
	 */
	public ExpressionNode(T data, ExpressionNode<T> right, ExpressionNode<T> left) {
		this.data = data;
		this.right = right;
		this.left = left;
	}
	
	/*
	 * Getters y setters de las variables de la clase
	 */


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}


	public ExpressionNode<T> getRight() {
		return right;
	}


	public void setRight(ExpressionNode<T> right) {
		this.right = right;
	}


	public ExpressionNode<T> getLeft() {
		return left;
	}


	public void setLeft(ExpressionNode<T> left) {
		this.left = left;
	}

}
