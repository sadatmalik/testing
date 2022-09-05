package com.sadatmalik.football;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FootballTeamTest {

    private static final int THREE_GAMES_WON = 3;

    @Test
    public void constructorShouldSetGamesWon() {
        FootballTeam team = new FootballTeam(THREE_GAMES_WON);
        assertEquals(THREE_GAMES_WON, team.getGamesWon(), () ->
                THREE_GAMES_WON + " games passed to constructor, but "
                + team.getGamesWon() +
                " were returned by team.getGamesWon()");
    }


}