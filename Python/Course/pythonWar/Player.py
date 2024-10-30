from Deck import Deck
from Card import Card


class Player:

    def __init__(self, playerName):
        self.playerName = playerName
        self.playerDeck = []

    def playCard(self):
        print(f"{self.playerName} has played the {self.playerDeck[0].value} of {self.playerDeck[0].suit}")
        return self.playerDeck.pop(0)

    def addCards(self, newCards):
        if type(newCards) == type([]):
            self.playerDeck.extend(newCards)
        else:
            self.playerDeck.append(newCards)

    def __str__(self):
        return f"Player {self.playerName} has a total of {len(self.playerDeck)} cards."
