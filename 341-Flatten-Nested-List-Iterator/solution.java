/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> nums = new ArrayList<Integer>();
    int i;
    public NestedIterator(List<NestedInteger> nestedList) {
        flatten(nums, nestedList);
        i = 0;
    }
    
    public void flatten(List<Integer> nums, List<NestedInteger> nestedList) {
        for(NestedInteger unit : nestedList) {
            if(unit.isInteger()) {
                nums.add(unit.getInteger());
            } else {
                flatten(nums, unit.getList());
            }
        }
    }
    @Override
    public Integer next() {
        Integer res = nums.get(i);
        i++;
        return res;
    }

    @Override
    public boolean hasNext() {
        return i < nums.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */