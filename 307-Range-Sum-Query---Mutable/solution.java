public class NumArray {
    public List<Integer> sum = new ArrayList<Integer>();
    public NumArray(int[] nums) {
        int c = 0;
        for(int i : nums) {
            c += i;
            sum.add(c);
        }
    }

    void update(int i, int val) {
        int diff = val - (i == 0 ? sum.get(0) : sum.get(i) - sum.get(i - 1));
        for(int j = i; j < sum.size(); j++) {
            sum.set(j, sum.get(j) + diff);
        }
    }

    public int sumRange(int i, int j) {
        return i == 0 ? sum.get(j) : sum.get(j) - sum.get(i - 1);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);