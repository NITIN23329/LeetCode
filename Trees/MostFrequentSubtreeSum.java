//time O(N) space O(N)
/*approach :
  --> recursively find left subtree sun,right subtree sum
  --> add root node to get sum of current tree
  --> store frequency of each sum in a map
  --> find sum with maximum freq
*/
class Solution {
    int count;
    int maxFreq;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> freq = new HashMap<>();
        count=0;maxFreq=0;
        findSum(root,freq);
        int[] arr = new int[count];
        int z=0;
        for(int ele : freq.keySet()){
            if(freq.get(ele)==maxFreq)arr[z++]=ele;
        }
        return arr;
        
    }
    private int findSum(TreeNode root,Map<Integer,Integer> map){
        if(root==null)return 0;
        int l = findSum(root.left,map);
        int r = findSum(root.right,map);
        int sum = l+r+root.val;
        if(!map.containsKey(sum))map.put(sum,0);
        map.put(sum,map.get(sum)+1);
        if(map.get(sum)>maxFreq){
            maxFreq =map.get(sum);
            count=1;
        }
        else if(map.get(sum)==maxFreq){
            count++;
        }
        return sum;
    }
}
