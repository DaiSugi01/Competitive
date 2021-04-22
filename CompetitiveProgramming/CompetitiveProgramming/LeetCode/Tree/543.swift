//
//  543.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/22.
//

import Foundation

// LeetCode: https://leetcode.com/problems/diameter-of-binary-tree/
func diameterOfBinaryTree(_ root: TreeNode?) -> Int {
  
  var adj = [[Int]](repeating: [Int](), count: 100001)
  
  func preOrder(_ node: TreeNode?) {
    guard let node = node else { return }

    
    if node.left != nil {
      adj[node.val].append(node.left!.val)
      adj[node.left!.val].append(node.val)
      preOrder(node.left)
    }
    
    if node.right != nil {
      adj[node.val].append(node.right!.val)
      adj[node.right!.val].append(node.val)
      preOrder(node.right)
    }
  }
  
  func bfs(_ node: Int, _ dis: inout [Int]) {
    var visited = [Bool](repeating: false, count: 100001)
    let q = Queue<Int>()
    q.enqueue(item: node)

    while !q.isEmpty() {
      let u = q.dequeue()!
      visited[u] = true
      for v in adj[u] {
        if !visited[v] {
          q.enqueue(item: v)
          dis[v] = dis[u] + 1
        }
      }
    }
  }
  
  preOrder(root)
  
  var dis1 = [Int](repeating: 1, count: 100001)
  bfs(1, &dis1)

  var maxCnt = 0
  var idx = 0
  for i in 0 ..< dis1.count {
    if dis1[i] > maxCnt {
      maxCnt = dis1[i]
      idx = i
    }
  }
  
  var dis2 = [Int](repeating: 0, count: 100001)
  bfs(idx, &dis2)

  return dis2.max()!
}
