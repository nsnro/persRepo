# LESSER OF TWO EVENS: Write a function that returns the lesser of two given numbers if both numbers are even,
# but returns the greater if one or both numbers are odd
from itertools import count


def problemOne(a, b):
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
    reserve = []
    if len(inputString.split()) != 2:
        print("String is of incorrect length")
        print(inputString)
        return False

    for words in inputString.split():
        reserve.append(words[0].lower())

    if len(set(reserve)) < 2:
        return True
    else:
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


# Given a sentence, return a sentence with the words reversed

def problemFive(inputString):
    outputString = []
    if len(inputString.split()) < 2:
        return inputString

    return ' '.join(inputString.split()[::-1])  # looked this up, forgot about it


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

def problemEight(inputString):
    outputString = []
    for i in range(len(inputString)):
        for j in range(3):
            outputString.append(inputString[i])

    return ''.join(outputString)


# BLACKJACK: Given three integers between 1 and 11, if their sum is less than or equal to 21, return their sum.
# If their sum exceeds 21 and there's an eleven, reduce the total sum by 10. Finally, if the sum (even after adjustment)
# exceeds 21, return 'BUST'

def problemNine(a, b, c):
    if a > 11 or b > 11 or c > 11:
        print("Numbers can be no bigger than 11")
        return
    if a <= 0 or b <= 0 or c <= 0:
        print("Numbers cannot be negative")
        return

    if (a + b + c) <= 21:
        return (a + b + c)
    else:
        if (a + b + c) > 21:
            if a == 11 or b == 11 or c == 11:
                if ((a + b + c) - 10) > 21:
                    print("BUST")
                    pass
                else:
                    return (a + b + c) - 10
            else:
                print("BUST")
                pass


# print(problemNine(5,6,7))
# print(problemNine(9,9,9))
# print(problemNine(9,9,11))
# print(problemNine(11,11,11))
# print(problemNine(10,10,11))


# SUMMER OF '69: Return the sum of the numbers in the array, except ignore sections of numbers starting with a 6
# and extending to the next 9 (every 6 will be followed by at least one 9). Return 0 for no numbers.

def problemTen(inputArray):
    ignore = False
    sum = 0
    for i in range(0, len(inputArray)):
        if ignore:
            if inputArray[i] == 9:
                ignore = False
                continue
            else:
                continue
        if not ignore:
            if inputArray[i] == 6:
                ignore = True
            else:
                sum = sum + inputArray[i]

    return sum


# print(problemTen([1,3,5]))
# print(problemTen([4,5,6,7,8,9]))
# print(problemTen([2,1,6,9,11]))
# print(problemTen([2,2,6,1,2,9,3,3,1,6,2,4,5,9]))

# SPY GAME: Write a function that takes in a list of integers and returns True if it contains 007 in order

# Apparently understood the whole idea wrong... it's not supposed to be consecutive...
def problemEleven(inputArray):
    toPop = [0,0,7]
    for i in range(len(inputArray)):
        if len(toPop) == 0:
            return True
        else:
            if inputArray[i] == toPop[0]:
                toPop.pop(0)
            else:
                continue
    return False


#print(problemEleven([1, 2, 4, 0, 0, 7, 5, 0, 0, 7]))
#print(problemEleven([1, 0, 2, 4, 0, 5, 7, 0, 2]))
#print(problemEleven([1, 7, 2, 0, 4, 5, 0, 7]))

