import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /* You must use this palindrome, and not instantiate
       new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome(); */
    static Palindrome palindrome = new Palindrome();
    @Test
    public void testWordToDeque() {

        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } /*Uncomment this class once you've created your Palindrome class. */

    @Test
    public void testPalindrome(){
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("a"));
        assertFalse(palindrome.isPalindrome("aA"));
        assertTrue(palindrome.isPalindrome("aa"));
    }

    @Test
    public void testNewPalindrome(){
        OffByOne ofb = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", ofb));
        assertFalse(palindrome.isPalindrome("flooke", ofb));
        assertTrue(palindrome.isPalindrome("a", ofb));
        assertFalse(palindrome.isPalindrome("oo", ofb));
    }

}
