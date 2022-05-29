package nextstep.ladder.view;

import nextstep.ladder.doman.LadderGame;
import nextstep.ladder.doman.Participants;

public class OutputView {

    private static final String EXECUTE_MESSAGE = "실행 결과";
    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void printResult(LadderGame ladderGame) {
        System.out.println(ladderGame.toString());
    }

    public static void printPersons(Participants participants) {
        System.out.println(participants.toString());
    }

    public static void printExecuteMessage() {
        stringBuilder.setLength(0);
        stringBuilder.append("\n")
                .append(EXECUTE_MESSAGE)
                .append("\n");
        System.out.println(stringBuilder);
    }
}
