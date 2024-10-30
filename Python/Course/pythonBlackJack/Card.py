class Card:
    suits = ["spades", "clubs", "hearts", "diamonds"]

    def __init__(self, suit, value):
        self.suit = self.validateSuit(suit)
        self.value = self.validateValue(value)

        if self.suit is None or self.value is None:
            print("WARNING: Incorrect definition of object")

    def validateSuit(self, cardSuit):

        if cardSuit.lower() in Card.suits:
            return cardSuit.capitalize()

    def validateValue(self, cardValue):
        valueDictionary = [(11, "jack"), (12, "queen"), (13, "king"), (14, "ace")]

        if 1 < int(cardValue) <= 10:
            return cardValue
        for value, names in valueDictionary:
            if cardValue == value:
                return names[0].capitalize()

    def __str__(self):
        return f"{self.value} of {self.suit}"
