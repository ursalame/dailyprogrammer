package Letter.Transformer;

import Letter.LetterSequence;

class LetterByLetterBasicStrategy extends LetterByLetterStrategy {

    LetterByLetterBasicStrategy(String start, String end) {
        super(start, end);
    }

    @Override
    public LetterSequence transformNext() {
        return letterByLetter.transformNext();
    }
}
