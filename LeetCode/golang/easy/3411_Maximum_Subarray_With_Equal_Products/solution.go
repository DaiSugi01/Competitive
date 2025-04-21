package _411_Maximum_Subarray_With_Equal_Products

// https://leetcode.com/problems/maximum-subarray-with-equal-products/submissions/1613731260/
func maxLength(nums []int) int {
	n := len(nums)
	if n < 2 {
		return n
	}

	primes := [4]int{2, 3, 5, 7}
	var cnt [4]int
	l, ans := 0, 2 // 長さ2の部分配列は常に valid

	// 右端 r を伸ばしつつ、素因数の重複があれば左端 l を詰める
	for r := 0; r < n; r++ {
		add(&cnt, nums[r], primes)
		for conflict(cnt) {
			remove(&cnt, nums[l], primes)
			l++
		}
		// window = nums[l..r]
		if length := r - l + 1; length > ans {
			ans = length
		}
	}
	return ans
}

// x の素因数 (primes に載っているもの) を cnt に足す
func add(cnt *[4]int, x int, primes [4]int) {
	for i, p := range primes {
		if x%p == 0 {
			cnt[i]++
			for x%p == 0 {
				x /= p
			}
		}
	}
}

// x の素因数を cnt から引く
func remove(cnt *[4]int, x int, primes [4]int) {
	for i, p := range primes {
		if x%p == 0 {
			cnt[i]--
			for x%p == 0 {
				x /= p
			}
		}
	}
}

// どれかの prime が 2 回以上出現していれば true
func conflict(cnt [4]int) bool {
	for _, c := range cnt {
		if c > 1 {
			return true
		}
	}
	return false
}
func MaxLength(nums []int) int {
	return maxLength(nums)
}
