public class NumberOfWaysToCoverDistanceN {
    public static void main(String[] args) {
        int distance = 4;
        int ways = waysToCoverDistance(distance);
        System.out.println("Number of ways to cover distance " + distance + ": " + ways);
    }

    public static int waysToCoverDistance(int n){
        if(n<0){
            return 0;
        } else if (n==0) {
            return 1;
        }else{
            return waysToCoverDistance(n-1) + waysToCoverDistance(n-2) + waysToCoverDistance(n-3);
        }
    }

    public static int waysToCoverDistance2(int n){
        if(n<0)
            return 0;
        else if(n==0)
            return 1;
        int[] arrDP = new int[n+1];
        arrDP[0] = 1;
        for(int i=1;i<=n;i++){
            arrDP[i] = 0;
            if(i-1>=0) {
                arrDP[i]+=arrDP[i-1];
            }
            if(i-2>=0){
                arrDP[i]+=arrDP[i-2];
            }
            if(i-3>=0){
                arrDP[i]+=arrDP[i-3];
            }
        }
        return arrDP[n];
    }

}

