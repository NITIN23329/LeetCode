// time complexity : O(n), space complexity : O(1)
/*
    approach :
      --> Condition 1 says every letter in s1  < every letter in s2.
      --> This given an idea that we must make a boundary character such that all letters in s1 <= boundary letter and all letters in s2 > boundary letter.
      --> How to find the boundar letter?, it can be any letter from 'a' to 'y'. Why not 'z'?. if it is 'z' then there is no character > boundary letter.
      --> For every boundary letter in 'a' : 'y', find cost of making (all letters <= boundary letter in s1 + cost of making all letters > boundary letter in s2).
      --> Condition 2 is a complementary of condition 1. Swap s1 and s2 to get condition 2 results.
      --> For Condition 3, find cost of making rest letter to max frequent letter for both s1 and s2.
      --> Take the min of all 3 condtions .
*/
class Solution {
    public int minCharacters(String a, String b) {
        int[] freq1 = new int[26];
        for(char c : a.toCharArray())freq1[c-'a']++;
        int[] freq2 = new int[26];
        for(char c : b.toCharArray())freq2[c-'a']++;
        return Math.min(helper(freq1,freq2),helper(freq2,freq1));
    }
    private int helper(int[] freq1,int[] freq2){
        int sum1 = 0,sum2 = 0;
        for(int ele : freq1)sum1 += ele;
        for(int ele : freq2)sum2 += ele;
        int left1=0,left2=0;        //prefix sum 
        int res = (int)2e5;
        int maxFreq1 = 0,maxFreq2 = 0;
        for(int i=0;i<26;i++){
            if(i<25){
                left1+=freq1[i];
                left2+=freq2[i];
                int right1 = sum1 - left1;       // suffix sum
                res = Math.min(res,left2 + right1);   // condition 1 or 2
            }
            maxFreq1 = Math.max(maxFreq1,freq1[i]);
            maxFreq2 = Math.max(maxFreq2,freq2[i]);
        }
        res = Math.min(res,sum1 - maxFreq1 + sum2 - maxFreq2);  // condition 3
        return res;
    }
}
