import java.util.Arrays;

public class ArrayManipulation {
    public static void main(String[] args) {
        int[] a = {4, 0, 1, -2, 3};
        System.out.println("Input array: "+ Arrays.toString(a));
        System.out.println("Output array: "+Arrays.toString(manipulatedArr(a)));
    }

    static int[] manipulatedArr(int[] arr){ //n-1 + n + n+1
        int[] b = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int val = ((i-1)<0?0:arr[i-1]) + arr[i] + ((i+1)==arr.length?0:arr[i+1]);
            b[i] = val;
        }
        return b;
    }
}
