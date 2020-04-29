package leet0201to0400.problem0355;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * https://leetcode-cn.com/problems/design-twitter/
 * @author Brilliant James
 * @date 2020-04-13 17:23
 **/
public class Twitter {

    Map<Integer, Set<Integer>> userAdj;

    Map<Integer, TwitterNode> postAdj;

    private AtomicLong timeStamp;

    /** Initialize your data structure here. */
    public Twitter() {
        userAdj = new HashMap<>();
        postAdj = new HashMap<>();
        timeStamp = new AtomicLong();
    }

    /** Compose a new tweet.
     *  freqs.computeIfAbsent(key, k -> new LongAdder()).increment();
     */
    public void postTweet(int userId, int tweetId) {
        Integer userObject = Integer.valueOf(userId);
        if (postAdj.containsKey(userObject)) {
            TwitterNode old = postAdj.get(userObject);
            TwitterNode newNode = new TwitterNode(tweetId);
            newNode.next = old;
            postAdj.put(userObject, newNode);
        } else {
            postAdj.put(userObject, new TwitterNode(tweetId));
        }

    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself.
     * Tweets must be ordered from most recent to least recent.
     * */
    public List<Integer> getNewsFeed(int userId) {
        Integer userObject = Integer.valueOf(userId);
        PriorityQueue<TwitterNode> maxHeap = new PriorityQueue<>((o1, o2) -> (int) (o2.time - o1.time));
        if (postAdj.containsKey(userObject)) {
            maxHeap.offer(postAdj.get(userObject));
        }
        Set<Integer> followingUserSet = userAdj.get(userObject);
        if (followingUserSet != null) {
            for (Integer i : followingUserSet) {
                if (postAdj.containsKey(i)) {
                    maxHeap.offer(postAdj.get(i));
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 10 && maxHeap.size() > 0; i++) {
            TwitterNode temp = maxHeap.poll();
            ans.add(temp.twitterId);
            if (temp.next != null) {
                maxHeap.offer(temp.next);
            }
        }
        return ans;
    }

    /** Follower follows a followee.
     * If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> followingUserSet = userAdj.computeIfAbsent(Integer.valueOf(followerId), k->new HashSet<>());
        followingUserSet.add(Integer.valueOf(followeeId));
    }

    /** Follower unfollows a followee.
     * If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        Set<Integer> followingUserSet = userAdj.computeIfAbsent(Integer.valueOf(followerId), k->new HashSet<>());
        followingUserSet.remove(Integer.valueOf(followeeId));
    }

    private class TwitterNode {
        Integer twitterId;
        long time;
        TwitterNode next;
        TwitterNode(int twitterId) {
            this.twitterId = twitterId;
            time = timeStamp.getAndIncrement();
        }
    }

    /**
     * ["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed"]
     * [[],[1,5],[1,3],[1,101],[1,13],[1,10],[1,2],[1,94],[1,505],[1,333],[1]]
     * ["Twitter","postTweet","follow","follow","getNewsFeed","postTweet","getNewsFeed","getNewsFeed","unfollow","getNewsFeed","getNewsFeed","unfollow","getNewsFeed","getNewsFeed"]
     * [[],         [1,5],    [1,2],    [2,1],   [2],          [2,6],      [1],         [2],           [2,1],     [1],          [2],           [1,2],    [1],           [2]]
     * [null,       null,     null,     null,    [5],          null,       [6,5],       [5],           null,      [6,5],        [],            null,     [5],           []]
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
//        ArrayList<Integer> list = new ArrayList<>();
//        System.out.println(Collections.binarySearch(list, 5));
//
//        System.out.println(list.toString());
//        System.out.println(Collections.binarySearch(list, 5));
//        list.remove(3);
//        System.out.println(Collections.binarySearch(list, 1));
//        list.remove(0);
//        System.out.println(list.toString());
//        Map<String, List<Integer>> map = new HashMap<>();
//        map.computeIfAbsent("aa", k -> new ArrayList<>()).add(1);
//        System.out.println(map.get("aa"));
//        map.computeIfAbsent("aa", k -> new ArrayList<>()).add(1);
//        System.out.println(map.get("aa"));
//        long start = System.currentTimeMillis();
//        TimeUnit.SECONDS.sleep(1);
//        long end = System.currentTimeMillis();
//        System.out.println( end - start);
//
        Twitter t = new Twitter();
//
        t.postTweet(1, 5);
        t.postTweet(1, 3);
        t.postTweet(1, 101);
        t.postTweet(1, 13);
        t.postTweet(1, 10);
        t.postTweet(1, 2);
        t.postTweet(1, 94);
        t.postTweet(1, 505);
        t.postTweet(1, 333);
        System.out.println(t.getNewsFeed(1));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        queue.offer(11123121);
//        queue.offer(11155);
//        queue.offer(11166);
//        queue.offer(11177);
//        queue.offer(111121);
        int[] tt = {111, 1111, 11223, 1123, 444, 12314, 1324, 444, 124, 12123, 9999, 900088, 111121, 2222, 333333, 444444};
        for (int i : tt) {
            queue.offer(i);
            if (queue.size() > 3) {
                System.out.println(queue.poll());
                System.out.println("size: " + queue.size());
            }
        }
        System.out.println("-----------------------");
        while (queue.size() > 0) {
            System.out.println(queue.poll());
        }


    }


}
