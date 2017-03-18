import java.util.Stack;
public class MinStack {
	private Stack<Integer> stacka;
	private Stack<Integer> stackb;
	MinStack(){
		this.stacka = new Stack<Integer>();
		this.stackb = new Stack<Integer>();
	}
	
	public void push(int num){
		this.stacka.push(num);
		if (this.stackb.isEmpty() ||this.stackb.peek() >= num){
			stackb.push(num);
		}
	}
	
	public int pop(){
		int tmp = this.stacka.pop();
		if (tmp == this.stackb.peek())
			this.stackb.pop();
			System.out.println("pop once");
		return tmp;
	}
	
	public int top(){
		return this.stacka.peek();
	}

	public int getMin(){
		return this.stackb.peek();
	}
}

	





