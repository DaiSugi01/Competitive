package _386_Button_with_Longest_Push_Time

// https://leetcode.com/problems/button-with-longest-push-time/submissions/1613906507/
func buttonWithLongestTime(events [][]int) int {
	res := events[0][0]
	maxDiff := events[0][1]
	for i := 1; i < len(events); i++ {
		idx := events[i][0]
		t := events[i][1]
		prevT := events[i-1][1]
		if t-prevT == maxDiff {
			res = min(res, idx)
		} else if t-prevT > maxDiff {
			maxDiff = t - prevT
			res = idx
		}
	}

	return res
}

func ButtonWithLongestTime(events [][]int) int {
	return buttonWithLongestTime(events)
}
