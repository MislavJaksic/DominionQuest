package cards.basic

import cards.TreasureCard
import cards.base_set.Merchant
import game.Player

data class Silver(override var owner: Player) : TreasureCard {
    override fun execute() {
        owner.addCoins(2)

        activateMerchant()
    }

    override val cost: Int
        get() = 3

    fun activateMerchant() {
        if (!owner.isPlayedSilver) {
            owner.isPlayedSilver = true
            for (card in owner.playArea) {
                if (card is Merchant) {
                    owner.addCoins(1)
                }
            }
        }
    }
}