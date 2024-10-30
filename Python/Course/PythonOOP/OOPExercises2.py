class Account:

    def __init__(self, name, amount):
        self.name = name
        self.amount = amount

    def deposit(self, amount):
        self.amount += amount
        print(f"Deposit accepted. New balance: {self.amount}")

    def withdraw(self, amount):
        if amount <= self.amount:
            self.amount -= amount
            print(f"Withdrawal accepted. New balance: {self.amount}")
        else:
            print(f"Withdrawal rejected. Not enough balance")
    def __str__(self):
        return f"Account owner:      {self.name}\nAccount balance:    {self.amount}"

account1 = Account('Daniel', 200)

print(account1)

account1.deposit(50)

account1.withdraw(500)
