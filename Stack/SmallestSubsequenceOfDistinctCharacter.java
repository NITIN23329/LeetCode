//time O(n) , space O(n)
class Solution {
    public String smallestSubsequence(String s) {
        Map<Character,Integer> map = new HashMap<>(); //it will store last index of each character
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++)map.put(arr[i],i);
        Deque<Character> dq = new ArrayDeque<>();
        Set<Character> set = new HashSet<>();    //it will contains elements in dq
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i]))continue;    //if dq has current element no need to do anything
            while(!dq.isEmpty()){
                if(map.get(dq.peek())<i)break;    // if the top element in dq will not occur again future, then we can not remove it from dq
                if(dq.peek()<arr[i])break;        //if top element of dq is smaller than current , then don't remove it as it is lexiographically ...
                set.remove(dq.pop());             //small than adding curr and then top dq element(smaller than curr element).
            }
            dq.push(arr[i]);
            set.add(arr[i]);
                
        }
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty())sb.append(dq.pop());
        return sb.reverse().toString();
    }
    
}
