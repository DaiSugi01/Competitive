"""
find the top kth receivers who received the loves
"""
import heapq
"""
    {"receiver": "c@yelp.com", "msg": "dddd", "sender": "a@yelp.com"},
    {"receiver": "c@yelp.com", "msg": "dddd", "sender": "b@yelp.com"},
    {"receiver": "c@yelp.com", "msg": "gggg", "sender": "d@yelp.com"},
    {"receiver": "b@yelp.com", "msg": "aaaa", "sender": "e@yelp.com"},
    {"receiver": "b@yelp.com", "msg": "bbbb", "sender": "a@yelp.com"},
    {"receiver": "a@yelp.com", "msg": "aaaa", "sender": "b@yelp.com"},
"""
yelp_lover_messages = [
    {"receiver": "a@yelp.com", "msg": "aaaa", "sender": "b@yelp.com"},
    {"receiver": "b@yelp.com", "msg": "aaaa", "sender": "e@yelp.com"},
    {"receiver": "b@yelp.com", "msg": "bbbb", "sender": "a@yelp.com"},
    {"receiver": "b@yelp.com", "msg": "ccc", "sender": "c@yelp.com"},
    {"receiver": "c@yelp.com", "msg": "dddd", "sender": "a@yelp.com"},
    {"receiver": "c@yelp.com", "msg": "dddd", "sender": "b@yelp.com"},
    {"receiver": "c@yelp.com", "msg": "gggg", "sender": "d@yelp.com"},
    {"receiver": "a@yelp.com", "msg": "eeeee", "sender": "c@yelp.com"},
    {"receiver": "a@yelp.com", "msg": "I love spam", "sender": "c@yelp.com"},
    {"receiver": "a@yelp.com", "msg": "I love spam", "sender": "c@yelp.com"},
    {"receiver": "d@yelp.com", "msg": "I love spam", "sender": "b@yelp.com"},
    {"receiver": "a@yelp.com", "msg": "I love spam", "sender": "c@yelp.com"},
    {"receiver": "a@yelp.com", "msg": "I love spam", "sender": "c@yelp.com"},
    {"receiver": "a@yelp.com", "msg": "I love spam 1", "sender": "c@yelp.com"},
    {"receiver": "a@yelp.com", "msg": "I love spam 2", "sender": "c@yelp.com"},
    {"receiver": "a@yelp.com", "msg": "I love spam 3", "sender": "c@yelp.com"},
]

from collections import defaultdict


def find_emp(yelp_lover_messages, k):
    # find the spam user
    spam_users = set()
    unique_messages = set()
    for message in yelp_lover_messages:
        pair_message = (message["sender"], message["msg"])
        if pair_message in unique_messages:
            spam_users.add(pair_message[0])
        else:
            unique_messages.add(pair_message)

    message_map = defaultdict(int)
    for message in yelp_lover_messages:
        receiver, sender, msg = message['receiver'], message['sender'], message['msg']
        if sender in spam_users: continue
        message_map[receiver] += 1

    message_arr = [(-count, receiver) for receiver, count in message_map.items()]
    heapq.heapify(message_arr)
    most_receivers = []
    for _ in range(k):
        message = heapq.heappop(message_arr)
        most_receivers.append((message[1], -message[0]))

    print(message_arr)
    print(message_map)
    return most_receivers


if __name__ == '__main__':
    print(find_emp(yelp_lover_messages, 4))
