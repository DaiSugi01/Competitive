//
//  100.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/22.
//

import Foundation

// LeetCode: https://leetcode.com/problems/same-tree/
func isSameTree(_ p: TreeNode?, _ q: TreeNode?) -> Bool {
    var p1 = [Int]()
    var p2 = [Int]()
    
    func preOrder(_ root: TreeNode?, _ arr: inout [Int]) {
        guard let node = root else {
            arr.append(-1)
            return
        }
        
        arr.append(node.val)
        preOrder(node.left, &arr)
        preOrder(node.right, &arr)
    }
    
    preOrder(p, &p1)
    preOrder(q, &p2)
    if p1.count != p2.count { return false }
    
    for i in 0 ..< p1.count {
        if p1[i] != p2[i] { return false }
    }
    
    return true
}

