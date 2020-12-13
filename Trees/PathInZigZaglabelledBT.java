//time :O(N) , space O(N)
/*
approach 1 : 
  -> create the zig zag tree upto given label using 2 stacks.
  ->traverse and find all ancestors of given label
*/
class TreeNode{
    int data;
    TreeNode left,right;
    public TreeNode(int data){
        this.data=data;
    }
}
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        Deque<TreeNode> s1 = new ArrayDeque<>();
        Deque<TreeNode> s2 = new ArrayDeque<>();
        TreeNode root=new TreeNode(1);
        s1.push(root);
        int c = 2;
        boolean isLess = true;
        while((!s1.isEmpty() || !s2.isEmpty()) && isLess) {
                while(!s1.isEmpty()){
                    TreeNode x = s1.pop();
                    TreeNode l = new TreeNode(c++);
                    TreeNode r=  new TreeNode(c++);
                    x.right =l;x.left=r;
                    s2.push(l);s2.push(r);
                    if(c>label){
                        isLess = false;
                        break;
                    }
                }
            if(!isLess)break;
            while(!s2.isEmpty()){
                    TreeNode x = s2.pop();
                    TreeNode l = new TreeNode(c++);
                    TreeNode r=  new TreeNode(c++);
                    x.left =l;x.right=r;
                    s1.push(l);s1.push(r);
                    if(c>label){
                        isLess = false;
                        break;
                    }
            }
            
        }
        LinkedList<Integer> ans = new LinkedList<>();
        form(root,ans,label);
        return ans;
    }
    private boolean form( TreeNode root,LinkedList<Integer> ans,int label){
        if(root==null)return false;
        if(root.data==label){
            ans.addFirst(root.data);
            return true;
        }
        
        boolean l = form(root.left,ans,label);
        if(l){
            ans.addFirst(root.data);
            return l;
        }
        boolean r = form(root.right,ans,label);
        if(r){
            ans.addFirst(root.data);
            return r;
        }
        return false;
    }
}
// time : O(N)  , space O(N) 
// approach 2 : 
  ->Instead to creating Tree , what we can do it to store level order of the zig zag tree in a list.
  -> for any index i , (i-1)/2 th index is the index of its parent
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        boolean isSmall = true;
        for(int i=2;i<=label;i++){
            if(i%2==0){
                for(int j=(int)Math.pow(2,i)-1;j>Math.pow(2,i-1)-1;j--){
                     list.add(j);
                     if(j==label){
                        isSmall=false;
                        break;
                    }
                }
            }
            else{
                for(int j=(int)Math.pow(2,i-1);j<Math.pow(2,i);j++){
                    list.add(j);
                    if(j==label){
                        isSmall=false;
                        break;
                    }
                    
                }
            }
            if(!isSmall)break;
        }
        LinkedList<Integer> ans = new LinkedList<>();
        ans.add(label);
         int zz=list.size()-1;
        while(zz>0){
            ans.addFirst(list.get((zz-1)/2));
            zz=(zz-1)/2;
        }
        return ans;
    }
}
//time O(logn) , space O(logn)
// approach 3 :
/*
  ->Now instead of storing the whole tree, we can initially store all the ancestors of label(like for a normal tree) without thinking zig zag tree.
  ->Now we need to change those values in the list which need to be reversed due to zig zag tree.(every alternative ancestor)
  -> upon observation we can see that the new value is the mirror image of the origional value.
  -> like we can find the diff btw origional value and the nearest greater power of 2 ,  
  -> so the new value will be the nearest smallest power of 2 + the calculated diff.
  -> one thing to keep in mind that we need to change either even indexed ancestor or odd indexed ancestors
  -> we can find this with the help of # of ancestors of label.
  -> if the # of ancestors(same as list size) is odd then we change odd indexed ancestors else change even indexed ancestors.
*/
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> list =new LinkedList<>();
        while(label>0){
            list.addFirst(label);
            label/=2;
        }
        ArrayList<Integer> ans = new ArrayList(list);
        int s = 0;
        if(ans.size()%2==1)s=1;
        for(int i=s;i<ans.size()-1;i+=2){
            int add = (int)Math.pow(2,i+1)-1-ans.get(i);
            ans.set(i,(int)Math.pow(2,i)+add);
        }
        return ans;
    }
}
