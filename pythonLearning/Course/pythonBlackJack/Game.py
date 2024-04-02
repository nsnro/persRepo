from Card import Card
from Deck import Deck
from Player import Player
from Dealer import Dealer


def calculateScore(hand):
    suit = ["Q", "K", "J"]
    score = 0
    if len(hand) == 2:
        if hand[0].value == 'A':
            hand.append(hand[0])
            hand.pop(0)

    for cards in hand:
        if cards.value == 'A':
            if score <= 10:
                score += 10
                continue
            else:
                if score > 10:
                    score += 1
                    continue
        if cards.value in suit:
            score += 10
        else:
            score += int(cards.value)

    return score


def continueGame():
    print("Would you like to continue?")
    userChoice = int(input("1 - Yes \n2 - No\n"))
    if userChoice == 1:
        return False
    if userChoice == 2:
        return True

class Game:
    def __init__(self):
        self.hiddenCard = None
        self.gameDeck = Deck()
        self.player = Player("Player")
        self.dealer = Dealer()
        self.round = 0
        self.bet = None
        self.gameFlow()

    def gameFlow(self):
        gameDone = False
        while not gameDone:
            self.player.makeBet()
            self.prepareGame()

            self.gameState()
            self.gameRound()
            self.cleanUp()
            gameDone = continueGame()
        return

    def cleanUp(self):
        self.hiddenCard = None
        self.gameDeck = Deck()
        self.player.playerHand = []
        self.dealer.dealerHand = []

    def gameRound(self):
        validInput = False
        userChoice = 0
        while userChoice != 2:
            print("What would you like to do?")
            print("1 - Hit\n2 - Stand\n3 - Double Down(TBD)\n4 - Surrender(TBD)\n5 - Split(TBD)")
            userChoice = int(input("Enter your choice: "))
            if 3 <= userChoice:
                print("Not implemented yet/Invalid Input")
                validInput = False
            if userChoice == 1:
                validInput = True
                self.player.playerHand.append(Deck.dealOne(self.gameDeck))
                print(f"{calculateScore(self.player.playerHand)}")
                if calculateScore(self.player.playerHand) > 21:
                    print(f"Bust!")
                    self.dealer.increaseScore()
                    self.player.removeMoney(self.player.bet)
                    return
                if calculateScore(self.player.playerHand) == 21:
                    print("Blackjack")
                    self.player.addMoney(self.player.bet)
                    self.player.increaseScore()
                    return
                if calculateScore(self.player.playerHand) < 21:
                    continue
            if userChoice == 2:
                validInput = True
                print("User chose to stay")

        if self.round > 1 and len(self.dealer.dealerHand) < 2:
            self.dealer.dealerHand.append(self.hiddenCard)

        while calculateScore(self.dealer.dealerHand) <= 16:
            self.dealer.dealerHand.append(Deck.dealOne(self.gameDeck))

        if calculateScore(self.dealer.dealerHand) > 21:
            print("Dealer busted!")
            self.player.removeMoney(self.player.bet)
            print(f"Score is: {self.player.score} to {self.dealer.score}")

        print(f"Player's final score is: {calculateScore(self.player.playerHand)}")
        print(f"Dealer's final score is: {calculateScore(self.dealer.dealerHand)}")

        if calculateScore(self.player.playerHand) > calculateScore(self.dealer.dealerHand):
            print("Player won!")
            self.player.addMoney(self.player.bet)
            self.player.increaseScore()
            print(f"Score is: {self.player.score} to {self.dealer.score}")

        if calculateScore(self.player.playerHand) < calculateScore(self.dealer.dealerHand):
            print("Dealer won!")
            self.player.removeMoney(self.player.bet)
            print(f"Score is: {self.player.score} to {self.dealer.score}")

    def prepareGame(self):
        self.gameDeck.shuffleDeck()

        Deck.dealOne(self.gameDeck)

        for i in range(2):
            self.player.playerHand.append(Deck.dealOne(self.gameDeck))
            self.dealer.dealerHand.append(Deck.dealOne(self.gameDeck))

        self.hiddenCard = self.dealer.dealerHand[0]
        self.dealer.dealerHand.pop(0)

        print("Cards have been dealt!\n")

    def gameState(self):
        print("Player has the following cards")

        for cards in self.player.playerHand:
            print(f"{cards.value} of {cards.suit}")

        print(f"Total player score right now is: {calculateScore(self.player.playerHand)}")
        print("\n")

        print("Dealer has the following cards")
        for cards in self.dealer.dealerHand:
            print(f"{cards.value} of {cards.suit}")
        print(f"Total dealer score right now is: {calculateScore(self.dealer.dealerHand)}")
        print("\n")



gameOne = Game()

