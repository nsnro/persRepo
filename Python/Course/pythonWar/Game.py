from Card import Card
from Player import Player
from Deck import Deck


def duel(cardOne, cardTwo):
    valueDictionary = [(11, "J"), (12, "Q"), (13, "K"), (14, "A")]

    playerOneCard = cardOne
    playerTwoCard = cardTwo

    for value, names in valueDictionary:
        if cardOne == names:
            playerOneCard = value
        if cardTwo == names:
            playerTwoCard = value

    if int(playerOneCard) < int(playerTwoCard):
        print("Player Two wins the round!\n")
        return 2
    if int(playerTwoCard) < int(playerOneCard):
        print("Player One wins the round!\n")
        return 1
    if int(playerOneCard) == int(playerTwoCard):
        return 0


class Game:

    def __init__(self):
        self.playerOne = Player("PlayerOne")
        self.playerTwo = Player("PlayerTwo")

        deck = Deck()
        deck.shuffleDeck()

        for i in range(52):
            if i % 2 == 0:
                card = Deck.dealOne(deck)
                self.playerOne.addCards(card)
            else:
                if i % 2 != 0:
                    card = Deck.dealOne(deck)
                    self.playerTwo.addCards(card)
        self.startWar()

    def startWar(self):
        count = 0
        print("Starting the war!")
        gameDone = False
        while not gameDone:
            self.playRound()
            gameDone = self.checkCondition(count)
            count = count + 1

    def __str__(self):
        print("Player One has the following deck:")
        for el in self.playerOne.playerDeck:
            print(f"{el.value} of {el.suit}")
        print("Player Two has the following deck:")
        for el in self.playerTwo.playerDeck:
            print(f"{el.value} of {el.suit}")
        return ""

    def playRound(self):

        victory = duel(self.playerOne.playerDeck[0].value, self.playerTwo.playerDeck[0].value)

        cards = [self.playerOne.playCard(), self.playerTwo.playCard()]

        while victory == 0:
            print("Round is a draw\n")
            try:
                cards.append(self.playerOne.playCard())
                cards.append(self.playerTwo.playCard())
                victory = duel(self.playerOne.playerDeck[0].value, self.playerTwo.playerDeck[0].value)
                cards.append(self.playerOne.playCard())
                cards.append(self.playerTwo.playCard())
            except IndexError:
                print("One of the players does not have enough cards for war\n")
                if len(self.playerOne.playerDeck) == 0:
                    victory = 2
                if len(self.playerTwo.playerDeck) == 0:
                    victory = 1

        if victory == 1:
            self.playerOne.playerDeck.extend(cards)
        if victory == 2:
            self.playerTwo.playerDeck.extend(cards)

        print(f"Score: {len(self.playerOne.playerDeck)} vs {len(self.playerTwo.playerDeck)}\n")

    def checkCondition(self, count):
        if len(self.playerOne.playerDeck) == 0:
            print("Player Two has won the game!")
            return True
        if len(self.playerTwo.playerDeck) == 0:
            print("Player One has won the game!")
            return True
        if count > 10000:
            print("Infinite loop detected! Stopping the game.")
            return True
        return False


gameOne = Game()
