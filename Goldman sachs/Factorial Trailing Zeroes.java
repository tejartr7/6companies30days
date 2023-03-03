class Solution {
    public int trailingZeroes(int n) {
     
        if(n==0)
            return 0;
        if(n>1 && n<5)
            return 0;
        int i,count=0;
        for(i=5;i<=n;i=i*5)
        {
            count+=n/i;
        }
        return count;
        
    }
}
