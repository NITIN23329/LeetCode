//time complexity : O(n), space complexity : O(26)
/*
  approach :
  --> The first thing we know is that for every character, a partition substring must include upto last occurence of a particular character.
  --> Let,"abcadebf". So firstly we know that a partition substring comprises of "abca" (upto last occurence of a). Now we need to see last occurence of all considered character as well.
  --> Why? cuz it will be illegal to consider them in a different partition string. So we will expand our current partition string upto the farthest last occurence of all considered character.
  --> So our current partition substring is "abcadeb". Now we can safely create next partiton cuz the previous partiton contains upto last occurence of each character present in it.
*/
class Solution {
    public List<Integer> partitionLabels(String str) {
        int[] rightMost = new int[26];
        for(int i=0;i<str.length();i++)
            rightMost[str.charAt(i)-'a'] = i;
        int left = 0;
        List<Integer> ans = new ArrayList<>();
        while(left<str.length()){
            int start = left;
            int right = left;
            while(left<str.length() && left<=right){
                right = Math.max(right,rightMost[str.charAt(left)-'a']);
                left++;
            }
            ans.add(right - start +1);
        }
        return ans;
    }
}
