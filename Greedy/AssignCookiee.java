// time complexity : o(nlogn), space complexity O(1)
// approach : try to give bigger cookie to more greedy child.
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = g.length-1,j = s.length-1;
        int count = 0;
        while(i>=0 && j>=0){
            if(g[i]<=s[j]){
                i--;
                j--;
                count++;
            }
            else i--;
        }
        return count;
    }
}
