package com.example.sprint1.Models;

import android.content.Context;

public class Collision {

    /*
     * Using the isColliding() method, determines the amount of health to subtract from the
     * player depending on if a collision is observed, and the difficulty
     *
     * @param context the context of the activity
     * @param player the player sprite/character
     * @param enemy1 one of the two enemies located in each room
     * @param enemy2 one of the two enemies located in each room
     */
    public static void checkCollision(Context context, Player player, Enemy enemy1, Enemy enemy2) {
        if (isColliding(player, enemy1) || isColliding(player, enemy2)) {
            if (player.getDifficulty() == 1) {
                player.setHealth(player.getHealth() - 15);
            } else if (player.getDifficulty() == 0.75) {
                player.setHealth(player.getHealth() - 12);
            } else {
                player.setHealth(player.getHealth() - 10);
            }
        }
    } // checkCollision

    /*
     * Uses the observer pattern to check if the player is colliding with an enemy
     *
     * @param player the player sprite/character
     * @param enemy one of the enemy sprites/entity
     * @return boolean containing whether player is colliding or not
     */
    private static boolean isColliding(Player player, Enemy enemy) {
        return player.notifyHealth(player, enemy);
    }


}
