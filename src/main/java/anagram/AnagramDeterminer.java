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
	 * and apostrophes.
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
	
	/* First validate the input string to ensure that it contains only letters
	 * 	of the English alphabet, blank spaces, or common punctuation characters
	 * 	and word separators (hyphens and underscores).
	 * If valid, remove all characters that are not alphabet letters 
	 *  and return the result wrapped in an Optional. */
	private static Optional<String> getClean(String inputStr) {
		if (inputStr == null) {
				return Optional.empty();
		}
		
		String cleanStr = inputStr.trim();
		if (cleanStr.length() == 0) {
			return Optional.empty();
		}
		
		if (! cleanStr.matches("[a-zA-Z \\.,;:!?\\-\\_']+")) {
			return Optional.empty();
		}
		
		cleanStr = cleanStr.replaceAll("[ \\.,;:!?\\-\\_']+", "")
					.toLowerCase();
		
		return Optional.of(cleanStr);
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
		
		char [] sArr = s1Clean.toCharArray();
		char [] tArr = s2Clean.toCharArray();
		
		Map<Character, Integer> sMap = new HashMap<>();
		
		for (char s: sArr) {
			sMap.merge(s, 1, Integer::sum);
		}
		
		Map<Character, Integer> tMap = new HashMap<>();
		for (char t: tArr) {
			tMap.merge(t, 1, Integer::sum);
		}
		
		return sMap.equals(tMap);
	}
	
}
