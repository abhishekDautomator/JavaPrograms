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
    public static void main(String[] args) {
        String[] emails = {"abhi@gmail.com", "abhishek.narayan@gmail.com", "anupriya06@gmail.com", "narutonarayan@gmail.com"};
        String targetEmail = "abhi@gmail.com";
        if(searchEmail(emails, targetEmail)){
            System.out.println("Email found");
        }else{
            System.out.println("Email not found");
        }
    }
}
