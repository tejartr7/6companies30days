class Solution {
    public int maxSum(int[][] grid) {
        
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i=0;i<m-2;i++){
            res = 0;
            for (int j=0;j<n-2;j++){
                
                                                      
                res = grid[i][j] + grid[i][j+1] + grid[i][j+2];             //  upper part
                res += grid[i+1][j+1];                                      // mid part
                res += grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2];      // lower part
                
                if (res > max) max = res;
            }
            
        }
       
        return max;
    }
}