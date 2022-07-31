
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    private boolean helperIsPalindrome(Deque<Character> d) {
        if (d.size() <= 1) {
            return true;
        }

        char first = d.removeFirst();
        char last = d.removeLast();
        return first == last && helperIsPalindrome(d);
    }
    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        return helperIsPalindrome(deque);
    }

    private boolean helperIsPalindrome(Deque<Character> d, CharacterComparator cc) {
        if (d.size() <= 1) {
            return true;
        }

        char first = d.removeFirst();
        char last = d.removeLast();

        return cc.equalChars(first, last) && helperIsPalindrome(d, cc);
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        return helperIsPalindrome(wordToDeque(word), cc);
    }

}
