package com.vuongthanh.t3h.baitap_buoi7_gamedhbc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Test extends AppCompatActivity {
    private LinearLayout ln1;
    private LinearLayout ln2;
    private CustomButton btn1;
    private CustomButton btn2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        innitView();
    }

    private void innitView() {
        ln1 = findViewById(R.id.ln1);
        ln2 = findViewById(R.id.ln2);
        btn1 = new CustomButton(this);
        btn1.setText("btn1");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setVisibility(View.INVISIBLE);
                Toast.makeText(Test.this,"dd",Toast.LENGTH_LONG).show();
            }
        });
       // btn1.setId(1);
        ln1.addView(btn1);

        btn2 = new CustomButton(this);
        btn2.setText("btn2");
        ln2.addView(btn2);
    }

}
