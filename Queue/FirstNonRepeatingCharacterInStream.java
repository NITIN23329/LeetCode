//problem link : https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream/0
/*
time : O(n) , space O(n)
approach : keep a map to store occurence of every character.
for every i :
add that element to q ,
remove from front of q as long as we find character whose frequcncy >1
then front will contain first non repeating character
*/
public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int t  = sc.nextInt();
	    while(t-->0){
	        int n = sc.nextInt();
	        char[] arr = new char[n];
	        for(int i=0;i<n;i++)arr[i] = sc.next().charAt(0);
	        Queue<Character> q =new LinkedList<>();
	        Map<Character,Integer> map = new HashMap<>();
	        for(int i =0;i<n;i++){
	            char c = arr[i];
	            if(!map.containsKey(c))map.put(c,0);
	            map.put(c,map.get(c)+1);
	            q.add(c);
	            while(!q.isEmpty() && map.get(q.peek())>1)q.poll();
	            if(q.isEmpty())System.out.print(-1+" ");
	            else System.out.print(q.peek()+" ");
	                
	        }
	        System.out.println();
	    }
	 }
