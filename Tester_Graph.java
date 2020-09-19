
public class Tester_Graph {
	public static void main(String[]args) {
		Graph grafo = new Graph();
		//agrego un nodo a la estructura.
		grafo.addNode(1);
		//intento volver a agregarlo. 
		grafo.addNode(1);
		//agrego un arco a la estructura
		grafo.addEdge(1, 2);
		//agrego otro nodo a la estructura.
		grafo.addNode(2);
		//agrego el mismo arco
		grafo.addEdge(1, 2);
		//intento agregar el mismo arco
		grafo.addEdge(1, 2);
		//remuevo el arco de la estructura
		grafo.removeEdge(1, 2);
	}
}
