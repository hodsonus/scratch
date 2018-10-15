import java.util.*;

public class Partition {
	
	public static void main(String[] args) {

		Partition sut = new Partition();
		int[] nums = {1, 2, 3, 6};
		int i = nums.length-1;
		int target = 13;

		System.out.println(sut.subsetSum(nums, i, target));
	}

	Map<Key, Boolean> map = new HashMap<Key, Boolean>();
	public boolean subsetSum(int[] nums, int i, int target) {

		if (target == 0) return true;
		if (i < 0) return false;

		Key key = new Key(i, target);
		if (map.containsKey(key)) return map.get(key);

		boolean ans;
		if (nums[i] > target)
			ans = subsetSum(nums, i-1, target);
		else 
			ans = subsetSum(nums, i-1, target-nums[i]) || subsetSum(nums, i-1, target);


		map.put(key, ans);
		return ans;
	}
}