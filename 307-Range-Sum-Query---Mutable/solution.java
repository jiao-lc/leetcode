public class NumArray {
    private int BIT[];               // Binary Indexed Tree = Fenwick Tree
    private int[] nums;
    
    public NumArray(int[] nums) {
        BIT = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            init(i + 1, nums[i]);
        }
        this.nums = nums;
    }

    private void init(int i, int val) {
        while(i < BIT.length) {
            BIT[i] += val;
            i = i + (i & -i);
        }
    }
    
    public void update(int i, int val) {
        int delta = val - nums[i];
        nums[i] = val;
        init(i + 1, delta);
    }

    public int sumRange(int i, int j) {
        return getSum(j + 1) - getSum(i);
    }
    
    private int getSum(int i) {
        int sum = 0;
        while(i > 0) {
            sum += BIT[i];
            i = i - (i & -i);
        }
        return sum;
    }
}