package gach0n.mptp06mpykl.mp01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mp01.R;

public class ResultActivity extends AppCompatActivity {
    TextView low_price;
    TextView pro_name;
    TextView pro_price;
    Button prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

        prev = findViewById(R.id.previous);
        low_price = findViewById(R.id.output);
        pro_name = findViewById(R.id.prod_name);
        pro_price = findViewById(R.id.prod_price);
        Intent intent = getIntent();
        Bundle myBundle = intent.getExtras();
        String val2 = myBundle.getString("content1");
        String val3 = myBundle.getString("content2");

        pro_name.setText(val2);
        pro_price.setText(val3);


        prev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}
