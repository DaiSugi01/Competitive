//
//  257.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/22.
//

import Foundation

// LeetCode: https://leetcode.com/problems/binary-tree-paths/
func binaryTreePaths(_ root: TreeNode?) -> [String] {
  
  var res = [String]()
  func dfs(_ node: TreeNode?, _ soFar: String) {
    var soFar = soFar
    guard let node = node else {
      return
    }
    
    if node.left == nil && node.right == nil  {
      soFar.append("\(node.val)")
      res.append(soFar)
      return
    }
    
    soFar.append("\(node.val)->")
    dfs(node.left, soFar)
    dfs(node.right, soFar)
  }
  
  dfs(root, "")
  
  return res
}
