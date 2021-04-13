    // time and space complexity : O(n)
    // my greedy approach is use maximum character twice and next maximum character 1 time in a row. Using this we can acheive maximum length happy string.
    // One case where this general approach breaks is when max == nextmax, in this we use max twice and nextMax once and in next iteration max = nextMax and we will use it 3 times in a row.
    // to stop this we keep hold of last character previous iteration as that nextMax can not be use 3rice. In that case it is better to use max and nextMax alternatively.
    public String longestDiverseString(int a, int b, int c) {
        int[] arr = new int[]{a,b,c};
        StringBuilder sb = new StringBuilder();
        char prev = '.';    // dummy character before starting
        while(true){
            int max = 0;     
            int maxIndex = -1;  // will hold the maximum freq character
            int nextMax = 0;
            int nextMaxIndex = -1;  // will hold the next maximum freq character
            for(int i=0;i<3;i++){
                if(max<arr[i]){
                    nextMax = max;
                    nextMaxIndex = maxIndex;
                    max = arr[i];
                    maxIndex = i;
                }
                else if(nextMax<arr[i]){
                    nextMax = arr[i];
                    nextMaxIndex = i;
                }
            }
            if(maxIndex==-1)break;      // if no maximum character found stop
            sb.append((char)(maxIndex+'a'));    // else append it once
            arr[maxIndex]--;
            if(arr[maxIndex]>0 && prev!=(char)(maxIndex+'a')){  // if the last character used during previous iteration is not the current max character we can append it. Otherwise it can repeat upto 3 times continiuously.
                sb.append((char)(maxIndex+'a'));
                 arr[maxIndex]--;
            }
            if(nextMaxIndex!=-1){       // append next maximum character only once.
                sb.append((char)(nextMaxIndex+'a'));
                    arr[nextMaxIndex]--;
            }
            else break;         // if no next maximum character is there we must break so that maximum character will not be added more that 2 continiously.
            prev = sb.charAt(sb.length()-1);
        }
        return sb.toString();
    }


