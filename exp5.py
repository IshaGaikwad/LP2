import random
import string

data = {
    "Hi": ["Hello", "How are you?", "Hey"],
    "How are you" : ["I'm Fine", "I'm Great"],
    "What is your name" : ["Chatbot","You can call me chatbot"],
    "Who created you" : ["Isha","Isha did"],
}

print("Chatbot")

run = True
while run:
    query = input("You : ")
    for i,j in data.items():
        if query.lower() == i.lower():
            print("Bot: ", random.choice(j))
        if query == 'end':
            print("Nice to chat with you!")
            run = False

