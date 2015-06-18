package com.melayer.interactivitycom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ProfileActivity extends Activity {

    private TextView textUserName;

    private Button btnGoBack;

    private String resultUserName = null;

    private Intent intentResponsible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textUserName = (TextView)findViewById(R.id.textUserName);

        intentResponsible = getIntent(); // getting data from intent
        Bundle bundle = intentResponsible.getExtras(); // getting bundle from intent
        String userName = bundle.getString(MainActivity.KEY_USER_ACT); //getting data from bundle

        if(textUserName != null) {

            textUserName.setText(userName);
            resultUserName = textUserName.getText().toString();
        }

        btnGoBack = (Button)findViewById(R.id.btnGoBack);
        btnGoBack.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                resultUserName += ""+System.currentTimeMillis();

                //Intent intentBack = new Intent();
                intentResponsible.putExtra("KEY_DATA_BACK", resultUserName);

                setResult(RESULT_OK, intentResponsible);
                finish();
            }
        });
    }
}
