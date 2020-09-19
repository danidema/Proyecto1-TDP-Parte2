import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.Filter;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class Graph {
	protected List<Integer> lista_nodos;
	protected List<Edge> lista_arcos;
	private static Logger logger;
	/**
	 * Inicializa la estructura Graph
	 * 
	 */
	public Graph() {
		lista_nodos = new LinkedList<Integer>();
		lista_arcos = new LinkedList<Edge>();
		if (logger == null){
			
			logger = Logger.getLogger(Graph.class.getName());
			
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);
			
			logger.setLevel(Level.WARNING);
			
			Logger rootLogger = logger.getParent();
			for (Handler h : rootLogger.getHandlers()){
				h.setLevel(Level.OFF);
			}
		}
	}
	/**
	 * Agrega el nodo “node” al grafo, si aún no pertenecía a la estructura.
	 * @param node
	 */
	public void addNode(int node) {
		Iterator<Integer> it = null;
		boolean encontre=false;
		if(!lista_nodos.isEmpty()) {
			it=lista_nodos.iterator();
			for(int i=0;i<lista_nodos.size() && !encontre && it.hasNext();i++) {
				if(node == it.next()) {
					encontre=true;
					logger.warning("El nodo " +node +" ya se encuentra en la estructura.");
				}
			}
			if(!encontre) {
				lista_nodos.add(node);
				logger.info("El nodo " +node +" fue agregado a la estructura.");
			}
		}
		else {
			lista_nodos.add(node);
			logger.info("El nodo " +node +" fue agregado a la estructura.");
		}
				
	}
	/**
	 * Agrega un arco entre el nodo “node1” y el nodo “node2”, si aún no existía el arco y ambos parámetros son nodos pertenecientes a la estructura.
	 * @param node1
	 * @param node2
	 */
	public void addEdge(int node1, int node2) {
		Iterator<Edge> it = null;
		Edge aux,nuevo = null;
		boolean encontre=false,es1=false,es2=false;
		if(!lista_nodos.isEmpty()) {
			es1=pertenece(node1,lista_nodos);
			es2=pertenece(node2,lista_nodos);
		if(!lista_arcos.isEmpty() && es1 && es2) {
			it=lista_arcos.iterator();
			for(int i=0;i<lista_arcos.size() && it.hasNext() && !encontre;i++) {
				aux=it.next();
				if(node1 == aux.getNode1() && node2==aux.getNode2()) {
					encontre=true;
					logger.warning("El arco ya se encuentra en la estructura.");
				}
			}
			if(!encontre) {
				nuevo = new Edge(node1,node2);
				lista_arcos.add(nuevo);
				logger.info("El arco fue agregado a la estructura.");
			}
		}
		else {
			if(es1 && es2) {
				nuevo = new Edge(node1,node2);
				lista_arcos.add(nuevo);
				logger.info("El arco fue agregado a la estructura.");
			}
			else {
				logger.warning("El/los nodos no se encuentran en la estructura.");
			}
		}}
	}
	private boolean pertenece(int n,List<Integer> l) {
		Iterator<Integer> it = null;
		boolean encontre=false;
		it=lista_nodos.iterator();
		for(int i=0;i<lista_nodos.size() && !encontre && it.hasNext();i++) {
			if(n == it.next()) {
				encontre=true;
			}
		}
		return encontre;
	}
	/**
	 * Remueve el nodo “node” del grafo, si el parámetro es un nodo de la estructura.
	 * @param node
	 */
	public void removeNode(int node) {
		Iterator<Integer> it = null;
		boolean encontre=false;
		if(!lista_nodos.isEmpty()) {
			it=lista_nodos.iterator();
			for(int i=0;i<lista_nodos.size() && it.hasNext() && !encontre;i++) {
				if(node == it.next()) {
					lista_nodos.remove(node);
					encontre=true;
					logger.info("El nodo " +node +" fue eliminado de la estructura.");
				}
			}
		}
		if(!encontre)
			logger.warning("El nodo " +node +" no es un parametro de la estructura.");
		
	}
	/**
	 * Remueve el arco entre el nodo “node1” y el nodo “node2”, si el arco formado por los parámetros pertenecen a la estructura.
	 * @param node1
	 * @param node2
	 */
	public void removeEdge(int node1, int node2) {
		Iterator<Edge> it = null;
		Edge aux;
		boolean encontre=false;
		if(!lista_arcos.isEmpty()) {
			it=lista_arcos.iterator();
			for(int i=0;i<lista_arcos.size() && it.hasNext() && !encontre;i++) {
				aux=it.next();
				if(node1 == aux.getNode1() && node2==aux.getNode2()) {
					lista_arcos.remove(aux);
					encontre=true;
					logger.info("El arco fue eliminado de la estructura.");
				}
			}
		}
		if(!encontre)
			logger.warning("El arco no es un parametro de la estructura.");
	}
	
}
