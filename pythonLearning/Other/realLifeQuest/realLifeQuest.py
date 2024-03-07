class Player:

    def __init__(self, name):
        self.name = name
        self.level = 1
        self.experience = 0

    def __str__(self):
        return f"Player name: {self.name}\nPlayer level: {self.level}\nPlayer experience: {self.experience}"

    def increasExperience(self, amount):
        self.experience += amount
        if self.experience >= self.level * 100:
            spare = self.experience - (self.level * 100)
            self.level += 1
            self.experience = spare
            print("Congratulations on leveling up!")
            print(f"Level: {self.level}")
            print(f"Experience: {self.experience}")


class Quest:

    def __init__(self, name, value):
        self.name = name
        self.value = value
