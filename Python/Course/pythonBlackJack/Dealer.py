from Card import Card
from Deck import Deck
from Player import Player


class Dealer:

    def __init__(self):
        self.score = 0
        self.dealerHand = []
        dealerDeck = Deck()
        dealerDeck.shuffleDeck()

    def increaseScore(self):
        return self.score + 1
