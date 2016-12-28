package Letter.Transformer;

import Letter.LetterSequence;

import java.util.Observable;

public class LetterByLetterTransformer extends Observable {

    public void transform(String start, String end) {
        Strategy strategy = new LetterByLetterBasicStrategy(start, end);

        while(strategy.hasNext()){
            LetterSequence letterSequence = strategy.transformNext();
            setChanged();
            notifyObservers(letterSequence);
        }
    }
}
