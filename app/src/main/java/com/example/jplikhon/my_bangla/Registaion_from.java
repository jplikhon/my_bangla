package com.example.jplikhon.my_bangla;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jplikhon.my_bangla.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Registaion_from extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference users;
    EditText username,mailadress,password;
    CardView signup;
    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registaion_from);
        username = (EditText) findViewById (R.id.username);
        mailadress = (EditText) findViewById (R.id.mailadress);
        password = (EditText) findViewById (R.id.pasword);
        signup = (CardView) findViewById(R.id.signup);
        msg = (TextView) findViewById(R.id.msg);
        //firebase
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final User user = new User(username.getText().toString(),
                                        mailadress.getText().toString(),
                                        password.getText().toString());
                users.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(user.getUsername()).exists())
                            msg.setText("Your User name is not available");
                        else {
                            users.child(user.getUsername()).setValue(user);
                            msg.setText("Registration is successful");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }

}
