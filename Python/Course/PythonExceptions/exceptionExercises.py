# Problem 1
# Handle the exception thrown by the code below by using try and except blocks.

def problemOne():
    for i in ['a', 'b', 'c']:
        try:
            print(i ** 2)
        except TypeError:
            print(f"Type error: {i} is not an integer or float")
    print("Bye")


# problemOne()

# Problem 2
# Handle the exception thrown by the code below by using try and except blocks. Then use a finally block to print
# 'All Done.'
def problemTwo():
    x = 5
    y = 0
    try:
        z = x / y
    except ZeroDivisionError:
        print("You're trying some dark sorcery here, bud. You cannot divide by 0")
    finally:
        print("All done")


# problemTwo()


# Problem 3
# Write a function that asks for an integer and prints the square of it. Use a while loop with a try, except, else
# block to account for incorrect inputs.

def problemThree():
    done = False
    while not done:
        userIn = input("Please enter the number you want squared\n")
        try:
            print(float(userIn) ** 2)
            done = True
        except ValueError:
            print("Invalid input. Please enter an integer or float.")
            continue
        else:
            print("Well done")
            break


problemThree()
