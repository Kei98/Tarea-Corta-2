package com.AyJK.tree;

/**
 * Clase en la que se crea, relaciona y controla las instancias de la clase tipo ExpressionNode
 * 
 * @author AyJK
 *
 * @param <T>
 */
public class Expression_Tree<T extends Comparable<T>> {
	/*
	 * Atributos de la clase
	 */
	
	private ExpressionNode<T> root;
	private ExpressionNode<T> temp;
	private ExpressionNode<T> temp1;
	private ExpressionNode<T> temp2;
	
	private SimpleLL<T> tempList = new SimpleLL<>();
	@SuppressWarnings("rawtypes")
	private Queue queue = new Queue<>();
	@SuppressWarnings("rawtypes")
	private Stack stack = new Stack<>();
	private int count = 0;
	
	/*
	 * Constructor de la clase
	 */
	
	public Expression_Tree() {
		
	}

	
	
	/**
	 * Este método se encarga de ir metiendo en la pila los operadores y en la cola los operandos
	 * hasta que queden elementos solo en la cola
	 * 
	 * @param recieved:
	 * 					 es de tipo String, es la expresión ingresada por el usuario
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void stackORQueue(String recieved) throws Exception {
		for(int i = 0; i < recieved.length(); i++) {
			if(isOperator(recieved.charAt(i))) {
				this.stack.push(recieved.charAt(i));
				this.count++;
				
			/*
			 * Si aparece un parétesis de cierre en la expresión ingresada, se añaden los elementos
			 * de la pila a la cola, hasta que se encuentre nuevamente con un paréntesis, pero 
			 * debe ser de inicio 
			 */
			}else if (recieved.charAt(i) == ')') {
				while((char) this.stack.peek() != '(') {
					this.queue.enqueue(this.stack.peek());
					this.stack.pop();
				}
				/*
				 * Se elimina ese paréntesis de la pila
				 */
				this.stack.pop();
				this.count--;
			}else if(isOperand(recieved.charAt(i))) {
				
				if((i <= (recieved.length() - 2)) && isOperand(recieved.charAt(i+1))) {
					throw new Exception("No se puede insertar un operando que no sea de un solo elemento");
				}else {
					this.queue.enqueue(recieved.charAt(i));
				}
	
			}else {
				throw new Exception("Inserte un valor válido");
			}
		}
		/*
		 * Si queda algún elemento en la pila se saca de la misma y se coloca en la cola
		 */
		
		if(this.stack.getTop() != -1) {
			while(this.stack.getTop() > -1) {
				this.queue.enqueue(this.stack.peek());
				this.stack.pop();
			}
		}
	}
	
	/**
	 * Método para crear en sí el árbol
	 * se va extrayendo de la cola los operandos, se pasan a tipo ExpressionNode y se insertan 
	 * en una lista, esto hasta que se encuentra con un operador. Cuando esto último sucede, se 
	 * toman los últimos 2 datos ingresados en la lista y se convierten en los hijos de ese operador,
	 * luego ese operador se guarda en la lista
	 * 
	 * 
	 * La variable count tiene el propósito de llevar la cuanta de cuántos operadores quedan aún en 
	 * la cola
	 */
	@SuppressWarnings("unchecked")
	public void order() {
		while(this.count > 0) {
			
			while(this.queue.getLenght() > 0) {
				
				if(isOperator((char) this.queue.peek()) && this.tempList.getSize() > 0) {
					
					this.temp = new ExpressionNode<T>((T) this.queue.peek());
					this.queue.dequeue();
					this.temp1 = this.tempList.getNodei(tempList.getSize()-1);
					this.temp2 = this.tempList.getNodei(tempList.getSize()-2);
					this.tempList.deleteValue(tempList.getSize()-1);
					this.tempList.deleteValue(tempList.getSize()-1);
					this.temp.setRight(temp1);
					this.temp.setLeft(temp2);
				
					if(this.count == 1) {
						this.root = this.temp;
					}
				
					this.tempList.add(this.temp);
					this.count--;
					break;
					
				}else {
					ExpressionNode<T> node = new ExpressionNode<>((T) this.queue.peek()); 
					tempList.add(node);
					this.queue.dequeue();
				}
			}
		}
	}
	
	
	/*
	 * Método para imprimir la cola sobre la que se está trabajando
	 */
	
	public void printQ() {
		this.queue.print();
		System.out.println(" ");
	}
	
	/*
	 * Este método imprime en consola el árbol de forma in-orden
	 */
	
	public void printT() {
		printT(this.root);
	}
	
	private void printT(ExpressionNode<T> node) {
		if (node != null) {
            printT(node.getLeft());
            System.out.print(node.getData() + " ");
            printT(node.getRight());
        }
	}
	
	
	/**
	 * Método para saber si se está en presencia de un operador
	 * 
	 * @param whatever
	 * 
	 * @return
	 */
	private boolean isOperator(char whatever) {
		if(whatever == '+' || whatever == '*' || whatever == '-' || whatever == '/' || whatever == '(') {
			return true;
			
		} else {
			return false;
		}
		
	}
	
	
	
	/**
	 *  Método que retorna si el caracter indicado es un operando, se considera operando
	 *  si es un número entero positivo entre 0 y 9 o si es una letra minúscula
	 * 
	 * @param whatever
	 * 
	 * @return
	 */
	private boolean isOperand(char whatever) {

		int up = (int) '9';
		int low = (int) '0';
		int upper = (int) 'z';
		int lower = (int) 'a';
		
	
		if(((int) whatever >= low && (int) whatever <= up) || ((int) whatever >= lower && (int) whatever <= upper)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	/*
	 * Main de prueba
	 */
	
	public static void main(String[] args) throws Exception {
		Expression_Tree tree = new Expression_Tree<>();
		tree.stackORQueue("(a+(b*c))+(((d*e)+f)*g)");
		tree.printQ();
		tree.order();
		tree.printT();
		System.out.println(" ");
		System.out.println(" ");
		
		Expression_Tree tree1 = new Expression_Tree<>();
		tree1.stackORQueue("a*(b+c)+8");
		tree1.printQ();
		tree1.order();
		tree1.printT();
	}
}
