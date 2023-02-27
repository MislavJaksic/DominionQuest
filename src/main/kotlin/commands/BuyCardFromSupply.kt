package commands

import Player
import enums.SupplyCardCode
import supplies.Supply

class BuyCardFromSupply(val player: Player, val cardCode: SupplyCardCode, val supply: Supply) : Command {
    override fun execute() {
        val card = supply.codeToCard(cardCode)
        if (player.isBuy(card) && supply.isCardInSupply(cardCode)) {
            player.buy(supply.sell(cardCode))
        }
    }
}