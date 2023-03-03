class Solution {
    int count = 0;
    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        dfs(s, 0, set);
        return count;
    }
    public void dfs(String s, int idx, Set<String> set) {
        if (idx == s.length()) {
            count = Math.max(count, set.size());
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            String sub = s.substring(idx,i+1);
            if (!set.contains(sub)) {
                set.add(sub);
                dfs(s, i+1, set);
                set.remove(sub);
            }
        }
    }
}