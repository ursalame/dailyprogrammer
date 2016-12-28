package View;

import Letter.LetterSequence;

import java.util.Observer;

public interface View extends Observer {
    void update(LetterSequence ls);
}
