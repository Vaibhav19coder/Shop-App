package com.example.shopprofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class SearchDetails extends AppCompatActivity {
    EditText e1,e3;
    TextView t1,t3;
    String s1,s2,s3,s4;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_details);
        b=findViewById(R.id.button);
        e1=findViewById(R.id.e6);
        e3=findViewById(R.id.e8);
        t1=findViewById(R.id.textView6);
        t3=findViewById(R.id.textView8);
        b.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString().trim().toLowerCase(Locale.ROOT);
                s3=e3.getText().toString().trim().toLowerCase(Locale.ROOT);
                s4=s1+s3;
                t1.setText("Item and Company and Weight");
                t3.setText("CP / SP");
                fetch();
            }
        });
    }
    public void fetch()
    {
        Query q = FirebaseDatabase.getInstance("https://shopprofit-828d1-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Items").orderByChild("pkey").equalTo(s4);
        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    e1.setText(s1+"_"+s3);
                    String s=snapshot.child(s4).child("cp").getValue(String.class);
                    String st=snapshot.child(s4).child("sp").getValue(String.class);
                    e3.setText(s+" / "+st);

                }
                else
                {
                    Toast.makeText(getApplicationContext(),s4+"Item",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}