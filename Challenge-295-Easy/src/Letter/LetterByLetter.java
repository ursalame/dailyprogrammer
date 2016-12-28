package Letter;

public class LetterByLetter {
    private LetterSequence start;
    private LetterSequence current;
    private LetterSequence end;
    private LetterComparator letterComparator;

    public LetterByLetter(String start, String end) {
        this.start = new LetterSequence(start);
        this.current = new LetterSequence(start);
        this.end = new LetterSequence(end);
        this.letterComparator = new LetterComparator();
    }

    public boolean hasNext() {
        return current.hasNext();
    }

    public LetterSequence transformNext() {
        if (this.hasNext() && letterComparator.compare(current.next(), end.next()) != 0) {
            current.setCurrentLetter(end.getCurrentLetter());
            return current;
        }
        return null;
    }

    public void reset() {
        current = start;
        end.resetIndex();
    }

    public void setIndex(int i) {
        current.setIndex(i);
        end.setIndex(i);
    }

    public LetterSequence changeCurrentLetter() {
        if (letterComparator.compare(current.getCurrentLetter(), end.getCurrentLetter()) != 0
                && current.setCurrentLetter(end.getCurrentLetter())) {
            return current;
        }
        return null;
    }
}
