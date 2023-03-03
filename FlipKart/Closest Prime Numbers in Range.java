import java.util.*;
import java.io.*;
class Solution {
    public boolean isPrime(int n) {
        if (n <= 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    public int[] closestPrimes(int left, int right) {
        int i;
        List<Integer> list=new ArrayList<>();
        for (i = left; i <= right; i++) {
            if(isPrime(i))
            list.add(i);
        }
        int ans[]=new int[2];
        Arrays.fill(ans,-1);
        if(list.size()<2)
        {
            return ans;
        }
        int dp[][]=new int[list.size()][2];
        i=0;
        while(i<list.size()-1)
        {
            dp[i][0]=list.get(i);
            dp[i][1]=list.get(i+1)-list.get(i);
            i++;
        }
        Arrays.sort(dp,(a,b)->(a[1]==b[1])?a[0]-b[0]:a[1]-b[1]);
        ans[0]=dp[1][0];
        ans[1]=dp[1][0]+dp[1][1];
        return ans;
    }
}
