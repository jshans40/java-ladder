package nextstep.ladder.view;

import nextstep.ladder.doman.LadderHeight;
import nextstep.ladder.doman.ParticipantNames;

import java.util.Scanner;

public class InputView {
    private static final String PARTICIPANT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MAX_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    public static ParticipantNames getParticipantNames() {
        System.out.println(PARTICIPANT_NAMES_MESSAGE);
        return new ParticipantNames(scanner.nextLine());
    }

    public static LadderHeight getLadderHeight() {
        System.out.println(MAX_LADDER_HEIGHT);
        return new LadderHeight(Integer.parseInt(scanner.nextLine()));
    }
}
