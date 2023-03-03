//Method 1
class Solution {
    public String getHint(String secret, String guess) {
        String ans="";
        int common=0;
        int i;
        int a[]=new int[10];
        int b[]=new int[10];
        for(i=0;i<secret.length();i++)
        {
            int c=secret.charAt(i)-'0';
            a[c]++;
        }
        for(i=0;i<secret.length();i++)
        {
            int c=guess.charAt(i)-'0';
            b[c]++;
        }
        for(i=0;i<10;i++)
        {
            common+=Math.min(a[i],b[i]);
        }
      //  System.out.println(common);
        int y=0;
        for(i=0;i<secret.length();i++)
        {
            if(secret.charAt(i)==guess.charAt(i))
                y++;
        }
        ans=y+"A"+(common-y)+"B";
        return ans;
    }
}
//Optimized method
class Solution {
    public String getHint(String secret, String guess) {
       //Time complexity=O(n+n)~O(n)
        //Space complexity=O(10+2)~O(1)
       int x=0,y=0;
       int a[]=new int[10];
       int i,n=secret.length();
        for(i=0;i<n;i++)
        {
            if(secret.charAt(i)==guess.charAt(i))
                x++;
            a[secret.charAt(i)-'0']++;
        }
        for(i=0;i<n;i++)
        {
            if(a[guess.charAt(i)-'0']>0)
                y++;
            a[guess.charAt(i)-'0']--;
        }
        return x+"A"+(y-x)+"B";
    }   
}
