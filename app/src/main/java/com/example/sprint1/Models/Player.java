package com.example.sprint1.Models;

import android.widget.ImageView;

public class Player implements EntityMovement, ScoreObserver, MovementObserver, CollisionObserver {
    private String name;
    private int health;
    private double difficulty;
    private ImageView character;
    private static Player player;
    private boolean  active;
    private boolean attacking;
    private int speed;
    private boolean timeFreeze;

    private Player(String name, double diff, ImageView charc) {
        this.name = name;
        this.difficulty = diff;
        this.character = charc;
        health = 100;
        this.active = true;
        this.attacking = false;
        this.speed = 10;
        this.timeFreeze = false;

        if (difficulty == 1) {
            health = 100;
        } else if (difficulty == 0.75) {
            health = 150;
        } else if (difficulty == 0.5) {
            health = 200;
        } // if
    }

    /*
     * Utilizes the singleton design pattern to return the only existing player
     *
     * @param name the name of the player
     * @param difficulty the difficulty of the game
     * @param charc the character sprite of the player
     * @return Leaderboard the Leaderboard object
     */
    public static Player getPlayer(String name, double difficulty, ImageView charc) {
        if (player == null) {
            synchronized (Player.class) {
                if (player == null) {
                    player = new Player(name, difficulty, charc);
                }
            }
        }
        player.setName(name);
        player.setDifficulty(difficulty);
        player.setChar(charc);
        player.setHealth(100);
        player.setActiveTrue();
        player.setAttackingFalse();
        player.setSpeed(10);
        return player;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public float getX() {
        if (character != null) {
            return character.getX();
        } // if
        return getInitX();
    } // getX()

    public float getY() {
        if (character != null) {
            return character.getY();
        } // if
        return getInitY();
    }

    public float getInitX() {
        return 0.0f;
    }

    public float getInitY() {
        return 0.0f;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public boolean getActive() {
        return active;
    }

    public boolean getAttacking() {
        return attacking;
    }
    public int getSpeed() {
        return speed;
    }

    public boolean getTimeFreeze() {
        return timeFreeze;
    }

    public void setDifficulty(double diff) {
        this.difficulty = diff;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChar(ImageView character) {
        this.character = character;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setX(float x) {
        character.setX(x);
    }

    public void setY(float y) {
        character.setY(y);
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setActiveTrue() {
        this.active = true;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public void setAttackingFalse() {
        this.attacking = false;
    }
    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }

    public void setTimeFreeze(boolean timeFreeze) {
        this.timeFreeze = timeFreeze;
    }

    /*
     * Method to change the position of the player
     *
     * @param currX the new x position to set the player to
     * @param currY the new y position to set the player to
     */
    @Override
    public void changePos(float newX, float newY) {
        character.setY(newY);
        character.setX(newX);
    }

    //Might implement if we need to shrink game screen code
    @Override
    public void move() {

    }

    public void alert(int score) {
        if (score == 10) {
            setHealth(this.health + 10);
        }
    }


    public void notifyPlayer(float newX, float newY) {
        player.alertMovement(newX, newY);
    }

    @Override
    public void alertMovement(float newX, float newY) {
        character.setY(newY);
        character.setX(newX);
    }

    public boolean notifyHealth(Player player, Enemy enemy) {
        return player.alertCollision(player, enemy);

    }

    @Override
    public boolean alertCollision(Player player, Enemy enemy) {
        float playerX = player.getX();
        float playerY = player.getY();
        float enemyX = enemy.getX();
        float enemyY = enemy.getY();


        boolean isColliding = Math.abs(playerX - enemyX) < 50 && Math.abs(playerY - enemyY) < 50;

        return isColliding;
    }

    @Override
    public boolean alertPowerupCollision(Player player, ImageView powerupImage,
                                         PowerUpDecorator powerup) {
        float playerX = player.getX();
        float playerY = player.getY();
        float powerX = powerup.getX(powerupImage);
        float powerY = powerup.getY(powerupImage);

        boolean isColliding = Math.abs(playerX - powerX) < 50 && Math.abs(playerY - powerY) < 50;

        return isColliding;
    }





}
