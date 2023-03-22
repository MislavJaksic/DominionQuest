package commands

import cards.Card
import helpers.DataSource
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import phases.BuyPhase

class PlayCardTest {

    val dataSource = DataSource()

    val player = dataSource.getPlayer()

    val actionCardZero = dataSource.getActionCard(player, 0)
    val actionCardOne = dataSource.getActionCard(player, 1)
    val treasureCardZero = dataSource.getTreasureCard(player, 0)
    val treasureCardOne = dataSource.getTreasureCard(player, 1)
    val victoryCardZero = dataSource.getVictoryCard(player, 0, 0)
    val victoryCardOne = dataSource.getVictoryCard(player, 1, 1)

    @Nested
    inner class Execute {
        @Test
        fun `play action in action phase`() {
            player.putInHand(actionCardZero)
            player.addActions(1)
            dataSource.getPlayCard(player, actionCardZero).execute()

            assertThat(player.hand).isEmpty()
            assertThat(player.playArea).isEqualTo(ArrayList<Card>().apply { add(actionCardZero) })
        }

        @Test
        fun `no victory play in action phase`() {
            player.putInHand(victoryCardZero)
            assertThatThrownBy {
                dataSource.getPlayCard(player, victoryCardZero).execute()
            }.hasMessage("Can only play action cards in action phase")
        }

        @Test
        fun `no treasure play in action phase`() {
            player.putInHand(treasureCardZero)
            assertThatThrownBy {
                dataSource.getPlayCard(player, victoryCardZero).execute()
            }.hasMessage("Can only play action cards in action phase")
        }

        @Test
        fun `play treasure in buy phase`() {
            player.phase = BuyPhase(player)
            player.putInHand(treasureCardZero)
            dataSource.getPlayCard(player, treasureCardZero).execute()

            assertThat(player.hand).isEmpty()
            assertThat(player.playArea).isEqualTo(ArrayList<Card>().apply { add(treasureCardZero) })
        }

        @Test
        fun `no victory play in buy phase`() {
            player.phase = BuyPhase(player)
            player.putInHand(victoryCardZero)
            assertThatThrownBy {
                dataSource.getPlayCard(player, victoryCardZero).execute()
            }.hasMessage("Can only play treasure cards in buy phase")
        }

        @Test
        fun `no action play in buy phase`() {
            player.phase = BuyPhase(player)
            player.putInHand(actionCardZero)
            assertThatThrownBy {
                dataSource.getPlayCard(player, actionCardZero).execute()
            }.hasMessage("Can only play treasure cards in buy phase")
        }
    }
}