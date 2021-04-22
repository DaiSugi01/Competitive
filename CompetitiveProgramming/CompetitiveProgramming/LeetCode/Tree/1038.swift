//
//  1038.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/22.
//

import Foundation

// LeetCode: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/submissions/
//func bstToGst(_ root: TreeNode?) -> TreeNode? {
//  var sum = 0
//  var sums = [Int](repeating: 0, count: 101)
//
//  func preOrder(node: TreeNode?) {
//    guard let node = node else {
//      return
//    }
//
//    preOrder(node: node.right)
//    sums[node.val] = sum + node.val
//    sum += node.val
//    preOrder(node: node.left)
//  }
//
//  func updateTree(_ node: TreeNode?) {
//    guard let node = node else { return }
//
//    node.val = sums[node.val]
//    updateTree(node.left)
//    updateTree(node.right)
//  }
//
//  let resRoot = root
//  preOrder(node: root)
//  updateTree(resRoot)
//
//  return resRoot
//}

func bstToGst(_ root: TreeNode?) -> TreeNode? {
  var sum = 0
  
  func preOrder(node: TreeNode?) {
    guard let node = node else {
      return
    }
    
    preOrder(node: node.right)
    sum += node.val
    node.val = sum
    preOrder(node: node.left)
  }
  
  let resRoot = root
  preOrder(node: root)

  return resRoot
}
