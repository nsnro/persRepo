# Use for, .split(), and if to create a Statement that will print out words that start with 's':

def problemOne():
    st = 'Print only the words that start with s in this sentence'
    for word in st.split(" "):
        if word[0] == 's' and len(word) > 1:
            print(word)


# Use range() to print all the even numbers from 0 to 10.

def problemTwo():
    for i in range(11):
        if i % 2 == 0 and i > 0:
            print(i)

# for i in range (0,11,2) was the answer they were looking for
# **Use a List Comprehension to create a list of all numbers between 1 and 50 that are divisible by 3.**


def problemThree():
    divisibleList = [x for x in range(51) if x % 3 == 0]
    print(divisibleList)


# Go through the string below and if the length of a word is even print "even!"
def problemFour():
    st = 'Print every word in this sentence that has an even number of letters'
    for words in st.split():
        if len(words) % 2 == 0:
            print("Even")


# Use List Comprehension to create a list of the first letters of every word in the string below:

def problemFive():
    st = 'Create a list of the first letters of every word in this string'
    mylist = [words[0] for words in st.split()]
    print(mylist)

problemFive()