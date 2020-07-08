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

public class PhysicsPage extends AppCompatActivity {
    DatabaseReference ref,qnos;
    TextView q, correctans, wrongans; int n=0;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    Button wavethermo;
    Button magemi, elec, optmod, mech;
    TextView ptextheader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics_page);
        ptextheader=findViewById(R.id.textView7p);
        wavethermo = findViewById(R.id.wavethermo);

        final Button opA, opB, opC, opD;


        magemi=findViewById(R.id.magemi);
        elec=findViewById(R.id.elec);
        optmod= findViewById(R.id.optmod);
        mech=findViewById(R.id.mechanics);

        opA=findViewById(R.id.opAbuttonp);
        opB=findViewById(R.id.opBbuttonp);opC=findViewById(R.id.opCbuttonp);opD=findViewById(R.id.opDbuttonp);

        getSupportActionBar().hide();
        q = (TextView) findViewById(R.id.questionp);
        correctans=findViewById(R.id.correctansp);
        wrongans=findViewById(R.id.wrongansp);
        mPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        mEditor=mPreferences.edit();

        wavethermo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String subj="pqphysics";
                final String qset="wavethermo";
                final String ca="physics_wavethermo_correct";
                final String aa="physics_wavethermo_attempted";
                opA.setEnabled(true);
                opB.setEnabled(true);
                opC.setEnabled(true);
                opD.setEnabled(true);

                correctans.setText("");
                wrongans.setText("");
                qnos = FirebaseDatabase.getInstance().getReference().child(subj).child(qset);

                qnos.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String qno = dataSnapshot.child("qnos").getValue().toString();

                        Random rand=new Random();
                        n = rand.nextInt(Integer.parseInt(qno));
                        String i = Integer.toString(n+1);

                        ref = FirebaseDatabase.getInstance().getReference().child(subj).child(qset).child(i);
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
        }); //wavethermo button ends
        elec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String subj="pqphysics";
                final String qset="elec";
                final String ca="physics_elec_correct";
                final String aa="physics_elec_attempted";
                opA.setEnabled(true);
                opB.setEnabled(true);
                opC.setEnabled(true);
                opD.setEnabled(true);

                correctans.setText("");
                wrongans.setText("");
                qnos = FirebaseDatabase.getInstance().getReference().child(subj).child(qset);

                qnos.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String qno = dataSnapshot.child("qnos").getValue().toString();

                        Random rand=new Random();
                        n = rand.nextInt(Integer.parseInt(qno));
                        String i = Integer.toString(n+1);

                        ref = FirebaseDatabase.getInstance().getReference().child(subj).child(qset).child(i);
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
        });
        optmod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String subj="pqphysics";
                final String qset="optmod";
                final String ca="physics_optmod_correct";
                final String aa="physics_optmod_attempted";
                opA.setEnabled(true);
                opB.setEnabled(true);
                opC.setEnabled(true);
                opD.setEnabled(true);

                correctans.setText("");
                wrongans.setText("");
                qnos = FirebaseDatabase.getInstance().getReference().child(subj).child(qset);

                qnos.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String qno = dataSnapshot.child("qnos").getValue().toString();

                        Random rand=new Random();
                        n = rand.nextInt(Integer.parseInt(qno));
                        String i = Integer.toString(n+1);

                        ref = FirebaseDatabase.getInstance().getReference().child(subj).child(qset).child(i);
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
        });
        mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String subj="pqphysics";
                final String qset="mech";
                final String ca="physics_mech_correct";
                final String aa="physics_mech_attempted";
                opA.setEnabled(true);
                opB.setEnabled(true);
                opC.setEnabled(true);
                opD.setEnabled(true);

                correctans.setText("");
                wrongans.setText("");
                qnos = FirebaseDatabase.getInstance().getReference().child(subj).child(qset);

                qnos.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String qno = dataSnapshot.child("qnos").getValue().toString();

                        Random rand=new Random();
                        n = rand.nextInt(Integer.parseInt(qno));
                        String i = Integer.toString(n+1);

                        ref = FirebaseDatabase.getInstance().getReference().child(subj).child(qset).child(i);
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
        });
        magemi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String subj="pqphysics";
                final String qset="magemi";
                final String ca="physics_magemi_correct";
                final String aa="physics_magemi_attempted";
                opA.setEnabled(true);
                opB.setEnabled(true);
                opC.setEnabled(true);
                opD.setEnabled(true);

                correctans.setText("");
                wrongans.setText("");
                qnos = FirebaseDatabase.getInstance().getReference().child(subj).child(qset);

                qnos.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String qno = dataSnapshot.child("qnos").getValue().toString();

                        Random rand=new Random();
                        n = rand.nextInt(Integer.parseInt(qno));
                        String i = Integer.toString(n+1);

                        ref = FirebaseDatabase.getInstance().getReference().child(subj).child(qset).child(i);
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
        });



    }
}
