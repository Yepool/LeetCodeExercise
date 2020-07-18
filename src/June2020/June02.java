package June2020;



public class June02 {

    public static void main(String[] args) {


        String IP = "20EE:FGb8:85a3:0:0:8A2E:0370:7334";

        System.out.print(validIPAddress(IP));

    }

    public static String validIPAddress(String IP) {

        if(isIPv4(IP)) {
            return "IPv4";
        }else if(isIPv6(IP)) {
            return "IPv6";
        }else {
            return "Neither";
        }
    }

    public static boolean isIPv4(String IP) {

        String[] arr = IP.split("\\.", -1);
        if(arr.length != 4) {
            return false;
        }
        for(String x : arr) {
            if(x.length() == 0 || x.length() > 3) {
                return false;
            }
            if(x.charAt(0) == '0' && x.length() != 1){
                return false;
            }
            for(char ch : x.toCharArray()) {
                if(!Character.isDigit(ch)) {
                    return false;
                }
            }
            if(Integer.valueOf(x) > 255) {
                return false;
            }
        }
        return true;


    }

    public static boolean isIPv6(String IP) {

        String[] arr = IP.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        if(arr.length != 8) {
            return false;
        }
        for(String x : arr) {
            if(x.length() == 0 || x.length() > 4) {
                return false;
            }
            for(char ch : x.toCharArray()) {
                if(hexdigits.indexOf(ch) == -1) {
                    return false;
                }
            }
        }
        return true;
    }
}
