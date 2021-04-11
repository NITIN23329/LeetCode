// time complexity : O(n) and space complexity : O(1)
/*
    --> first thing to note is that in order to be s1 ==s2, they must have same # of x and same # of y or freq of x and y in both string must be even.
    --> After that, there are 2 type of irregularties, s1[i]=='x' and s2[i]=='y'(let say x_y) or s1[i]=='y' and s2[i]=='x'(let say y_x).
    --> We can observe that 2 x_y irregulatires take only 1 operation to become equal. (Swap 'x' in s1 with 'y' in s2).
    --> Similarly 2 y_x irregulatries take 1 operations to become equal.
    --> But 1 x_y and 1 y_x takes 2 operations to become equal. ( swap 'x' in s1 with 'y' in s2 then they  become 2 x_y irregularties ) 
    --> So we pair 2 x_y with each other and 2 y_x with each other. operations = x_y/2 + y_x/2.
    --> There may be 1 x_y and 1 y_x left or none left. For former case operations = 2 else 0.
*/
class Solution {
    public int minimumSwap(String s1, String s2) {
        int countX = 0;
        int countY = 0;
        for(char c : (s1+s2).toCharArray()){
            countX += c=='x'?1:0;
            countY += c=='y'?1:0;
        }
        if(countX%2==1 || countY%2==1)return -1;
        int x_y = 0;
        int y_x = 0;
        for(int i=0;i<s1.length();i++)
            if(s1.charAt(i)!=s2.charAt(i)){
                if(s1.charAt(i) == 'x')x_y++;
                else y_x++;
            }
        return x_y/2 + x_y%2 + y_x/2 + y_x%2;
    }
}
