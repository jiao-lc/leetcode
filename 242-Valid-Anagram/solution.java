public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        int big = 107 * 113;
        int hash1 = 1, hash2 = 1;
        for(char a : s.toCharArray()) {
            hash1 *= prime[a - 'a'];
            hash1 %= big;
        }
        for(char b : t.toCharArray()) {
            hash2 *= prime[b - 'a'];
            hash2 %= big;
        }
        return hash1 == hash2;
    }
}