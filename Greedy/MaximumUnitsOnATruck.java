// time complexity O(nlogn), space complexity O(1)
/*
  apporach : same as fractional knapsack.
  --> as boxType[i][1] represents # of unit in 1 box. And we have boxType[i][0] such boxes.
  --> As we need to maximize our units, we will sort then according to decreasing order of units.
  --> Then we start picking maximum unit boxes first and then move on to less unit boxes untill we have truckSize>0
    
*/
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->(b[1]-a[1]));
        int units = 0;
        for(int i=0;i<boxTypes.length;i++){
            units+=Math.min(truckSize,boxTypes[i][0]) * boxTypes[i][1];
            truckSize -=boxTypes[i][0];
            if(truckSize<=0)break;
        }
        return units;
    }
}
