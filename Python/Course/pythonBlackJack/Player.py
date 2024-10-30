from Deck import Deck
from Card import Card


class Player:

    def __init__(self, playerName):
        self.playerName = playerName
        self.playerHand = []
        self.score = 0
        self.money = 100
        self.bet = None

    def addCard(self, card):
        return self.playerHand.append(card)

    def removeMoney(self, amount):
        self.money -= amount

    def addMoney(self, amount):
        self.money += amount

    def increaseScore(self):
        return self.score + 1

    def makeBet(self):
        validBet = False
        print(f"Your current balance is: {self.money}$")
        while not validBet:
            self.bet = int(input("How much would you like to bet for this round?\n"))
            if (self.money - self.bet) < 0:
                print("Invalid bet... You do not have enough money")
            else:
                validBet = True
        print(f"You've bet {self.bet}$")