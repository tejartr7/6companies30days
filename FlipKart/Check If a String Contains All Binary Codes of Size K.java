class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> seen=new HashSet<>();
        int i=0,j=0,n=s.length();
        while(j<n)
        {
            while(j-i+1>k)
            {
                i++;
            }
            if(j-i+1==k)
            {
                String temp=s.substring(i,j+1);
                if(!seen.contains(temp))
                {
                    seen.add(temp);
                }
            }
            j++;
        }
        //System.out.println(seen);
        return (1<<k)==seen.size();
    }
}
