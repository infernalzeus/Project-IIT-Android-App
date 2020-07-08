package com.example.projectiitapp;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class ChemistryPage extends AppCompatActivity  {

DatabaseReference ref,qnos;
TextView q, correctans, wrongans; int n=0;
private SharedPreferences mPreferences;
private SharedPreferences.Editor mEditor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemistry_page);
        Button physical = findViewById(R.id.physical);
        final Button  opA, opB, opC, opD;
        Button organic, inorganic;
        organic= findViewById(R.id.organic);
        inorganic=findViewById(R.id.inorganic);
        opA=findViewById(R.id.opAbutton);
        opB=findViewById(R.id.opBbutton);opC=findViewById(R.id.opCbutton);opD=findViewById(R.id.opDbutton);

        getSupportActionBar().hide();
        q = (TextView) findViewById(R.id.question);
        correctans=findViewById(R.id.correctans);
        wrongans=findViewById(R.id.wrongans);
        mPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        mEditor=mPreferences.edit();


                physical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String qset="physical";
                final String ca="chemistry_physical_correct";
                final String aa="chemistry_physical_attempted";
                opA.setEnabled(true);
                opB.setEnabled(true);
                opC.setEnabled(true);
                opD.setEnabled(true);

                correctans.setText("");
                wrongans.setText("");
                qnos = FirebaseDatabase.getInstance().getReference().child("pqchemistry").child(qset);

                qnos.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String qno = dataSnapshot.child("qnos").getValue().toString();

                        Random rand=new Random();
                        n = rand.nextInt(Integer.parseInt(qno));
                        String i = Integer.toString(n+1);

                        ref = FirebaseDatabase.getInstance().getReference().child("pqchemistry").child(qset).child(i);
                        ref.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                String question = dataSnapshot.child("Q").getValue().toString();
                                q.setText(question);
                                String opa=dataSnapshot.child("A").getValue().toString();
                                String opb=dataSnapshot.child("B").getValue().toString();
                                String opc=dataSnapshot.child("C").getValue().toString();
                                String opd=dataSnapshot.child("D").getValue().toString();
                                final String ans = dataSnapshot.child("R").getValue().toString();
                                opA.setText("A : "+opa); opB.setText("B : "+opb);opC.setText("C : "+opc);opD.setText("D : "+opd);


                                opA.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        opA.setEnabled(false);
                                        opB.setEnabled(false);
                                        opC.setEnabled(false);
                                        opD.setEnabled(false);


                                        if(ans.equals("A")){
                                            correctans.setText("Correct Answer is "+ans);

                                            mEditor.putInt(ca, mPreferences.getInt(ca, 0)+1);
                                            mEditor.commit();

                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();


                                        }
                                        else
                                        {
                                            wrongans.setText("Wrong answer, Correct answer: "+ans);
                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();
                                        }
                                    }
                                });
                                opC.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        opA.setEnabled(false);
                                        opB.setEnabled(false);
                                        opC.setEnabled(false);
                                        opD.setEnabled(false);

                                        if(ans.equals("C")){
                                            correctans.setText("Correct Answer is "+ans);

                                            mEditor.putInt(ca, mPreferences.getInt(ca, 0)+1);
                                            mEditor.commit();

                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();


                                        }
                                        else
                                        {
                                            wrongans.setText("Wrong answer, Correct answer: "+ans);
                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();
                                        }
                                    }
                                });
                                opB.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        opA.setEnabled(false);
                                        opB.setEnabled(false);
                                        opC.setEnabled(false);
                                        opD.setEnabled(false);

                                        if(ans.equals("B")){
                                            correctans.setText("Correct Answer is "+ans);

                                            mEditor.putInt(ca, mPreferences.getInt(ca, 0)+1);
                                            mEditor.commit();

                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();


                                        }
                                        else
                                        {
                                            wrongans.setText("Wrong answer, Correct answer: "+ans);
                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();
                                        }
                                    }
                                });
                                opD.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        opA.setEnabled(false);
                                        opB.setEnabled(false);
                                        opC.setEnabled(false);
                                        opD.setEnabled(false);

                                        if(ans.equals("D")){
                                            correctans.setText("Correct Answer is "+ans);

                                            mEditor.putInt(ca, mPreferences.getInt(ca, 0)+1);
                                            mEditor.commit();

                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();


                                        }
                                        else
                                        {
                                            wrongans.setText("Wrong answer, Correct answer: "+ans);
                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();
                                        }
                                    }
                                });


                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        }); //physical button ends

                organic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String qset="organic";
                final String ca="chemistry_organic_correct";
                final String aa="chemistry_organic_attempted";
                opA.setEnabled(true);
                opB.setEnabled(true);
                opC.setEnabled(true);
                opD.setEnabled(true);

                correctans.setText("");
                wrongans.setText("");
                qnos = FirebaseDatabase.getInstance().getReference().child("pqchemistry").child(qset);

                qnos.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String qno = dataSnapshot.child("qnos").getValue().toString();

                        Random rand=new Random();
                        n = rand.nextInt(Integer.parseInt(qno));
                        String i = Integer.toString(n+1);

                        ref = FirebaseDatabase.getInstance().getReference().child("pqchemistry").child(qset).child(i);
                        ref.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                String question = dataSnapshot.child("Q").getValue().toString();
                                q.setText(question);
                                String opa=dataSnapshot.child("A").getValue().toString();
                                String opb=dataSnapshot.child("B").getValue().toString();
                                String opc=dataSnapshot.child("C").getValue().toString();
                                String opd=dataSnapshot.child("D").getValue().toString();
                                final String ans = dataSnapshot.child("R").getValue().toString();
                                opA.setText("A : "+opa); opB.setText("B : "+opb);opC.setText("C : "+opc);opD.setText("D : "+opd);


                                opA.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        opA.setEnabled(false);
                                        opB.setEnabled(false);
                                        opC.setEnabled(false);
                                        opD.setEnabled(false);


                                        if(ans.equals("A")){
                                            correctans.setText("Correct Answer is "+ans);

                                            mEditor.putInt(ca, mPreferences.getInt(ca, 0)+1);
                                            mEditor.commit();

                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();


                                        }
                                        else
                                        {
                                            wrongans.setText("Wrong answer, Correct answer: "+ans);
                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();
                                        }
                                    }
                                });
                                opC.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        opA.setEnabled(false);
                                        opB.setEnabled(false);
                                        opC.setEnabled(false);
                                        opD.setEnabled(false);

                                        if(ans.equals("C")){
                                            correctans.setText("Correct Answer is "+ans);

                                            mEditor.putInt(ca, mPreferences.getInt(ca, 0)+1);
                                            mEditor.commit();

                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();


                                        }
                                        else
                                        {
                                            wrongans.setText("Wrong answer, Correct answer: "+ans);
                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();
                                        }
                                    }
                                });
                                opB.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        opA.setEnabled(false);
                                        opB.setEnabled(false);
                                        opC.setEnabled(false);
                                        opD.setEnabled(false);

                                        if(ans.equals("B")){
                                            correctans.setText("Correct Answer is "+ans);

                                            mEditor.putInt(ca, mPreferences.getInt(ca, 0)+1);
                                            mEditor.commit();

                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();


                                        }
                                        else
                                        {
                                            wrongans.setText("Wrong answer, Correct answer: "+ans);
                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();
                                        }
                                    }
                                });
                                opD.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        opA.setEnabled(false);
                                        opB.setEnabled(false);
                                        opC.setEnabled(false);
                                        opD.setEnabled(false);

                                        if(ans.equals("D")){
                                            correctans.setText("Correct Answer is "+ans);

                                            mEditor.putInt(ca, mPreferences.getInt(ca, 0)+1);
                                            mEditor.commit();

                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();


                                        }
                                        else
                                        {
                                            wrongans.setText("Wrong answer, Correct answer: "+ans);
                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();
                                        }
                                    }
                                });


                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        }); //organic button ends

                inorganic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String qset="inorganic";
                final String ca="chemistry_inorganic_correct";
                final String aa="chemistry_inorganic_attempted";
                opA.setEnabled(true);
                opB.setEnabled(true);
                opC.setEnabled(true);
                opD.setEnabled(true);

                correctans.setText("");
                wrongans.setText("");
                qnos = FirebaseDatabase.getInstance().getReference().child("pqchemistry").child(qset);

                qnos.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String qno = dataSnapshot.child("qnos").getValue().toString();

                        Random rand=new Random();
                        n = rand.nextInt(Integer.parseInt(qno));
                        String i = Integer.toString(n+1);

                        ref = FirebaseDatabase.getInstance().getReference().child("pqchemistry").child(qset).child(i);
                        ref.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                String question = dataSnapshot.child("Q").getValue().toString();
                                q.setText(question);
                                String opa=dataSnapshot.child("A").getValue().toString();
                                String opb=dataSnapshot.child("B").getValue().toString();
                                String opc=dataSnapshot.child("C").getValue().toString();
                                String opd=dataSnapshot.child("D").getValue().toString();
                                final String ans = dataSnapshot.child("R").getValue().toString();
                                opA.setText("A : "+opa); opB.setText("B : "+opb);opC.setText("C : "+opc);opD.setText("D : "+opd);


                                opA.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        opA.setEnabled(false);
                                        opB.setEnabled(false);
                                        opC.setEnabled(false);
                                        opD.setEnabled(false);


                                        if(ans.equals("A")){
                                            correctans.setText("Correct Answer is "+ans);

                                            mEditor.putInt(ca, mPreferences.getInt(ca, 0)+1);
                                            mEditor.commit();

                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();


                                        }
                                        else
                                        {
                                            wrongans.setText("Wrong answer, Correct answer: "+ans);
                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();
                                        }
                                    }
                                });
                                opC.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        opA.setEnabled(false);
                                        opB.setEnabled(false);
                                        opC.setEnabled(false);
                                        opD.setEnabled(false);

                                        if(ans.equals("C")){
                                            correctans.setText("Correct Answer is "+ans);

                                            mEditor.putInt(ca, mPreferences.getInt(ca, 0)+1);
                                            mEditor.commit();

                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();


                                        }
                                        else
                                        {
                                            wrongans.setText("Wrong answer, Correct answer: "+ans);
                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();
                                        }
                                    }
                                });
                                opB.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        opA.setEnabled(false);
                                        opB.setEnabled(false);
                                        opC.setEnabled(false);
                                        opD.setEnabled(false);

                                        if(ans.equals("B")){
                                            correctans.setText("Correct Answer is "+ans);

                                            mEditor.putInt(ca, mPreferences.getInt(ca, 0)+1);
                                            mEditor.commit();

                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();


                                        }
                                        else
                                        {
                                            wrongans.setText("Wrong answer, Correct answer: "+ans);
                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();
                                        }
                                    }
                                });
                                opD.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        opA.setEnabled(false);
                                        opB.setEnabled(false);
                                        opC.setEnabled(false);
                                        opD.setEnabled(false);

                                        if(ans.equals("D")){
                                            correctans.setText("Correct Answer is "+ans);

                                            mEditor.putInt(ca, mPreferences.getInt(ca, 0)+1);
                                            mEditor.commit();

                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();


                                        }
                                        else
                                        {
                                            wrongans.setText("Wrong answer, Correct answer: "+ans);
                                            mEditor.putInt(aa, mPreferences.getInt(aa, 0)+1);
                                            mEditor.commit();
                                        }
                                    }
                                });


                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        }); //inorganic button ends

    }
}
