public class Solution {//BFS
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        if(s.length() == 0) {res.add(""); return res;}
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        boolean found = false;
        queue.add(s);
        while(queue.peek() != null) {
            String tmp = queue.poll();
            //System.out.println(tmp);
            if(valid(tmp))  {found = true; res.add(tmp);}
            if(found)   continue;
            for(int i = 0; i < tmp.length(); i++) {
                if(tmp.charAt(i) != '(' && tmp.charAt(i) != ')') continue;  
                String sub = tmp.substring(0,i) + tmp.substring(i+1); 
                if(!visited.contains(sub)) {  
                    queue.offer(sub);  
                    visited.add(sub);  
                }
            }
        }
        return res;
    }
    public boolean valid(String s) {
        int cnt = 0;
        for(char c : s.toCharArray()) {
            if(c == '(')    cnt++;
            if(c == ')')    cnt--;
            if(cnt < 0) return false;
        }
        return cnt == 0;
    }
}