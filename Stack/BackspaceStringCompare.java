// time : O(n) and space complexity : O(1)
/*
  --> since '#' will remove some previous character, we can traverse from end to start of the string and compare them.
  --> We gonna need 2 pointer which will points to a valid index in 1st string and other one will point to a valid index in 2nd string for comparision.
  --> If str1[i] != str2[j] or one string becomes empty while other not, then both strings will not be equal.
  --> if we compared all valid indeces in both string and all of them are equal we return true.
*/
class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] str1  = s.toCharArray();
        char[] str2 = t.toCharArray();
        int i = str1.length-1;
        int j = str2.length-1;
        while(i>=0 || j>=0){
            i = moveBack(str1,i);   // move back the 1st pointer to a vaid character 
            j = moveBack(str2,j);   // move back the 2nd pointer to a vaid character 
            if(i>=0 && j>=0 && str1[i]!=str2[j])return false; // both valid character are different, return false.
            if(i<0 && j>=0 || j<0 && i>=0)break;  // one of them become empty while other not, then return false,
            i--;j--;
        }
        return i==j;    // both of them should be -1 to become them equal
    }
    private int moveBack(char[] str,int ind){
        int skip = 0;
        while(ind>=0){
                if(str[ind] =='#')skip++;
                else if(skip>0)skip--;
                else break;
                ind--;
        }
        return ind;
    }
}
