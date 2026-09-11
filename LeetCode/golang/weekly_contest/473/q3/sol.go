package q3

/*
Q3. Stable Subarrays With Equal Boundary and Interior Sum
Attempted
Medium
5 pt.
You are given an integer array capacity.

A subarray capacity[l..r] is considered stable if:

Its length is at least 3.
The first and last elements are each equal to the sum of all elements strictly between them (i.e., capacity[l] = capacity[r] = capacity[l + 1] + capacity[l + 2] + ... + capacity[r - 1]).
Return an integer denoting the number of stable subarrays.

Example 1:

Input: capacity = [9,3,3,3,9]

Output: 2

Explanation:

[9,3,3,3,9] is stable because the first and last elements are both 9, and the sum of the elements strictly between them is 3 + 3 + 3 = 9.
[3,3,3] is stable because the first and last elements are both 3, and the sum of the elements strictly between them is 3.
Example 2:

Input: capacity = [1,2,3,4,5]

Output: 0

Explanation:

No subarray of length at least 3 has equal first and last elements, so the answer is 0.

Example 3:

Input: capacity = [-4,4,0,0,-8,-4]

Output: 1

Explanation:

[-4,4,0,0,-8,-4] is stable because the first and last elements are both -4, and the sum of the elements strictly between them is 4 + 0 + 0 + (-8) = -4

Constraints:

3 <= capacity.length <= 105
-109 <= capacity[i] <= 109

Copyright © 2025 LeetCode. All rights reserved.©leetcode
*/
func countStableSubarrays(capacity []int) int64 {
	n := len(capacity)
	if n < 3 {
		return 0
	}

	// prefix: P[k] = sum of capacity[0..k-1], P[0]=0
	prefix := make([]int64, n+1)
	for i := 0; i < n; i++ {
		prefix[i+1] = prefix[i] + int64(capacity[i])
	}

	type key struct {
		val int64 // A[i]
		pfx int64 // P[i+1]
	}
	cnt := make(map[key]int64)

	var ans int64
	for j := 0; j < n; j++ {
		// 有効にできる i は j-2 まで。j に来たタイミングで i = j-2 を map に追加。
		i := j - 2
		if i >= 0 {
			k := key{val: int64(capacity[i]), pfx: prefix[i+1]}
			cnt[k]++
		}

		// 長さ >=3 が必要なので j >= 2 のときだけ数える
		if j >= 2 {
			need := key{
				val: int64(capacity[j]),             // A[j]
				pfx: prefix[j] - int64(capacity[j]), // P[j]-A[j]
			}
			ans += cnt[need]
		}
	}

	return ans
}

func CountStableSubarrays(capacity []int) int64 {
	return countStableSubarrays(capacity)
}

/*
9,3,3,3,9,1,3

[3,6,X9,18,19,21] 4-0-1=3
[0,X3,6,15,16,18] 3-1-1=1, 6-1-1=4
[0,0,3,12,13,15]
[0,0,0,9,10,12]
[0,0,0,0,1,3]



*/
