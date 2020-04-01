package IntegerSum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.*;

public class IntegerSum {
	public static Set<Integer> cSet = new HashSet<>(Arrays.asList(2, 5, 1, 6, 7));
	public static int t = 7;
	
	public static List<Integer> findC(int t){
		List<Integer> ret = new ArrayList<>();
		if (t < 0) return ret;
		if (cSet.contains(t)) {
			ret.add(t);
		}
		for (Integer c: cSet){
			List<Integer> tmp = findC(t - c);
			if (!tmp.isEmpty()){
				System.out.println(tmp);
				tmp.add(c);
				ret.addAll(tmp);
			}
		}
		return ret;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerSum isum = new IntegerSum();
		List<Integer>c = isum.findC(7);
		System.out.println(c);
	}

}
