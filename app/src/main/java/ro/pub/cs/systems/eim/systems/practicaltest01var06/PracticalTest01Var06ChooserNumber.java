package ro.pub.cs.systems.eim.systems.practicaltest01var06;

import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var06ChooserNumber extends AppCompatActivity {
    private EditText NumberText;
    private Button playButton;


    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
//            int rightNumberOfClicks = Integer.valueOf(rightEditText.getText().toString());

            switch (view.getId()) {
                case R.id.play_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02PlayActivity.class);
                    int nr = Integer.parseInt(NumberText.getText().toString());
//                    int nr = 5;
                    intent.putExtra("key", nr);
                    startActivityForResult(intent, 1);
                    break;

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_choose_number);


        NumberText = (EditText) findViewById(R.id.number);
        playButton = (Button) findViewById(R.id.play_button);
        playButton.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}


