package View;

import Letter.LetterSequence;

import java.util.Observable;

public class Console implements View {
    public void update(LetterSequence letterSequence) {
        if (letterSequence != null) {
            System.out.println(letterSequence);
        }
    }

    @Override
    public void update(Observable observable, Object o) {
        update((LetterSequence) o);
    }
}
