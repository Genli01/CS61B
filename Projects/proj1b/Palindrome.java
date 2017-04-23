/**
 * Created by Gen on 4/22/17.
 */
public class Palindrome {

    public static Deque<Character> wordToDeque(String word) {
        Deque<Character> charactersFromWord = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            charactersFromWord.addLast(word.charAt(i));
        }
        //charactersFromWord.printDeque();
        return charactersFromWord;
    }
    public static boolean isPalindrome(String word) {
        Deque<Character> charactersFromWord = wordToDeque(word);
        return isPalindrome(charactersFromWord);
    }
    public static boolean isPalindrome(Deque<Character> characters) {
        if (characters.size() <= 1) {
            return true;
        }
        if (characters.removeFirst() == characters.removeLast()) {
            return isPalindrome(characters);
        }
        return false;
    }
    public static boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> charactersFromWord = wordToDeque(word);
        return isPalindrome(charactersFromWord, cc);
    }
    public static boolean isPalindrome(Deque<Character> characters, CharacterComparator cc) {
        if (characters.size() <= 1) {
            return true;
        }
        if (cc.equalChars(characters.removeFirst(), characters.removeLast())) {
            return isPalindrome(characters, cc);
        }
        return false;
    }

}
