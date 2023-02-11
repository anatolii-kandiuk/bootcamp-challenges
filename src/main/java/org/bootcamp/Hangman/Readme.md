Hangman

Hangman is a word-guessing game. It keeps asking the user to guess characters until:

    They guess every character correctly (win).

    They miss 6 guesses (loss).

Why is hangman your capstone project?

    It's hard.

    It will effectively test your ability to apply concepts from Module one. 

    It will challenge you to get creative and do some research. As a developer, it's important that you practice finding resources online. 

Tips before you start

    If you struggle building hangman, that's good! That means you will learn a lot by trying to solve it.

    As you're building hangman, you're likely going to get bugs (unexpected results). The best way to fix bugs is to use breakpoints.

    You don't have to go through this alone. The community is a great place to ask questions.

Instructions

Because this is your capstone project, the instructions are less detailed. Unlike the workbooks and challenges, the instructions will only tell you what the task is. They will not explain nor guide you towards completing the task.

Finally, I encourage you to read all of the instructions before starting your code. I left some helpful hints in the end.

At every turn, you need to show the gallows.

In your starter project, you'll find an array: String[] gallows. Each String in the array reflects the number of times the user guessed incorrectly

You need to show the gallows at every turn. This should be your output when the user misses two guesses.

You need to keep track of every incorrect guess the user made. This helps the user not make the same mistake twice.

When the user guesses correctly, replace the matching placeholders.

Possible Design and Hints

1. Hints

Look up how to:

    Convert a String to an array of characters.

    Get the index of a character in a String.

    Loop through characters in a String.

    check if two arrays are equal to each other.

2. Possible design

There are many ways to build Hangman. Here's a possible design for your functions:

    randomWord(): returns a random word from the list of random words.

    checkGuess(): returns true if the user guessed a letter from the word correctly.

    updatePlaceholders(): updates the placeholders when the user makes a correct guess.

    printPlaceholders(): prints the placeholders.

    printMissedGuesses(): prints guesses that the user missed.


