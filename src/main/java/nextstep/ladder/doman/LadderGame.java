package nextstep.ladder.doman;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private static final int ZERO = 0;

    private final List<Line> lines;

    public LadderGame(Participants participants, LadderHeight ladderHeight, RandomConnectStrategy randomConnectStrategy) {
        this.lines = makeLines(ladderHeight, participants, randomConnectStrategy);
    }

    private List<Line> makeLines(LadderHeight ladderHeight, Participants participants, RandomConnectStrategy randomConnectStrategy) {
        return IntStream.range(ZERO, ladderHeight.getValue())
                .mapToObj(x -> new Line(participants, randomConnectStrategy))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return lines.stream().map(Line::toString).collect(Collectors.joining("\n"));
    }
}
