package com.example.DungeonCrawler;

import static junit.framework.TestCase.assertEquals;

import android.widget.ImageView;

import com.example.DungeonCrawler.Models.Leaderboard;
import com.example.DungeonCrawler.Models.ScoreData;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import com.example.DungeonCrawler.Models.Player;
import com.example.DungeonCrawler.ViewModels.GameScreen;

import org.junit.Test;

public class AdiTest {
    @Test
    public void testLeaderboardSingleton() {
        // Get Today's Date
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateTime = dateFormat.format(calendar.getTime());

        // Create first leaderboard instance
        Leaderboard ldb = Leaderboard.getinstance();
        ldb.addScore(new ScoreData("score1", 100, 1, dateTime));

        // Create second leaderboard instance (should be equal to first)
        Leaderboard ldb2 = Leaderboard.getinstance();
        ldb.addScore(new ScoreData("score2", 50, 2, dateTime));

        // Check if singleton pattern was applied
        assertEquals(ldb2.getScore(0), ldb.getScore(0));
        assertEquals(ldb2.getScore(1), ldb.getScore(1));
    } // testLeaderboardSingleton

    @Test
    public void testPlayerSingleton() {
        GameScreen gs = new GameScreen();
        ImageView charc = new ImageView(null);

        Player p1 = Player.getPlayer("John", 1, charc);
        Player p2 = Player.getPlayer("Joshua", 2, charc);

        assertEquals(p1.getName(), p2.getName());
        assertEquals(p1.getHealth(), p2.getHealth());
    } // testPlayerSingleton
}