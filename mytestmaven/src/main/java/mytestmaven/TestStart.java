/*package mytestmaven;

public class TestStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("test");
		System.out.println("see what happens.");
		System.out.println("try again, this println function.");
	}

}*/

package py4j.examples;

import java.util.LinkedList;
import java.util.List;

public class Stack {
    private List<String> internalList = new LinkedList<String>();

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

import py4j.GatewayServer;

public class StackEntryPoint {

    private Stack stack;

    public StackEntryPoint() {
      stack = new Stack();
      stack.push("Initial Item");
    }

    public Stack getStack() {
        return stack;
    }

    public static void main(String[] args) {
        GatewayServer gatewayServer = new GatewayServer(new StackEntryPoint());
        gatewayServer.start();
        System.out.println("Gateway Server Started");
    }

}

