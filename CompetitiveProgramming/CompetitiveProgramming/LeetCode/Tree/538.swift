//
//  538.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/22.
//

import Foundation

// LeetCode: https://leetcode.com/problems/convert-bst-to-greater-tree/
func convertBST(_ root: TreeNode?) -> TreeNode? {
  var sum = 0
  
  func inOrder(node: TreeNode?) {
    guard let node = node else {
      return
    }
    
    inOrder(node: node.right)
    sum += node.val
    node.val = sum
    inOrder(node: node.left)
  }
  
  let resRoot = root
  inOrder(node: root)

  return resRoot
}
