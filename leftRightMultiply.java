import java.util.*;

public class leftRightMultiply {

	public static void main(String[] args) {

		int[] a = {1,2,3,4,5};
		System.out.println(leftRightMultiply(a,4));
	}
	
	public static int leftRightMultiply(int[] a, int n) {

		int[] leftMultiply = new int[a.length];
		int[] rightMultiply = new int[a.length];

		leftMultiply[0] = a[0];
		for (int i = 1; i < a.length; i++) {
			leftMultiply[i] = leftMultiply[i-1]*a[i];
		}
		
		rightMultiply[rightMultiply.length-1] = a[a.length-1];
		for (int i = a.length-2; i >= 0; i--) {
			rightMultiply[i] = rightMultiply[i+1]*a[i];
		}

		if (n == 0) return rightMultiply[1];
		else if (n == a.length-1) return leftMultiply[leftMultiply.length-2];
		else return leftMultiply[n-1]*rightMultiply[n+1];
	}
}