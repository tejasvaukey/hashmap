import javax.imageio.ImageTranscoder;
import java.util.*;


public class Questions {
    static HashMap<Character, Integer> makeFreqMap(String str){
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if(!mp.containsKey(ch)) mp.put(ch, 1);
            else {
                int currFreq = mp.get(ch);
                mp.put(ch, currFreq+1);
            }
        }
        return mp;
    }
    public static boolean isAnagram1(String s, String t){
        if(s.length() != t.length()) return false;
        Map<Character, Integer> mp1 = makeFreqMap(s);
        Map<Character, Integer> mp2 = makeFreqMap(s);
        return mp1.equals(mp2);
    }
    public static boolean isAnagram2(String s, String t){ // space optimal
        if(s.length() != t.length()) return false;
        Map<Character, Integer> mp = makeFreqMap(s);
        for (int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            if(!mp.containsKey(ch)) return false;
            int currFreq = mp.get(ch);
            mp.put(ch, currFreq -1);
        }
        for( Integer i : mp.values()){
            if(i != 0) return false;
        }
        return true;
    }

    public static boolean isIsomorphic1(String s, String t){
        Map<Character, Character> mp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character sCh = s.charAt(i);
            Character tCh = t.charAt(i);

            if(mp.containsKey(sCh)) if(mp.get(sCh) != tCh) return  false;
            else if(mp.containsValue(tCh)) return false;
            else mp.put(sCh, tCh);
        }
        return true;
    }
    public static boolean isIsomorphic2(String s, String t){
        Map<Character, Character> mp = new HashMap<>();
        HashSet<Character> st = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character sCh = s.charAt(i);
            Character tCh = t.charAt(i);

            if(mp.containsKey(sCh)) if(mp.get(sCh) != tCh) return  false;
            else if(st.add(tCh)) return false;
            else {
                mp.put(sCh, tCh);
                st.add(tCh);
            }
        }
        return true;
    }
    
    public static int[] twoSum1(int[] nums, int target){
        int n = nums.length;
        int[] ans = {-1};
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(nums[j] == target - nums[i]){
                    ans = new int[]{i,j};
                    return ans;
                }
            }
        }
        return ans;
    }
    public static int[] twoSum2(int[] nums, int target){
        int n = nums.length;
        int[] ans = {-1};
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int partner = target - nums[i];
            if(mp.containsKey(partner)) {
                ans = new int[]{i, mp.get(partner)};
                return ans;
            }
            mp.put(nums[i], i);
        }
        return ans;
    }

    public static int zeroSumLargetSubarray(int[] arr, int n){
        Map<Integer, Integer> mp = new HashMap<>();
        int maxLen = 0, prefSum = 0;
        mp.put(0,-1);
        for (int i = 0; i < arr.length; i++) {
            prefSum += arr[i];
            if(mp.containsValue(prefSum))
                maxLen = Math.max(maxLen, i - mp.get(prefSum));
            else mp.put(prefSum, i);
        }
        return maxLen;
    }


    static void main(String[] args) {

        boolean anagram = isAnagram2("keen", "knee");
        boolean isomorphic = isIsomorphic2("abcc", "xyzz");


    }
}
