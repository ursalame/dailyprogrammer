package Letter.Transformer;

import Letter.LetterSequence;

public interface Strategy {
    LetterSequence transformNext();
    boolean hasNext();
}
