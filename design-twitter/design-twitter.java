class Twitter {
    
    static int time = 0;
    
    public class Tweet{
        public int tweetId;
        public int timestamp;
        public Tweet next;
        public Tweet(int tweetId){
            this.tweetId  = tweetId;
            this.timestamp = time++;
        }
    }
    
    public class User{
        public int userId;
        public Set<Integer> followed;
        public Tweet head;
        
        public User(int userId){
            this.userId  = userId;
            followed = new HashSet<>();
            follow(userId);
        }
        
        public void follow(int userId){
            followed.add(userId);
        }
        
        public void unfollow(int userId){
            followed.remove(userId);
        }
        
        public void post(int tweetId){
            Tweet newTweet = new Tweet(tweetId);
            newTweet.next = head;
            head = newTweet;
        }   
    }
    
    private final Map<Integer, User> userMap;
    
    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)){
            User user = new User(userId);
            userMap.put(userId, user);
        }
        
        userMap.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed  = new ArrayList<>();
        if (!userMap.containsKey(userId))return newsFeed;
        
        Set<Integer> userIds = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(10, (a,b) -> b.timestamp - a.timestamp); 
        
        for (Integer id : userIds){
            Tweet tweetHead = userMap.get(id).head;
            if (tweetHead != null){
                pq.offer(tweetHead);
            }
        }
        
        int tweetCount = 0;
        while (!pq.isEmpty() && tweetCount < 10){
            Tweet tweet = pq.poll();
            newsFeed.add(tweet.tweetId);
            tweetCount++;
            
            if (tweet.next != null){
                pq.offer(tweet.next);
            }
        }
        
        
        return newsFeed;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)){
            User user = new User(followerId);
            userMap.put(followerId, user);
        }
        
        if (!userMap.containsKey(followeeId)){
            User user = new User(followeeId);
            userMap.put(followeeId, user);
        }
        
        userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId==followeeId)return;
        userMap.get(followerId).unfollow(followeeId);
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