public class Solution {
    int[][] step = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        if(board == null || words == null)  return new ArrayList<String>();
        HashMap<Character, Set<Character>> map = buildMap(board);
        Set<String> res = new HashSet<String>();
        for(String str : words) {
            if(!check(map, str))    continue;
            char[] arr = str.toCharArray();
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(dfs(board, arr, 0, i, j))    res.add(str);
                }
            }
        }
        return new ArrayList<String>(res);
    }
    
    private boolean dfs(char[][] board, char[] words, int idx, int x, int y) {
        if (idx == words.length) return true;
        if (x < 0 || x == board.length || y < 0 || y == board[0].length)  return false;
        if (board[x][y] != words[idx])  return false;
        board[x][y] ^= 256;
        boolean exist = dfs(board, words, idx + 1, x, y + 1) ||
        dfs(board, words, idx + 1, x, y - 1) || dfs(board, words, idx + 1, x + 1, y) ||
        dfs(board, words, idx + 1, x - 1, y) ;
        board[x][y] ^= 256;
        return exist;
    }
    
    public HashMap<Character, Set<Character>> buildMap(char[][] board) {
        HashMap<Character, Set<Character>> map = new HashMap<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(!map.containsKey(board[i][j])) map.put(board[i][j], new HashSet<Character>());
                Set<Character> set = map.get(board[i][j]);
                for(int k = 0; k < 4; k++) {
                    int r = i + step[k][0], c = j + step[k][1];
                    if(r >= 0 && r < board.length && c >= 0 && c < board[0].length) set.add(board[r][c]);
                }
                map.put(board[i][j], set);
            }
        }
        return map;
    }
    
    public boolean check(HashMap<Character, Set<Character>> map, String word) {
        char[] arr = word.toCharArray();
        char c = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(!map.containsKey(c)) return false;
            Set<Character> tmp = map.get(c);
            if(!tmp.contains(arr[i]))   return false;
            c = arr[i];
        }
        return true;
    }
}