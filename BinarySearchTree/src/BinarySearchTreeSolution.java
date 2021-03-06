import java.util.*;
import java.lang.String.*;
public class BinarySearchTreeSolution {
	
	public boolean isValidBST(TreeNode root){
		if (root == null) return true;
		return isValidBST(root.left) && isValidBST(root.right) && 
				isSubTreeLessThan(root.left, root.val) 
				&& isSubTreeGreaterThan(root.right, root.val);
	}
	
	private boolean isSubTreeLessThan(TreeNode p, int val){
		if (p == null) return true;
		return (p.val < val) && isSubTreeLessThan(p.left, val)
				&& isSubTreeLessThan(p.right, val);
	}
	
	private boolean isSubTreeGreaterThan(TreeNode p, int val){
		if(p == null) return true;
		return (p.val > val) && isSubTreeGreaterThan(p.left, val)
				&& isSubTreeGreaterThan(p.right, val);
	}
	
	public boolean isValidBST_2(TreeNode root){
		if (root == null) return true;
		return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private boolean isValid(TreeNode p, int low, int high){
		if (p == null) return true;
		return p.val > low && p.val < high &&
				isValid(p.left, low, p.val)
				&& isValid(p.right, p.val, high);
	}

	public static boolean validateBinarySearchTree(TreeNode root){
		if (root == null) return false;
		if (validateBinarySearchTree(root.left) 
		&& validateBinarySearchTree(root.right)
		&& isLessThanRoot(root.left, root.val) 
		&& isGreaterThanRoot(root.right, root.val))
			return true;
		else return false;
	}
	public static boolean isLessThanRoot(TreeNode left, int val){
		if(left == null) return true;
		if ((left.val < val) 
			&& isLessThanRoot(left.left, val)
			&& isLessThanRoot(left.right, val))
			return true;
		else return false;
	}
	public static boolean isGreaterThanRoot(TreeNode right, int val){
		if (right == null) return true;
		if ((right.val >= val)
				&& isGreaterThanRoot(right.left, val)
				&& isGreaterThanRoot(right.right, val))
			return true;
		else return false;
	}
	
	private TreeNode prev;
	public boolean isValidBST3(TreeNode root) {
	prev = null;
	   return isMonotonicIncreasing(root);
	}
	private boolean isMonotonicIncreasing(TreeNode p) {
	   if (p == null) return true;
	   if (isMonotonicIncreasing(p.left)) {
	      if (prev != null && p.val <= prev.val) return false;
	      prev = p;
	      return isMonotonicIncreasing(p.right);
	}
	   return false;
	}
	// starting from a root of a binary tree.
	// make an inorder traversal of a binary tree
	// and return a list of the node value
	public static List<Integer> inorderTraversal(TreeNode root){
		List<Integer> nodeValueList = new ArrayList<>();
		List<Integer> leftList = new ArrayList<>();
		List<Integer> rightList = new ArrayList<>();
		if (root != null){
			leftList = inorderTraversal(root.left);
			rightList = inorderTraversal(root.right);
		}
		else return nodeValueList;
		nodeValueList.addAll(leftList);
		nodeValueList.add(root.val);
		nodeValueList.addAll(rightList);
		return nodeValueList;
	}

	public static List<Integer> preorderTraversal(TreeNode root){
		List<Integer> nodeValueList = new ArrayList<>();
		List<Integer> leftList = new ArrayList<>();
		List<Integer> rightList = new ArrayList<>();
		if (root != null){
			leftList = preorderTraversal(root.left);
			rightList = preorderTraversal(root.right);
		}
		else return nodeValueList;
		nodeValueList.add(root.val);
		nodeValueList.addAll(leftList);
		nodeValueList.addAll(rightList);
		return nodeValueList;
	}
	
	public static List<Integer> postorderTraversal(TreeNode root){
		List<Integer> nodeValueList = new ArrayList<>();
		List<Integer> leftList = new ArrayList<>();
		List<Integer> rightList = new ArrayList<>();
		if (root != null){
			leftList = postorderTraversal(root.left);
			rightList = postorderTraversal(root.right);
		}
		else return nodeValueList;
		nodeValueList.addAll(leftList);
		nodeValueList.addAll(rightList);
		nodeValueList.add(root.val);
		return nodeValueList;
	}
	
	
	
	public static void testTraversalType(){
		TreeNode root = buildBTree();
		System.out.println("Inorder Traversal:");
		List<Integer> nodeList = inorderTraversal(root);
		System.out.println(nodeList);
		
		System.out.println("postorder Traversal:");
		nodeList = postorderTraversal(root);
		System.out.println(nodeList);
		
		System.out.println("preorder Traversal:");
		nodeList = preorderTraversal(root);
		System.out.println(nodeList);
		
	}
	
	
	public static void testQueueOfLinkedListFIFO(){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
	}
	
	
	
	
	
	
	public static int[] twoSum(int[] nums, int target){
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++){
			if (map.containsKey(target - nums[i])){
				return new int[]{map.get(target - nums[i])+1, i + 1};
		}
		map.put(nums[i], i);
		System.out.println("add key value pairs");
		System.out.println(i);
		
		}
		throw new IllegalArgumentException("No two sum solution.");
	}
	
	public static int getMaxDepthBTree(TreeNode root){
		int maxlevel = traverse(root, 0);	
		return maxlevel;
	}
	
	private static int traverse(TreeNode p, int level){
		if (p == null) return level;
		level += 1;
		int levelleft = traverse(p.left, level);
		int levelright = traverse(p.right, level);
		return (levelleft >= levelright) ? levelleft: levelright;
	}
	
	
	public static int MaxDepth(TreeNode root){
		if (root == null) return 0;
		return Math.max(MaxDepth(root.left), MaxDepth(root.right)) + 1;
	}
	
	public static int MinDepth(TreeNode root){
		if (root == null) return 0;
		if (root.left == null) return MinDepth(root.right) + 1;
		if (root.right == null) return MinDepth(root.left) + 1;
		return Math.min(MinDepth(root.left), MinDepth(root.right)) + 1;
	}
	
	
	public static TreeNode buildBTree(){
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		e.right = f;
		return a;
	}
	
	public int minDepth2(TreeNode root){
		if (root == null) return 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		TreeNode rightMost = root;
		int depth = 1;
		while(!q.isEmpty()){
			TreeNode node = q.poll();
			if (node.left == null && node.right == null) break;
			if (node.left != null) q.add(node.left);
			if (node.right != null) q.add(node.right);
			if (node == rightMost){
				depth++;
				rightMost = (node.right != null) ? node.right : node.left;
				
			}
		}
		return depth;
	}
	
	public static boolean isBalanced(TreeNode root){
		if (root == null) return true;
		return isBalanced(root.left)
				&& isBalanced(root.right)
				&& (Math.abs(MaxDepth(root.left) - MaxDepth(root.right)) <= 1);
	}
	
	public static void testIsBalanced(){
		TreeNode root = buildBTree();
		System.out.println(isBalanced(root));
	}
	
	public static TreeNode convertSortedList2BST(int[] nums){
		return convertSortedList2BST(nums, 0, nums.length-1);
	}
	
	private static TreeNode convertSortedList2BST(int[] nums, int begin, int end){
		if (begin > end) return null;
		int mid = (begin + end) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = convertSortedList2BST(nums, begin, mid-1);
		root.right = convertSortedList2BST(nums, mid + 1, end);
		return root;
	}
	
	
	
	private static LinkNode list;
	private static TreeNode sortedListToBST(int start, int end) {
	   if (start > end) return null;
	   int mid = (start + end) / 2;
	   System.out.println("mid value is " + mid);
	   TreeNode leftChild = sortedListToBST(start, mid-1);
	   TreeNode parent = new TreeNode(list.getVal());
	   System.out.println("parent value is " + list.getVal());
	   parent.left = leftChild;
	   list = list.next;
	   parent.right = sortedListToBST(mid+1, end);
	   return parent;
	}
	
	public static TreeNode sortedListToBST(LinkNode head) {
	   int n = 0;
	   LinkNode p = head;
	   while (p != null) {
		   p = p.next;
		   n++; }
	   list = head;
	   return sortedListToBST(0, n - 1);
	}
	
	public static void testSortedListToBST(){
		LinkNode root = new LinkNode(0);
		root.next = new LinkNode(1);
		root.next.next = new LinkNode(2);
		root.next.next.next = new LinkNode(3);
		root.next.next.next.next = new LinkNode(4);
		
		TreeNode treeroot = sortedListToBST(root);
		
		List<Integer> nodes = inorderTraversal(treeroot);
		
		for (int i = 0; i < nodes.size(); i++){
			System.out.println(nodes.get(i));
		}
	}
	
	// find max sum of all the a binary tree path
	// TreeNode, start from a root node of the tree
	private static int maxSum;
	public static int maxSumOfAllPaths(TreeNode root){
		// make the basis case is met
		// find left max, find right max and make combinations
		// find the final max and return the value
		
		maxSum = Integer.MIN_VALUE;
		findMaxPath(root);
		return maxSum;
	}
	public static int findMaxPath(TreeNode p){
		if (p == null) return 0;
		int maxL = maxSumOfAllPaths(p.left);
		int maxR = maxSumOfAllPaths(p.right);
		int ret = p.val + Math.max(maxL, maxR);
		maxSum = Math.max(maxL + p.val + maxR, maxSum);
		return (ret > 0) ? ret : 0;
	}
	
	public static TreeNode rotateBTUpsideDown(TreeNode root){
		TreeNode p = root, pp = null, pr = null;
		while (p != null){
			TreeNode pl = p.left;
			p.left = pr;
			pr = p.right;
			p.right = pp;
			pp = p;
			p = pl;
		}
		return pp;
	}
	
	public static void testRotateBTUpsideDown(){
		System.out.println("test rotate BT upside down");
		TreeNode a = new TreeNode(0);
		a.left = new TreeNode(1);
		a.right = new TreeNode(2);
		a.left.left = new TreeNode(3);
		a.left.right = new TreeNode(4);
		a.left.left.left = new TreeNode(5);
		a.left.left.right = new TreeNode(6);
		TreeNode b = rotateBTUpsideDown(a);
		List<Integer> treenodes = preorderTraversal(b);
		for (int i = 0; i < treenodes.size(); i++){
			System.out.println(treenodes.get(i));
		}
	}
	
	
	public static TreeNode rotateBTreeFromBottomUp(TreeNode root){
		return rotate(root, null);
	}
	
	public static TreeNode rotate(TreeNode p, TreeNode parent){
		if (p == null) return parent; 
		TreeNode root = rotate(p.left, p);
		p.left = (parent == null) ? parent : parent.right;
		p.right = parent;
		return root;
		
		
	}
	
	public static int findSingleNumber(int[] nums){
		//if (nums.length <= 0) return 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++){
			if (!map.containsKey(nums[i])){
				map.put(nums[i], i);
				System.out.println(map.get(nums[i]));
			}
			else{
				System.out.println("remove number" + nums[i]);
				System.out.println("remove" + map.get(nums[i]));
				map.remove(nums[i]);
			}
		}
		for (int i = 0; i < nums.length; i++){
			if (map.containsKey(nums[i])){
				return nums[i];
			}
			//return 0;
		}
		return -1;
	}
	
	
	public static void testFindSingleNumber(){
		System.out.println("test finding single number:");
		int[] nums = {1, 2, 4, 3, 2, 3,  1};
		System.out.println("Single number is " + findSingleNumber(nums));
		int[] nums1 = {1, 1, 2, 2, 999, 3, 3, 2, 3,  1};
		System.out.println("Single number is " + findSingleNumberUsingBits(nums1));
	}
	
	
	
	
	
	public static int findSingleNumberUsingHashSet(int[] nums){
		Set<Integer> numset = new HashSet<>();
		for (int x : nums){
			if (!numset.contains(x)){
				numset.add(x);
			}
			else{
				numset.remove(x);
			}
		}
		return numset.iterator().next();
	}
	
	
	public static void testXOROperator(){
		System.out.println("test xor operator");
		System.out.println(5^6);
		int h = 3;
		System.out.println((h >> 1)&1);

	}
	
	
	public static int findSingleNumberUsingBits(int[] nums){
		System.out.println("find single number using bits:");
		int result = 0;
		for (int i = 0; i < 32; i++){
			int counter = 0;
			for (int j = 0; j < nums.length; j++){
				int num = nums[j];
				if (((num >> i) & 1) == 1){
					counter++;
				}
			}
			result |= (counter % 3) << i;
		}
		return result;
		
	}
	
	public static List<Integer> spiralMatrix(int[][] A){
		List<Integer> result = new ArrayList<Integer>();
		int m = A.length, n = A[0].length + 1;
		int row = 0, col = -1;
		while (true){
			if (--n == 0) break;
			for (int i = 0; i < n; i++){
				result.add(A[row][++col]);
			}
			if (--m == 0) break;
			for (int j = 0; j < m; j++){
				result.add(A[++row][col]);
			}
			if (--n == 0) break;
			for (int i = 0; i < n; i++){
				result.add(A[row][--col]);
			}
			if (--m == 0) break;
			for (int j = 0; j < m; j++){
				result.add(A[--row][col]);
			}
		}
		return result;
	}
	
	public static void testSpiralMatrix(){
		System.out.println("Test spiral matrix:");
		int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
		List<Integer> list = spiralMatrix(A);
		for (int i = 0; i < list.size(); i++){
			System.out.println("spiral : " + list.get(i) );
		}
	}
	
	private static final String[] symbols ={
			"M", "CM", "D", "CD",
			"C", "XC", "L", "XL",
			"X", "IX", "V", "IV",
			"I"
	};
	
	private static final int[] values ={
			1000, 900, 500, 400,
			100,  90,  50,  40,
			10,   9,   5,   4,
			1
	};
	
	public static String numeral2Roman(int num){
		StringBuilder s = new StringBuilder();
		int i = 0;
		while (num > 0){
			int k = num / values[i];
			for (int j = 0; j < k; j++){
				s.append(symbols[i]);
				num -= values[i];
			}
			i++;
		}
		return s.toString();
	}
	
	public static void testNumeral2Roman(){
		int num = 2615;
		System.out.println("test numeral to Roman:");
		System.out.println(num + "  -> " +numeral2Roman(num));
		String roman = "MMDCXIVI";
		System.out.println(roman + " Roman to numeral is :" +
		roman2numeral(roman));
	}
	
	
	public static int roman2numeral(String roman){
		Map<Character, Integer> map = 
				new HashMap<Character, Integer>(){{
			put('I', 1); put('V', 5); put('X', 10);
			put('L', 50); put('C', 100); put('D', 500);
			put('M', 1000);
		}};
		int prev = 0, total = 0;
		for (char c : roman.toCharArray()){
			int curr = map.get(c);
			total += (curr > prev) ? (curr - 2 * prev) : curr;
			prev = curr;
		}
		return total;
		
		
	}
	
	public static DirectedGraphNode testBuildDirectedGraph(){
		DirectedGraphNode a = new DirectedGraphNode(0);
		DirectedGraphNode b = new DirectedGraphNode(1);
		DirectedGraphNode c = new DirectedGraphNode(4);
		DirectedGraphNode d = new DirectedGraphNode(6);
		a.neigbors.add(b);
		a.neigbors.add(new DirectedGraphNode(2));
		a.neigbors.add(new DirectedGraphNode(3));
		b.neigbors.add(c);
		b.neigbors.add(d);
		d.neigbors.add(c);
		c.neigbors.add(a);
		c.neigbors.add(new DirectedGraphNode(5));
		System.out.println("Directed Graph Example:" + a.label + "-> "
				+ a.neigbors.get(0).label + " -> "
				+ a.neigbors.get(0).neigbors.get(0).label +"->"
				+ a.neigbors.get(0).neigbors.get(0).neigbors.get(0).label
				);
		return a;
	}
	
	public static Set<DirectedGraphNode> traversedNodeSet = new HashSet<>();
	public static List<Integer> traverseDirectedGraph(DirectedGraphNode start){
		List<Integer> result = new ArrayList<Integer>();
		
		if ((start == null))return result;
		result.add(start.label);
		traversedNodeSet.add(start);
		
		if (start.neigbors.isEmpty()){
			return result;
		}
		else{
			for (DirectedGraphNode node : start.neigbors){
				if (!traversedNodeSet.contains(node)){
					traversedNodeSet.add(node);
					result.addAll(traverseDirectedGraph(node));
				}	
			}
		return result;
		}
	}
	
	public static void testTraverseDirectedGraph(){
		System.out.println("traverse directed graph:");
		DirectedGraphNode graph = testBuildDirectedGraph();
		List<Integer> gnodelist = traverseDirectedGraph(graph);
		for (int i = 0; i < gnodelist.size(); i++){
			
			System.out.println("graph node label: " + gnodelist.get(i));
		}
		
	}
	
	public static Set<UndirectedGraphNode> UndirectedGraphNodeSet = new HashSet<UndirectedGraphNode>();
	public static Map<UndirectedGraphNode, UndirectedGraphNode>gmap = new HashMap<>();
	public static UndirectedGraphNode 
	croneUndirectedGraph(UndirectedGraphNode p){
		UndirectedGraphNode croneNode = null;
		if (p == null) return croneNode;
		if (UndirectedGraphNodeSet.contains(p)) return gmap.get(p);
		UndirectedGraphNodeSet.add(p); 
		croneNode = new UndirectedGraphNode(p.label);
		gmap.put(p,croneNode);
		if (p.neigbors.isEmpty()) return croneNode; 
		for (UndirectedGraphNode node : p.neigbors){
			croneNode.neigbors.add(croneUndirectedGraph(node));		
		}
		return croneNode;
	}
	
	
	public static UndirectedGraphNode testBuildUndirectedGraph(){
		UndirectedGraphNode a = new UndirectedGraphNode(0);
		UndirectedGraphNode b = new UndirectedGraphNode(1);
		UndirectedGraphNode c = new UndirectedGraphNode(4);
		UndirectedGraphNode d = new UndirectedGraphNode(6);
		a.neigbors.add(b);
		a.neigbors.add(new UndirectedGraphNode(2));
		a.neigbors.add(new UndirectedGraphNode(3));
		b.neigbors.add(c);
		b.neigbors.add(d);
		d.neigbors.add(c);
		c.neigbors.add(a);
		c.neigbors.add(new UndirectedGraphNode(5));
		System.out.println("Directed Graph Example:" + a.label + "-> "
				+ a.neigbors.get(0).label + " -> "
				+ a.neigbors.get(0).neigbors.get(0).label +"->"
				+ a.neigbors.get(0).neigbors.get(0).neigbors.get(0).label
				);
		return a;
	}
	
	public static void testCroneUndirectedGraph(){
		System.out.println("crone undirected graph:");
		UndirectedGraphNode graph = testBuildUndirectedGraph();
		UndirectedGraphNode croneGraph = croneUndirectedGraph(graph);
		System.out.println("graph node label: " + graph.neigbors.get(0).neigbors.get(0).neigbors.get(1) + "  address: " + graph);
		System.out.println("croneGraph node label: " + croneGraph.neigbors.get(0).neigbors.get(0).neigbors.get(1) + "  address: " + croneGraph);
	}
	
	
	
	public static void testMinStack(){
		System.out.println("test minstack: ");
		MinStack myMinStack = new MinStack();
		myMinStack.push(5);
		System.out.println(myMinStack.getMin());
		myMinStack.push(1);
		System.out.println(myMinStack.getMin());
		myMinStack.push(2);
		System.out.println(myMinStack.getMin());
		myMinStack.push(1);
		System.out.println(myMinStack.getMin());
		myMinStack.push(0);
		System.out.println(myMinStack.getMin());
		myMinStack.push(0);
		System.out.println(myMinStack.getMin());
		System.out.println("start pop");
		myMinStack.pop();
		System.out.println(myMinStack.getMin());
		myMinStack.pop();
		System.out.println(myMinStack.getMin());
		myMinStack.pop();
		System.out.println(myMinStack.getMin());
		myMinStack.pop();
		System.out.println(myMinStack.getMin());
		myMinStack.pop();
		System.out.println(myMinStack.getMin());
		
	}
	
	public static final Set<String> OperatorSet 
	= new HashSet<>(Arrays.asList("+", "-", "*", "/"));
	
	public static int evaluateReversedPolishExpression(String[] tokens){
		int result = 0;
		Stack<String> sk = new Stack<String>();
		for (String token : tokens){
			if (OperatorSet.contains(token)){
				int x = Integer.parseInt(sk.pop());
				int y = Integer.parseInt(sk.pop());
				result = evalOPRN(x, y, token);
				sk.push(Integer.toString(result));
			}
			else{
				sk.push(token);
			}
		}
		return Integer.parseInt(sk.pop());
		
	}
	
	public static int evalOPRN(int x, int y, String operator){
		switch (operator){
			case "+": return x + y;
			case "-": return x - y;
			case "*": return x * y;
			default: return x / y;
		}
	}
	
	public static void testEvalReversedPolish(){
		System.out.println("test eval polish expression");
		String[] tokens = {"1","2", "+", "3", "/","5","*","55","35", "+", "/"};
		System.out.println(evaluateReversedPolishExpression(tokens));
		System.out.println(evalPolishExp(tokens));
	}
	
	public static final
	Map<String, Operator> OPERATORS = new HashMap<String, Operator>(){{
		put("+", new Operator(){public int eval(int x, int y){return x + y;}});
		put("-", new Operator(){public int eval(int x, int y){return x - y;}});
		put("*", new Operator(){public int eval(int x, int y){return x * y;}});
		put("/", new Operator(){public int eval(int x, int y){return x / y;}});
	}};
	
	public static int evalPolishExp(String[] tokens){
		Stack<String> sk = new Stack<String>();
		for (String token : tokens){
			if (OPERATORS.containsKey(token)){
				// do calculation
				int x = Integer.parseInt(sk.pop());
				int y = Integer.parseInt(sk.pop());
				sk.push(Integer.toString(OPERATORS.get(token).eval(x, y)));
			}
			else{
				sk.push(token);
			}
		}
		return Integer.parseInt(sk.pop());	
	}
	
	public static final Map<Character, Character> map =
			new HashMap<Character, Character>(){{
				put('(', ')');
				put('[', ']');
				put('{', '}');
			}};
	
	public boolean isValid(String s){
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()){
			if (map.containsKey(c)){
				stack.push(c);
			}
			else if (stack.isEmpty() || map.get(stack.pop()) != c){
				return false;
			}
		}
		return stack.isEmpty();
	}
	
	// dynamic programming
	public static int climbStairs(int n){
		int present = 1, previous = 1;
		for (int i = 1; i < n; i++){
			int tmp = present;
			present += previous;
			previous = tmp;
			
		}
		return present;
	}
	
	public static int alternativeClimbStairs(int n){
		if (n <= 1) return 1;
		if (n == 2) return 2;
		return alternativeClimbStairs(n - 1) + alternativeClimbStairs(n - 2);
	}
	
	public static void testClimbStairs(){
		for (int i = 1; i < 10; i++){
			System.out.println(i + "stairs : " + climbStairs(i));
			System.out.println(i + "stairs : " + alternativeClimbStairs(i));};
	
	}
	
	public static int counter = 0;
	public static int backTrack(int r, int c, int m, int n){
		System.out.println("times of access: " + counter);
		counter++;
		if (r == m - 1 && c == n - 1) return 1;
		if (r >= m || c >= n) return 0;
		//counter++;
		return backTrack(r + 1, c, m, n) + backTrack(r, c + 1, m, n);
	}
	
	public static int uniquePaths(int m, int n){
		return backTrack(0, 0, m, n);
	}
	
	public static int counter2 = 0;
	public static int backTrackDynamicPro(int r, int c, int m, int n, int[][] map){
		System.out.println("times of access: " + counter2);
		counter2++;
		if (r == m - 1 && c == n - 1) return 1;
		if (r >= m || c >= n) return 0;
		if (map[r + 1][c] == -1){
			 map[r + 1][c] = backTrackDynamicPro(r + 1, c, m, n, map);}
		if (map[r][c + 1] == -1){
			map[r][c + 1] = backTrackDynamicPro(r, c + 1, m, n, map);}
		return map[r + 1][c] + map[r][c + 1];
	}
	
	public static int uniquePathsDynamicPro(int m, int n){
		int[][] map = new int[m+1][n+1];
		for (int i = 0; i < m; i++){
			for (int j = 0; j < n; j++){
				map[i][j] = -1;
			}
		}
		return backTrackDynamicPro(0, 0, m, n, map);
	}
	
	
	public static void testUniquePaths(){
		int m = 3, n = 2;
		System.out.println("unique paths:" + m + "," + n + ":  "+ uniquePaths(m, n));
		System.out.println("2n unique paths:" + m + "," + n + ":  "+uniquePathsDynamicPro(m, n));
	}
	
	
	//Find the contiguous subarray within an array (containing at least one number) that has the largest sum.
	public static int maxSumContinguousSubArrays(int[] nums){
		return maxSumSub(nums, 0, nums.length-1);
	}
	
	public static int maxSumSub(int[] A, int L, int R){
		if (L > R) return Integer.MIN_VALUE;
		int M = (L + R) / 2;
		int maxleft = maxSumSub(A, L, M - 1);
		int maxright = maxSumSub(A, M + 1, R);
		int maxSumL = 0;
		int sum = 0;
		for (int i = M-1; i >= L; i--){
			sum += A[i];
			maxSumL = Math.max(sum, maxSumL);
			System.out.println(maxSumL);
		}
		int maxSumR = 0;
		sum = 0;
		for (int i = M + 1; i < R; i++){
			sum += A[i];
			maxSumR = Math.max(sum, maxSumR);
		}
		return Math.max(maxSumL + A[M] + maxSumR, Math.max(maxleft, maxright));
			
	}
	
	public static void testMaxSubArray(){
		int[] arrA = { -13, -14, 5, -3, 12, -4, -15, -16};
        System.out.println("Maximum subarray is  " + maxSumContinguousSubArrays(arrA));
	}
	
	
	public static int strStr(){
		return strStr("The skye is very blue yeah", "blue");
	}
	public static int strStr(String haystack, String needle){
		
		for (int i = 0; ; i++){
			for (int j = 0; ; j++){
				//System.out.println(j);
				if (j == needle.length()) return i;
				if ((i + j) == haystack.length()) return -1;
				if (needle.charAt(j) != haystack.charAt(i+j)) break;
			}
			//System.out.println("current i is : " + i);
		}
	}
	
	
//	public static String reverseStr(String sentence){
//	String	
//	}
	// merge two sorted linkedlist together according to the their value order
	public static LinkNode merge2LinkedLists(LinkNode rootL, LinkNode rootR){
		if (rootL == null && rootR == null) return null;
		if (rootL == null && rootR != null) return rootR;
		if (rootL != null && rootR == null) return rootL;
		LinkNode tmp = new LinkNode(0);
		LinkNode head = tmp;
		while(rootL != null && rootR != null){
			if (rootL.getVal() <= rootR.getVal()){
				tmp.next = rootL;
				rootL = rootL.next;
				tmp = tmp.next;
			}else{
				tmp.next = rootR;
				rootR = rootR.next;
				tmp = tmp.next;
			}
		}
		if(rootL == null && rootR != null){
			tmp.next = rootR;
		}
		if(rootL != null && rootR == null){
			tmp.next = rootL;
		}
		return head.next;
	}
	
	private static final Comparator<LinkNode> listComparator = 
			new Comparator<LinkNode>(){
		@Override
		public int compare(LinkNode x, LinkNode y)
		{
			return x.getVal() - y.getVal();
			}
		};
		
	public static LinkNode mergeKLists(List<LinkNode> lists){
		if (lists.isEmpty()) return null;
		Queue<LinkNode> queue = new PriorityQueue<>(lists.size(), listComparator);
		for (LinkNode node: lists){
			if (node != null){
				queue.add(node);
			}
		}
		LinkNode dummyHead = new LinkNode(0);
		LinkNode p = dummyHead;
		while (!queue.isEmpty()){
			LinkNode node = queue.poll();
			p.next = node;
			p = p.next;
			if (node.next != null){
				queue.add(node.next);
			}
		}
		return dummyHead.next;
	}
	
	
	// Todo: 1, define Comparator
	//       2. MergeKsortedLists
	//          // see if lists is empty
	//            make a new queue
	//            load the lists into the que
	//            poll the mininum out of the queue
	//            add next node to the queue
	//            
	
	private static final Comparator<LinkNode> listComparator2 = new Comparator<LinkNode>(){
		@Override
		public int compare(LinkNode x, LinkNode y){
			return x.getVal() - y.getVal();
		}
		
	};
	
	public static LinkNode mergeKSortedLinkedLists2(List<LinkNode> lists){
		if (lists.isEmpty()) return null;
		Queue<LinkNode> q = new PriorityQueue<LinkNode>(lists.size(), listComparator2);
		for (LinkNode node : lists){
			if (node != null){
				q.add(node);
			}
		}
		LinkNode dummyHead = new LinkNode(0);
		LinkNode p = dummyHead;
		while (!q.isEmpty()){
			LinkNode node = q.poll();
			p.next = node;
			p = p.next;
			if (node.next != null){
				q.add(node.next);
			}
		}
		return dummyHead.next;
	}
	
	public static LinkNode mergeKSortedLinkedNodeListsUsingMerge2(List<LinkNode> lists){
		if (lists.isEmpty()) return null;
		int start = 0, end = lists.size() - 1;
		LinkNode dummyHead = new LinkNode(0);
		while (end > 0){
			while (start < end){
				dummyHead.next = merge2SortedLinkedNodeLists(lists.get(start), lists.get(end));
				lists.set(start, dummyHead.next);
				start++;
				end--;
			}
		//end = start -1;
		start = 0;
		}
		return lists.get(0);
	}
	
	public static LinkNode merge2SortedLinkedNodeLists(LinkNode left, LinkNode right){
		if (left == null || right == null) return (left == null) ? right : left;
		System.out.println("merge two sorted linked lists start");
		LinkNode pl, pr, p, dummyHead = new LinkNode(0);
		p = dummyHead;
		pl = left;
		pr = right;
		while (pl != null && pr != null){
			if (pl.getVal() <= pr.getVal()){
				p.next = pl;
				pl = pl.next;
				p = p.next;
				System.out.println("merge two sorted linked lists ongoing");
			}
			else{
				p.next = pr;
				pr = pr.next;
				p = p.next;
				System.out.println("merge two sorted linked lists ongoing2");
			}
		}
		if (pl != null) p.next = pl;
		if (pr != null) p.next = pr;
		return dummyHead.next;
	}
	
	public static void testMerge2SortedLinkedLists(){
		LinkNode roota = new LinkNode(1);
		roota.next = new LinkNode(2);
		roota.next.next = new LinkNode(4);
		roota.next.next.next = new LinkNode(8);
		
		LinkNode rootb = new LinkNode(3);
		rootb.next = new LinkNode(4);
		rootb.next.next = new LinkNode(5);
		rootb.next.next.next = new LinkNode(7);
		
		//LinkNode mergedlinklist = merge2LinkedLists(roota, rootb);
		
		LinkNode mergedlinklist2 = merge2SortedLinkedNodeLists(roota, rootb);
		LinkNode tmp;
		tmp = mergedlinklist2;
		//tmp = roota;

		
		while (tmp != null){
			System.out.println(tmp.getVal());
			tmp = tmp.next;
		}
		
	}
	
	public static LinkNode addTwoNumbers(LinkNode l1, LinkNode l2){
		// each list has a reversed number, such, 1, 2, 3 -> 321
		// to add up two numbers, we need to move along both list
		// until one of them hit the null pointer.
		// then link the left digits as well as the carry to 
		// this left part and potenially add one more node for the carry
		// variables I need:
		LinkNode sumHead = new LinkNode(0);
		LinkNode p1 = l1, p2 = l2, p3 = sumHead;
		
		int carry = 0;
		if (p1 == null) return l2;
		if (p2 == null) return l1;
		
		while (p1 != null && p2 != null){
			p3.next = new LinkNode((p1.getVal() + p2.getVal() + carry) % 10);
			carry = (p1.getVal() + p2.getVal() + carry) / 10;
			p1 = p1.next;
			p2 = p2.next;
			p3 = p3.next;
		}
		while (p1 != null){
			p3.next = new LinkNode((p1.getVal()  + carry) % 10);
			carry = (p1.getVal() + carry) / 10;
			p1 = p1.next;
			p3 = p3.next;
		}
		while (p2 != null){
			p3.next = new LinkNode((p2.getVal()  + carry) % 10);
			carry = (p2.getVal() + carry) / 10;
			p2 = p2.next;
			p3 = p3.next;
		}
		
		if (carry > 0) p3.next = new LinkNode(carry);
		System.out.println("last digit is  " + p3.getVal());
		return sumHead.next;
		
	}
	
	public static void testAddTwoLinkListNumbers(){
		LinkNode roota = new LinkNode(1);
		roota.next = new LinkNode(2);
		roota.next.next = new LinkNode(4);
		roota.next.next.next = new LinkNode(8);
		
		LinkNode rootb = new LinkNode(3);
		rootb.next = new LinkNode(4);
		rootb.next.next = new LinkNode(5);
		rootb.next.next.next = new LinkNode(7);
		//rootb.next.next.next.next = new LinkNode(1);
		
		LinkNode sumlinklist = addTwoNumbers(roota, rootb);
		LinkNode tmp;
		tmp = sumlinklist;
		//tmp = roota;

		//swapNodesInPairs();
		while (tmp != null){
			System.out.println("curr "+tmp.getVal());
			tmp = tmp.next;
			//System.out.println("next" + tmp.getVal());
		}
		
		System.out.println("test swap Nodes in pairs:");
		LinkNode rootc = new LinkNode(1);
		rootc.next = new LinkNode(2);
		rootc.next.next = new LinkNode(4);
		rootc.next.next.next = new LinkNode(8);
		rootc.next.next.next.next = new LinkNode(9);
		rootc.next.next.next.next.next = new LinkNode(10);
		
		System.out.println("before swap:");
		tmp = rootc;
		while (tmp != null){
			System.out.println(tmp.getVal());
			tmp = tmp.next;
		}
		System.out.println("after swap:");
		tmp = swapNodesInPairs(rootc);
		while (tmp != null){
			System.out.println(tmp.getVal());
			tmp = tmp.next;
			//System.out.println("next" + tmp.getVal());
		}
		
		System.out.println("test the merge k sorted linked lists:");
		
		roota = new LinkNode(1);
		roota.next = new LinkNode(2);
		roota.next.next = new LinkNode(4);
		roota.next.next.next = new LinkNode(8);
		
		rootb = new LinkNode(3);
		rootb.next = new LinkNode(4);
		rootb.next.next = new LinkNode(5);
		rootb.next.next.next = new LinkNode(7);
		//rootb.next.next.next.next = new LinkNode(1);
		
		rootc.next = new LinkNode(2);
		rootc.next.next = new LinkNode(4);
		rootc.next.next.next = new LinkNode(8);
		rootc.next.next.next.next = new LinkNode(9);
		rootc.next.next.next.next.next = new LinkNode(10);
		List<LinkNode> lists = new ArrayList<LinkNode>(Arrays.asList(roota, rootb, rootc));
		//tmp = mergeKLists(lists);
		//tmp = mergeKSortedLinkedLists2(lists);
		System.out.println("test mergeKSortedLinkedNodeListsUsingMerge2(lists) ");
		tmp = mergeKSortedLinkedNodeListsUsingMerge2(lists);
		while (tmp != null){
			System.out.println(tmp.getVal());
			tmp = tmp.next;
			//System.out.println("next" + tmp.getVal());
		}
		
	}
	
	public static LinkNode swapNodesInPairs(LinkNode root){
		LinkNode p, p1, p2, p3, dummyHead = new LinkNode(0);
		dummyHead.next = root;
		
		if (root == null) return dummyHead.next;
		if (root.next == null) return dummyHead.next;
		dummyHead.next = root.next; 
		p = dummyHead;
		p1 = root; p2 = root.next; p3 = root.next.next;
		while (p1 != null){
			if (p2 != null){
				p.next = p2;
				p1.next = p3;
				p.next.next = p1;
				p = p.next.next;
				p1 = p3;
				p2 = (p3 != null) ? p3.next : null;
				p3 = (p3 != null && p3.next != null) ? p3.next.next: null;
			}
			else{
				p.next = p1;
				return dummyHead.next;
			}
		}
		return dummyHead.next;
	}
	
	public static RandomListNode copyRandomList(RandomListNode head){
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode p = head;
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode q = dummy;
		while (p != null){
			q.next = new RandomListNode(p.label);
			map.put(p, q.next);
			p = p.next;
			q = q.next;
		}
		p = head;
		q = dummy;
		while (p != null){
			q.next.random = map.get(p.random);
			p = p.next;
			q = q.next;
		}
		return dummy.next;
		
	}
	
	public static RandomListNode deepCopyRandomLinkedList(RandomListNode root){
		RandomListNode driver1 = root;
		RandomListNode dummyEngine = new RandomListNode(0);
		RandomListNode driver2 = dummyEngine;
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		while (driver1 != null){
			driver2.next = new RandomListNode(driver1.label);
			map.put(driver1, driver2.next);
			driver1 = driver1.next;
			driver2 = driver2.next;
			
		}
		driver1 = root;
		driver2 = dummyEngine;
		while (driver1 != null){
			driver2.next.random = map.get(driver1.random);
			driver1 = driver1.next;
			driver2 = driver2.next;
		}
		return dummyEngine.next;
	}
	
	public static void testDeepCopyRandomLinkedList(){
		RandomListNode roota = new RandomListNode(0);
		roota.next = new RandomListNode(1);
		roota.next.next = new RandomListNode(2);
		roota.next.next.next = new RandomListNode(3);
		roota.random = roota.next.next;
		roota.next.random = roota.next;
		roota.next.next.random = roota;
		roota.next.next.next.random = roota.next.next;
		RandomListNode p = roota;
		while (p != null){
			System.out.println(p.label + " " );
			if (p.next != null) System.out.println( p.next.label + " " + p.random.label);
			p = p.next;
		}
		//RandomListNode rootacopy = deepCopyRandomLinkedList(roota);
		RandomListNode rootacopy = deepCopyRandomLinkedListUsingInsert(roota);
		p = rootacopy;
		System.out.println("the copy is below:");
		while (p != null){
			System.out.println(p.label + " " );
			if (p.next != null) System.out.println( p.next.label + " " + p.random.label);
			p = p.next;
		}
		
	}
	
	public static RandomListNode deepCopyRandomLinkedListUsingInsert(RandomListNode root){
		RandomListNode driver1, driver2, driver3, dummyHead = new RandomListNode(0);
		System.out.println("start copy");
		driver1 = root;
		driver2 = dummyHead;
		while (driver1 != null){
			driver2 = new RandomListNode(driver1.label);
			driver3 = driver1.next;
			driver1.next = driver2;
			driver2.next = driver3;
			driver1 = driver1.next.next;
			
		}
		System.out.println("insert is done.");
		driver1 = root;
		driver2 = driver1.next;
		
		while (driver1 != null){
			System.out.println(driver1.label);
			driver1.next.random = (driver1.random != null) ? driver1.random.next : null;
			driver1 = driver1.next.next;
		}
		driver1 = root;
		driver3 = dummyHead;
		while (driver1 != null){
			driver3.next = driver1.next;
			driver3 = (driver1 != null) ? driver3.next : null;
			driver1 = driver1.next.next;
		}
		return dummyHead.next;
			
	}
	
	public static char[] inverseStr(char[] inputStr){
		if (inputStr.length < 2) return inputStr;
		int i = 0;
		for(int j = 1; j <= inputStr.length - 1; j++){
			System.out.println("j is " + j);
			if(Character.isSpace(inputStr[j]) && !Character.isSpace(inputStr[j-1]))
			{ System.out.println("reverse, j is " + j + " , i is " + i);
				reverseStr(inputStr, i, j-1);
				System.out.println(inputStr);
				
			}
			if(!Character.isSpace(inputStr[j]) && Character.isSpace(inputStr[j-1])){
				System.out.println("reverse, j is " + j + " , i is " + i);
				i = j;
			}
		}
		return inputStr;
	}
	
	public static char[] reverseStr(char[] s, int start, int end){
		char tmp;
		for (int i = 0; i <= (end - start) / 2; i++){
			tmp = s[start + i];
			s[start + i] = s[end - i];
			s[end - i] = tmp;
		}
		return s;
	}
	
	
	public static String reverseStr2(String s){
		StringBuilder r = new StringBuilder();
		for (int j = s.length()-1; j >= 0; j--){
			if (!Character.isLetter(s.charAt(j))){
				r.append(' ');
				continue;
			}
			int i = j;
			while (i-1 >= 0 && Character.isLetter(s.charAt(i-1))) i--;
			r.append(s.substring(i, j+1));
			r.append(' ');
			j = i - 1;
			
		}
		return r.toString();
	}
	
	public static int convertStr2Num(String inputStr){
		System.out.println("start convert string to number.");
		int maxDiv10 = Integer.MAX_VALUE / 10;
		int result = 0;
		//check each inputStr.CharAt[i] if is space until not;
		int i = 0;
		int s = 1;
		int n = inputStr.length();
		while(i < n && Character.isWhitespace(inputStr.charAt(i))) {i++;}
		//check if the Char is '+' or '-' and then set a variable s as 1 or -1;
		while(i < n && inputStr.charAt(i) == '+') {s = 1; i++;}
		while(i < n && inputStr.charAt(i) == '-') {s = -1; i++;}
		while(Character.isWhitespace(inputStr.charAt(i))) {i++;}
		// move on check inputStr.ChartAt[i] if is a digit;
		while(i < n && Character.isDigit(inputStr.charAt(i))) {
			System.out.println("found digit");
			int digit = Character.getNumericValue(inputStr.charAt(i));
			if (result > maxDiv10 || result == maxDiv10 && digit >=8){
				return s == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE; 
			}
			result = result * 10 + digit;
			System.out.println("rseult is "+ result);
			i++;
		}
		result = s * result;
		return result;
		// if it is a digit, then convert it into an int and calculate the result*10 +  digit
		// till the end where the inputStr.CharAt[i] becomes not a digit
		// then check the result if it is larger than Integeter.MaxValue or smaller than Integer.MinValue
		// and decide which value to return.
	}
	
	
	//valide palindrome
	public static boolean isParlindrome(String s){
		//set two indices for s and scan from two sides toward the center
		int i = 0, j = s.length() - 1;
		while (i < j){
			System.out.println("good 1");
			while (i != j && !Character.isLetterOrDigit(s.charAt(i))) i++;
			System.out.println("good 2");
			while (i != j && !Character.isLetterOrDigit(s.charAt(j))) j--;
			System.out.println("good 3");
			if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
				i++; 
				j--;
				}
			else{ return false;}
			System.out.println("good 4");
		}
		return true;
		
		// move the index toward the center until it hits a letter or digit, otherwise, just keep skipping.
		// once it hits either letter or number, it stops and wait for the other to hit a letter or number
		// then compare and see if they are identical either letters or numbers.
		// if they are different, then return false
		// else keep scan until they both hits the center or overlap and return true;
	}
	
	
	
	
	
	public boolean isNumber(String s) {
		   int i = 0, n = s.length();
		   while (i < n && Character.isWhitespace(s.charAt(i))) i++;
		   if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
		   boolean isNumeric = false;
		   while (i < n && Character.isDigit(s.charAt(i))) {
			   i++;
			   isNumeric = true;
		   }
		   if (i < n && s.charAt(i) == '.') {
		      i++;
		      while (i < n && Character.isDigit(s.charAt(i))) {
		         i++;
		         isNumeric = true;
		      }
		   }
		   while (i < n && Character.isWhitespace(s.charAt(i))) i++;
		   return isNumeric && i == n;
		}
	
	public static void testStringSplit(){
	     String[] result = "this is a test".split("\\s");
	     for (int x=0; x<result.length; x++)
	         System.out.println(result[x]);
	}
	
	public static boolean isNumeric(String s){
		int i = 0, n = s.length();
		while (i < n && Character.isWhitespace(s.charAt(i))) i++;
		if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {i++;}
		boolean isNumeric = false;
		while (i<n && Character.isDigit(s.charAt(i))) {
			i++;
			isNumeric = true;
		}
		if (i < n && s.charAt(i) == '.') {
			i++; 
			while (i<n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumeric = true;
			}	
		}
		while (i < n && Character.isWhitespace(s.charAt(i))) i++;
		return isNumeric && i == n;
	}
	
	//Longest Substring Without Repeating Characters:
	//what parameter we have, an input String, s,
	//return will be an int length of the longest nonrepeat substring
	public static int lengthMaxNonrepeatSubStr(String s){
		int maxLen = 0;
		int i = 0;
		int[] charMap = new int[256];
		Arrays.fill(charMap, -1);
		// assuming all characters are lower case, or upper doesn't equivalent to lower case. 
	 // make a loop with some condition,say, scan j from 0 to n all the way by j++
		for (int j = 0; j < s.length(); j++){	 
			if (charMap[s.charAt(j)] >= i){	
				i = charMap[s.charAt(j)] + 1;
				// set the nonrepeated string start char to the index right after the char 
			}
			charMap[s.charAt(j)] = j;// this is for remembering the index of the char in the 
			maxLen = Math.max(maxLen, j - i + 1);
		}
		return maxLen;
		//open a new dict for temp use.
		//set i = 0, j = 0, scan s from 0, and check if each character already in the a temperory dict ('a', index)
		// if not in the dict, just add it to the dict and move to the next j by j++
		// until hit a point where we see the charAt(j) is in the dict and then we take the 
		// substring out and check its length and see if it is larger than the previous recorded substring length,
		// it is larger, then update, if it is not just skip. and flush the dict so that
		
		// once j reach the end of s. we just return the largest substring lenght back.
	}
	
	public static int getLongestSubstrWithMost2DistChars(String s){
		int n = s.length();
		int i = 0, j = -1;
		int maxLen = 0;
		// scan k from the beginning of the s, all the way to the end
		for (int k = 1; k < n; k++){
			if (s.charAt(k) == s.charAt(k-1)){ continue;}
			if (j >= 0 && s.charAt(j) != s.charAt(k)){
				maxLen = Math.max(k - i, maxLen);
				i = j + 1; // if k char change, and j was following k, then it means the string is ending 
				           // we need to change the value of i to the new start of a string.
				
			}
			j = k - 1; // when eeee, k keep increasing, and j will lag behind, but as soon as k change, 
			           //j will jump up next to k, i.e. k-1.  
		}
		return Math.max(s.length() - i, maxLen);
	}
	// range of elements are [0, 99] inclusive
	//[0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]
	public static List<String> missingRanges(int[] intList){
		List<String> rangeList = new ArrayList<>();
		if (intList.length == 0) {rangeList.add("0 -> 99"); return rangeList;}
		if (intList.length == 100) {
			return rangeList;
		}
		if (intList[0] > 0) {rangeList.add(rangeStr(0, intList[0]));}
		int start, end;
		for (int i = 0; i < intList.length - 1; i++){
			if (intList[i] + 1 == intList[i + 1]) continue;
			start = intList[i] + 1;
			end = intList[i+1] - 1;
			rangeList.add(rangeStr(start, end));
		}
		if (intList[intList.length -1] < 99) {rangeList.add(rangeStr(intList[intList.length -1] + 1, 99));}
		return rangeList;
		/*
		 * if the first element is 0, 
		 * then we need to check the second element see if it is 1 
		 * and next if next one is 2, i.e., if next element is num[i] + 1== num[i+1]
		 * until it voilate this relationship, then we should take num[i] + 1 as a start 
		 * and num[i]-1 as an end of the range to generate a string and add the string to
		 * the ArrayList
		 * then we should repeat the check with num[i+1] to its next element, until the last one;
		 * then check num[n-1] if smaller than 99. if it is we will get a range (num[n-1]+1, 99)
		 */
		
		
	}
	public static String rangeStr(int from, int to){
		return (from == to) ? String.valueOf(from) : from + " -> " + to;
	}
	
	
	public static String findLongestPalindrome(String s){
		int len1 = 0, len2 = 0, Len = 0;
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++){
			len1 = expandPalindrome(s, i, i);
			len2 = expandPalindrome(s, i, i + 1);
			Len = Math.max(len1, len2);
			if (Len > end - start){
				start = i - (Len - 1) / 2;
				end = i + Len / 2;
			}
		}
		return s.substring(start, end + 1);
	}
	
	public static int expandPalindrome(String s, int left, int right){
		while( left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
			left--;
			right++;
		}
		return right - left - 1;
	}
	
	
	public static boolean isOneEditDistance(String s, String t){
		int m = s.length(), n = t.length();
		if (m > n) return isOneEditDistance(t, s);
		if (n - m > 1) return false;
		int i = 0, shift = n - m;
		while (i < m && s.charAt(i) == t.charAt(i)) i++;
		if (i == m) return shift > 0;
		if (shift == 0) i++;
		while (i < m && s.charAt(i) == t.charAt(i + shift)) i++;
		return i == m;
	}
	
	
	public static int reverseInt(int num){
		
		/*
		 * divide the num by 10 if it is larger than 1 then
		 * we should continue
		 */
		int result = 0;
		while (num != 0){
			if (Math.abs(result) > 214748364){
				return 0;
			}
			result = result * 10 + num % 10; 
			num /= 10;
		}
		return result;
	}
	
	public static void plusOne(List<Integer> digits){
		int n = digits.size();
		for (int i = n - 1; i >= 0; i--){
			int digit = digits.get(i);
			System.out.println("digit is " + digit);
			if (digit < 9){
				digits.set(i, digit + 1);
				return;
			}
			else if (digit == 9){
				digits.set(i, 0);
			}
		}
		
		digits.add(0, 1);
		//digits.set(0, 1);
		
	}
	
	public static boolean isPalindrome(int x){
		if (x < 0) return false;
		int div = 1;
		while (x / div >= 10){
			div *= 10;
			System.out.println(div);
		}
		while (x != 0){
			int l = x / div;
			int r = x % 10;
			if (l != r) return false;
			x = (x - l * div - r) / 10;
			div /= 100;
		}
		return true;
	}
	
	
	public static void practiceJava(){
		// list practice
		List<Integer> myIntegerList = new ArrayList<>();
		myIntegerList.add(1);
		myIntegerList.add(2);
		myIntegerList.set(0, 10);
		myIntegerList.set(0, 20);
		//myIntegerList.remove(0);
		myIntegerList.addAll(myIntegerList);
		System.out.println(myIntegerList.isEmpty());
		System.out.println(myIntegerList.get(0));
		System.out.println(myIntegerList.get(1));
		System.out.println(myIntegerList.get(2));
		System.out.println(myIntegerList.get(3));
		for (int i = 0; i < myIntegerList.size(); i++){
			System.out.println(myIntegerList.get(i));
			
		}
		
		List<Integer> my2ndNumbList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		for (int i = 0; i < my2ndNumbList.size(); i++){
			System.out.println(my2ndNumbList.get(i));
		}
		
		
		Set<String> myStringSet = new HashSet<>();
		myStringSet.add("double");
		myStringSet.add("quote");
		myStringSet.add("is");
		myStringSet.add("string");
		myStringSet.remove("is");
		
		for (String s : myStringSet){
			if (myStringSet.contains(s)) continue;
			System.out.println(s);
		}
		
		
		
		
		//set practice
		//map practice
		//interface practice
		//queue practice
		// stack practice
		// array[][] practice
		// class practice
		
		
	}
	
	
	
	public static void houseColoring(){
		int[][] priceList =
			{{7, 5, 10},
			 {3, 6, 1},
			 {8, 7, 4},
			 {6, 2, 9},
			 {1, 4, 7},
			 {2, 3, 6}};
		int finalCost = finalprice(priceList);
		System.out.println("the minimum final cost is " + finalCost);
		maxSubSequence();
		
	}
	public static int finalprice(int[][] M){
		int finalCost = 0;
		int r = M.length;
		int c = M[0].length;
		int[][] C = new int[r+1][c];
		for (int i = 0; i < c; i++){
			C[0][i] = 0;
		}
		for (int i = 1; i < r + 1; i++){
			C[i][0] = Math.min(C[i-1][1], C[i-1][2]) + M[i-1][0];
			C[i][1] = Math.min(C[i-1][0], C[i-1][2]) + M[i-1][1];
			C[i][2] = Math.min(C[i-1][0], C[i-1][1]) + M[i-1][2];	
		}
		finalCost = Math.min(Math.min(C[r][0], C[r][1]), C[r][2]);
		
		System.out.println(r);
		System.out.println(c);
		return finalCost;
		
	}
	
	
	
	public static void maxSubSequence(){
		int[] A = {-2, 11, -4, 13, -5, 2};
		int[] B = {-15, 29, -36, 3, -22, 11, 19, -5};
		maxContiguousSum(A);
		maxContiguousSum(B);
	}
	public static void maxContiguousSum(int[] A){
		int j = 0;
		int start = 0, finish = 0, maxSum = 0;
		int runningSum = A[0];
		for (int i = 1; i < A.length; i++){
			if (runningSum > 0){
				runningSum += A[i];
			} else{
				runningSum = A[i];
				j = i;
			}
			if (runningSum > maxSum){
				maxSum = runningSum;
				start = j;
				finish = i;
			}
		}
		System.out.println("Max Sum: " + maxSum);
		System.out.println("Indices: i = " + start + ": j = " + finish);
	}
	
	public static void KnapSackUnbounded(){
		int[] W = {6, 3, 4, 2};
		int[] V = {30, 14, 16, 9};
		int M = 10;
		int optimalValue = unboundedKnapSack(W, V, M);
	}
	public static int unboundedKnapSack(int[] W, int[] V, int M){
		int wLen = W.length;
		int [] K = new int[M+1];
		K[0] = 0;
		int best = 0;
		for (int w=1; w <= M; w++){
			for (int i=0; i < wLen; i++){
				if (w > W[i]){
					best = Math.max(K[w-W[i]] + V[i], best);
				}
				K[w] = best;
			}		
		System.out.println("printing knapsack");	
			
		}
		return best;
	}
	

	public static List<TreeNode> generateTrees(int n) {
	        
	        return genTrees(1,n);
	}
	        
	public static List<TreeNode> genTrees (int start, int end){

	        List<TreeNode> list = new ArrayList<TreeNode>();
	        System.out.println("----");
	        System.out.println(start);
	        System.out.println(end);

	        

	        if(start>end)
	        {
	            list.add(null);
	            return list;
	        }
	        
	        if(start == end){
	            list.add(new TreeNode(start));
	            return list;
	        }
	        
	        List<TreeNode> left,right;
	        for(int i=start;i<=end;i++)
	        {
	            
	            left = genTrees(start, i-1);
	            System.out.println(left);
	            right = genTrees(i+1,end);
	            
	            for(TreeNode lnode: left)
	            {
	                for(TreeNode rnode: right)
	                {
	                    TreeNode root = new TreeNode(i);
	                    root.left = lnode;
	                    root.right = rnode;
	                    list.add(root);
	                }
	            }
	                
	        }
	        
	        return list;
	    }

	
	
	
	
	//public boolean isValidBST()
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello World!");
		TreeNode tn = new TreeNode(10);
		System.out.println(tn.val);
		System.out.println("complete!");
		int[] arr = {1, 5, 6, 10, 8, 9, 15};
		int[] result =  BinarySearchTreeSolution.twoSum(arr, 13);
		System.out.println(result[0]);
		System.out.println(result[1]);
		
		
		TreeNode root;
		root = buildBTree();
		int maxD = getMaxDepthBTree(root);
		int maxD2nd = MaxDepth(root);
		int minD = MinDepth(root);
		System.out.println("maximum depth of the btree is: ");
		System.out.println(maxD);
		System.out.println(maxD2nd);
		System.out.println(minD);
		System.out.println("string match:");
		System.out.println(strStr());
		
		System.out.println("test merging two linked lists:");
		testMerge2SortedLinkedLists();
		
		System.out.println("Test reverse string:");
		char mystring[] = "i am coming hello world".toCharArray();
		reverseStr(mystring, 0, mystring.length - 1);
		System.out.println(mystring);
		
		System.out.println(" ----- 2nd:");
		inverseStr(mystring);
		System.out.println(mystring);
		System.out.println(reverseStr2("i am coming hello world"));
		
		String s = "   -129939";
		System.out.println(s + " is " + convertStr2Num(s));
		
		String ss = "A man, , a, i plan, a canal: Panama";
		System.out.println("the sentence is a palindrome: " + isParlindrome(ss));

		System.out.println("is Numeric?  : " + isNumeric("    -1.03321"));
		
		String sss = "aaaabcdeeeeefghijk";
		System.out.println("longest nonrepeated substring is : " + lengthMaxNonrepeatSubStr(sss));
		
		
		System.out.println(rangeStr(10, 10));
		
		int[] arr2 = new int[]{0, 1, 2, 3, 5, 6, 99};
		List<String> ranges = missingRanges(arr2);
		System.out.println(ranges);
		
		System.out.println(findLongestPalindrome("abccbaadda"));
		
		System.out.println(reverseInt(123));
		System.out.println(2^4);
		
		List<Integer> arr3 = new ArrayList<Integer>(Arrays.asList(8, 9, 9));
		plusOne(arr3);
		System.out.println(arr3);
		
		
		System.out.println("is it palindrome : " + isPalindrome(32123));
		
		testAddTwoLinkListNumbers();
		
		System.out.println("scope of variables test: ");
		{
			int x = 5;
			for (int i = 0; i < 10; i++)
			{
				int y = 10;
				System.out.println(x);
			}
		}
		
		System.out.println("test random linked list deep copy:");
		testDeepCopyRandomLinkedList();
		
		System.out.println("test binary tree traversal type:");
		testTraversalType();
		
		System.out.println("test Queue, LinkedList if it is FIFO:");
		testQueueOfLinkedListFIFO();
		
		System.out.println("balanced:");
		testIsBalanced();
		
		
		System.out.println("sorted linked list to binary search tree");
		testSortedListToBST();
		
		testRotateBTUpsideDown();
		
		testFindSingleNumber();
		
		System.out.println(5^6^3);
		System.out.println(5^6^5^5^5^6^5);
		
		testXOROperator();
		
		testSpiralMatrix();
		testNumeral2Roman();
		
		testBuildDirectedGraph();
		
		testTraverseDirectedGraph();
		
		testCroneUndirectedGraph();
		testMinStack();
		
		testEvalReversedPolish();
		testClimbStairs();
		
		testUniquePaths();
		testMaxSubArray();
		
		testStringSplit();
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		
		practiceJava();
		
		System.out.println(reverseStr2("  i am coming hello    world  !"));
		
		houseColoring();
		
		List<TreeNode> L = generateTrees(3); 
		System.out.println(L);
		
	}

}
/*
int[] charMap = new int[256];
Arrays.fill(charMap, -1);
String s;
s.length();
continue;
List<String> rangeList = new ArrayList<>();

List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
list.add(index, value);// insert at the index and shift from there to the right.
list.set(index, value);
list.get(index);



lists.isEmpty();
list.size();
Comparator<LinkNode> listComparator = new Comparator<>{
@Override;
public int compare(LinkNode x, LinkNode y){
return x.getVal() - y.getVal();
}

Queue<TreeNode> q = new LinkedList<>();
Queue<LinkNode> queue = new PriorityQueue<>(lists.size(), listComparator);
Integer.MIN_VALUE, Integer.MAX_VALUE

just remmeber using any list, we have to instantiate with an empty one first,
so that it got a pointer.
List<Integer> rightList = new ArrayList<>();
also the template, List, needs to come with a data type, which can't be
int, instead, it should be Integer.

Set<Integer> numset = new HashSet<>();
numset.contains(x)
numset.add(x);
numset.remove(x);
numset.iterator().next();
for (int x : nums)
		
int[][] multi = new int[5][10];
... which is a short hand for something like this:

int[][] multi = new int[5][];
multi[0] = new int[10];
multi[1] = new int[10];
multi[2] = new int[10];
multi[3] = new int[10];
multi[4] = new int[10];
Note that every element will be initialized to the default value for int, 0, so the above are also equivalent to:

int[][] multi = new int[][]{
  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
};

switch (operator){
			case "+": return x + y;
			case "-": return x - y;
			case "*": return x * y;
			default: return x / y;

*
*
*
*/