package Letter;

import java.util.ArrayList;

public class LetterSequence {
    private ArrayList<Letter> letters;
    private int index = -1;

    public LetterSequence(String s) {
        letters = new ArrayList<Letter>();
        for (char c : s.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    public boolean hasNext() {
        return index < letters.size()-1;
    }

    public Letter getCurrentLetter() {
        if (isIndexValid()) {
            return letters.get(index);
        }
        return null;
    }

    public Letter next() {
        if (hasNext()) {
            return letters.get(++index);
        }
        return null;
    }

    public int getIndex() {
        return index;
    }

    public boolean setIndex(int index) {
        if (isIndexValid(index)) {
            this.index = index;
            return true;
        }
        return false;
    }

    public void resetIndex() {
        this.index = -1;
    }

    public boolean setCurrentLetter(Letter l) {
        if (isIndexValid()) {
            letters.set(index, l);
            return true;
        }
        return false;
    }

    private boolean isIndexValid(int index) {
        return (index < letters.size() && index >= 0);
    }

    private boolean isIndexValid() {
        return isIndexValid(this.index);
    }

    @Override
    public String toString() {
        char arr[] = new char[letters.size()];
        for (int i = 0; i < letters.size(); i++) {
            Letter l = letters.get(i);
            arr[i] = l.toChar();
        }
        return new String(arr);
    }
}
