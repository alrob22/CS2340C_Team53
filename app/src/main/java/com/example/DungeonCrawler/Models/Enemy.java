package com.example.DungeonCrawler.Models;

import android.widget.ImageView;

public interface Enemy extends EntityMovement {
    int getHealth();
    double getDifficulty();
    int getCharacterID();
    float getMovementSpeed();
    float getX();
    float getY();
    void setHealth(int newHealth);
    void setCharacter(ImageView charc);
    void setX(float x);
    void setY(float y);
    boolean getActive();
    void setActive(boolean active);
}
