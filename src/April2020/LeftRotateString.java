package April2020;

import java.util.Scanner;
import java.util.Stack;

public class LeftRotateString {
    public static void main(String[] args) {

        LeftRotateString obj = new LeftRotateString();

        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.print(obj.isValid(s));


    }
    public static String reverseLeftWords(String s, int n) {
        String s1;
        String s2;
        s1 = s.substring(0, n);
        s2 = s.substring(n);
        return s2 + s1;
    }

    public int game(int[] guess, int[] answer) {
        int ans = 0, i = 0;
        while (i < 3) {
            if (guess[i] == answer[i]) {
                ans ++;
            }
            i ++;
        }
        return  ans;
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack();
        int length = s.length();
        for(int i=0; i<length; i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{' ){
                stack.push(s.charAt(i));
            } else if(stack.size() == 0) {
                return false;
            } else if(s.charAt(i) == ')' && stack.pop() != '(') {
                return false;
            } else if(s.charAt(i) == ']' && stack.pop() != '[') {
                return false;
            } else if(s.charAt(i) == '}' && stack.pop() != '{') {
                return false;
            }
        }
        if(stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
