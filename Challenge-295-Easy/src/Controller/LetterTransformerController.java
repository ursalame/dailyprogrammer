package Controller;

import Letter.Transformer.LetterByLetterTransformer;
import Letter.LetterSequence;
import View.View;

public class LetterTransformerController implements Controller {
    private View view;

    public LetterTransformerController(View view) {
        this.view = view;
    }

    public void updateView(LetterSequence ls) {
        view.update(ls);
    }

    public void transform(String start, String end) {
        LetterByLetterTransformer letterByLetterTransformer = new LetterByLetterTransformer();
        letterByLetterTransformer.addObserver(this.view);
        letterByLetterTransformer.transform(start,end);
    }
}
