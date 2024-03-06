from tkinter import *
from tkinter.ttk import *
import sqlite3

def on_submit():
    pass

def on_register():
    registerWindow = Toplevel(app)
    registerWindow.title("Register")

    registerWindow.geometry("300x450")

    usernameR = Label(registerWindow, text="Enter username:")
    usernameR.pack()

    usernameRegister = Entry(registerWindow)
    usernameRegister.pack()

    passwordR = Label(registerWindow, text="Enter password:")
    passwordR.pack()

    passwordRegister = Entry(registerWindow, show="*")
    passwordRegister.pack()

    passwordRA = Label(registerWindow, text="Enter password again:")
    passwordRA.pack()

    registerButton = Button(registerWindow, text="Register", command=on_submit)
    registerButton.pack()


# First window

app = Tk()

app.title("Real Life Quest")
app.geometry("400x800")

username = Label(app, text="Username:")
username.pack()

usernameEntry = Entry(app)
usernameEntry.pack()

password = Label(app, text="Password:")
password.pack()

passwordEntry = Entry(app, show="*")
passwordEntry.pack()

submit_button = Button(app, text="Login", command=on_submit)
submit_button.pack()

register = Button(app, text="Don't have an account? Register!", command=on_register)
register.pack()

app.mainloop()

register = Button(app, text="Don't have an account? Register!", command=on_register)
register.pack()

app.mainloop()