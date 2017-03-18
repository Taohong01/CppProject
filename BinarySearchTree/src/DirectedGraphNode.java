import java.util.*;
public class DirectedGraphNode {
	int label;
	List<DirectedGraphNode> neigbors = new ArrayList<DirectedGraphNode>();
	public DirectedGraphNode(int label){
		this.label = label;

//		for (int i = 0; i < neigbors.size(); i++){
//			neigbors.set(i, null);
//		}
	}
}
