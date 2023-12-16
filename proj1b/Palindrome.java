public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> Lld = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            char currentChar = word.charAt(i);
            Lld.addLast(currentChar);
        }
        return Lld;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        int word_len = word.length();
        for (int i = 0; i < word_len/2; i+=1){
            char front = word.charAt(i);
            char back = word.charAt(word_len - i - 1 );
            if (!cc.equalChars(front, back)){
                return false;
            }
        }
        return true;
    }
}
