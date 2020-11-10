
#problem link : https://practice.geeksforgeeks.org/problems/circular-tour-1587115620/1
/* approach : suppose we started from x petrol pump and we got out of petrol at y petrol pump , 
so any petrol pump from x to before y can not be our starting point cuz each petrol pump must add a positive fuel .
so assume our next petrol pump to be y and check if we reach y again after visiting all petrol pump , if yes then y is our starting point
one corner case is if we started from y>x and got out of fuel at x , then there is no petrol pump from where we can start (return -1)
*/

 static int tour(int petrol[], int distance[])
    {
        int curr = 0;
        int res =0;
        int i=0;
        int n = petrol.length;
        while(i<2*n){
            if(curr<0){
                if(i%n<res)return -1;
                res = i%n;
                curr=petrol[i%n];
                curr-=distance[i%n];
            }
            else{
                curr+=petrol[i%n];
                curr-=distance[i%n];

            }
            i++;
            if(res==i%n)break;
        }
        if(curr<0)return -1;
        return res;
    }
