package com.xiongxh.cryptocoin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.xiongxh.cryptocoin.coindetails.CoinDetailActivity;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText memail_et;
    private EditText mpassword_et;
    private Button mlog_in_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        memail_et = (EditText) findViewById(R.id.et_email);
        mpassword_et = (EditText) findViewById(R.id.et_password);
        mlog_in_btn = (Button) findViewById(R.id.btn_sign_in);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser() == null){

                    startActivity(new Intent(MainActivity.this , CoinDetailActivity.class));

                }
            }
        };

        mlog_in_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){

                startSignIn();

            }


        });


    }


    @Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthListener);

    }

    private void startSignIn(){

        String email = memail_et.getText().toString();
        String password = mpassword_et.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull com.google.android.gms.tasks.Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    Toast.makeText(MainActivity.this, "Sign In Problem", Toast.LENGTH_LONG).show();

                } else {


                }

            }
        });


    }

}
