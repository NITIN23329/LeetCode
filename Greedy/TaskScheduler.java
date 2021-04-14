// time complexity : O(n * 26log26) = O(n) Space complexity : O(26) = O(1), n = tasks.length.
/*
  --> approach is to schedule most frequent character before less frequent character
  --> Put character's frequency in a max heap and simply simulate the work.
  --> During one iteration we take our maximum frequent elment and try to put next n distinct elements. If not sufficient we add idle for remaining.
  --> Then we reduce frequency of each scheduled task by 1 and continue doing it .
*/
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int idleCount = 0;
        int[] freq = new int[26];
        for(var c : tasks)freq[c-'A']++;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(var i = 0;i<26;i++)
            if(freq[i]>0)pq.add(freq[i]);
        while(!pq.isEmpty()){
            int adjCount = n;  
            List<Integer> list = new ArrayList<>();
            list.add(pq.poll());    // taking our maximum frequent element 1st
            if(list.get(0)==1)break;  // we can stop here.
            while(!pq.isEmpty() && adjCount-->0)list.add(pq.poll());
            idleCount += Math.max(0,adjCount);    // if pq.size()<n, then remaining slots will be added by idle.
            for(int ele : list){
                ele--;
                if(ele>0)pq.add(ele);
            }
        }
        return idleCount + tasks.length;
    }
}
// efficient solution with time comlexity : O(n) and space complexity : O(1)
/*
    approach : Since we dont need the actual order in which tasks will be performed, we can do better.
    --> Notice that we will first seprate the most frequent task such that there should be exactly n task slots in btw each consecutive seprated task.
    --> Cuz maximum frequent task is the only one who determine the idleCount and every other task will fall in btw them.
    --> The total # of tasks required in btw of maximum frequent task  = (n) * (freq of max frequent tasks - 1) # last task dont require any idle after it.
    --> Now we need to find how many other tasks can be filled in btw.
    --> Note that each distint task will be placed in btw 2 most frequent task exaclty once.
    --> # of slots available = (freq of max frequent tasks - 1).
    --> All other tasks have freq <= freq of max frequent tasks. If other task freq == max freq, then we can only use (other task freq - 1) other tasks to fill slots as each slot cant have same task more than 1.
    --> We find the total count of all other tasks except the maximum freqnent task to fill these gap slots.
    --> then idleCount = taskReqdInBtw - availableTaskInBtw.
    
*/
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        for(var c : tasks){
            freq[c-'A']++;
            maxFreq = Math.max(maxFreq,freq[c-'A']);
        }
        int taskReqdInBtw = (maxFreq-1)*n;
        int availableTaskInBtw = 0;
        for(var i=0;i<26;i++){
            if(freq[i]==maxFreq)freq[i]--;
            availableTaskInBtw += freq[i];
        }
        availableTaskInBtw -= (maxFreq-1);  // take out the maximum frequent task
        int idleCount = Math.max(0,taskReqdInBtw - availableTaskInBtw);
        return idleCount + tasks.length;
    }
}
