package com.example.projectiitapp;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Performance extends AppCompatActivity {

    private SharedPreferences mPreferences;
    String cpa="chemistry_physical_attempted", cpc="chemistry_physical_correct", coa="chemistry_organic_attempted", coc="chemistry_organic_correct", cia="chemistry_inorganic_attempted",cic="chemistry_inorganic_correct";
    int icpa,  icoa,  icia;
    double icpc, icoc, icic;
    String scp, sco, sci;

    String pwc="physics_wavethermo_correct", pwa="physics_wavethermo_attempted", pmaa="physics_magemi_attempted", pmac="physics_magemi_correct", pmec="physics_mech_correct", pmea="physics_mech_attempted";
     String poc="physics_optmod_correct", poa="physics_optmod_attempted", pec="physics_elec_correct", pea="physics_elec_attempted";
     int ipwa, ipmaa, ipmea, ipoa, ipea;
     double ipwc, ipmac, ipmec, ipoc, ipec;
     String spw, spo, spma,spme, spe;

     String mcc="math_calc_correct", mca="math_calc_attempted", mac="math_algebra_correct", maa="math_algebra_attempted", mtc="math_trig_correct", mta="math_trig_attempted";
     String mcgc="math_coor_correct", mcga="math_coor_attempted", mv3dc="math_v3d_correct", mv3da="math_v3d_correct";
     int imca, imaa, imta, imcga, imv3da;
     double imcc, imac, imtc, imcgc, imv3dc;
     String smc, sma, smt, smcg, smv3d;


    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    TextView chemtext, phytext, mathtext, advicetext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance);
        getSupportActionBar().hide();
        mPreferences= PreferenceManager.getDefaultSharedPreferences(this);

        chemtext = findViewById(R.id.chemtext);
        phytext = findViewById(R.id.phytext);
        mathtext = findViewById(R.id.mathtext);
        advicetext = findViewById(R.id.advicetb);

        icpa=mPreferences.getInt(cpa,0);
        icpc=mPreferences.getInt(cpc,0);
        icoa=mPreferences.getInt(coa,0);
        icoc=mPreferences.getInt(coc,0);
        icia=mPreferences.getInt(cia,0);
        icic=mPreferences.getInt(cic,0);
        ipwa=mPreferences.getInt(pwa, 0);
        ipwc=mPreferences.getInt(pwc, 0);
        ipoc=mPreferences.getInt(poc, 0);
        ipoa=mPreferences.getInt(poa, 0);
        ipmac=mPreferences.getInt(pmac, 0);
        ipmaa=mPreferences.getInt(pmaa, 0);
        ipmec=mPreferences.getInt(pmec, 0);
        ipmea=mPreferences.getInt(pmea, 0);
        ipec=mPreferences.getInt(pec, 0);
        ipea=mPreferences.getInt(pea, 0);
        imaa=mPreferences.getInt(maa, 0);
        imca=mPreferences.getInt(mca, 0);
        imcga=mPreferences.getInt(mcga, 0);
        imta=mPreferences.getInt(mta, 0);
        imv3da=mPreferences.getInt(mv3da, 0);
        imac=mPreferences.getInt(mac, 0);
        imcc=mPreferences.getInt(mcc, 0);
        imcgc=mPreferences.getInt(mcgc, 0);
        imtc=mPreferences.getInt(mtc, 0);
        imv3dc=mPreferences.getInt(mv3dc, 0);



        if(icpa==0){
            scp="-";
        }
        else{
            scp=round(((icpc/icpa)*100), 2)+"%";
        }
        if(icoa==0){
            sco="-";
        }
        else{
            sco=round(((icoc/icoa)*100),2)+"%";
        }
        if(icia==0){
            sci="-";
        }
        else{
            sci=round(((icic/icia)*100),2)+"%";
        }
        chemtext.setText("Physical: "+scp + "\nOrganic: "+sco+"\nInorganic: "+sci+"\n\nAttempted:"+Integer.toString(icpa+icoa+icia));

        if(ipoa==0){
            spo="-";
        }
        else{
            spo=round(((ipoc/ipoa)*100), 2)+"%";
        }
        if(ipmaa==0){
            spma="-";
        }
        else{
            spma=round(((ipmac/ipmaa)*100), 2)+"%";
        }
        if(ipmea==0){
            spme="-";
        }
        else{
            spme=round(((ipmec/ipmea)*100), 2)+"%";
        }
        if(ipea==0){
            spe="-";
        }
        else{
            spe=round(((ipec/ipea)*100), 2)+"%";
        }
        if(ipwa==0){
            spw="-";
        }
        else{
            spw=round(((ipwc/ipwa)*100), 2)+"%";
        }
        phytext.setText("Waves and Thermoddynamics: "+spw+"\nMechanics: "+spme+"\nOptics and Modern Physics: "+spo+"\nMagnetism and EMI: "+spma+"\nElectricity and Electrostatics: "+spe+"\n\nAttempted:"+Integer.toString(ipwa+ipmaa+ipmea+ipoa+ipea));

        if(imaa==0){
            sma="-";
        }
        else{
            sma=round(((imac/imaa)*100), 2)+"%";
        }
        if(imcga==0){
            smcg="-";
        }
        else{
            smcg=round(((imcgc/imcga)*100), 2)+"%";
        }
        if(imcc==0){
            smc="-";
        }
        else{
            smc=round(((imcc/imca)*100), 2)+"%";
        }
        if(imv3da==0){
            smv3d="-";
        }
        else{
            smv3d=round(((imv3dc/imv3da)*100), 2)+"%";
        }
        if(imta==0){
            smt="-";
        }
        else{
            smt=round(((imtc/imta)*100), 2)+"%";
        }

        mathtext.setText("Algebra: "+sma+"\nCoordinate Geometry: "+smcg+"\nTrigonometry: "+smt+"\nCalculus: "+smc+"\nVectors and 3-D: "+smv3d+"\n\nAttempted:"+Integer.toString(imv3da+imca+imcga+imaa+imta));





    }
}
