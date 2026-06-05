

import java.util.HashMap;

public class LengthSubstring {
    public static void main(String[] args){

    String s = "aabcbad";
    int k = 2;
    int max = 0;
    HashMap<Character, Integer> map = new HashMap<>();
    
    for(int r=0;r<s.length();r++){
        char curr = s.charAt(r);
        map.put(curr, map.getOrDefault(curr,(0)+1));

        if(map.size()<=k){
            max = max<(r-1+1)? r-1+1:max;
        }
        while(map.size()>k){
            if(map.get(s.charAt(1))==1){
                map.remove(s.charAt(1));
            }else {
                map.put(s.charAt(1), map.get(s.charAt(1))-1);
            }
        }
        
    }
    }
}
