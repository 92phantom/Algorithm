package study.algorithm;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class LeetCode355 {


    class TweetLog {

        int userId;
        int tweetId;
        int input_index;

        public TweetLog(int userId, int tweetId, int input_index) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.input_index = input_index;
        }
    }

    class Twitter {

        List<TweetLog> tweetLogs;
        ConcurrentHashMap<Integer, ArrayList<Integer>> posting;
        ConcurrentHashMap<Integer, Set<Integer>> following;

        /** Initialize your data structure here. */
        public Twitter() {
            tweetLogs       = new ArrayList<>();
            posting         = new ConcurrentHashMap<>();
            following       = new ConcurrentHashMap<>();
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {

            ArrayList<Integer> tweetArray;
            
            if(posting.containsKey(userId)) tweetArray = posting.get(userId);
            
            else tweetArray = new ArrayList<>();
            
            tweetArray.add(tweetId);
            posting.put(userId, tweetArray);

            tweetLogs.add(new TweetLog(userId, tweetId, tweetLogs.size()+1));

        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {

            Set<Integer> f_set = following.get(userId);
            List<TweetLog> tweetLogs_tmp = new ArrayList<>();

            // 내 게시글
            for(int i=tweetLogs.size()-1; i>=0; i--) {
                if(tweetLogs.get(i).userId == userId) {
                    tweetLogs_tmp.add(tweetLogs.get(i));
                }
            }
            
            // following 하는 대상의 게시글
            if(f_set != null) {

                ArrayList<Integer> f_list = new ArrayList<>(f_set);

                for(int i=0; i<f_list.size(); i++) {
                    
                    for(int j=tweetLogs.size()-1; j>=0; j--) {
                        
                        if(tweetLogs.get(j).userId == f_list.get(i)) 
                            tweetLogs_tmp.add(tweetLogs.get(j));
                        
                    }
                }

            }

            // 시간 순서로 정렬
            tweetLogs_tmp.sort(new Comparator<TweetLog>() {
                @Override
                public int compare(TweetLog t1, TweetLog t2) {
                    if(t1.input_index > t2.input_index) return -1;
                    else if(t1.input_index < t2.input_index) return 1;
                    return 0;
                }
            });

            // 가장 최근 10개만 추출
            List<Integer> ans = new ArrayList<>();

            for(int i=0; i<tweetLogs_tmp.size(); i++){
                ans.add(tweetLogs_tmp.get(i).tweetId);
                if(ans.size() == 10) break;
            }

            return ans;

        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {

            Set<Integer> f_list;
            
            if(following.containsKey(followerId)) f_list = following.get(followerId);
            else f_list = new HashSet<>();

            f_list.add(followeeId);
            following.put(followerId, f_list);

        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {

            if(following.containsKey(followerId)) {
                Set<Integer> f_list = following.get(followerId);
                f_list.remove(followeeId);

                following.put(followerId, f_list);
            }

        }
    }


    @Test
    void test_1() {

        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        // User 1 posts a new tweet (id = 5).
        List<Integer> re = twitter.getNewsFeed(1);
        System.out.println(re);

        // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);
        // User 1 follows user 2.
        twitter.postTweet(2, 6);
        // User 2 posts a new tweet (id = 6).
        re = twitter.getNewsFeed(1);
        System.out.println(re);

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);
        // User 1 unfollows user 2.
        re = twitter.getNewsFeed(1);
        System.out.println(re);
        // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.

    }

    @Test
    void test_2() {

        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        // User 1 posts a new tweet (id = 5).
        List<Integer> re = twitter.getNewsFeed(1);
        System.out.println(re);

        twitter.postTweet(1, 3);
        // User 2 posts a new tweet (id = 6).
        re = twitter.getNewsFeed(1);
        System.out.println(re);

        re = twitter.getNewsFeed(1);
        System.out.println(re);
        // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.

    }



}
