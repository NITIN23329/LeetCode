// time complexity : O(n), space complexity : O(1)
/*
    approach :
    --> find the least amount of shift we need to do, to convert s[i] to t[i].
    --> if that was done, then add 26 to it(As a shift amount can not be done more than once).
    --> If that was also done add 26*2 to the least shift amount and so on.
    --> Well the question is how to know the # of time we need to add 26.
    --> For this we create a map of size 26. Cuz least shift can be upto 25, when 'a' -> 'z'.
    --> map[i] = j means we added 26 upto j times for a shift by i.
    --> But how to ensure that a particular value of shifting is not used more than once.
    --> This is beacuse a * 26 + i != b * 26 + j for any value of a and b and i!=j and 1<=i,j<=25.
*/
class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if(s.length()!=t.length())return false;
        int[] map = new int[26];
        for(var i=0;i<s.length();i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(c1==c2)continue;
            int shifts  = 0;
            if(c2>c1) shifts = c2-c1;
            else shifts = 'z'- c1 + 1 + c2-'a';
            int totalShifts = 26*map[shifts] + shifts;
            map[shifts]++;
            if(totalShifts>k)return false;
        }
        return true;
    }
}
