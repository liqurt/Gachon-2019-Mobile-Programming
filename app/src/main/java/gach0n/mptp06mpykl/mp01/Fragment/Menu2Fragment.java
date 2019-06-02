package gach0n.mptp06mpykl.mp01.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mp01.R;

import java.util.ArrayList;

public class Menu2Fragment extends Fragment {
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
    public Menu2Fragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu2,container,false);
        sub1_1 = v.findViewById(R.id.sub1_1);
        sub1_2 = v.findViewById(R.id.sub1_2);
        sub1_3 = v.findViewById(R.id.sub1_3);
        sub1_4 = v.findViewById(R.id.sub1_4);
        sub1_5 = v.findViewById(R.id.sub1_5);
        sub1_6 = v.findViewById(R.id.sub1_6);
        sub1_7 = v.findViewById(R.id.sub1_7);
        sub1_8 = v.findViewById(R.id.sub1_8);
        sub1_9 = v.findViewById(R.id.sub1_9);
        sub1_10 = v.findViewById(R.id.sub1_10);
        sub2_1 = v.findViewById(R.id.sub2_1);
        sub2_2 = v.findViewById(R.id.sub2_2);
        sub2_3 = v.findViewById(R.id.sub2_3);
        sub2_4 = v.findViewById(R.id.sub2_4);
        sub2_5 = v.findViewById(R.id.sub2_5);
        sub2_6 = v.findViewById(R.id.sub2_6);
        sub2_7 = v.findViewById(R.id.sub2_7);
        sub2_8 = v.findViewById(R.id.sub2_8);
        sub2_9 = v.findViewById(R.id.sub2_9);
        sub2_10 = v.findViewById(R.id.sub2_10);

        ViewGroup rootView =(ViewGroup) inflater.inflate(R.layout.fragment_menu2, container, false);
        return rootView;
    }

    public void update(String[] sub1_,String[] sub2_){
        sub1_1.setText(sub1_[0]);
        sub1_3.setText(sub1_[1]);
        sub1_5.setText(sub1_[2]);
        sub1_7.setText(sub1_[3]);
        sub1_9.setText(sub1_[4]);
        sub1_2.setText(sub1_[5]);
        sub1_4.setText(sub1_[6]);
        sub1_6.setText(sub1_[7]);
        sub1_8.setText(sub1_[8]);
        sub1_10.setText(sub1_[9]);
        sub2_1.setText(sub2_[0]);
        sub2_3.setText(sub2_[1]);
        sub2_5.setText(sub2_[2]);
        sub2_7.setText(sub2_[3]);
        sub2_9.setText(sub2_[4]);
        sub2_2.setText(sub2_[5]);
        sub2_4.setText(sub2_[6]);
        sub2_6.setText(sub2_[7]);
        sub2_8.setText(sub2_[8]);
        sub2_10.setText(sub2_[9]);
    }
}

