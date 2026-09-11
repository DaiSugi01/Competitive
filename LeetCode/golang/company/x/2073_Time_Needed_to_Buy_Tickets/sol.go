package _073_Time_Needed_to_Buy_Tickets

// https://leetcode.com/problems/time-needed-to-buy-tickets/?envType=company&envId=twitter&favoriteSlug=twitter-more-than-six-months
func timeRequiredToBuy(tickets []int, k int) int {
	//res := 0
	//for {
	//	for i := 0; i < len(tickets); i++ {
	//		if tickets[k] == 0 {
	//			return res
	//		}
	//		if tickets[i] > 0 {
	//			tickets[i]--
	//			res++
	//		}
	//	}
	//}

	var sum int
	target := tickets[k]
	for i, t := range tickets {
		if i <= k {
			sum += min(t, target)
		} else {
			sum += min(t, target-1)
		}
	}

	return sum
}

func TimeRequiredToBuy(tickets []int, k int) int {
	return timeRequiredToBuy(tickets, k)
}
