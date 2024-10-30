import random
from random import randint

from selenium import webdriver
from selenium.common import NoSuchElementException
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By

import time



def precondition():
    #Check username is not empty
    valid = False
    username = ""
    while not valid:
        username = input("Please specify the username: ")
        if username is None:
            print("Please enter a valid username")
        else:
            valid = True

    #Set browser options & open browser
    options = Options()
    #options.add_argument('--headless=new')
    options.add_experimental_option("excludeSwitches", ["enable-automation"])
    options.add_experimental_option('useAutomationExtension', False)
    options.add_argument("--disable-blink-features=AutomationControlled")

    browser = webdriver.Chrome(options=options)



    #Check username exists

    browser.get("https://www.google.com")

    time.sleep(random.uniform(5.12, 6.37))

    browser.get("https://www.reddit.com")

    time.sleep(random.uniform(15,25))

    baseUrl = "https://www.reddit.com/u/"
    browser.get(baseUrl + str(username))

    print(browser.page_source)
    if r"This account may have been banned or the username is incorrect." in browser.page_source or r"This account has been suspended" in browser.page_source:
        print("Account may have been banned/suspended or the username does not exist")
        return
    else:
        print("Account seems to be OK.")

    time.sleep(random.uniform(5,10))

def validate(name):
    pass


def startDataDownload():
    pass

precondition()