package June2020;

import java.util.HashMap;
import java.util.HashSet;

public class June04 {
    public static void main(String[] args) {

        String s = "dcadedcad";
        int maxLetters = 3;
        int minSize = 4;
        int maxSize = 14;

        System.out.print(maxFreq2(s, maxLetters, minSize, maxSize));
    }

    public static int maxFreq2(String s, int maxLetters, int minSize, int maxSize) {

        int n = s.length();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = (int)s.charAt(i) - (int)'a';
        }

        int maxTimes = 0;
        long window = 0;
        int a = 26;
        long aL = 1;
        long modulus = (long)Math.pow(2, 32);
        int[] charArr = new int[26];

        for(int i=0; i<minSize; i++) {
            window = (window * a + arr[i]) % modulus;
            aL = (aL * a) % modulus;
            charArr[arr[i]] ++;
        }

        HashMap<Long, Integer> strMap = new HashMap<>();
        if(validLetters2(charArr, maxLetters)) {
            strMap.put(window, 1);
        }

        for(int i=1; i<n-minSize+1; i++) {

            charArr[arr[i-1]] --;
            charArr[arr[i+minSize-1]] ++;
            if(validLetters2(charArr, maxLetters)){
                window = (window * a - arr[i-1] * aL % modulus + modulus) % modulus;
                window = (window + arr[i+minSize-1]) % modulus;
                if(strMap.containsKey(window)) {
                    strMap.put(window, strMap.get(window) + 1);
                } else {
                    strMap.put(window, 1);
                }
                maxTimes = maxTimes < strMap.get(window) ? strMap.get(window) : maxTimes;
            }
        }
        return maxTimes;
    }

    public static boolean validLetters2(int charArr[], int maxLetters) {

        int sum = 0;
        for(int x : charArr) {
            if(x != 0) {
                sum++;
                if(sum > maxLetters) {
                    return false;
                }
            }
        }
        return true;
    }


    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        int maxTimes = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for(int k=minSize; k<=maxSize; k++) {
            for(int i=0; i<=s.length()-k; i++) {
                String s1 = s.substring(i, i+k);
                if(validLetters(s1, maxLetters)) {
                    if(map.containsKey(s1)) {
                        map.put(s1, map.get(s1) + 1);
                    } else {
                        map.put(s1, 1);
                    }
                    maxTimes = maxTimes < map.get(s1) ? map.get(s1) : maxTimes;
                }
            }
        }
        System.out.print(map);
        return maxTimes;
    }

    public static boolean validLetters(String s, int maxLetters) {

        HashSet<Character> set = new HashSet<>();
        for(char ch : s.toCharArray()) {
            set.add(ch);
            if(set.size() > maxLetters) {
                return false;
            }
        }
        return true;
    }
}
