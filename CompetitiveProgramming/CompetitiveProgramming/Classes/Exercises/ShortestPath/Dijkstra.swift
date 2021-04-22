//
//  Dijkstra.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/22.
//

import Foundation

func Dijkstra() {
  
  func dijkstra(_ adj: [[DijkstraEdge]], _ src: Int) -> [Int] {
    let n = adj.count
    var dist = [Int](repeating: Int.max, count: n)
    dist[src] = 0
    
    var pq = IndexPriorityQueue<DijkstraEdge>(<)
    for edge in adj[src] {
      pq.enqueue(edge)
    }
    
    while !pq.isEmpty {
      let edge = pq.dequeue()!
      if edge.w < dist[edge.v] {
        dist[edge.v] = edge.w
        for e in adj[edge.v] {
          pq.enqueue(DijkstraEdge(v: e.v, w: e.w + edge.w))
        }
      }
    }
    
    return dist
  }
  
  let adj = [
    [],
    [DijkstraEdge(v: 2, w: 2), DijkstraEdge(v: 5, w: 5)],
    [DijkstraEdge(v: 1, w: 2), DijkstraEdge(v: 3, w: 3), DijkstraEdge(v: 4, w: 8), DijkstraEdge(v: 5, w: 1)],
    [DijkstraEdge(v: 2, w: 3), DijkstraEdge(v: 4, w: 1), DijkstraEdge(v: 7, w: 4)],
    [DijkstraEdge(v: 2, w: 8), DijkstraEdge(v: 3, w: 1), DijkstraEdge(v: 5, w: 4), DijkstraEdge(v: 6, w: 1), DijkstraEdge(v: 7, w: 5)],
    [DijkstraEdge(v: 1, w: 5), DijkstraEdge(v: 2, w: 1), DijkstraEdge(v: 4, w: 5)],
    [DijkstraEdge(v: 4, w: 1), DijkstraEdge(v: 7, w: 1)],
    [DijkstraEdge(v: 3, w: 4), DijkstraEdge(v: 4, w: 5), DijkstraEdge(v: 6, w: 1)]
  ]
  
  print(dijkstra(adj, 1))
}

struct DijkstraEdge {
  let v: Int
  let w: Int
}

extension DijkstraEdge: Comparable {
  static func < (lhs: DijkstraEdge, rhs: DijkstraEdge) -> Bool {
    return lhs.w < rhs.w
  }
}

extension DijkstraEdge: Hashable {}
