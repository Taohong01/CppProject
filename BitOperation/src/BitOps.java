import java.util.*;

public class BitOps {
	
	public static void printArray(){
		int[] zeroes = new int[32];
		Arrays.fill(zeroes, 10);
		int[] myOnes = {1,1,1};
		
		for (int x : myOnes){
			System.out.println(x);}
	}
	
	public static void testBitOps(){
		int[] a = {9, 6, 7, 7, 6, 7, 6};
		int[] bits = new int[32];
		//int x = 4;
		//int base = 2;
		for (int bit: bits){
			for (int i = 0; i < a.length; i++){
			    bit += a[i] % 2;
			    a[i] /= 2;
			    //System.out.println(a[i]);
			    }
			bit %= 3;
			System.out.println(bit);
		}
		// note using foreach the variable bit only get 
		// the value not the address of the element in bits
		for (int bit: bits){
			System.out.println(bit);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//printArray();
		//System.out.println(~2);
		testBitOps();
		int a = 3;
		System.out.println(a >> 1);
		System.out.println(a);

	}

}
