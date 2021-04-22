//
//  Work2.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/17.
//

import Foundation

func test() {
  let blocks = [
    ["gym": false, "school": true, "store": false],
    ["gym": true, "school": false, "store": false],
    ["gym": true, "school": true, "store": false],
    ["gym": false, "school": true, "store": false],
    ["gym": false, "school": true, "store": true]
  ]
  let reqs = ["gym", "school", "store"]

  var minCost = Int.max
  var res = -1
  
  for start in 0 ..< blocks.count {
    var i = start - 1, j  = start + 1
    var cost = 0
    var isMeets = blocks[start]
    
    while i >= 0 || j < blocks.count {
      if isMeets.values.filter({ $0 }).count == reqs.count { break }
      if i >= 0 {
        for buildingName in reqs {
          if blocks[i][buildingName]! {
            isMeets[buildingName] = true
          }
        }
        i -= 1
      }
      
      if j < blocks.count {
        for buildingName in reqs {
          if blocks[j][buildingName]! {
            isMeets[buildingName] = true
          }
        }
        j += 1
      }
      cost += 1
    }
    
    
    if isMeets.values.filter({ $0 }).count == reqs.count && cost < minCost {
      minCost = cost
      res = start
    }
  }
  print(res)
}
