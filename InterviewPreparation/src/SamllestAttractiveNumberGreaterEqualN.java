public class SamllestAttractiveNumberGreaterEqualN {
    public static void main(String[] args) {
        String num = "25252";
        int k = 2;
        String result = findSmallestAttractiveNumber(num, k);
        System.out.println(result);
    }

    public static String findSmallestAttractiveNumber(String num, int k) {
        long number = Long.parseLong(num);
        while (true) {
            if (isAttractive(Long.toString(number), k)) {
                return Long.toString(number);
            }
            number++;
        }
    }
    private static boolean isAttractive(String num, int k) {
        int n = num.length();
        for (int i = 0; i < n - k; i++) {
            if (num.charAt(i) != num.charAt(i + k)) {
                return false;
            }
        }
        return true;
    }
}
