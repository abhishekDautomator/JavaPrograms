public class ShortArrayOfBits0and1 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1, 0, 1};
        shortBitsArray(arr);

        // Print the sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void shortBitsArray(int[] bits) {
        int left=0;
        for (int i = 0; i < bits.length; i++) {
            if(bits[i]==0){
                int temp = bits[left];
                bits[left] = bits[i];
                bits[i] = temp;
                left++;
            }
        }
    }
}
