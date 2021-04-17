// time complexity : O(nlogn), space complexity : o(n)
/*
    approach :
      --> let say diff = aliceScore - bobScore. We want to maximize it. We can do so by increasing aliceScore or by decreasing bobScore.
      --> Suppose alice pick i'th stone,so alice gets a[i] stone and bob gets 0. Hence diff = a[i] - 0 = a[i].
      --> Or we can say alice gets a[i]+b[i] and bob gets b[i], Hence diff = a[i] + b[i] - b[i] = a[i]. Both are same.
      --> So say every time alice pick i'th stone she gets a[i] + b[i] stone and bob gets b[i] Stone.
      --> Alice wants to maximize her score, so she will pick max value of a[i] + b[i] for all i. Same will be done by bob
      --> This gives an idea to sort array in decrasing order to sum value.
      --> After that start picking stones alternatively starting with alice and compare final score.

*/
class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] arr = new int[n][2];
        for(var i=0;i<n;i++)arr[i] = new int[]{aliceValues[i],bobValues[i]};
        Arrays.sort(arr,(a,b)->(b[1]+b[0]-a[0]-a[1]));
        int aliceScore = 0;
        int bobScore = 0;
        for(int i=0;i<n;i++){
            if(i%2==0)aliceScore += arr[i][0];
            else bobScore += arr[i][1];
        }
        return aliceScore>bobScore?1:(aliceScore==bobScore?0:-1);
    }
}

