# https://leetcode.com/problems/insert-delete-getrandom-o1/
class RandomizedSet:

    def __init__(self):
        self.dic = {}
        self.nums = []

    def insert(self, val: int) -> bool:
        if val in self.dic:
            return False

        self.dic[val] = len(self.nums)
        self.nums.append(val)
        return True

    def remove(self, val: int) -> bool:
        if val not in self.dic:
            return False
        last_idx, target_idx = len(self.nums) - 1, self.dic[val]
        self.nums[last_idx], self.nums[target_idx] = self.nums[target_idx], self.nums[last_idx]
        self.dic[self.nums[target_idx]] = target_idx
        self.nums.pop()
        del self.dic[val]
        return True

    def getRandom(self) -> int:
        random_int = int(random.uniform(0, len(self.nums)))
        return self.nums[random_int]

# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()