package main

import (
	"context"
	"fmt"
	"github.com/redis/go-redis/v9"
	"log"
	"time"
)

func test() {
	ctx := context.Background()
	// Redisクライアントの設定
	rdb := redis.NewClient(&redis.Options{
		Addr:     "localhost:6379", // Redisサーバーのアドレス
		Password: "",               // パスワードがあれば記載
		DB:       0,                // 使用するDB番号（通常は0）
	})

	// 投稿ID（例：post:123）の「いいね」数をINCR
	key := "likes:post:123"

	// Redisでカウントをインクリメント
	count, err := rdb.Incr(ctx, key).Result()
	if err != nil {
		log.Fatalf("INCR failed: %v", err)
	}

	// TTLも設定する（例：1時間後に自動削除）
	rdb.Expire(ctx, key, time.Hour)

	fmt.Printf("いいね数: %d\n", count)
}
