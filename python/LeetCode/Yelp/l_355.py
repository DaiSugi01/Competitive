from typing import List


class Twitter:
    #     {
    #         "user1" : {
    #             "tweets": ["tweetId1", "tweetId1"],
    #             "followees": ("user2", "user3"),
    #             "followers": ("user2", "user3"),
    #           }
    #     }

    #     {
    #         "tweetId": "userId"
    #     }

    userMap = {}
    tweetMap = {}

    def __init__(self):
        pass

    def postTweet(self, userId: int, tweetId: int) -> None:
        if userId not in self.userMap:
            self.userMap[userId] = {
                "tweets": [],
                "followees": set(),
                "followers": set()
            }
        self.tweetMap[userId] = tweetId
        self.userMap[userId]["tweets"].append(tweetId)

        for user in self.userMap[userId]["followers"]:
            self.userMap[user]["tweets"].append(tweetId)

    def getNewsFeed(self, userId: int) -> List[int]:
        if userId not in self.userMap:
            self.userMap[userId] = {
                "tweets": [],
                "followees": set(),
                "followers": set()
            }

        tweets = self.userMap[userId]["tweets"]
        return [tweets[i] for i in reversed(range(len(tweets)))]

    def follow(self, followerId: int, followeeId: int) -> None:
        self.create_user(followerId)
        self.create_user(followeeId)
        self.userMap[followeeId]["followers"].add(followerId)
        self.userMap[followerId]["followees"].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        self.create_user(followerId)
        self.create_user(followeeId)
        self.userMap[followeeId]["followers"].remove(followerId)
        self.userMap[followerId]["followees"].remove(followeeId)

    def create_user(self, userId: int):
        if userId not in self.userMap:
            self.userMap[userId] = {
                "tweets": [],
                "followees": set(),
                "followers": set()
            }

if __name__ == '__main__':
    obj = Twitter()
    obj.postTweet(1, 5)
    feed = obj.getNewsFeed(1)
    obj.follow(1, 2)
    obj.postTweet(2, 6)
    obj.getNewsFeed(1)
    obj.unfollow(1, 2)
    obj.getNewsFeed(1)
