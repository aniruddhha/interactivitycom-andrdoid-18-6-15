package com.melayer.interactivitycom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    public static final String KEY_USER_ACT = "key_user_act";

    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUserName = (EditText)findViewById(R.id.edtUserName);

        edtPassword = (EditText)findViewById(R.id.edtPassword);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = edtUserName.getText().toString();

                String password = edtPassword.getText().toString();

                if(userName.equals("android") && password.equals("android")) {
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    intent.putExtra(KEY_USER_ACT,userName);
                    //startActivity(intent);

                    startActivityForResult(intent,1111);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1111){

            if(resultCode == RESULT_OK){

                if(data != null){

                    Log.i("##############","Okay");

                    Bundle bundle = data.getExtras();
                    String resultUserName = bundle.getString("KEY_DATA_BACK");

                    edtUserName.setText(resultUserName);
                }
            }
        }
    }
}
