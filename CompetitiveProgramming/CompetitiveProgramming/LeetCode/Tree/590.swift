//
//  590.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/22.
//

import Foundation

// LeetCode: https://leetcode.com/problems/n-ary-tree-postorder-traversal/
func postorder(_ root: Node?) -> [Int] {
  
  var res = [Int]()
  
  func dfs(_ node: Node?) {
    guard let node = node else { return }
    
    let children = node.children
    for v in children {
      dfs(v)
    }
    res.append(node.val)
  }
  
  dfs(root)
  
  return res
}
