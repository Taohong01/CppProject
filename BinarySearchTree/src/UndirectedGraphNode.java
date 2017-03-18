import java.util.ArrayList;
public class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neigbors; 
	public UndirectedGraphNode(int label){
		this.label = label;
		neigbors = new ArrayList<UndirectedGraphNode>();
	}
}

