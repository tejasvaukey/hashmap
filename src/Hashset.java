import java.util.HashSet;
public class Hashset {
    public int longestConsecutive(int[] nums){
        HashSet<Integer> st = new HashSet<>();
        for(int num : nums) st.add(num);

        int maxStreak = 0;
        for(int num : st){
            if(!st.contains(num-1)){ // num is starting point of a sequence
                int currNum = num;
                int currStreak = 1;
                while(st.contains(currNum +1)){
                    currStreak++;
                    currNum++;
                }
                maxStreak = Math.max(maxStreak, currStreak);
            }
        }
        return maxStreak;
    }
    public int bagTable(int[] bag){
        HashSet<Integer> table = new HashSet<>();
        int maxNums = 0;

        for (int i = 0; i < bag.length; i++) {
            int num = bag[i];
            if(table.contains(num)) table.remove(num);
            else {
                table.add(num);
                maxNums = Math.max(maxNums, table.size());
            }
        }
        return maxNums;
    }
}
