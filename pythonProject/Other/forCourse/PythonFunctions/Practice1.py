# LESSER OF TWO EVENS: Write a function that returns the lesser of two given numbers if both numbers are even,
# but returns the greater if one or both numbers are odd
from itertools import count


def problemOne(a,b):
    if a == b:
        return a
    if a % 2 == 0 and b % 2 == 0:
        if a < b:
            return a
        else:
            return b
    else:
        if a < b:
            return b
        else:
            return a

# ANIMAL CRACKERS: Write a function takes a two-word string and returns True if both words begin with same letter
def problemTwo(inputString):
    reserve=[]
    if len(inputString.split()) != 2:
        print("String is of incorrect length")
        print(inputString)
        return False

    for words in inputString.split():
        reserve.append(words[0].lower())

    if len(set(reserve)) < 2:
        print("True")
        return True
    else:
        print("False")
        return False

# MAKES TWENTY: Given two integers, return True if the sum of the integers is 20 or if one of the integers is 20. If not, return False

def problemThree(a, b):
    if a == 20 or b == 20:
        return True
    else:
        if a + b == 20:
            return True
        else:
            return False


# OLD MACDONALD: Write a function that capitalizes the first and fourth letters of a name

def problemFour(inputString):
    outputString = []
    if len(inputString.split()) > 1:
        print("String is of incorrect length")

    for i in range(len(inputString)):
        if i == 0 or i == 3:
            outputString += inputString[i].upper()
        else:
            outputString += inputString[i]
    return ''.join(outputString)


#Given a sentence, return a sentence with the words reversed

def problemFive(inputString):
    outputString = []
    if len(inputString.split()) < 2:
        return inputString

    return ' '.join(inputString.split()[::-1]) #looked this up, forgot about it


# ALMOST THERE: Given an integer n, return True if n is within 10 of either 100 or 200

def problemSix(n):
    if 90 <= n <= 110:
        return True
    if 190 <= n <= 210:
        return True
    else:
        return False


# Given a list of ints, return True if the array contains a 3 next to a 3 somewhere.

def problemSeven(integers):
    for i in range(0, len(integers) - 1):
        if integers[i] == 3:
            if integers[i] == integers[i + 1]:
                return True
    return False


# PAPER DOLL: Given a string, return a string where for every character in the original there are three characters