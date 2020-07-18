package July2020;

import java.util.ArrayList;
import java.util.Stack;

public class July2020 {

    public static void main(String[] args) {

        int n = 7;
        System.out.println(countAndSay(n));
    }

    public static String countAndSay(int n) {

        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        for(int i=1; i<n; i++) {
            list.add(countAndSayCore(list.get(i-1)));
        }
        return list.get(n-1);
    }

    public static String countAndSayCore(String lastStr) {

        Stack<Character> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();

        int i = 0;
        while(i < lastStr.length()) {
            if(stack.size() == 0 || stack.peek() == lastStr.charAt(i)) {
                stack.push(lastStr.charAt(i));
                i++;
            } else {
                sb.append(stack.size());
                sb.append(stack.peek());
                stack.clear();
            }
        }

        sb.append(stack.size());
        sb.append(stack.peek());
        return sb.toString();
    }
}
