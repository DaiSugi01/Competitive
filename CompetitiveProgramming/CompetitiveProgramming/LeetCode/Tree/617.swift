//
//  617.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/22.
//

import Foundation

// LeetCode: https://leetcode.com/problems/merge-two-binary-trees/
func mergeTrees(_ root1: TreeNode?, _ root2: TreeNode?) -> TreeNode? {

  if root1 == nil {
    return root2
  } else if root2 == nil {
    return root1
  }
  
  root1!.val += root2!.val
  root1!.left = mergeTrees(root1!.left, root2!.left)
  root1!.right = mergeTrees(root1!.right, root2!.right)
  
  return root1
}
