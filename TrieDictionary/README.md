Dictionary:

The challenge is to construct a Dictionary using a Trie that has the following operations:
1.	Insert
2.	Delete
3.	Find (Boolean return)
4.	Count (number of total words)
5.	Clear All
6.	Number Of Nodes

A Trie is a tree that has the following properties
1.	The ROOT node has no specific letter identifier
2.	Each node has 26 children, one for each letter of the alphabet
3.	Each node has a count if the LAST letter of a word falls there, signifying that the dictionary contains that word
a.	For example if we only add the word CAR, the final R node will have a count of 1, while the A node will have a count of 0
