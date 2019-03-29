package ro.pub.cs.systems.eim.systems.practicaltest01var06;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class PracticalTest01Var02PlayActivity extends AppCompatActivity {
    private EditText generateText;
    private Button generateButton;
    private EditText score;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.generate_button:
                    Random r = new Random();
                    int value = r.nextInt(5);
                    Log.d("DEBUG", Integer.toString(value));
                    generateText.setText(Integer.toString(value));
                    break;

            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_second);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("score")) {
                score.setText(savedInstanceState.getString("score"));
            }
            if (savedInstanceState.containsKey("guess")) {
                generateText.setText(savedInstanceState.getString("guess"));
            }
        }

        generateText = (EditText) findViewById(R.id.generate_text);
        score = (EditText) findViewById(R.id.score_text);

        generateButton = (Button) findViewById(R.id.generate_button);
        generateButton.setOnClickListener(buttonClickListener);

        Intent intent = getIntent();
        if (intent != null) {
            int number = intent.getIntExtra("key", -1);
//            numberOfClicksTextView.setText(String.valueOf(numberOfClicks));
        }

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("score", score.getText().toString());
        savedInstanceState.putString("guess", generateText.getText().toString());

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("score")) {
            score.setText(savedInstanceState.getString("score"));
        }
        if (savedInstanceState.containsKey("guess")) {
            generateText.setText(savedInstanceState.getString("guess"));
        }

    }
}
