package designTwitter355;

import java.util.*;

/**
 * 思路 2：用一个 HashMap 存储每个人的推文
 *
 * 执行用时 :37 ms, 在所有 Java 提交中击败了63.47%的用户
 * 内存消耗 :45.2 MB, 在所有 Java 提交中击败了10.00%的用户
 */
class Twitter2 {

    /**
     * Initialize your data structure here.
     * 设计一个简化版的推特(Twitter1)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/design-twitter
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */
    public Twitter2() {
        followMap = new HashMap<>();
        tweetList = new HashMap<>();
        queue = new PriorityQueue<>((o1, o2) -> o2.time - o1.time);
    }

    /**
     * Compose a new tweet.
     * 创建一条新的推文。
     * @param userId 用户 ID
     * @param tweetId 推文 ID
     */
    public void postTweet(int userId, int tweetId) {
        // 用一个空的头结点，避免各种空指针判断
        Tweet tweetHead = tweetList.computeIfAbsent(userId, x -> new Tweet());
        // 将新的推文插入到头结点的后继
        Tweet post = new Tweet(tweetId, timestamp++);
        post.next = tweetHead.next;
        tweetHead.next = post;
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by
     * users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     * 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
     * @param userId 用户 ID
     * @return 用户能够看到的最近十条推文
     */
    public List<Integer> getNewsFeed(int userId) {
        // 全局使用
        queue.clear();

        List<Integer> news = new ArrayList<>();
        int count = 0;

        Set<Integer> followeeSet = followMap.get(userId);
        if (null != followeeSet) {
            for (int followee : followeeSet) {
                // 从每个关注人那里获取一条最近的推文，如果存在头结点，则一定有推文
                Tweet tweet = tweetList.get(followee);
                if (null != tweet) {
                    queue.add(tweet.next);
                }
            }
        }
        // 自己发出的推文也要能看见
        Tweet tweet = tweetList.get(userId);
        if (null != tweet) {
            queue.add(tweet.next);
        }

        // 多路归并排序，将每个关注人和自己的最近一条推文放入优先队列中进行排序，输出最近的一条推文，
        // 然后取出这条推文的属主的下一条推文放入优先队列，继续判断，直到队列为空或者取够十条。
        while (!queue.isEmpty()) {
            Tweet poll = queue.poll();
            news.add(poll.id);
            count++;
            if (null != poll.next) {
                queue.add(poll.next);
            }
            if (10 == count) break;
        }

        return news;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     * 关注一个用户。
     * @param followerId 关注操作发起人 ID
     * @param followeeId 被关注人 ID
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followMap.computeIfAbsent(followerId, x -> new HashSet<>()).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     * 取消关注一个用户。
     * @param followerId 取消关注操作发起人 ID
     * @param followeeId 被关注人 ID
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        Set<Integer> followeeSet = followMap.get(followerId);
        if (null != followeeSet) {
            followeeSet.remove(followeeId);
        }
    }

    private static int timestamp = 0;

    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, Tweet> tweetList;
    private PriorityQueue<Tweet> queue;

    class Tweet {
        public Tweet() {
        }

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }

        private int id;
        private int time;
        private Tweet next;
    }
}


