package gach0n.mptp06mpykl.mp01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mp01.R;

public class ResultActivity extends AppCompatActivity {
    TextView sub1_1;
    TextView sub1_2;
    TextView sub1_3;
    TextView sub1_4;
    TextView sub1_5;
    TextView sub1_6;
    TextView sub1_7;
    TextView sub1_8;
    TextView sub1_9;
    TextView sub1_10;
    TextView sub2_1;
    TextView sub2_2;
    TextView sub2_3;
    TextView sub2_4;
    TextView sub2_5;
    TextView sub2_6;
    TextView sub2_7;
    TextView sub2_8;
    TextView sub2_9;
    TextView sub2_10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_menu2);

        sub1_1 = findViewById(R.id.sub1_1);
        sub1_2 = findViewById(R.id.sub1_2);
        sub1_3 = findViewById(R.id.sub1_3);
        sub1_4 = findViewById(R.id.sub1_4);
        sub1_5 = findViewById(R.id.sub1_5);
        sub1_6 = findViewById(R.id.sub1_6);
        sub1_7 = findViewById(R.id.sub1_7);
        sub1_8 = findViewById(R.id.sub1_8);
        sub1_9 = findViewById(R.id.sub1_9);
        sub1_10 = findViewById(R.id.sub1_10);
        sub2_1 = findViewById(R.id.sub2_1);
        sub2_2  = findViewById(R.id.sub2_2);
        sub2_3  = findViewById(R.id.sub2_3);
        sub2_4  = findViewById(R.id.sub2_4);
        sub2_5  = findViewById(R.id.sub2_5);
        sub2_6  = findViewById(R.id.sub2_6);
        sub2_7  = findViewById(R.id.sub2_7);
        sub2_8  = findViewById(R.id.sub2_8);
        sub2_9  = findViewById(R.id.sub2_9);
        sub2_10  = findViewById(R.id.sub2_1);

        sub1_7.setText("asdfasdfasdfasdf");
    }
}
