package problems;

import java.util.HashMap;

public class Q0003LongestWithoutRepeating {
    public int lengthOfLongestSubstring(String s){
        if(s.length()==1) return 1;
        var map = new HashMap<Character, Integer>();
        int last=0;
        int result=0;
        int i=0;
        for(;i<s.length(); i++){
            if(!map.containsKey(s.charAt(i)) ) {
                map.put(s.charAt(i), i);
            }
            else{
                if(i-last >result) result = i-last;
                last=Math.max(last, map.get(s.charAt(i))+1);
                map.put(s.charAt(i), i);
            }
        }
        if(i-last> result) result= i-last;

        return result;

    }
}
