package July2020;

public class July07 {
    public static void main(String[] args) {

        int[] nums = {2,7,9,3,1,3,5,7,8,9,4,32};
        System.out.println(rob2(nums));
    }

    public static int rob2(int[] nums) {

        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[1];
        }
        int[] sum = new int[nums.length + 1];
        sum[1] = nums[0];
        for(int i=1; i<nums.length; i++) {
            sum[i+1] = sum[i] > sum[i-1] + nums[i] ? sum[i] : sum[i-1] + nums[i];
        }
        return sum[nums.length];
    }




    public static int rob(int[] nums) {

        return robCore(nums, 0,0);
    }

    public static int robCore(int[] nums, int start, int sum) {

        if(start == nums.length-1) {
            return sum + nums[start];
        } else if(start > nums.length-1) {
            return sum;
        } else {
            return nums[start] + robCore(nums, start+2, sum) > robCore(nums, start+1, sum) ?
                    nums[start] + robCore(nums, start+2, sum) : robCore(nums, start+1, sum);
        }
    }
}
