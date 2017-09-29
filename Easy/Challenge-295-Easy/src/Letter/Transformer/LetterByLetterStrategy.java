package Letter.Transformer;

import Letter.LetterByLetter;
import Letter.LetterSequence;

abstract class LetterByLetterStrategy implements Strategy {
    protected LetterByLetter letterByLetter;

    LetterByLetterStrategy(String start, String end) {
        this.letterByLetter = new LetterByLetter(start,end);
    }

    public abstract LetterSequence transformNext();

    @Override
    public boolean hasNext() {
        return letterByLetter.hasNext();
    }
}
