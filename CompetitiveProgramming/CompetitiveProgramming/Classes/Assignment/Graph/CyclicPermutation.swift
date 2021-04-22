//
//  CyclicPermutation.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/21.
//

import Foundation

func cyclicPermutation() {
  let n = Int(readLine()!)!
  
  for _ in 0 ..< n {
    
    let m = Int(readLine()!)!
//    var adj = [[Int]](repeating: [Int](), count: m + 1)
    var cnt = 0
    var adj = readLine()!.split(separator: " ").map { Int($0)! }
    adj.insert(0, at: 0)
    var visited = [Bool](repeating: false, count: m + 1)
    let q = Queue<Int>()
    
    for i in 1 ..< adj.count {
      if visited[i] { continue }
      q.enqueue(item: i)

      while !q.isEmpty() {
        let u = q.dequeue()!
        visited[u] = true
        
        let v = adj[u]
        if !visited[v] {
          q.enqueue(item: v)
        }
      }
      
      cnt += 1
    }
    print(cnt)
  }
  
}
