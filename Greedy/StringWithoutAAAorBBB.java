// time complexity : O(max(a,b)), space complexity : O(a+b)
/*
approach :
    step 1--> Suppose a != b , this means we need to use 'a' and 'b' with dirrerent rate. That having maximum freq should be added more time.
        --> I used 'aab' for a>=b and 'bba' for b>a. 
   step 2--> suppose a==b, we need to use both characters ar same rate.
      --> if initally a!=b, then we reach step 2 after step 1. last characters may be "aab" or "bba", So I used "ab", we can use "ba" also.
   step 3 --> Suppose (a=0 && b!=0 ) or (a!=0 and b=0). 
      --> if a!=0, we can use 'a' only.
      --> if b!='0' we can use 'b' only.
      --> Fact, if a==0 or b==0, the other one is always <=2.
*/
class Solution {
    public String strWithout3a3b(int a, int b) {
        String diff = a>=b?"aab":"bba"; // when a!=b
        String equal = a>=b?"ab":"ba";  // when a==b
        String only = a>=b? "a":"b";    // when a=0 || b==0.
        int max = Math.max(a,b);
        int min = a + b - max;
        StringBuilder sb = new StringBuilder();
        while(max>0 || min>0){
            if(min==0){
                sb.append(only);
                max--;
            }
            else if(max>min){
                sb.append(diff);
                max-=2;min-=1;
            }
            else {
                sb.append(equal);
                max--;min--;
            }
        }
        return sb.toString();
    }
}
