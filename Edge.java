
public class Edge {
	protected int node1;
	protected int node2;
	public Edge(int n1, int n2) {
		node1=n1;
		node2=n2;
	}
	//setters:
	public void setNode1(int node) {
		node1=node;
	}
	public void setNode2(int node) {
		node2=node;
	}
	//getters:
	public int getNode1() {
		return node1;
	}
	public int getNode2() {
		return node2;
	}
}
