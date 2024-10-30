# Write a function that computes the volume of a sphere given its radius.
# 4/3 * pi * r^3

def problemOne(n):
    return 4/3 * 3.14 * n**3

#print(problemOne(2))

# Write a function that checks whether a number is in a given range (inclusive of high and low)

def problemTwo(n, l, h):
    return l < n < h

#print(problemTwo(2,1,5))
#print(problemTwo(5,1,4))
#print(problemTwo(5,2,7))


# Write a Python function that accepts a string and calculates the number of upper case letters and lower case letters.
#
# Sample String : 'Hello Mr. Rogers, how are you this fine Tuesday?'

def problemThree(inputString):
    upper = 0
    lower = 0
    for letters in inputString:
        if letters.isalpha():
            if letters.islower():
                lower = lower + 1
            else:
                upper = upper + 1
    return lower,upper

# print(problemThree("Hello Mr. Rogers, how are you this fine Tuesday?"))


# Write a Python function that takes a list and returns a new list with unique elements of the first list.
# Sample List : [1,1,1,1,2,2,3,3,3,3,4,5]


def problemFour(inputArray):
    return set(inputArray)


# print(problemFour([1,1,1,1,2,2,3,3,3,3,4,5]))


# Write a Python function to multiply all the numbers in a list.

# Sample List : [1, 2, 3, -4]
# Expected Output : -24

def problemFive(inputArray):
    fsum = 1
    for i in range(len(inputArray)):
        fsum = fsum * inputArray[i]
    return fsum

# print(problemFive([1,2,3,-4]))


# Write a Python function that checks whether a word or phrase is palindrome or not.

def problemSix(inputString):
    return inputString[::-1].replace(" ", "") == inputString.replace(" ", "")


#print(problemSix("race car"))


# Write a Python function to check whether a string is pangram or not. (Assume the string passed in does not have any
# punctuation)
#
# Note : Pangrams are words or sentences containing every letter of the alphabet at least once.
# For example : "The quick brown fox jumps over the lazy dog"

def problemSeven(inputString):
    return len(set(inputString.lower().replace(" ", ""))) >= 26

# print(problemSeven("The quick brown fox jumps over the lazy dog"))



