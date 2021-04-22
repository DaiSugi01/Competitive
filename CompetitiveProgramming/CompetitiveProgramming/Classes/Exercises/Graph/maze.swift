//
//  Maze.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/21.
//

import Foundation

func maze() {
  
  struct Square {
    let x: Int
    let y: Int
  }
  
  let input = readLine()!.split(separator: " ").map { Int($0)! }
  let n = input[0]
  let m = input[1]
  
  var mazeMap = [[Int]]()
  var coloreMap = [[Int]](repeating: [Int](repeating: 0, count: m), count: n)
  
  for _ in 0 ..< n {
    let ip = Array(readLine()!).map { Int(String($0))! }
    mazeMap.append(ip)
  }
  
  let dx = [1, 0, -1, 0]
  let dy = [0, 1, 0, -1]
  
  func bfs(square: Square) {
    var count = 1
    let q = Queue<Square>()
    q.enqueue(item: square)
    coloreMap[square.x][square.y] = count
    
    while !q.isEmpty() {
      let sq = q.dequeue()!
      let x = sq.x
      let y = sq.y

      count += 1
      for i in 0 ..< 4 {
        let nx = x + dx[i]
        let ny = y + dy[i]
        if nx < 0 || nx >= n || ny < 0 || ny >= m { continue }
        if coloreMap[nx][ny] == 0 && mazeMap[nx][ny] == 1 {
          coloreMap[nx][ny] = count
          q.enqueue(item: Square(x: nx, y: ny))
        }
      }
    }
  }
  
  bfs(square: Square(x: 0, y: 0))
  print(coloreMap[n - 1][m - 1])
}
