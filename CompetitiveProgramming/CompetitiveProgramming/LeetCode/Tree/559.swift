//
//  559.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/22.
//

import Foundation

// LeetCode: https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
func maxDepth(_ root: Node?) -> Int {
  guard let root = root else { return 0 }
  var dist = [Int](repeating: 1, count: 10001)
  let q = Queue<Node>()
  q.enqueue(item: root)
  
  while !q.isEmpty() {
    let u = q.dequeue()!
    for v in u.children {
      dist[v.val] = dist[u.val] + 1
      q.enqueue(item: v)
    }
  }
  
  return dist.max()!
}
