package com.example.shopprofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class SaveDetails extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    FirebaseDatabase root;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_details);
        Button b1=findViewById(R.id.b1);
        e1=findViewById(R.id.editTextTextPersonName);
        e3=findViewById(R.id.editTextTextPersonName3);
        e4=findViewById(R.id.editTextTextPersonName4);
        e5=findViewById(R.id.editTextTextPersonName5);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent();
                a.setClass(getApplicationContext(),MainActivity.class);
                root=FirebaseDatabase.getInstance("https://shopprofit-828d1-default-rtdb.asia-southeast1.firebasedatabase.app/");
                ref=root.getReference("Items");
                String s1=e1.getEditableText().toString().toLowerCase(Locale.ROOT);
                String s3=e3.getEditableText().toString().toLowerCase(Locale.ROOT);
                String s4=e4.getEditableText().toString().toLowerCase(Locale.ROOT);
                String s5=e5.getEditableText().toString().toLowerCase(Locale.ROOT);
                String s6=s1+s3;
                DataStore ds=new DataStore(s1,s3,s4,s5,s6);
                ref.child(s6).setValue(ds);
                startActivity(a);
            }
        });
    }
}