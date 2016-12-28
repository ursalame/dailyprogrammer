package Letter;

public class Letter implements Comparable<Letter> {
    private char c;

    public Letter(char c) {
        this.c = c;
    }

    public char toChar() {
        return c;
    }

    @Override
    public int compareTo(Letter letter) {
        return Character.compare(this.c, letter.toChar());
    }
}
