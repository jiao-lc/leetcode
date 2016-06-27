public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0)   return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] e1, int[] e2){
                return Integer.compare(e1[0], e2[0]);
            }
        });
        int max = 0;
        int[] num = new int[envelopes.length];
        Arrays.fill(num, 1);
        for(int i = 0; i < envelopes.length; i++) {
            for(int j = 0; j < i; j++) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                    num[i] = Math.max(num[j] + 1, num[i]);
            }
            max = Math.max(num[i], max);
        }
        return max;
    }
}