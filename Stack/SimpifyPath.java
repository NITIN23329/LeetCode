class Solution {
    public String simplifyPath(String path) {
        Deque<String> dq = new ArrayDeque<>();
        String arr[] = path.split("/");
        for(String str:arr){
           if(str.isEmpty() || str.equals("."))continue; 
           if(str.equals("..")){
              if(!dq.isEmpty())dq.pop();
           }
            else dq.push(str);
        }
        StringBuilder str = new StringBuilder();
        if(dq.isEmpty())return "/";
        while(!dq.isEmpty())str.append("/").append(dq.pollLast());
        return str.toString();
        
    }
}
