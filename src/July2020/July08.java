package July2020;

import java.util.*;

public class July08 {

    public static void main(String[] args) {

//        String test = "asfsfdefdf/erefd";
//        String[] arr = test.split("//");
//        System.out.println(Arrays.toString(arr));

//        String[] source = {"/*Test program */", "int main()", "{ ",
//                " // variable declaration ", "int a, b, c;", "/* This is a test",
//                "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
//
//        String[] source2 = {"/*abc*/", "aaa", "b", "//dfsf"};
//        System.out.println(removeComments(source).toString());

        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));

    }

    public static int firstMissingPositive(int[] nums) {


        int length = nums.length;
        int i = 0;
        while (i < nums.length) {

            if(nums[i] > 0 && nums[i] <= length && nums[nums[i]-1] != nums[i]) {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }

        }

        for(int j=0; j<nums.length; j++) {
            if(nums[j] != j+1) {
                return j+1;
            }
        }
        return length+1;
    }

    public static List<String> removeComments(String[] source) {

        List<String> list = new ArrayList<>();

        StringBuffer sb = new StringBuffer();
        for(String str : source) {
            sb.append(str);
            sb.append("\n");
        }

        String longStr = sb.toString();
        sb.delete(0, sb.length());
        int i = 0;
        while (i<longStr.length()) {
            if(longStr.charAt(i) == '/' && i<longStr.length() && longStr.charAt(i+1) == '/') {
                while(i<longStr.length()) {
                    if(longStr.charAt(i) == '\n') {
                        break;
                    }
                    i++;
                }
            } else if(longStr.charAt(i) == '/' && i<longStr.length() && longStr.charAt(i+1) == '*') {
                i = i+2;
                while (i<longStr.length()-1) {
                    if(longStr.charAt(i) == '*' && longStr.charAt(i+1) == '/' ) {
                        i = i+2;
                        break;
                    }
                    i++;
                }
            } else {
                sb.append(longStr.charAt(i));
                i++;
            }
        }

        String[] ans = sb.toString().split("\n");
        for(String str : ans) {
            if(str.length() != 0) {
                list.add(str);
            }
        }
        return list;
    }





    public static String fractionToDecimal(int numerator, int denominator) {

        if(numerator == 0) {
            return "0";
        }

        StringBuffer sb = new StringBuffer();
        if(numerator < 0 ^ denominator < 0) {
            sb.append("-");
        }

        long a = Math.abs(Long.valueOf(numerator));
        long b = Math.abs(Long.valueOf(denominator));
        sb.append(String.valueOf(a/b));
        long c = a % b;
        if(c == 0) {
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();

        while (c != 0) {

            if(map.containsKey(c)) {
                sb.insert(map.get(c), "(");
                sb.append(")");
                break;
            } else {
                map.put(c, sb.length());
                c *= 10;
                sb.append(String.valueOf(c/b));
                c = c%b;
            }
        }
        return sb.toString();
    }
}
