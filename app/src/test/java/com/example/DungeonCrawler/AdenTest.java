package com.example.DungeonCrawler;

import static junit.framework.TestCase.assertEquals;

import com.example.DungeonCrawler.ViewModels.GameScreen;
import com.example.DungeonCrawler.ViewModels.InitialConfiguration;

import org.junit.Test;

public class AdenTest {
    @Test
    public void testScore() {
        GameScreen gs = new GameScreen();

        assertEquals(0, gs.getScore());
    }

    @Test
    public void testName() {
        InitialConfiguration ic = new InitialConfiguration(null);

        assertEquals(false, ic.getIsAllFieldsChecked());
    }
}
