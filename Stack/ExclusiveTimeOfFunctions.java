//approach one
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();//will store id of process;
        int curr = 0;//time stamp
        for(int i=0;i< logs.size();i++){
            String ele = logs.get(i);
            String[] str = ele.split(":");
            int id = Integer.parseInt(str[0]);
            int time = Integer.parseInt(str[2]);
            if(str[1].startsWith("s")){
                dq.push(id);
                /*handling start-start  process. so during start of curr and next process, 
                curr process will be executing.*/
                if(i+1!= logs.size()){
                    String[] next=logs.get(i+1).split(":");
                    if(next[1].startsWith("s")){
                        res[id]+=Integer.parseInt(next[2])-curr;
                        //now current time will be start of process id(i+1)
                        curr = Integer.parseInt(next[2]);
                        continue;
                    }
                }
                //if next process is not start process ,curr will be time of curr process
                curr = time;

            }
            else{
                dq.pop();
                res[id]+=time-curr+1;
                //cur will be the end time of curr process
                curr = time+1;
                /*handeling gap between end-start porcess. So during end of curr and 
                start of next process, the top process in stack will be executed*/
                if(i+1!= logs.size() ){
                    String[] next=logs.get(i+1).split(":");
                    if(next[1].startsWith("s") && !dq.isEmpty()){
                        res[dq.peek()]+=Integer.parseInt(next[2])-curr;
                        // now curr time will be the start fo next process
                        curr = Integer.parseInt(next[2]);
                    }
                }
            }
        }
        return res;
    }
}
