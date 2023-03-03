class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
       int i,max=0;
       int j=0,curr=0,min=Integer.MAX_VALUE,maxi=0;
       Arrays.sort(special);
       for(i=1;i<special.length;i++)
       {
           max=Math.max(max,special[i]-special[i-1]-1);
       }
       max=Math.max(max,special[0]-bottom);
       max=Math.max(max,top-special[special.length-1]);
       return max;
    }
}
