class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int len = nums[0].length(), idx = 0 ;
        Map<Integer, List<String[]>> hm = new HashMap<>();
        
        for(int[] q : queries){
            hm.putIfAbsent(q[1], new ArrayList<>());
        }
        
        for(int k: hm.keySet()){
            List<String[]> al = hm.get(k);
            for(int i=0; i<nums.length; i++){
                String sub = nums[i].substring(len-k);
                al.add(new String[]{sub, String.valueOf(i)});
            }
        }
    
        int[] ans = new int[queries.length];
        for(int[] q : queries){
            List<String[]> al = hm.get(q[1]);
            Collections.sort(al, (a,b) -> (a[0].equals(b[0])) ? Integer.valueOf(a[1]) - Integer.valueOf(b[1]) : a[0].compareTo(b[0]));
            ans[idx++] = Integer.valueOf(al.get(q[0]-1)[1]);
        }
        return ans;
    }
}
