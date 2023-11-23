package com.example.sprint4;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.example.DungeonCrawler.Models.CollisionObserver;
import com.example.DungeonCrawler.Models.Enemy;
import com.example.DungeonCrawler.Models.EnemyFactory;
import com.example.DungeonCrawler.Models.Player;
import com.example.DungeonCrawler.R;
import com.example.DungeonCrawler.ViewModels.GameScreen;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class TejaTest {


    @Test
    public void collisionObserver() {
        Player player = Player.getPlayer("TestPlayer", 0.75, null);
        GameScreen gameScreen = new GameScreen();
        gameScreen.getPlayer(); //observer
        assertNotNull(player); //makes sure player is not null

        // if Player Class (Observer) implements ScoreObserver interface
        List<Class<?>> interfaces = Arrays.asList(player.getClass().getInterfaces());
        assertTrue(interfaces.contains(CollisionObserver.class));

    }
    

    @Test
    public void testEnemyInterface() {
        assertEnemyImplementsInterface(EnemyFactory.createEnemy(1, 1.0, null), Enemy.class);
        assertEnemyImplementsInterface(EnemyFactory.createEnemy(2, 1.0, null), Enemy.class);
        assertEnemyImplementsInterface(EnemyFactory.createEnemy(3, 1.0, null), Enemy.class);
        assertEnemyImplementsInterface(EnemyFactory.createEnemy(4, 1.0, null), Enemy.class);
        assertNull(EnemyFactory.createEnemy(5, 1.0, null));
    }

    private void assertEnemyImplementsInterface(Enemy enemy, Class<?> interfaceClass) {
        assertNotNull(enemy);
        assertTrue(interfaceClass.isAssignableFrom(enemy.getClass()));
    }


}
