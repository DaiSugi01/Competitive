//
//  94.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/22.
//

import Foundation

// https://leetcode.com/problems/binary-tree-inorder-traversal/
func inorderTraversal(_ root: TreeNode?) -> [Int] {
  var res = [Int]()
  func inOrder(_ root: TreeNode?) {
    guard let node = root else { return }
    
    inOrder(node.left)
    res.append(node.val)
    inOrder(node.right)
  }
  
  inOrder(root)
  return res
}
