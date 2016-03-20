package com.example.user.hmw3reciever;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int recievedInd;
    private String recievedString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        TextView mytxt= (TextView)findViewById(R.id.mytxt);
        if(intent.getType()!=null) {
            mytxt.setText("if1");
            if (intent.getType().equals("text/plain")) {
                mytxt.setText("if2");
                if (intent.getAction().equals(Intent.ACTION_SEND_MULTIPLE)) {
                    mytxt.setText("if3");
                    recievedInd = intent.getIntExtra("intValue", -1);
                    recievedString = intent.getStringExtra("stringValue");
                }
            }
            recievedInd = 222;
            recievedString = "Changed String";
            Intent resultIntenr = new Intent("com.example.RESULT_ACTION");
            resultIntenr.putExtra("intValue", recievedInd);
            resultIntenr.putExtra("stringValue", recievedString);
            setResult(Activity.RESULT_OK, resultIntenr);
            mytxt.setText("finish");
            finish();
        }

    }
}
