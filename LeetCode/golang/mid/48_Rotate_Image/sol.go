package _48_Rotate_Image

/*
https://leetcode.com/problems/rotate-image/
48. Rotate Image
Medium
Topics
premium lock icon
Companies
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:

Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
*/
func rotate(matrix [][]int) {
	nums := make([]int, len(matrix)*len(matrix))
	p := 0
	for c := 0; c < len(matrix); c++ {
		for r := len(matrix) - 1; r >= 0; r-- {
			nums[p] = matrix[r][c]
			p++
		}
	}

	p = 0
	for r := 0; r < len(matrix); r++ {
		for c := 0; c < len(matrix); c++ {
			matrix[r][c] = nums[p]
			p++
		}
	}
}

func rotate2(matrix [][]int) {
	n := len(matrix)
	for r := 0; r < n; r++ {
		for c := r + 1; c < n; c++ {
			matrix[r][c], matrix[c][r] = matrix[c][r], matrix[r][c]
		}
	}

	for i := 0; i < n; i++ {
		for l, r := 0, n-1; l < r; l, r = l+1, r-1 {
			matrix[i][l], matrix[i][r] = matrix[i][r], matrix[i][l]
		}
	}
}

func Sol() {
	rotate2([][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})
}
