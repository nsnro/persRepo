# Exercise Ideas taken from: https://www.pyforschool.com/assignment/text-file-handling-set-1.html
from random import randrange


def problemOne():
    with open('TextFiles\\numbers.txt', 'w') as numbers:
        for i in range(0, 10):
            numbers.write(str(randrange(0, 100)))
            numbers.write('\n')
    numbers.close()


def problemTwo():
    total = 0
    with open('TextFiles\\numbers.txt', 'r') as numbers:
        for line in numbers:
            value = int(line.strip())  # To read into line.strip - had to use solution
            print(line.strip())
            total += value
    print(f"Total is... {total}")
    numbers.close()


def problemThree():
    digitCount = 0
    with open('TextFiles\\problem3.txt', 'r') as file:
        content = file.read()
    for i in range(0, len(content)):
        if content[i].isdigit():  # Didn't know isDigit() is a thing.
            digitCount += 1
    file.close()
    print(f"Digit count is... {digitCount}")


def problemFour():
    vowels = ['a', 'e', 'i', 'o', 'u']
    with open('TextFiles\\zen.txt', 'r') as zen:
        for lines in zen:
            line = lines.rstrip()
            if line[0].lower() in vowels:
                print(line)
    zen.close()


def problemFive():
    with open('TextFiles\\notes.txt', 'r') as notes:
        for lines in notes:
            for word in lines.split():
                if len(word) > 7:
                    print(word)
    notes.close()

def problemSix():
    counter = 0
    with open('TextFiles\\notes2.txt', 'r') as notes:
        for lines in notes:
            for word in lines.split():
                if word[-1].isdigit():
                    counter += 1
    print(f"Total number of words ending in digits is {counter}")
    notes.close()

def problemSeven():
    count = 0
    with open('TextFiles\\names.txt', 'r') as names:
            for lines in names:
                if count >= 5:
                    break
                else:
                    print(lines.rstrip())
                    count += 1
    print(f"Count limit: {count}")
    names.close()

def problemEight():
    with open('TextFiles\\order.txt', 'r') as order:
        content = order.readlines()
        for i in range(len(content)-1, 0, -1):
            print(content[i].rstrip())
    order.close()

def problemNine():
    with open('TextFiles\\sentences.txt', 'r') as sentences:
        for lines in sentences:
            content = lines.split()
            if len(content) > 8:
                print(lines)
    sentences.close()

def problemTen():
    positiveFeedback = 0
    negativeFeedback = 0
    feedbackCount = 0
    with open('TextFiles\\feedback.txt', 'r') as feedback:
        for lines in feedback:
            content = lines.split()
            if content[0] == 'Positive:':
                positiveFeedback += 1
                feedbackCount += 1
            else:
                if content[0] == 'Negative:':
                    negativeFeedback += 1
                    feedbackCount += 1
    feedback.close()
    print(f"Total feedback: {feedbackCount}")
    print(f"Positive feedback: {positiveFeedback}")
    print(f"Negative feedback: {negativeFeedback}")

def problemEleven():
    with open('TextFiles\\input.txt', 'r') as input:
        for lines in input:
            content = lines.split()
            print(content)
    for i in range(0, len(content)):
        if content[i][0].islower():
            content[i] = content[i].capitalize()
            print(content[i])

    with open('TextFiles\\output.txt', 'w') as output:
        for words in content:
            output.write(words)
            output.write(" ")
    input.close()
    output.close()


# problemOne()
# problemTwo()
# problemThree()
# problemFour()
# problemFive()
# problemSix()
# problemSeven()
# problemEight()
# problemNine()
# problemTen()
# problemEleven()

# TO BE CONTINUED https://www.pyforschool.com/assignment/file-handling.html