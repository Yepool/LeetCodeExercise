package June2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class June19 {

    public static void main(String[] args) {

//        int[] nums = {2, 3, 3, 1};
//        int target = 6;
//        int[] ans = findNums(nums, target);
//        System.out.print(Arrays.toString(ans));

        System.out.print(climbStairs(10));
    }

    public static int climbStairs(int n) {

        int[] arr = {0,1,2};
        if(n < 3) {
            return arr[n];
        }
        for(int i=3; i<=n; i++) {
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = arr[0] + arr[1];
        }
        return arr[2];
    }

//    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

    public static int[] findNums(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

}
