package commands

import Player
import enums.SupplyCardCode
import phases.BuyPhase
import supplies.Supply

class BuyCardFromSupply(val player: Player, val cardCode: SupplyCardCode, val supply: Supply) : Command {
    override fun execute() {
        if (supply.isCodeInSupply(cardCode)) {
            val card = supply.codeToCard(cardCode)
            if (player.phase is BuyPhase && player.isBuy(card) && supply.isCardInSupply(cardCode)) {
                player.buy(supply.sell(cardCode))
            }
        }
    }
}