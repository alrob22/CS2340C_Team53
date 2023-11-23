package com.example.DungeonCrawler.Models;

import android.widget.ImageView;

public interface CollisionObserver {
    public boolean alertCollision(Player player, Enemy enemy);

    public boolean alertPowerupCollision(Player player, ImageView powerupImage, PowerUpDecorator powerup);
}
