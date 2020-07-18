package May2020;

public class May29 {

    public static void main(String[] args) {

        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.print(removeElement(nums, val));

    }

    public static int removeDuplicates(int[] nums) {

        if(nums.length == 1) {
            return 1;
        }
        int i = 0;
        int j = i + 1;
        while(j < nums.length) {
            if(nums[i] == nums[j]) {
                j++;
            }else {
                nums[i+1] = nums[j];
                j++;
                i++;
            }
        }
        return i+1;
    }


    public static int removeElement(int[] nums, int val) {

        if(nums.length == 1) {
            if(nums[0] == val) {
                return 0;
            }else {
                return 1;
            }
        }
        int i = 0;
        int j = i + 1;
        while(j < nums.length) {
            if(nums[j] == val || j == i) {
                j++;
                continue;
            }else {
                if(nums[i] == val) {
                    nums[i] = nums[j];
                    nums[j] = val;
                    i++;
                    j++;
                }else {
                    i++;
                }
            }
        }
        return i;

    }
}
