class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int i,n=nums.length;
        int arr[]=new int[n];
        for(i=0;i<n;i++)
        arr[i]=nums[i];
        Arrays.sort(arr);
        i=0;
        int j=n-1;
        if(n<=1)
        return 0;
        while(i<n && arr[i]==nums[i])
        {
            i++;
        }
        while(j>=0 && arr[j]==nums[j])
        {
            j--;
        }
        //System.out.println(i+" "+j);
        if(j<i)
        return 0;
        return j-i+1;
    }
}
