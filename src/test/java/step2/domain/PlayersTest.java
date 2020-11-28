package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @Test
    @DisplayName("플레이어 인원이 잘 되는지 확인")
    void testPlayersCount() {
        //given
        Players players = Players.of(Arrays.asList(Player.of("a"), Player.of("b"), Player.of("c")));
        assertThat(players.getPlayersCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("플레이어가 생성되는지 확인")
    void createPlayers() {
        //given
        Players players = Players.of(Arrays.asList(Player.of("a"), Player.of("b"), Player.of("c")));
        assertThat(players).isEqualTo(Players.of(Arrays.asList(Player.of("a"), Player.of("b"), Player.of("c"))));
    }

    @Test
    @DisplayName("플레이어가 리스트가 잘 생성되는지 확인")
    void createPlayersList() {
        //given
        Players players = Players.of(Arrays.asList(Player.of("a"), Player.of("b"), Player.of("c")));
        assertThat(players.getPlayers()).containsExactly(Player.of("a"), Player.of("b"), Player.of("c"));
    }
}