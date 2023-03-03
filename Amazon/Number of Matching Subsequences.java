class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] indexArr = new List[26];
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (indexArr[c - 'a'] == null)
                indexArr[c - 'a'] = new ArrayList<>();
            indexArr[c - 'a'].add(i);
        }

        for (String word : words){
            boolean isSub = true;
            int prev = 0;
            for (int i = 0; i < word.length(); i++){
                char w1 = word.charAt(i);
                int num = w1 - 'a';
                if (indexArr[w1 - 'a'] == null){
                    isSub = false;
                    break;
                }
                int index = Collections.binarySearch(indexArr[num], prev);
                if (index < 0){
                    index = - index - 1;
                    if (index == indexArr[num].size()){
                        isSub = false;
                        break;
                    }
                }
                prev = indexArr[num].get(index) + 1;
            }
            if (isSub)
                count++;
        }
        return count;
    }
}