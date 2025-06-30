package anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AnagramDeterminerTester {

    @Test
    public void testBadInputNull() {
        var s1 = "abc";
        String s2 = null;
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        assertEquals(testResult, false);

    }

    @Test
    public void testBadInputEmpty() {
        var s1 = "abc";
        var s2 = "";
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        assertEquals(testResult, false);

    }

    @Test
    public void testBadInputNonAlpha() {
        var s1 = "abc1";
        var s2 = "cba1";
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        assertEquals(testResult, false);

    }

    @Test
    public void testIsAnagramLengthOne() {
        var s1 = "t";
        var s2 = "t";
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        assertEquals(testResult, true);

    }

    @Test
    public void testIsAnagramLowerCaseMatch() {
        var s1 = "tony";
        var s2 = "ynto";
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        assertEquals(testResult, true);

    }

    @Test
    public void testIsAnagramLowerCaseNoMatch() {
        var s1 = "tony";
        var s2 = "yntoo";
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        assertEquals(testResult, false);

    }

    @Test
    public void testIsAnagramMixedCaseMatch() {
        var s1 = "Tony";
        var s2 = "yNto";
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        assertEquals(testResult, true);

    }

    @Test
    public void testIsAnagramDupLetterMatch() {
        var s1 = "banana";
        var s2 = "nbanaa";
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        assertEquals(testResult, true);

    }

    @Test
    public void testIsAnagramDupLetterNoMatch() {
        var s1 = "sbanana";
        var s2 = "nbanaa";
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        assertEquals(testResult, false);

    }

    @Test
    public void testIsAnagramMultiWordMatch() {
        var s1 = "Bad dog NO TREAT";
        var s2 = "Trade toad BOng";
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        assertEquals(testResult, true);

    }

    @Test
    public void testIsAnagramMultiWordNoMatch() {
        var s1 = "Bad dog NO TREAT";
        var s2 = "Trade toad BOngg";
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        assertEquals(testResult, false);

    }

    @Test
    public void testIsAnagramPunctuationMatch() {
        var s1 = "Replay!";
        var s2 = "Player?";
        var testResult = AnagramDeterminer.isAnagram(s1, s2);

        assertEquals(testResult, true);

    }

}
