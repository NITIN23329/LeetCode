// approach 1 : maintain a hashmap to keep freq of all distinct value nodes , find all  maximum occured node
// time o(n) , space O(n).                                                                                 
class Solution {
    private Map<Integer,Integer> map;
    int maxf;
    public int[] findMode(TreeNode root) {
        map = new HashMap<>();
        maxf=0;
        freq(root);
        ArrayList<Integer> list = new ArrayList<>();
        for(int ele : map.keySet())
            if(map.get(ele)==maxf)
                list.add(ele);
        int[] arr = new int[list.size()];
        for(int i=0;i<list.size();i++)
            arr[i] = list.get(i);
        return arr;
            
    }
    private void freq(TreeNode root){
        if(root==null)return;
        if(!map.containsKey(root.val))map.put(root.val , 0);
        map.put(root.val, map.get(root.val)+1);
        maxf = Math.max(maxf,map.get(root.val));
        freq(root.left);
        freq(root.right);
    }
}
// efficient approach: Time O(n) and auxilarry space O(1)
/*
    --> If we do an inorder traversal, then we are gonna see the same values consecutively and we can easily decide the curr node is a mode or not.
    --> We find the current frequency and if this frequency is greater , we update the mode frequency and add current node value as a mode.
    --> If we find the current frequency = mode frequency, then also we add current node value as a mode.
*/
class Solution {
    List<Integer> list = new ArrayList<>(); // stores the mod element
    int maxFreq = 0;    // the mode freq
    int currFreq = 0;   // freq of current node value
    TreeNode prev = null;   // previously visited node
    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] res = new int[list.size()];
        for(int i=0;i<res.length;i++)
            res[i] = list.get(i);
        return res;
    }
    public void inOrder(TreeNode root){
        if(root == null)return;
        inOrder(root.left);
        if(prev == null){   // visiting a node for 1st time
            list.add(root.val);
            currFreq = 1;
            maxFreq = 1;
        }
        else{
            if(prev.val == root.val)currFreq++; // previous node is same as curr node
            else currFreq = 1;
            if(currFreq>maxFreq){
                maxFreq = currFreq;
                list.clear();
                list.add(root.val);
            }else if(currFreq == maxFreq)list.add(root.val);
        }
        prev = root;
        inOrder(root.right);
    }
}
