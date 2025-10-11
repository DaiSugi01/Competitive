package _161_Partition_Array_According_to_Given_Pivot

type memoIdx struct {
	Index int
	Value int
	Left  bool
	Right bool
}

//func pivotArray(nums []int, pivot int) []int {
//	memo := make([]memoIdx, 0, len(nums))
//	var l, r, c int
//	for _, num := range nums {
//		if num < pivot {
//			memo = append(memo, memoIdx{l, num, true, false})
//			l++
//		} else if num > pivot {
//			memo = append(memo, memoIdx{r, num, false, true})
//			r++
//		} else {
//			memo = append(memo, memoIdx{c, num, false, false})
//			c++
//		}
//	}
//
//	for _, mi := range memo {
//		if mi.Left {
//			nums[mi.Index] = mi.Value
//		} else if mi.Right {
//			nums[l+c+mi.Index] = mi.Value
//		} else {
//			nums[l+mi.Index] = mi.Value
//		}
//	}
//
//	return nums
//}

func pivotArray(nums []int, pivot int) []int {
	res := make([]int, len(nums))
	n := len(nums)
	l := 0
	r := n - 1
	for i := 0; i < n; i++ {
		if nums[i] < pivot {
			res[l] = nums[i]
			l++
		}
		if nums[n-1-i] > pivot {

			res[r] = nums[n-1-i]
			r--
		}
	}

	for l <= r {
		res[l] = pivot
		l++
	}

	return res
}
