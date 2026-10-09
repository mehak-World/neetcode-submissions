
class Tweet {
    int tweetId;
    int time;

    Tweet(int tweetId, int time) {
        this.tweetId = tweetId;
        this.time = time;
    }
}

class Info implements Comparable<Info> {
    Tweet tweet;
    int userId;
    int idx;

    Info(Tweet tweet, int userId, int idx) {
        this.tweet = tweet;
        this.userId = userId;
        this.idx = idx;
    }

    @Override
    public int compareTo(Info other) {
        // Newest tweet first: max-heap
        return Integer.compare(
            other.tweet.time,
            this.tweet.time
        );
    }
}

class Twitter {
    Map<Integer, Set<Integer>> following;
    Map<Integer, List<Tweet>> tweets;
    int time;

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(
            userId, id -> new ArrayList<>()
        ).add(new Tweet(tweetId, time++));
    }

    private void addLatestTweet(
        PriorityQueue<Info> pq, int userId
    ) {
        List<Tweet> list = tweets.get(userId);

        if (list != null && !list.isEmpty()) {
            int idx = list.size() - 1;
            pq.offer(new Info(list.get(idx), userId, idx));
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Info> pq = new PriorityQueue<>();

        // Include the user's own tweets.
        addLatestTweet(pq, userId);

        // Include the latest tweet of every followee.
        for (int id : following.getOrDefault(
                userId, Collections.emptySet())) {
            addLatestTweet(pq, id);
        }

        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty() && ans.size() < 10) {
            Info current = pq.poll();

            ans.add(current.tweet.tweetId);

            // Move backward in this user's tweet list.
            if (current.idx > 0) {
                int prevIdx = current.idx - 1;
                Tweet prevTweet = tweets
                    .get(current.userId)
                    .get(prevIdx);

                pq.offer(new Info(
                    prevTweet,
                    current.userId,
                    prevIdx
                ));
            }
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(
            followerId, id -> new HashSet<>()
        ).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        following.getOrDefault(
            followerId, Collections.emptySet()
        ).remove(followeeId);
    }
}
