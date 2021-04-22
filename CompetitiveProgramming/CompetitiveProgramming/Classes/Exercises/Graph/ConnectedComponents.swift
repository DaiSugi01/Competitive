//
//  ConnectedComponents.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/21.
//

import Foundation

func connectedComponents() {
  
  let firstLine = readLine()!.split(separator: " ").map { Int($0)! }
  let n = firstLine[0]
  let m = firstLine[1]
  var adj = [[Int]](repeating: [Int](), count: n + 1)
  
  for _ in 0 ..< m {
    let ip = readLine()!.split(separator: " ").map { Int($0)! }
    let u = ip[0]
    let v = ip[1]
    adj[u].append(v)
  }
  
  var visited = [Bool](repeating: false, count: n + 1)
  let q = Queue<Int>()
  var cnt = 0
  
  for i in 1 ..< adj.count {
    if visited[i] { continue }
    q.enqueue(item: i)
    
    while !q.isEmpty() {
      let u = q.dequeue()!
      visited[u] = true
      for v in adj[u] {
        if !visited[v] {
          q.enqueue(item: v)
        }
      }
    }
    
    cnt += 1
  }
  print(cnt)
}
