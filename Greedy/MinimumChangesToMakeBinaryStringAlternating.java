// time complexity O(n) and space complexity : O(1)
/*
  --> We can either choose 1 out of 2 possibilities to make string alternating.
  --> 1) put 0 at even indeces and 1 at odd indeces.
  --> 2) put 1 at even indeces and 0 at odd indeces.
  --> We choose that whose cost of changing is minimum.
*/
class Solution {
    public int minOperations(String s) {
        int zeroAtEven = 0;
        int oneAtOdd = 0;
        int oneAtEven = 0;
        int zeroAtOdd = 0;
        for(int i=0;i<s.length();i++){
            if(i%2==0){
                if(s.charAt(i)=='0')zeroAtEven++;
                else oneAtEven++;
            }
            else {
                if(s.charAt(i)=='1')oneAtOdd++;
                else zeroAtOdd++;
            }
        }
        int c1 = oneAtEven + zeroAtOdd;
        int c2 = zeroAtEven + oneAtOdd;
        return Math.min(c1,c2);
    }
}
