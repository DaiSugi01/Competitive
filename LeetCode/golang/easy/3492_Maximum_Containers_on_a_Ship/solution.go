package maximum_Containers_on_a_Ship

func maxContainers(n int, w int, maxWeight int) int {
	weight := maxWeight / w
	cells := n * n

	return min(weight, cells)
}
