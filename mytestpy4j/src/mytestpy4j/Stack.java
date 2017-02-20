package mytestpy4j;
import java.util.LinkedList;
import java.util.List;
import java.lang.Math;

public class Stack {
	private List<String> internalList = new LinkedList<String>();
	
	public double x, y, z;
	
	public double WaveFunction(double x, double y){
		return Math.sin(x) * Math.cos(y);
	}
	

    public void push(String element) {
        internalList.add(0, element);
    }

    public String pop() {
        return internalList.remove(0);
    }

    public List<String> getInternalList() {
        return internalList;
    }

    public void pushAll(List<String> elements) {
        for (String element : elements) {
            this.push(element);
        }
    }
}
