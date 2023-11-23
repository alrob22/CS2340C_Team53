package com.example.sprint4;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;
import static junit.framework.TestCase.assertTrue;

import com.example.DungeonCrawler.Models.Enemy;
import com.example.DungeonCrawler.Models.EnemyNecromancer;
import com.example.DungeonCrawler.R;

import org.junit.Test;

public class OwenTest {
        @Test
        public void testEnemyMovement() {
            Enemy enemy1 = new EnemyNecromancer(0.5, null);

            assertEquals(enemy1.getY(), 0.0f);
            assertEquals(enemy1.getX(), 0.0f);

            enemy1.move();

            assertNotSame(enemy1.getY(), 0.0f);
            assertNotSame(enemy1.getX(), 0.0f);

        }

        @Test
        public void testEnemyMovement2() {

            Enemy enemy1 = new EnemyNecromancer(0.5, null);

            assertEquals(enemy1.getY(), 0.0f);
            assertEquals(enemy1.getX(), 0.0f);

            enemy1.changePos(10f, 10f);

            assertTrue(enemy1.getY() > 0.0f);
            assertTrue(enemy1.getX() > 0.0f);

        }
    }
