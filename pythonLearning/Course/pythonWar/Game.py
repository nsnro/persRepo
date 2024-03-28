from Card import Card
from Player import Player
from Deck import Deck


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
        # while not gameDone:
        while count < 50:
            self.playRound()
            gameDone = self.checkCondition()
            count += 1

    def __str__(self):
        print("Player One has the following deck:")
        for el in self.playerOne.playerDeck:
            print(f"{el.value} of {el.suit}")
        print("Player Two has the following deck:")
        for el in self.playerTwo.playerDeck:
            print(f"{el.value} of {el.suit}")
        return ""

    def playRound(self):
        valueDictionary = [(11, "J"), (12, "Q"), (13, "K"), (14, "A")]
        print("Starting new round!")

        playerOneCard = self.playerOne.playerDeck[0].value
        playerTwoCard = self.playerTwo.playerDeck[0].value

        for value, names in valueDictionary:
            if self.playerOne.playerDeck[0].value == names:
                playerOneCard = value
            if self.playerTwo.playerDeck[0].value == names:
                playerTwoCard = value

        self.playerOne.playCard()
        self.playerTwo.playCard()

        cards = [self.playerOne.playerDeck[0], self.playerTwo.playerDeck[0]]

        if int(playerOneCard) < int(playerTwoCard):
            print("Player Two wins the round!\n")
            self.playerTwo.addCards(cards)
        else:
            if int(playerOneCard) > int(playerTwoCard):
                print("Player One wins the round!\n")
                self.playerOne.addCards(cards)
            else:
                if int(playerOneCard) == int(playerTwoCard):
                    print("Draw TBD")
                    self.playerOne.playerDeck.pop(0)
                    self.playerTwo.playerDeck.pop(0)
                    pass
        self.playerOne.playerDeck.pop(0)
        self.playerTwo.playerDeck.pop(0)
        print(f"Score: {len(self.playerOne.playerDeck)} vs {len(self.playerTwo.playerDeck)}")

    def checkCondition(self):
        if len(self.playerOne.playerDeck) == 0:
            print("Player Two has won the game!")
            return True
        if len(self.playerTwo.playerDeck) == 0:
            print("Player One has won the game!")
            return True
        return False


gameOne = Game()
