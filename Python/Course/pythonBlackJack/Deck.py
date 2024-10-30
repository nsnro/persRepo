from random import shuffle
from Card import Card

class Deck:

    def __init__(self):
        self.entireDeck = []
        self.score = 0

        for el in Card.suits:
            for i in range(2, 15):
                newCard = Card(el, i)
                self.entireDeck.append(newCard)

    def printDeck(self):
        for el in self.entireDeck:
            print(f"{el.value} of {el.suit}")

    def shuffleDeck(self):
        return shuffle(self.entireDeck)

    def dealOne(self):
        return self.entireDeck.pop(0)

    def increaseScore(self):
        return self.score + 1
