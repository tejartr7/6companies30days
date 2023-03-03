class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int LeftMax =0,RightMin=0;
        if(left.length!=0){
              LeftMax = left[0];
        }
        if(right.length!=0){
            RightMin = right[0];
        }
       
    // Take max of left Array    
        for(int i=0;i<left.length;i++){
            if(left[i]>LeftMax){
                LeftMax = left[i];
            }
        }
     // Take min of right Array    
        for(int j=0;j<right.length;j++){
             if(right[j]<RightMin){
                RightMin = right[j];
            }
        }
    // For Cases When Any Array is Empty
        if(left.length==0){
              return n-RightMin;
        } 
        if(right.length==0){
            return LeftMax;
        }

       return Math.max(LeftMax,n-RightMin);
    }
}