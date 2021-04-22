//
//  Coin.swift
//  CompetitiveProgramming
//
//  Created by 杉原大貴 on 2021/04/02.
//

import Foundation

func coin() {
  let coinType = [1, 5, 10, 50, 100, 500]
  var bill = 620
  let coins = [3, 2, 1, 3, 1, 2]
  
  var ans = 0
  
  for i in (0...5).reversed() {
    let total = min(bill / coinType[i], coins[i])
    bill -= total * coinType[i]
    ans += total
  }
  
  print(ans)
}
