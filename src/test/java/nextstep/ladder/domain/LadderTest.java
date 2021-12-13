package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @DisplayName("객체 생성 테스트")
    @Test
    void create() {
        Height height = new Height(5);
        Ladder ladder = Ladder.of(4, height, () -> true);

        assertThat(ladder).isNotNull();
        assertThat(ladder.getLadder().size()).isEqualTo(height.getValue());
    }
}