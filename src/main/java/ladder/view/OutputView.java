package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class OutputView {
    private static final int STRING_MAX_LENGTH = 6;
    private static final String SHOW_LADDER_MESSAGE = "\n사다리 결과\n";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String HORIZONTAL_BLANK = "     ";
    private static final String VERTICAL_LINE = "|";
    private static final String PARTICIPANTS_ALL = "ALL";
    private static final String LADDER_RESULT_MESSAGE = "실행 결과";

    private OutputView() {
    }

    public static void printLadder(Participants participants, Ladder ladder, LadderReward ladderReward) {
        System.out.println(SHOW_LADDER_MESSAGE);

        printParticipants(participants);
        printLadder(ladder);
        printLadderReward(ladderReward);
    }

    private static void printLadderReward(LadderReward ladderReward) {
        ladderReward.getResults()
                .stream()
                .map(result -> result + repeat(" ", STRING_MAX_LENGTH - result.length()))
                .forEach(System.out::print);

        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLines()
                .stream()
                .map(OutputView::getConnection)
                .map(OutputView::toLineString)
                .forEach(System.out::println);
    }

    public static List<Boolean> getConnection(Line line) {
        return line.getPoints()
                .stream()
                .map(Point::isRight)
                .collect(Collectors.toList());
    }

    private static String toLineString(List<Boolean> connection) {
        return connection.stream()
                .map(connect -> Boolean.TRUE.equals(connect)
                        ? HORIZONTAL_LINE
                        : HORIZONTAL_BLANK)
                .map(line -> VERTICAL_LINE + line)
                .collect(Collectors.joining());
    }

    private static void printParticipants(Participants participants) {
        String names = participants.getNames()
                .stream()
                .map(name -> name.toString() + repeat(" ", STRING_MAX_LENGTH - name.length()))
                .collect(Collectors.joining());

        System.out.println(names);
    }

    private static String repeat(String string, int length) {
        return IntStream.range(0, length)
                .mapToObj(i -> string)
                .collect(Collectors.joining(""));
    }

    public static void printLadderReward(LadderGameResult ladderGameResult, String wishParticipantName) {
        System.out.println(LADDER_RESULT_MESSAGE);

        if (PARTICIPANTS_ALL.equalsIgnoreCase(wishParticipantName)) {
            printLadderAllResult(ladderGameResult);
            return;
        }

        String result = ladderGameResult.getBy(wishParticipantName);
        System.out.println(result);
    }

    private static void printLadderAllResult(LadderGameResult ladderGameResult) {
        Map<Name, String> resultByParticipant = ladderGameResult.getResult();

        resultByParticipant.keySet()
                .stream()
                .map(key -> key.toString() + " : " + resultByParticipant.get(key))
                .forEach(System.out::println);
    }
}