//
//  1022.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/22.
//

import Foundation

func sumRootToLeaf(_ root: TreeNode?) -> Int {
  var nums = [String]()
  
  func dfs(_ node: TreeNode?, _ soFar: String) {
    guard let node = node else { return}
    
    dfs(node.left, soFar + "\(node.val)")
    dfs(node.right, soFar + "\(node.val)")
    
    if node.left == nil && node.right == nil {
      nums.append(soFar + "\(node.val)")
    }
  }
  
  dfs(root, "")
  
  var sum = 0
  for s in nums {
    sum += Int(s, radix: 10)!
  }
  
  return sum
}
