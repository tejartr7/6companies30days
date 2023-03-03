class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int i,n=barcodes.length;
        Map<Integer,Integer> map=new HashMap<>();
        int max=0,val=0;
        int ans[]=new int[n];
        for(int x:barcodes)
        {
            map.put(x,map.getOrDefault(x,0)+1);
            if(map.get(x)>max)
            {
                max=map.get(x);
                val=x;
            }
        }
        i=0;
        while(map.get(val)>0)
        {
            ans[i]=val;
            map.put(val,map.get(val)-1);
            i=i+2;
        }
        for(int x:map.keySet())
        {
            while(map.get(x)>0)
            {   if(i>=n)
                i=1;
                ans[i]=x;
                i+=2;
                map.put(x,map.get(x)-1);
            }
        }
        return ans;
    }
}
