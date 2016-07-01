public class Solution {
public List<Integer> countSmaller(int[] nums) {
    List<Integer> res = new ArrayList<>(nums.length);
    List<Integer> index = new ArrayList<>(nums.length);

    for (int i = nums.length - 1; i >= 0; i--) {
        res.add(0);
        index.add(i);
    }

    countSmallerSub(nums, index, 1 << 31, res);

    return res;
}

private void countSmallerSub(int[] nums, List<Integer> index, int mask, List<Integer> res) {
    if (mask != 0 && index.size() > 1) {
        List<Integer> lowGroup = new ArrayList<>(index.size());
        List<Integer> highGroup = new ArrayList<>(index.size());

        int high = mask < 0 ? 0 : mask;
        for (int i = 0; i < index.size(); i++) {
            if ((nums[index.get(i)] & mask) == high) {
                res.set(index.get(i), res.get(index.get(i)) + lowGroup.size());
                highGroup.add(index.get(i));
            } else {
                lowGroup.add(index.get(i));
            }
        }

        countSmallerSub(nums, lowGroup, mask >>> 1, res);
        countSmallerSub(nums, highGroup, mask >>> 1, res);
    }
}
}