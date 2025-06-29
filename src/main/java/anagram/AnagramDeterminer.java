package anagram;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Class AnagramDeterminer provides static method isAnagram to determine
 * whether two input strings are anagrams of each other.
 * 
 * Stateless class AnagramDeterminer provides a single static method, 
 * isAnagram, that determines whether or not two input strings are anagrams
 * of each other, returning a boolean result.
 * 
 * Since this class is designed for this single purpose, it has been
 * declared final.
 * 
 * 
 */
public final class AnagramDeterminer {

	/**
	 * Method isAnagram determines whether or not two input strings are
	 * anagrams of each other.
	 * 
	 * Static method isAnagram receives two strings as input and determines
	 * whether or not they're anagrams of each other. Each string should
	 * only contain letters of the English alphabet, spaces, and standard
	 * punctuation characters, along with hyphens, underscores, 
	 * and apostrophes. Also, neither string should be null or empty
	 * after the removal of leading and trailing spaces
	 * 
	 * @param s1Str String containing characters from the English alphabet
	 * @param s2Str String containing characters from the English alphabet
	 * @return Result of type boolean indicating whether or not
	 * 			s1Str and s2Str are anagrams of each other.
	 */
	public static boolean isAnagram(String s1Str, String s2Str) {
		
		/* Method composition to retrieve Optional values for cleaned input, 
			and if valid, determine whether these values are anagrams of each other */
		Boolean isAnagramFinalResult 
					= getClean(s1Str)
						.map(s1Clean -> {
							Boolean isAnagram 
								= getClean(s2Str)
									.map(s2Clean -> 
										foundAnagram(s1Clean, s2Clean))
								.orElse(false);
								return isAnagram;
										})
							.orElse(false);
			
		return isAnagramFinalResult;
		
		
	}
	
	/* First validate the input string to ensure that it's neither null
	 *  nor empty and that it contains only letters of the English alphabet, 
	 *  blank spaces, or common punctuation characters and word separators 
	 *  (hyphens and underscores).
	 * If valid, remove all characters that are not alphabet letters 
	 *  and return the result wrapped in an Optional. */
	private static Optional<String> getClean(String inputStr) {
		
		Optional<String> cleanStrOptional
			= Optional.ofNullable(inputStr)
				.map(s -> s.trim())
				.filter(s -> s.length() > 0)
				.filter(s -> s.matches("[a-zA-Z \\.,;:!?\\-\\_']+"))
				.map(s -> s.replaceAll("[ \\.,;:!?\\-\\_']+", "")
							.toLowerCase());
		
		return cleanStrOptional;
	}
	
	/* First check whether both strings of cleaned input (with only 
	 * 	alphabet characters remaining) are the same length. If not, 
	 * 	immediately return false.
	 * Otherwise, create a map for each input string, where each key is a distinct
	 * 	alphabet letter of that string and the corresponding value
	 * 	is the number of times that letter appears in the string. 
	 * If both resulting maps are equal, then the corresponding input
	 * 	strings must also be equal. */
	private static boolean foundAnagram(String s1Clean, String s2Clean) {
		if (s1Clean.length() != s2Clean.length()) {
			return false;
		}
		
		char [] s1Arr = s1Clean.toCharArray();
		char [] s2Arr = s2Clean.toCharArray();
		
		Map<Character, Integer> s1Map = new HashMap<>();
		
		for (char s1Char: s1Arr) {
			s1Map.merge(s1Char, 1, Integer::sum);
		}
		
		Map<Character, Integer> s2Map = new HashMap<>();
		for (char s2Char: s2Arr) {
			s2Map.merge(s2Char, 1, Integer::sum);
		}
		
		return s1Map.equals(s2Map);
	}
	
}
