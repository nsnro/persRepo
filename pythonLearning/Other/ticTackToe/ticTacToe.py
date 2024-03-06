# Done with udemy course.
def displayGame(matrix):
    for i in range(len(matrix)):
        print(matrix[i])

def takeInput(matrix, round):
    userInput = input("Please input your next move in the format x,y: \n")

    while not validateInput(userInput,matrix):
        userInput = input("Incorrect input. Please try again in the format x,y: \n")

    if round % 2 == 0:
        matrix[int(userInput[0])-1][int(userInput[2])-1] = 'X'
    if round % 2 == 1:
        matrix[int(userInput[0])-1][int(userInput[2])-1] = 'O'
    return matrix

def validateInput(userInput, matrix):
    if len(userInput) > 3:
        return False
    if userInput[1] != ',' or not userInput[0].isnumeric() or not userInput[2].isnumeric():
        return False

    i = int(userInput[0])-1
    j = int(userInput[2])-1

    if 0 <= i <= 2 and 0 <= j <= 2:
        if matrix[i][j] != ' ':
            return False
        else:
            return True

def checkCondition(round, matrix):
    if round < 6:
        pass
    else:
        if checkRow(matrix) != -1:
            return True
        if checkColumn(matrix) != -1:
            return True
        if checkDiagonal(matrix) != -1:
            return True
    if round == 10:
        print("Draw")
        return True


def checkRow(matrix):
    for i in range (0, len(matrix)):
        if len(set(matrix[i])) == 1 and matrix[i][0] != ' ':
            print(f"Winner: {matrix[i][0]}")
            return matrix[i][0]
    return -1


def checkDiagonal(matrix):
    if len(set(matrix[i][i] for i in range(len(matrix)))) == 1 and matrix[0][0] != ' ':
        print(f"Winner: {matrix[0][0]}")
        return matrix[0][0]
    if len(set(matrix[i][len(matrix)-i-1] for i in range(len(matrix)))) == 1 and matrix[2][0] != ' ':
        print(f"Winner: {matrix[2][0]}")
        return matrix[2][0]
    return -1


def checkColumn(matrix):
    for i in range(len(matrix)):
        if len(set(matrix[j-1][i-1] for j in range(len(matrix)))) == 1 and matrix[0][i-1] != ' ':
            print(f"Winner: {matrix[0][i-1]}")
            return True
    return -1


def startGame():
    done = False
    round = 1
    initialMatrix = [[' ', ' ', ' '], [' ', ' ', ' '], [' ', ' ', ' ']]
    displayGame(initialMatrix)
    while not done:
        matrix = takeInput(initialMatrix, round)
        displayGame(matrix)
        round = round + 1
        done = checkCondition(round, matrix)
    print("Thank you for playing, goodbye")
startGame()