package anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnagramDeterminerTest {

    @Test
    @DisplayName("Any null input should result in false")
    public void isAnagram_Null_False() {
        
        // Arrange
        var s1 = "abc";
        String s2 = null;
        
        // Act
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        // Assert
        assertEquals(false, testResult);

    }

    @Test
    @DisplayName("Any empty input should result in false")
    public void isAnagram_Empty_False() {
        
        // Arrange
        var s1 = "abc";
        var s2 = "";
        
        // Act
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        // Assert
        assertEquals(false, testResult);

    }

    @Test
    @DisplayName("Invalid characters (including numeric) should result in false")
    public void isAnagram_Invalid_False() {
        
        // Arrange
        var s1 = "abc1";
        var s2 = "cba1";
        
        // Act
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        // Assert
        assertEquals(false, testResult);

    }

    @Test
    @DisplayName("Matching inputs of length 1 should result in true")
    public void isAnagram_SameOneChar_True() {
        
        // Arrange
        var s1 = "t";
        var s2 = "t";
        
        // Act
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        
        // Assert
        assertEquals(true, testResult);

    }

    @Test
    @DisplayName("Valid inputs with matching alphabet characters should result in true")
    public void isAnagram_SameChars_True() {
        
        // Arrange
        var s1 = "tony .";
        var s2 = "ynto";
        
        // Act
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        // Assert
        assertEquals(true, testResult);

    }

    @Test
    @DisplayName("Matching characters but differing character counts should result in false")
    public void isAnagram_DiffCharNums_False() {
        
        // Arrange
        var s1 = "tony";
        var s2 = "yntoo";
        
        // Act
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        // Assert
        assertEquals(false, testResult);

    }

    @Test
    @DisplayName("Matching characters but differing letter cases should result in true")
    public void isAnagram_SameCharsDiffCase_True() {
        
        // Arrange
        var s1 = "Tony";
        var s2 = "yNto";
        
        // Act
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        // Assert
        assertEquals(true, testResult);

    }

    @Test
    @DisplayName("Matching characters with matching duplicates should result in true")
    public void isAnagram_SameDupChars_True() {
        
        // Arrange
        var s1 = "banana";
        var s2 = "nbanaa";
        
        // Act
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        // Assert
        assertEquals(true, testResult);

    }

    @Test
    @DisplayName("Matching characters with differing duplicates should result in false")
    public void isAnagram_DiffDupChars_False() {
        
        // Arrange
        var s1 = "sbanana";
        var s2 = "nbanaa";
        
        // Act
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        // Assert
        assertEquals(false, testResult);

    }

    @Test
    @DisplayName(("Matching characters in multiple words should result in true"))
    public void isAnagram_SameCharsMultiWord_True() {
        
        // Arrange
        var s1 = "Bad dog NO TREAT";
        var s2 = "Trade toad BOng";
        
        // Act
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        // Assert
        assertEquals(true, testResult);

    }

    @Test
    @DisplayName("Matching chars, differing duplicates in multiple words should result in false")
    public void isAnagram_DiffCharsMultiWord_False() {
        
        // Arrange
        var s1 = "Bad dog NO TREAT";
        var s2 = "Trade toad BOngg";
        
        // Act
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        // Assert
        assertEquals(false, testResult);

    }

    @Test
    @DisplayName("Matching characters but differing punctuation should result in true")
    public void isAnagram_SameCharsDiffPunct_True() {
        
        // Arrange
        var s1 = "Replay!";
        var s2 = "Player?";
        
        // Act
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        // Assert
        assertEquals(true, testResult);

    }

}
