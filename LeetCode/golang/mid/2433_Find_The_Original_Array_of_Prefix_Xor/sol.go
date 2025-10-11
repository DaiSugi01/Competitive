package _433_Find_The_Original_Array_of_Prefix_Xor

// https://leetcode.com/problems/find-the-original-array-of-prefix-xor/
func findArray(pref []int) []int {
	n := len(pref)
	res := make([]int, n)
	res[0] = pref[0]
	for i := 1; i < n; i++ {
		res[i] = pref[i] ^ pref[i-1]
	}

	return res
}

func FindArray(pref []int) []int {
	return findArray(pref)
}
