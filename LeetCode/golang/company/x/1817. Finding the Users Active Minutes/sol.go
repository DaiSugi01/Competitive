package _817__Finding_the_Users_Active_Minutes

func findingUsersActiveMinutes(logs [][]int, k int) []int {
	memo := make(map[int]userMinutesMap)
	for _, log := range logs {
		userID := log[0]
		minutes := log[1]
		if userMinutes, ok := memo[userID]; ok {
			userMinutes[minutes] = struct{}{}
		} else {
			memo[userID] = map[int]struct{}{minutes: {}}
		}
	}

	res := make([]int, k)
	for _, minutes := range memo {
		if len(minutes) > 0 {
			res[len(minutes)-1]++
		}
	}

	return res
}

type userMinutesMap map[int]struct{}
