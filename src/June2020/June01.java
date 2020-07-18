package June2020;

public class June01 {
    public static void main(String[] args) {

//        int[] nums = {3,4,2,3};
//        System.out.print(checkPossibility(nums));

        String a = "1807";
        String b = "7801";
        System.out.print(getHint(a,b));


    }

    public static boolean checkPossibility(int[] nums) {

        if(nums.length < 3) {
            return true;
        }
        int count = 0;
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] > nums[i+1]) {
                count++;
                if(count > 1) {
                    break;
                }
                if(i>0 && nums[i-1] > nums[i+1]) {
                    nums[i+1] = nums[i];
                }
            }
        }
        return count<=1;
    }

    public static String getHint(String secret, String guess) {

        int A = 0;
        int B = 0;
        int[] arrA = new int[10];
        int[] arrB = new int[10];
        for(int i=0; i<secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                A++;
            } else {
                arrA[secret.charAt(i) - '0']++;
                arrB[guess.charAt(i) - '0']++;
            }
        }
        for(int i=0; i<10; i++) {
            B = B + (arrA[i] < arrB[i] ? arrA[i] : arrB[i]);
        }
        String ans = String.valueOf(A) + 'A' + String.valueOf(B) + 'B';
        return ans;
    }
}
