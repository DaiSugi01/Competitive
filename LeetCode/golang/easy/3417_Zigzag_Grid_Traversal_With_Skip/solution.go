package _417_Zigzag_Grid_Traversal_With_Skip

// https://leetcode.com/problems/zigzag-grid-traversal-with-skip/submissions/1613634433/
func zigzagTraversal(grid [][]int) []int {
	res := make([]int, 0)

	goToRight := true
	var row, col, p int
	for row < len(grid) {
		if p%2 == 0 {
			res = append(res, grid[row][col])
		}

		if goToRight {
			col++
		} else {
			col--
		}

		if col == len(grid[0]) {
			row++
			col = len(grid[0]) - 1
			goToRight = false
		} else if col < 0 {
			row++
			col = 0
			goToRight = true
		}
		p++
	}

	return res
}
