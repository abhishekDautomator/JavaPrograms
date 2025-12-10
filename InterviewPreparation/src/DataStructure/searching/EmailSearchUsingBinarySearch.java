package DataStructure.searching;

public class EmailSearchUsingBinarySearch {

    public static boolean searchEmail(String[] emails, String targetEmail){
        int l = 0;
        int r = emails.length;

        while(l<=r){
            int mid = l + (r-l)/2;
            int result = emails[mid].compareTo(targetEmail);
            if(result==0){
                return true;
            }else if(result > 0){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return false;
    }

    public static boolean searchEmailUsingRecursion(String[] emails, int l, int r, String targetEmail){
        if(l>r) return false;
        int mid = l+ (r-l)/2;
        int result = emails[mid].compareTo(targetEmail);
        if(result==0){
            return true;
        }else if(result > 0){
            return searchEmailUsingRecursion(emails, l, mid-1, targetEmail);
        }else{
            return searchEmailUsingRecursion(emails, mid+1, r, targetEmail);
        }
    }

    public static void main(String[] args) {
        String[] emails = {"abhi@gmail.com", "abhishek.narayan@gmail.com", "anupriya06@gmail.com", "narutonarayan@gmail.com"};
        String targetEmail = "abhi@gmail.com";
        if(searchEmail(emails, targetEmail)){
            System.out.print("Email found");
        }else{
            System.out.print("Email not found");
        }
        System.out.print(" using while loop and binary search logic");
        System.out.println();
        if(searchEmailUsingRecursion(emails, 0, emails.length-1, targetEmail)){
            System.out.print("Email found");
        }else{
            System.out.println("Email not found");
        }
        System.out.print(" using recursion and binary search logic");
    }
}
