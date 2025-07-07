# Anagram Determiner

A simple Java utility class to efficiently determine if two strings are anagrams of each other.

## Overview

The `AnagramDeterminer` class provides a single, static method `isAnagram` that checks whether two given strings are anagrams. It's designed to be straightforward and handles common variations like case-insensitivity and the presence of spaces and punctuation.

## Features

* **Case-Insensitive:** Compares strings without regard to letter casing.

* **Punctuation and Space Handling:** Automatically ignores spaces, common punctuation (`.`, `,`, `;`, `:`, `!`, `?`), hyphens (`-`), underscores (`_`), and apostrophes (`'`) when determining anagrams.

* **Null/Empty String Handling:** Gracefully handles `null` or empty strings, returning `false`.

* **Simple API:** A single static method for ease of use.

## Usage

To use the `isAnagram` method, simply call it with two `String` arguments:

## Input Constraints

The `isAnagram` method expects strings that primarily contain letters of the English alphabet, spaces, and standard punctuation characters (including hyphens, underscores, and apostrophes). Strings that are `null` or become empty after trimming leading/trailing spaces will result in `false`.

## How it Works

The core logic involves:

1. **Cleaning:** Each input string is cleaned by trimming whitespace, validating allowed characters, and then removing all non-alphabetic characters (spaces, punctuation, etc.) and converting the remaining letters to lowercase.

2. **Length Check:** If, after cleaning, the two strings do not have the same length, they cannot be anagrams, and the method returns `false`.

3. **Character Frequency Mapping:** For each cleaned string, a frequency map is created where keys are individual characters and values are their counts within the string.

4. **Comparison:** The two character frequency maps are compared. If they are identical, the original strings are determined to be anagrams.

## License

This project is open-source and available under the [MIT License](https://www.google.com/search?q=LICENSE)
