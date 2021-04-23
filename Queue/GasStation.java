        // time : O(n), space O(1)
        /*
            --> approach :
                --> Suppose we start at index i and suppose the first index which we can not reach from i is j.
                --> Then if we start from any index i+1 to j, we can not pass the jth index.Why?
                --> Cuz our currGas is always >=0 and it might have more gas if we started from a previous index.
                --> Then we again start from j+1 and try to cover a circle.
                --> If we can not reach an index j< start index, then there is no way we can complete our tour.Why?
                --> Cuz our new startIndex is j+1 <= startIndex and we have already consider it.
         */
public static int canCompleteCircuit(int[] gas, int[] cost) {
        int currIndex = 0;
        int currGas = 0;
        int startIndex = 0;
        int n = gas.length;
        while(true){
            if(currIndex>=n && currIndex%n == startIndex)
                return startIndex;
            currGas += gas[currIndex%n];
            currGas -= cost[currIndex%n];
            if(currGas<0){
                if(currIndex%n<startIndex)break;
                startIndex = currIndex+1;
                currGas = 0;
                currIndex = startIndex;
            }else currIndex++;
        }
        return -1;
    }
