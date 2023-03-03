class Solution {
    public long maxMatrixSum(int[][] matrix) {
        
    	int i,j,n=matrix.length,neg_nums=0,m=matrix[0].length,min=Integer.MAX_VALUE;
    	long ans=0;
    	for(i=0;i<n;i++)
    		for(j=0;j<m;j++) {
    			if(matrix[i][j]<0)
    				neg_nums++;
    			min=Math.min(min, Math.abs(matrix[i][j]));
    			ans+=Math.abs(matrix[i][j]);
    		}
    	if(neg_nums%2==0)
    		return ans;
    	return ans-min-min;
    	
    }
}