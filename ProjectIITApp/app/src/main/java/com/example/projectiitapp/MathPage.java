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

public class MathPage extends AppCompatActivity {
    DatabaseReference ref,qnos;
    TextView q, correctans, wrongans; int n=0;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    Button vector;
    Button algebra, coor, calc, trig;
    TextView ptextheader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_page);
        ptextheader=findViewById(R.id.textView7p);
        vector = findViewById(R.id.Vector3);

        final Button opA, opB, opC, opD;


        algebra=findViewById(R.id.Algebra);
        calc=findViewById(R.id.Calculus);
        trig= findViewById(R.id.Trigonometry);
        coor=findViewById(R.id.CoordinateGeometry);

        opA=findViewById(R.id.opAbuttonp);
        opB=findViewById(R.id.opBbuttonp);opC=findViewById(R.id.opCbuttonp);opD=findViewById(R.id.opDbuttonp);

        getSupportActionBar().hide();
        q = (TextView) findViewById(R.id.questionp);
        correctans=findViewById(R.id.correctansp);
        wrongans=findViewById(R.id.wrongansp);
        mPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        mEditor=mPreferences.edit();

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String subj="pqmath";
                final String qset="calc";
                final String ca="math_calc_correct";
                final String aa="math_calc_attempted";
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
        algebra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String subj="pqmath";
                final String qset="algebra";
                final String ca="math_algebra_correct";
                final String aa="math_algebra_attempted";
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
        coor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String subj="pqmath";
                final String qset="coordgeo";
                final String ca="math_coor_correct";
                final String aa="math_coor_attempted";
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
        trig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String subj="pqmath";
                final String qset="trig";
                final String ca="math_trig_correct";
                final String aa="math_trig_attempted";
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
        vector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String subj="pqmath";
                final String qset="v3d";
                final String ca="math_v3d_correct";
                final String aa="math_v3d_attempted";
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
