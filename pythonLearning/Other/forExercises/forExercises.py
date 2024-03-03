# Exercises taken from https://www.w3resource.com/python-exercises/python-conditional-statements-and-loop-exercises.php
import random
import re


def problemOne():
    for i in range(1500, 2700):
        if i % 7 == 0 and i % 5 == 0:
            print(i)


def problemTwo():
    celsius = [7, 60]
    print(celsius)
    for temperatures in celsius:
        fahrenheit = ((temperatures * 9) / 5 + 32)
        print(f"Celsius: {temperatures}, Fahrenheit: {int(fahrenheit)}")


def problemThree():
    guessed = False
    number = random.randrange(1, 9)

    while not guessed:
        userInput = int(input("Guess the number?\n"))
        if userInput == number:
            print("Congratulations. You guessed correctly")
            break
        else:
            print("Wrong... Let's try again")
    print("OK, game's done now. Bugger off")


def problemFour():  # Used solution for this one...
    n = 5
    for i in range(n):
        for j in range(i):
            print("*", end="")
        print('')
    for i in range(n, 0, -1):
        for j in range(i):
            print("*", end="")
        print('')


def problemFive():
    word = []
    word = str(input("Enter a word for me to reverse..."))
    for i in range(len(word) - 1, -1, -1):
        print(word[i], end="")


def problemSix():
    even = 0
    odd = 0
    testList = []
    for i in range(0, 99):
        testList.append(random.randrange(1, 150))
    for element in testList:
        if element % 2 == 0:
            even = even + 1
        else:
            odd = odd + 1

    print(f"Number of even numbers: {even}")
    print(f"Number of odd numbers: {odd}")


def problemSeven():
    datalist = [1452, 11.23, 1 + 2j, True, 'w3resource', (0, -1), [5, 12], {"class": 'V', "section": 'A'}]
    for elements in datalist:
        print(type(elements))


def problemEight():
    for i in range(0, 6):
        if i == 3 or i == 6:
            continue
        else:
            print(i)


def problemNine(previous, current):
    if current >= 50:
        print("We're done")
    else:
        newCurrent = current + previous
        newPrevious = current
        print(current)
        problemNine(newPrevious, newCurrent)


def problemTen():
    for number in range(50):
        if number % 3 == 0 and number % 5 == 0:
            print("FizzBuzz")
        else:
            if number % 3 == 0:
                print("Fizz")
            else:
                if number % 5 == 0:
                    print("Buzz")
                else:
                    print(number)


def problemEleven():
    row = int(input("Enter numbers of rows: "))
    column = int(input("Enter number of columns: "))
    matrix = [[0 for col in range(column)] for row in range(row)]

    for i in range(row):
        for j in range(column):
            matrix[i][j] = i * j

    print(matrix)


def problemTwelve():
    lines = []
    userInput = "initial"
    while userInput != "":
        userInput = input("Enter a line: \n")
        lines.append(userInput)
    lines.pop()

    for elements in lines:
        print(elements.lower())


def problemThirteen():
    valid = True
    i = 0
    binarySequence = input("Enter a binary sequence: \n")
    finalList = []
    secondarySequence = []
    # Validate the sequence
    # for i in range(0, len(binarySequence)-1):
    while i < len(binarySequence):
        if (i + 1) % 5 == 0:
            if binarySequence[i] != ',':
                valid = False
                break
        else:
            if abs(int(binarySequence[i])) > 1:
                valid = False
                break
        i = i + 1
    if valid:
        print("Valid sequence. Now let's try calculate this bad boy...")
        # Calculate... Used solution for this. My approach was very cave man-y.
        secondarySequence = [x for x in binarySequence.split(',')]
        for values in secondarySequence:
            sum = int(values, 2)

            if sum % 5 == 0:
                finalList.append(values)
        print(finalList)


    else:
        print("Invalid sequence")


def problemFourteen():
    digit = 0
    letter = 0
    userInput = input("Enter a string: \n")
    for chars in userInput:
        if chars.isdigit():
            digit = digit + 1
        else:
            if chars.isalpha():
                letter = letter + 1
    print(f"Digits: {digit}; Letters: {letter}")


def problemFifteen():
    password = input("Please enter a password: ")
    valid = True
    if len(password) < 6 or len(password) > 18:
        print("Password is of invalid length")
        valid = False
    else:
        if not re.search('[A-Z]', password):
            valid = False
            print("Password does not contain uppercase letters")
        else:
            if not re.search('[a-z]', password):
                valid = False
                print("Password does not contain lowercase numbers")
            else:
                if not re.search('[1-9]', password):
                    valid = False
                    print("Password does not contain numbers")
                else:
                    if not re.search("[$#@]", password):
                        valid = False
                        print("Password does not contain special characters")

    if valid:
        print("Password is valid, congratulations")
    else:
        print("Password is invalid...")


def problemSixteen():
    fit = True
    finalList = []
    for i in range(100, 401):
        fit = True
        number = i
        while number > 0 and fit == True:
            if (number % 10) % 2 == 0:
                fit = True
                number = int(number / 10)
            else:
                fit = False
        if fit:
            finalList.append(i)
    print(finalList)

def problemThirtyOne():
    userInput = int(input("Enter your dog's age"))
    i = 1
    age = 0
    while i <= userInput:
        if i == 1 or i == 2:
           age = age + 10.5
           i = i + 1
        else:
            age = age + 4
            i = i + 1
    print(f"{userInput}, {age}")

def problemThirtyTwo():
    months = {"January": "31",
              "February": "28/29",
              "March": "31",
              "April": "30",
              "May": "31",
              "June": "30",
              "July": "31",
              "August": "31",
              "September": "30",
              "October": "31",
              "November": "30",
              "December": "31"}
    userInput = input("Enter the month and I'll tell you the number of days in it...\n")
    uinput = userInput.lower()
    uinput = uinput.capitalize()
    print(months[uinput])

problemThirtyTwo()