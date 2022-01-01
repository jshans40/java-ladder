package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.factory.LadderFactory;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

/**
 * @author han
 */
public class Main {

    public static void main(String[] args) {

        Users users = InputView.inputUserNames();
        Results results = InputView.inputResults();
        Height height = InputView.inputLadderHeight();

        LadderFactory ladderFactory = LadderFactory.from(users.width(), height);
        Ladder ladder = ladderFactory.getLadder();
        ResultView.print(ladder, users, results);

        Play play = new Play(ladder);
        User user;

        do {
            user = InputView.inputResultUser();
            ResultView.printResults(results, play, users, user);
        } while (!user.isAll());
    }
}