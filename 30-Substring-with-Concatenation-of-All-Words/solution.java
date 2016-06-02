public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int N = s.length();
        List<Integer> indexes = new ArrayList<Integer>();
        if(words.length == 0) return indexes;
        int M = words[0].length();
        if(N < M * words.length) return indexes;
        int last = s.length() - M + 1;
        
        //map each string in words array to some index and compute target counters
        Map<String, Integer> mapping = new HashMap<String, Integer>();
        int[][] table = new int[2][words.length];
        int num = 0;
        for(int i = 0; i < words.length; i++) {
            Integer mapped = mapping.get(words[i]);
            if(mapped == null) {
                mapping.put(words[i], num);
                num++;
                mapped = num - 1;
            }
            table[0][mapped]++;
        }
        
        //find all occurrences at string S and map them to their current integer, -1 means no such string is in words array
        int[] smapping = new int[last];
        for(int i = 0; i < last; i++) {
            String section = s.substring(i, i + M);
            Integer mapped = mapping.get(section);
            smapping[i] = mapped == null ? -1 : mapped;
        }
        
        //fix the number of linear scans
        for(int i = 0; i < M; i++) { // i = M + 1 is repeated i = 1
            int current = num;
            int left = i, right = i;
            Arrays.fill(table[1], 0);
            //here, simple solve the minimum-window-substring problem
            while(right < last) {
                while(current > 0 && right < last) {
                    int target = smapping[right];
                    if(target != -1 && ++table[1][target] == table[0][target])
                        current--;
                    right += M;
                }
                while(current == 0 && left < right) {
                    int target = smapping[left];
                    if(target != -1 && --table[1][target] == table[0][target] - 1){
                        int len = right - left;
                        if(len / M == words.length) indexes.add(left);
                        current++;
                    }
                    left += M;
                }
            }
        }
        return indexes;
    }
}