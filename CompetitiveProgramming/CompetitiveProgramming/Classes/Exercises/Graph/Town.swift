//
//  Town.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/21.
//

import Foundation

func town() {
  struct Position {
    let x: Int
    let y: Int
  }
  
  let n = Int(readLine()!)!
  var townMap = [[Int]]()
  var coloredMap = [[Int]](repeating: [Int](repeating: 0, count: n), count: n)
  var houses = [Int](repeating: 0, count: n * n)
  for _ in 0 ..< n {
    let tmp = Array(readLine()!).map { Int(String($0))! }
    townMap.append(tmp)
  }
  
  let dy = [-1, 0, 1, 0]
  let dx = [0, 1, 0, -1]
  
  func bfs(p: Position, id: Int) {
    let q = Queue<Position>()
    q.enqueue(item: p)
    coloredMap[p.x][p.y] = id
    
    while !q.isEmpty() {
      let u = q.dequeue()!
      let x = u.x
      let y = u.y
      for i in 0 ..< 4 {
        let nx = x + dx[i]
        let ny = y + dy[i]
        if nx < 0 || nx >= n || ny < 0 || ny >= n {
          continue
        }
        
        if townMap[nx][ny] == 1 && coloredMap[nx][ny] == 0 {
          q.enqueue(item: Position(x: nx, y: ny))
          coloredMap[nx][ny] = id
          houses[id] += 1
        }
      }
    }
  }

  var id = 0
  for x in 0 ..< n {
    for y in 0 ..< n {
      if townMap[x][y] == 1 && coloredMap[x][y] == 0 {
        id += 1
        bfs(p: Position(x: x, y: y), id: id)
      }
    }
  }
  
  for i in coloredMap {
    print(i)
  }
}
