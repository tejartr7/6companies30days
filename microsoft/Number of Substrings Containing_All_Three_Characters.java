class Solution {
    public int numberOfSubstrings(String s) {
        int count[]=new int[3];
        int i,n=s.length();
        //System.out.println(n);
        int ans=0,l=0;
        int j;
        for(i=0;i<n;i++)
        {
            count[s.charAt(i)-'a']++;
            while(count[0]>0 && count[1]>0 && count[2]>0)
            {
                count[s.charAt(l)-'a']--;
                l++;
            }
            ans+=l;
        }
        return ans;
    }
}
