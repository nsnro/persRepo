import random
import time


def entry_point():
    global amount
    global number_set

    amount = input("Enter amount of tries: ")
    number_set = input("Input set of numbers to be randomly generated: ")

    birthday_paradox()


def birthday_paradox():
    true_instance = 0
    counter = 0
    for elements in range(int(amount)):
        time.sleep(1)
        values = []
        generate_table(values)
        if has_duplicates(values):
            true_instance += 1
            counter = counter + 1
        else:
            counter = counter + 1
        calculate_chance(true_instance, counter)


def generate_table(sample_rate):
    for i in range(0, int(number_set)):
        sample_rate.append(random.randrange(1, 365))
    return sample_rate


def has_duplicates(sample_rate):
    return len(sample_rate) != len(set(sample_rate))


def calculate_chance(success, total):
    # print(f"{success} out of {total}")
    print(100 * float(success) / float(total))


entry_point()
