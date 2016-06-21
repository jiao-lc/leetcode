public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //利用hashMap，和优先级队列。
        List<Integer> res=new ArrayList<Integer>();
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        if(k>nums.length||k<1){
            return res;
        }
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,0);
            }
        }
        ArrayList<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int count = 0;
        while (count < k)
            res.add(list.get(count++).getKey());
        return res;
    }
}