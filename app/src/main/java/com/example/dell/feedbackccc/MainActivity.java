package com.example.dell.feedbackccc;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {
        EditText text = (EditText) findViewById(R.id.for_name);
        String valueN = text.getText().toString();
        EditText text1 = (EditText) findViewById(R.id.for_feedback);
        String valueF = text1.getText().toString();
        String message= createsummary(valueN,valueF);
        Intent intentf=new Intent(Intent.ACTION_SENDTO);
        intentf.setData(Uri.parse("mailto:"));
        intentf.putExtra(Intent.EXTRA_SUBJECT,"Feedback");
        intentf.putExtra(Intent.EXTRA_TEXT,message);
        if (intentf.resolveActivity(getPackageManager())!=null)
        {
            startActivity(intentf);
        }

    }

    private String createsummary(String valueN,String valueF)
    { String message =" Name : "+valueN;
      message=message+"\nComplain: "+valueF;
       return message;
    }

}