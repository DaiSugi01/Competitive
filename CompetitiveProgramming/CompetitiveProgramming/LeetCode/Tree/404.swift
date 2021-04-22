//
//  404.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/22.
//

import Foundation

// LeetCode: https://leetcode.com/problems/sum-of-left-leaves/
func sumOfLeftLeaves(_ root: TreeNode?) -> Int {
  
  var sum = 0
  func preOrder(_ root: TreeNode?, isLeft: Bool) {
    guard let root = root else { return }
    
    if isLeft && root.left == nil && root.right == nil {
      sum += root.val
    }
    
    preOrder(root.left, isLeft: true)
    preOrder(root.right, isLeft: false)
  }
  
  preOrder(root, isLeft: false)
  return sum
}
