//
//  589.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/22.
//

import Foundation

// LeetCode: https://leetcode.com/problems/n-ary-tree-preorder-traversal/
func preorder(_ root: Node?) -> [Int] {
  
  var res = [Int]()
  func dfs(_ node: Node?) {
    guard let node = node else { return }
    
    res.append(node.val)
    let children = node.children
    for v in children {
      dfs(v)
    }
  }
  
  dfs(root)

  return res
}
