class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        int distance = Math.abs(endPos - startPos);
        int[][] d_k = new int[1001][k + 1]; 
        for (int[] kArr : d_k) {
            Arrays.fill(kArr, -1);
        }
        return numberOfWays(distance, k, d_k);
    }

    private int numberOfWays(int d, int k, int[][] d_k) {
        if (d > k) return 0;
        if (d == k) return 1;
        if (d_k[d][k] != -1) return d_k[d][k];
        d_k[d][k] = (numberOfWays(d + 1, k - 1, d_k) + numberOfWays(Math.abs(d - 1), k - 1, d_k)) % 1_000_000_007;
        return d_k[d][k];
    }
}