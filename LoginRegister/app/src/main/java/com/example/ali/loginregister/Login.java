package com.example.ali.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener{

    Button bLogin, bSignUp;
    EditText etUserName, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);
        bLogin.setOnClickListener(this);
        bSignUp = (Button) findViewById(R.id.bSignUp);
        bSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bLogin:

                Searchmanager sm = Searchmanager.getInstance();
                if(sm.searchUser(etUserName.getText().toString(), etPassword.getText().toString())){
                    Intent intent = new Intent(this,SearchActivity.class);
                    sm.getUser(etUserName.getText().toString());
                    startActivity(intent);
                } else
                    Toast.makeText(getApplicationContext(), "User Not Found. Please enter valid user details", Toast.LENGTH_LONG).show();

                break;
            case R.id.bSignUp:
                startActivity(new Intent(this, Register.class));
                break;

        }

    }
}
