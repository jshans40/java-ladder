package ladder.domain;

import ladder.domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @DisplayName("높이만큼 HorizonLine 을 가진다.")
    @Test
    public void hasHorizonLineTest() {
        Ladder ladder = new Ladder(5, 3);
        assertThat(ladder.getHeight()).isEqualTo(5);
    }

    @DisplayName("최소 높이 보다 작은 높이가 입력되면 IllegalArgumentException 이 발생한다.")
    @Test
    public void createLessThanMinHeight() {
        assertThatThrownBy(() -> {
            Ladder ladder = new Ladder(1, 3);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("최소 참여 사용자 수 보다 작은 사용자 수가 입력되면 IllegalArgumentException 이 발생한다.")
    @Test
    public void createLessThanMinStratPositon() {
        assertThatThrownBy(() -> {
            Ladder ladder = new Ladder(3, 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("가로라인의 짧은 라인(ShortLine)는 (입렫된 사용자의 수 - 1) 개까지 만든다.")
    @Test
    public void createShortLineInHorizonLine() {
        Ladder ladder = new Ladder(3, 4);
        assertThat(ladder.getShortLineCountInHorizonLine(0)).isEqualTo(3);
        assertThat(ladder.getShortLineCountInHorizonLine(1)).isEqualTo(3);
        assertThat(ladder.getShortLineCountInHorizonLine(2)).isEqualTo(3);
    }

    @DisplayName("입력되는 Horizon Line 높이와 사다리 시작점에서 오른쪽에 ShortLine 의 유무를 알 수 있다.")
    @Test
    public void isEnabledShortLineOfRightTest() {
        Ladder ladder = new Ladder(3, 4, () -> true);

        assertThat(ladder.isEnabledShortLineOfRight(0, 0)).isTrue();
        assertThat(ladder.isEnabledShortLineOfRight(1, 1)).isFalse();
    }

    @DisplayName("입력되는 Horizon Line 높이와 사다리 시작점에서 왼쪽에 ShortLine 의 유무를 알 수 있다.")
    @Test
    public void isEnabledShortLineOfLeftTest() {
        Ladder ladder = new Ladder(3, 4, () -> true);

        assertThat(ladder.isEnabledShortLineOfLeft(0, 0)).isFalse();
        assertThat(ladder.isEnabledShortLineOfLeft(1, 1)).isTrue();
    }
}
