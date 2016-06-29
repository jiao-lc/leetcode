public class Twitter {
    HashMap<Integer, Set<Integer>> user; //user -> follow users
    HashMap<Integer, Integer> map;       //tweetsId -> userId
    HashMap<Integer, List<Integer>> list;     //userId -> tweets
    /** Initialize your data structure here. */
    public Twitter() {
        HashMap<Integer, Set<Integer>> user =new HashMap<>(); // user -> follow users
        HashMap<Integer, Integer> map = new HashMap<>(); //tweetsId -> userId
        HashMap<Integer, List<Integer>> list = new HashMap<>(); //userId -> tweets
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!user.containsKey(userId)) {
            user.put(userId, new HashSet<Integer>());
        }
        if(!list.containsKey(userId)) {
            list.put(userId, new ArrayList<Integer>());
        }
        List<Integer> tmp = list.get(userId);
        tmp.add(tweetId);
        list.put(userId, tmp);
        map.put(tweetId, userId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> set = user.get(userId);
        List<Integer> tmp = list.get(userId);
        List<Integer> arr = new ArrayList<Integer>();
        int cnt = 0;
        for(int i = tmp.size() - 1; i >= 0 && cnt < 10; i--) {
            int tweet = tmp.get(i);
            int follow = map.get(tweet);
            if(!set.contains(follow)) {
                tmp.remove(i); continue;
            }
            arr.add(tweet);
        }
        return arr;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = user.get(followerId);
        set.add(followeeId);
        user.put(followerId, set);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = user.get(followerId);
        if(set.contains(followeeId)) {
            set.remove(followeeId);
            user.put(followerId, set);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */