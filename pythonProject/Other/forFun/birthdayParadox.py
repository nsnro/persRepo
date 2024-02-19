import random
import time


def entryPoint():
    global amount
    global numberSet

    amount = input("Enter amount of tries: ")
    numberSet = input("Input set of numbers to be randomly generated: ")

    birthdayParadox()


def birthdayParadox():
    trueInstance = 0
    counter = 0
    for i in range(0, int(amount)):
        time.sleep(1)
        values = []
        generateTable(values)
        if hasDuplicates(values):
            trueInstance += 1
            counter = counter + 1
        else:
            counter = counter + 1
        calculateChance(trueInstance, counter)


def generateTable(sampleRate):
    for i in range(0, int(numberSet)):
        sampleRate.append(random.randrange(1, 365))
    return sampleRate


def hasDuplicates(sampleRate):
    return len(sampleRate) != len(set(sampleRate))


def calculateChance(success, total):
    # print(f"{success} out of {total}")
    print(100 * float(success) / float(total))


entryPoint()
