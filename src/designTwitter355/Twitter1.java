package designTwitter355;

import java.util.*;

/**
 * 思路 1：用一个 ArrayList 存储所有推文，根据用户查找推文时不太方便
 *
 * 执行用时 :69 ms, 在所有 Java 提交中击败了30.31%的用户
 * 内存消耗 :45.5 MB, 在所有 Java 提交中击败了10.00%的用户
 */
class Twitter1 {

    /**
     * Initialize your data structure here.
     * 设计一个简化版的推特(Twitter1)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/design-twitter
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */
    public Twitter1() {
        followMap = new HashMap<>();
        tweetList = new ArrayList<>();
    }

    /**
     * Compose a new tweet.
     * 创建一条新的推文。
     * @param userId 用户 ID
     * @param tweetId 推文 ID
     */
    public void postTweet(int userId, int tweetId) {
        tweetList.add(new Integer[]{userId, tweetId});
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by
     * users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     * 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
     * @param userId 用户 ID
     * @return 用户能够看到的最近十条推文
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> followeeSet = followMap.get(userId);
        int count = 0;
        for (int i = tweetList.size() - 1; i >= 0; i--) {
            Integer[] tweet = tweetList.get(i);
            if ( tweet[0] == userId || (null != followeeSet && followeeSet.contains(tweet[0]))) {
                res.add(tweet[1]);
                count++;
                if (count >= 10) break;
            }
        }
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     * 关注一个用户。
     * @param followerId 关注操作发起人 ID
     * @param followeeId 被关注人 ID
     */
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, x -> new HashSet<>()).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     * 取消关注一个用户。
     * @param followerId 取消关注操作发起人 ID
     * @param followeeId 被关注人 ID
     */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followeeSet = followMap.get(followerId);
        if (null != followeeSet) {
            followeeSet.remove(followeeId);
        }
    }

    private Map<Integer, Set<Integer>> followMap;
    private List<Integer[]> tweetList;
}

