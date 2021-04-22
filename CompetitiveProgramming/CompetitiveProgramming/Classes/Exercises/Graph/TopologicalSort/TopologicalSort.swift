//
//  TopologicalSort.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/21.
//

import Foundation

// https://docs.google.com/presentation/d/1h-6FV3FsQy-ww4k0iU16vE2L8OsToR2Pbbal5gAsvqE/edit#slide=id.g549ecd9ea0_0_190
func topologicalSort() {
  let input = readLine()!.split(separator: " ").map { Int($0)! }
  let n = input[0]
  let m = input[1]
  
  var adj = [[Int]](repeating: [Int](), count: n + 1)
  var indegree = [Int](repeating: 0, count: n + 1)
  for _ in 0 ..< m {
    let ip = readLine()!.split(separator: " ").map { Int($0)! }
    let u = ip[0]
    let v = ip[1]
    adj[u].append(v)
    indegree[v] += 1
  }
  
  let q = Queue<Int>()
  for i in 1 ..< n {
    if indegree[i] == 0 {
      q.enqueue(item: i)
    }
  }
  
  while !q.isEmpty() {
    let u = q.dequeue()!
    print(u)
    for v in adj[u] {
      indegree[v] -= 1
      if indegree[v] == 0 {
        q.enqueue(item: v)
      }
    }
  }
}

func topologicalSortDAG() {
  let input = readLine()!.split(separator: " ").map { Int($0)! }
  let n = input[0]
  let m = input[1]
  
  var adj = [[Int]](repeating: [Int](), count: n + 1)
  var indegree = [Int](repeating: 0, count: n + 1)
  for _ in 0 ..< m {
    let ip = readLine()!.split(separator: " ").map { Int($0)! }
    let u = ip[0]
    let v = ip[1]
    adj[v].append(u)
    indegree[u] += 1
  }
  
  var checked = [Bool](repeating: false, count: n + 1)
  func dfs(_ u: Int) {
    checked[u] = true
    for v in adj[u] {
      if !checked[v] {
        dfs(v)
      }
    }
    print(u)
  }
  
  
  for i in adj {
    print(i)
  }
  print(indegree)
  func preDfs(_ u: Int) {
    print(u)
    for v in adj[u] {
      indegree[v] -= 1
      if indegree[v] == 0 {
        preDfs(v)
      }
    }
  }
  
  for i in 1 ... n {
    if indegree[i] == 0 {
      dfs(i)
    }
  }
  print("**********")
  for i in 1 ... n {
    if indegree[i] == 0 {
      preDfs(i)
    }
  }
}
