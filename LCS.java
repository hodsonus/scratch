import java.util.*;

public class LCS {
	
	public static void main(String[] args) {

		LCS sut = new LCS();

		String A = "ABCDEFGH";
		String B = "BACEAFFFF";
		int M = A.length()-1;
		int N = B.length()-1;

		System.out.println(sut.LCS(A, B, M, N));
	}

	Map<Key, Integer> map = new HashMap<Key, Integer>();

	public int LCS(String A, String B, int M, int N) {

		if (M == -1 || N == -1) return 0;

		Key key = new Key(M,N);
		if (map.containsKey(key)) return map.get(key);

		int ans;
		if (A.charAt(M) == B.charAt(N))
			ans = 1 + LCS(A,B,M-1,N-1);
		else 
			ans = Math.max(LCS(A,B,M,N-1), LCS(A,B,M-1,N));

		map.put(key, ans);
		return ans;
	}
}