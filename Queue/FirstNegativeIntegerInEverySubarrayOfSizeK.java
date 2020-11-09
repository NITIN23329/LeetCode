	//problem link : https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k/0
  public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-->0){
	        int n = sc.nextInt();
	        int[] arr = new int[n];
	        Queue<Integer> q = new LinkedList<>();
	        for(int i=0;i<n;i++){
	            arr[i] = sc.nextInt();
	            if(arr[i]<0)q.add(i);
	        }
	        int k = sc.nextInt();
	        int[] res = new int[n-k+1];
	        for(int i=0;i<n-k+1;i++){
	            if(q.isEmpty()){
	                res[i]=0;
	                continue;
	            }
	            if(i+k>q.peek())res[i]= arr[q.peek()];
	            if(i==q.peek())q.poll();
	        }
	        for(int i=0;i<n-k+1;i++)System.out.print(res[i]+" ");
	        System.out.println();
	    }
	 }
