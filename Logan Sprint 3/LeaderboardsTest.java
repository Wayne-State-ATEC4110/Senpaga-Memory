package me.logan.senpagamemory;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class LeaderboardsTest {

    @Test
    public void chooseLeaderboardToView() {
        Leaderboards leaderboards = new Leaderboards();
        assertEquals(1, leaderboards.chooseLeaderboardToView());
    }

    @Test
    public void printLeaderboard() {
        Leaderboards leaderboards = new Leaderboards();
        leaderboards.loadLeaderboard(1);
        leaderboards.printLeaderboard();
    }

    @Test
    public void loadLeaderboard() {
        Leaderboards leaderboards = new Leaderboards();
        leaderboards.loadLeaderboard(1);
        assertEquals(4, leaderboards.leaderboard.size());
    }
}
