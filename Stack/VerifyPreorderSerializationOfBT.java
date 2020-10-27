/*approach 1: time complexity O(n) , space complexity O(n)
*every time i insert a new value in stack , i will increment no. of child of
*of its parent. if no. of child of any element in stack ==2 ,then it means we discovered
* all children of top element and we can safely pop it from stack */
class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] str = preorder.split(",");
        /*will store first element as actual value of element, 2nd element is the no.
        *child found so far .*/
        Deque<Integer[]> dq = new ArrayDeque<>();
        //corner case "#" is a valid preorder 
        if(str[0].equals("#")) return str.length==1;
        for(int i=0;i<str.length;i++){
            String ele = str[i];
            if(ele.equals("#")){
                if(dq.isEmpty())return false;
                dq.peek()[1]++;
                if(dq.peek()[1]==2)dq.pop();
            }
            else{
                int x = Integer.parseInt(ele);
                if(!dq.isEmpty()){
                     dq.peek()[1]++;
                    if(dq.peek()[1]==2)dq.pop();
                }
                   
                dq.push(new Integer[]{x,0});
                
            }
            //if the stack becomes empty before processing of final element , then it
            //will be a disconnected tree , then return false;
            if(i!=str.length-1 && dq.isEmpty())return false;
            
        }
        return dq.isEmpty();
    }
}

//optimization fo above approach: as we don't need the values of node , so no need to to Integer.parseInt() ..Store only the no. of child of each node in stack
*every time i try to insert a new value in stack , i will increment no. of child of
*of its parent. if no. of child of any element in stack ==2 ,then it means we discovered
* all children of top element and we can safely pop it from stack */
class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] str = preorder.split(",");
        /*will store the no. child found so far for a node.*/
        Deque<Integer> dq = new ArrayDeque<>();
        //corner case "#" is a valid preorder 
        if(str[0].equals("#")) return str.length==1;
        for(int i=0;i<str.length;i++){
            String ele = str[i];
            if(ele.equals("#")){
                if(dq.isEmpty())return false;
                 int x = dq.pop()+1;
                if(x!=2)dq.push(x); //x==2 means top node has 2 children which are discovered
            }
            else{
                if(!dq.isEmpty()){
                    int x = dq.pop()+1;
                    if(x!=2)dq.push(x);
                }
                dq.push(0);
            }
            //if the stack becomes empty before processing of final element , then it
            //will be a disconnected tree , then return false;
            if(i!=str.length-1 && dq.isEmpty())return false;
            
        }
        return dq.isEmpty();
    }
}
