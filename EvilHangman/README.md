The challenge is to develop a hangman game that actively cheats against the player. 
In a normal game of hangman, one word is selected that the other player will try to guess. 

In this version, the computer will delay picking a single word for as long as possible to maximize the possibility that the player will fail. 

Consider the following example of one guess for the “Evil Hangman” program:

Game: 3 letter word
Dictionary: add, hat, cat, dog

User guesses -> a
The computer does the following computation:

a _ _ -> add -> new dictionary size = 1
_ a _ -> hat, cat -> new dictionary size = 2
_ _ a -> __ -> new dictionary size = 0
a _ a -> __ -> new dictionary size = 0
_ a a -> __ -> new dictionary size = 0
a a _ -> __ -> new dictionary size = 0
a a a -> __ -> new dictionary size = 0
_ _ _ -> dog -> new dictionary size = 1

Because _ a _ has the largest remaining words, that is chosen and the new dictionary becomes the current dictionary, and the user is told that the second letter is an ‘A’.
