package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText numberInput;
    private Button callBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = numberInput.getText().toString().trim();
                if(number.isEmpty()){
                    numberInput.setError("enter valid phone number");
                }else{
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+number));
                    startActivity(intent);

                }

            }
        });
    }

    private void init() {
        callBtn = findViewById(R.id.call);
        numberInput = findViewById(R.id.numET);
    }
}
