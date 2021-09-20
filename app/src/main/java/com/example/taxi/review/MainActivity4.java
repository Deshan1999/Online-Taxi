package com.example.taxi.review;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.taxiapp2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity4 extends AppCompatActivity {

    TextView txt1 , txt2;
    EditText t10 , t10U1;
    LinearLayout l1,l2, l2U1, layout;
    RatingBar simpleRatingBar , simpleRatingBar2 , simpleRatingBar3;
    String intentId , krySeleced , name ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        l2U1 = findViewById(R.id.l1U1);
        layout = findViewById(R.id.layout);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);

        l1.setVisibility(View.VISIBLE);
        l2.setVisibility(View.GONE);
        l2U1.setVisibility(View.GONE);

        t10 = findViewById(R.id.t10);
        t10U1 = findViewById(R.id.t10U1);

        simpleRatingBar = findViewById(R.id.ratingBar);
        simpleRatingBar2 = findViewById(R.id.ratingBar2);
        simpleRatingBar3 = findViewById(R.id.ratingBarU1);


        Intent i = getIntent();
        intentId = i.getStringExtra("id");
        name = i.getStringExtra("name");

        Toast.makeText(MainActivity4.this, "passed Id " + intentId, Toast.LENGTH_LONG).show();

        DatabaseReference familyListReference = FirebaseDatabase.getInstance().getReference().child("ratings");
        familyListReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String key = (String) ds.getKey();
                    DatabaseReference keyReference = FirebaseDatabase.getInstance().getReference().child("ratings").child(key);
                    keyReference.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String comment = dataSnapshot.child("comment").getValue(String.class);
                            String rating = dataSnapshot.child("rating").getValue(String.class);
                            String userID = dataSnapshot.child("userID").getValue(String.class);
                            if(userID.equals(intentId)){
                                l2.setVisibility(View.VISIBLE);
                                l1.setVisibility(View.GONE);
                                krySeleced = key;
                                txt2.setText(name);
                                txt1.setText(comment);
                                simpleRatingBar2.setRating(Float.valueOf(rating));
                                simpleRatingBar2.setEnabled(false);
                            }
                            else {
                                l1.setVisibility(View.VISIBLE);
                                l2.setVisibility(View.GONE);
                            }
                            if(!userID.equals(intentId)){
                                loadData(name ,rating ,  comment);
                            }

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void loadData(String name2 , String ratngs , String Comment){
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(10, 10, 10, 10);
        ll.setLayoutParams(params);

        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params2.setMargins(20, 20, 20, 20);

        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        final int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            ll.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.border) );
        } else {
            ll.setBackground(ContextCompat.getDrawable(this, R.drawable.border));
        }

        TextView tv = new TextView(this);
        tv.setText(name2);
        tv.setTextColor(getResources().getColor(R.color.black));
        ll.addView(tv);
        tv.setLayoutParams(params2);

        RatingBar rb = new RatingBar(getApplicationContext());
        // now set num of stars
        rb.setNumStars(5);
        rb.setRating(Float.valueOf(ratngs));
        rb.setEnabled(false);
        rb.setLayoutParams(params3);

        ll.addView(rb);

        TextView tv2 = new TextView(this);
        tv2.setText(Comment);
        ll.addView(tv2);
        tv2.setLayoutParams(params2);

        layout.addView(ll);


    }
    public void postReview(View view){
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        ratings rt = new ratings(intentId ,String.valueOf(simpleRatingBar.getRating()) , t10.getText().toString() );

        DatabaseReference myRef2 = database.getReference("ratings");

        finish();
        myRef2.push().setValue(rt);
        Intent i = new Intent(MainActivity4.this, MainActivity4.class);
        i.putExtra("id", intentId);
        i.putExtra("name", name);
        startActivity(i);
        Toast.makeText(MainActivity4.this, "Rating saved Successful", Toast.LENGTH_LONG).show();
    }

    public void displayUpdateWindow(View view){
        l2.setVisibility(View.GONE);
        l2U1.setVisibility(View.VISIBLE);

        simpleRatingBar3.setRating(Float.valueOf(simpleRatingBar2.getRating()));
        t10U1.setText(txt1.getText().toString());
    }

    public void cancelUpdate(View view){
        l2.setVisibility(View.VISIBLE);
        l2U1.setVisibility(View.GONE);
    }

    public void updateRatings(View view){
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        ratings rt = new ratings(intentId ,String.valueOf(simpleRatingBar3.getRating()) , t10U1.getText().toString() );

        DatabaseReference myRef2 = database.getReference("ratings").child(krySeleced);

        finish();
        myRef2.setValue(rt);
        Intent i = new Intent(MainActivity4.this, MainActivity4.class);
        i.putExtra("id", intentId);
        i.putExtra("name", name);
        startActivity(i);
        Toast.makeText(MainActivity4.this, "Rating saved Successful", Toast.LENGTH_LONG).show();
    }
    public void deleteReview(View v){
        DatabaseReference familyListReference = FirebaseDatabase.getInstance().getReference().child("ratings").child(krySeleced);
        familyListReference.getRef().removeValue();

        finish();
        Intent i2 = new Intent(this, MainActivity4.class);
        i2.putExtra("id", intentId);
        i2.putExtra("name", name);
        startActivity(i2);
    }

}