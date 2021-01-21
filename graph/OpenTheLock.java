/*  time complexity O(16 * 9^4). cuz total combinations 9*9*9*9
    approach :  do a bfs
          --> add "0000" to q
          --> for each string in queue.poll() , find 8 possible combinations and add them to queue.
*/
class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> stuck = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for(String ele : deadends)stuck.add(ele);
        if(!stuck.contains("0000")) q.add("0000");
        visited.add("0000");
        int c = 0;
        while(!q.isEmpty()){
            int s = q.size();
            for(int count=0;count<s;count++){
                String str = q.poll();
                if(str.equals(target))return c;
                char[] x = str.toCharArray();
                for(int i=0;i<4;i++){
                    char[] c1 = new char[4];
                    char[] c2 = new char[4];
                    for(int j=0;j<4;j++){
                        c1[j] = x[j];
                        c2[j] = x[j];
                    }
                    if(x[i]=='0')c1[i]='9';
                    else c1[i] = (char)(x[i]-1);
                    if(x[i]=='9')c2[i]='0';
                    else c2[i] = (char)(x[i]+1);
                    String strc1 = ""+c1[0]+c1[1]+c1[2]+c1[3];
                    String strc2 = ""+c2[0]+c2[1]+c2[2]+c2[3];
                    if(!stuck.contains(strc1) && !visited.contains(strc1)){
                        q.add(strc1);
                        visited.add(strc1);
                    }
                    if(!stuck.contains(strc2) && !visited.contains(strc2)){
                        q.add(strc2);
                        visited.add(strc2);
                    }
                }
            }
            c++;
        }
        return -1;
    }
}
