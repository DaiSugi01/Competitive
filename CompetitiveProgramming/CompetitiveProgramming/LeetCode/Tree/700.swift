//
//  700.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/22.
//

import Foundation

// LeetCode: https://leetcode.com/problems/search-in-a-binary-search-tree/
func searchBST(_ root: TreeNode?, _ val: Int) -> TreeNode? {
  
  func rec(_ node: TreeNode?, _ val: Int) -> TreeNode? {
    guard let node = node else { return nil }
    
    if val == node.val {
      return node
    } else if val < node.val {
      return rec(node.left, val)
    } else {
      return rec(node.right, val)
    }
  }
  
  return rec(root, val)
}
