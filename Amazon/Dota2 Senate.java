class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dires = new LinkedList<>();
        
        for(int i = 0; i < senate.length(); i++){
            if(senate.charAt(i) == 'R'){
                radiant.add(i);
            }else{
                dires.add(i);
            }
        }
     
        while(!radiant.isEmpty() && !dires.isEmpty()){
            int iR = radiant.poll();
            int iD = dires.poll();
            if(iR < iD){
                radiant.add(iR + n);      
            }else{
                dires.add(iD + n);
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}