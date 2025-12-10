public class PowerOf2 {
    public static boolean isPower2(int n){
        return n>0 && (n & (n-1))==0;
    }

    public static void main(String[] args) {
        System.out.println("32 is power of 2: "+isPower2(32));
        System.out.println("128 is power of 2: "+isPower2(128));
        System.out.println("6 is power of 2: "+isPower2(6)); // 110 & 101 = 100 !=0
    }
}
