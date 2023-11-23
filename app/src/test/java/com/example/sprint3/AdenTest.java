package com.example.sprint3;
import static junit.framework.TestCase.assertEquals;
import com.example.DungeonCrawler.Models.Player;

import org.junit.Test;

public class AdenTest {
    @Test
    public void testInitX() {
        Player player = Player.getPlayer("name", 1.0, null);

        assertEquals(player.getInitX(), 0.0f);
    }

    @Test
    public void testInitY() {
        Player player = Player.getPlayer("name", 1.0, null);

        assertEquals(player.getInitY(), 0.0f);
    }
}
