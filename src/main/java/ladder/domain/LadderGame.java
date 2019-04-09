package ladder.domain;

import java.util.List;

public class LadderGame {
    public static final String LADDER_WIDTH = "-----";
    public static final String LADDER_EMPTY_WIDTH = "     ";
    public static final String LADDER_SIDE = "|";
    public static final int DEFAULT_LADDER_WIDTH = 5;
    public static final int DEFAULT_DRAW_TIME = 1;
    private Players players;
    private Ladder ladder;

    public LadderGame(List<String> players, int height) {
        this.players = new Players(players);
        this.ladder = new Ladder(players.size(), height);
    }

    public int maxtWidthDrawTimes() {
        return getWidthDrawTimes();
    }

    private int getWidthDrawTimes() {
        return (players.maxNameLength() / DEFAULT_LADDER_WIDTH) + DEFAULT_DRAW_TIME;
    }

    public List<Line> ladder() {
        return ladder.getLines();
    }

    public List<Player> players() {
        return players.getPlayers();
    }
}
