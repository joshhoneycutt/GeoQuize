package jhoneycutt.com.geoquize;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

/**
 * Created by Josh on 6/22/16.
 */
public class CheatActivity extends Activity{

    public static final String EXTRA_ANSWER_IS_TRUE = "jhoneycutt.com.geoquize.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "jhoneycutt.com.geoquize.answer_shown";

    private boolean mAnswerIsTrue;

    private TextView mAnswerTextView;
    private Button mShowAnswer;

    private void setAnswerShownResults(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView)findViewById(R.id.answerTextView);

        mShowAnswer = (Button)findViewById(R.id.showAnswerButton);

        setAnswerShownResults(false);

        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v) {
                if(mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                }else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                setAnswerShownResults(true);
            }
        });
    }

}
