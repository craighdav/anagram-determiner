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

For examples on how to use the `isAnagram` method and to see various test cases, please refer to the `AnagramDeterminerTest.java` file in the `src/test/java/anagram` directory of this repository. The unit tests demonstrate different scenarios, including valid anagrams, edge cases, and handling of special characters.

## Input Constraints

The `isAnagram` method expects strings that primarily contain letters of the English alphabet, spaces, and standard punctuation characters (including hyphens, underscores, and apostrophes). Strings that are `null` or become empty after trimming leading/trailing spaces will result in `false`.

## Key Technical Highlights

This implementation showcases a modern Java approach, leveraging several key features for conciseness and robustness:

* **Declarative Method Composition with Optional:** The input cleaning and initial validation are handled elegantly using Optional and a chain of map and filter operations. This promotes a functional, readable style that gracefully handles null and empty string scenarios.
* **Efficient Character Counting with Map.merge():** Character frequency mapping, a core step in anagram detection, is performed efficiently using HashMap and the Map.merge() method. This concise construct simplifies the logic for incrementing character counts.

## Implementation Details

The core logic involves:

1. **Cleaning:** Each input string is cleaned by trimming whitespace, validating allowed characters, and then removing all non-alphabetic characters (spaces, punctuation, etc.) and converting the remaining letters to lowercase.

2. **Length Check:** If, after cleaning, the two strings do not have the same length, they cannot be anagrams, and the method returns `false`.

3. **Character Frequency Mapping:** For each cleaned string, a frequency map is created where keys are individual characters and values are their counts within the string.

4. **Comparison:** The two character frequency maps are compared. If they are identical, the original strings are determined to be anagrams.

## License

This project is open-source and available under the [MIT License](https://www.google.com/search?q=LICENSE)
