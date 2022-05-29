package nextstep.ladder.doman;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final String NOT_EMPTY_RESULTS = "실행 결과는 비어있을수 없습니다.";

    private final List<Result> results;

    public Results(String results) {
        validate(results);
        this.results = makeResults(results);
    }

    private void validate(String results) {
        if (results == null || results.isEmpty()) {
            throw new IllegalArgumentException(NOT_EMPTY_RESULTS);
        }
    }

    private List<Result> makeResults(String results) {
        return Arrays.stream(results.split(",")).map(Result::new).collect(Collectors.toList());
    }
}
