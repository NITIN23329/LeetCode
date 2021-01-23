// time O(total combinations)
/*  approach :
      --> for every digit in digits try out all possible combiantions
*/  
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.isEmpty())
            return res;
        Map<Character,List<String>> map = new HashMap<>();
        char c = 'a';
        for(char i='2';i<='9';i++){
            map.put(i,new ArrayList<>());
            int e = i=='7' || i=='9' ? 4 : 3;
            for(int j=0;j<e;j++)
                map.get(i).add(""+c++);
        }
        form(0,digits,"",res,map);
        return res;
    }
    private void form(int i,String digits,String str,List<String> res, Map<Character,List<String>> map){
        if(i==digits.length()){
            res.add(str);
            return;
        }
        for(String ele : map.get(digits.charAt(i)))
            form(i+1,digits,str+ele,res,map);
    }
}
