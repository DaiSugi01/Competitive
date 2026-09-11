package q1

func removeZeros(n int64) int64 {
	var ans []int64
	for n >= 10 {
		digit := n % 10
		if digit > 0 {
			ans = append(ans, digit)
		}
		n /= 10
	}

	if n > 0 {
		ans = append(ans, n)
	}

	var res int64
	for i := len(ans) - 1; i >= 0; i-- {
		res = res*10 + ans[i]
	}

	return res
}

func RemoveZeros(n int64) int64 {
	return removeZeros(n)
}
