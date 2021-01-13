// time O(n + nlogn + n* helpr(i))
/*  approach :
        --> for every x in lo to hi, find number of steps required to convert in to 1
        --> sort according to steps require . if same sort according to value of x
*/
class Solution {
    public int getKth(int lo, int hi, int k) {
        int[][] arr = new int[hi-lo+1][2];
        for(int i=lo;i<=hi;i++){
            arr[i-lo][1] = helpr(i);
            arr[i-lo][0] = i;
        }
            
        Arrays.sort(arr,(a,b)->(a[1]==b[1]? a[0]-b[0] : a[1]-b[1]));
        return arr[k-1][0];
    }
    private int helpr(int x){
        int c = 0;
        while(x!=1){
            if(x%2==0)x/=2;
            else x=3*x+1;
            c++;
        }
        return c;
    }
}
// dp of above solution
class Solution {
    public int getKth(int lo, int hi, int k) {
        Map<Integer,Integer> count = new HashMap<>();
        count.put(1,0);
        int[][] arr = new int[hi-lo+1][2];
        for(int i=lo;i<=hi;i++){
            arr[i-lo][1] = helpr(i,count);
            arr[i-lo][0] = i;
        }
            
        Arrays.sort(arr,(a,b)->(a[1]==b[1]? a[0]-b[0] : a[1]-b[1]));
        return arr[k-1][0];
    }
    private int helpr(int x,Map<Integer,Integer> map){
        if(map.containsKey(x))return map.get(x);
        int c = 1;
        if(x%2==0)c+=helpr(x/2,map);
        else c+=helpr(3*x+1,map);
        map.put(x,c);
        return c;
    }
}
