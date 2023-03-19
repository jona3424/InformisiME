package com.example.informisime.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.informisime.Entities.LinkoviSkola;
import com.example.informisime.Entities.ObrazovniSkola;
import com.example.informisime.R;
import com.example.informisime.SingleTon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;

import java.util.List;

public class SkolaMainActivity extends AppCompatActivity {
        TextView tw,adress,phone,mail,direrctor,obr;
        ImageView fb,yt,gps,ws,ig;

        SingleTon singleTon= SingleTon.getInstance();
        Boolean checkfb=false,checkig=false,checkws=false,checkyt=false;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skola_main);
        adress=findViewById(R.id.adress);
        phone=findViewById(R.id.phone);
        mail=findViewById(R.id.mail);
        direrctor=findViewById(R.id.directorname);
        tw=findViewById(R.id.skola);
        obr=findViewById(R.id.twop);
        gps=findViewById(R.id.gps);
        tw.setText(singleTon.getNazivskole());
        if(singleTon.getInfoSkola().isEmpty()){
            adress.setText("nepoznato");
            phone.setText("nepoznato");
            mail.setText("nepoznato");
            direrctor.setText("nepoznato");


        }
        else {
            adress.setText(singleTon.getInfoSkola().get(0).getFkInfo().getAdresa());
            mail.setText(singleTon.getInfoSkola().get(0).getFkInfo().getMail());
            direrctor.setText(singleTon.getInfoSkola().get(0).getFkInfo().getImedirektora());

            if (singleTon.getInfoSkola().get(0).getFkInfo().getBrojfaxa().isEmpty()) {
                phone.setText(singleTon.getInfoSkola().get(0).getFkInfo().getBrojtelefona());
            } else {
                phone.setText(singleTon.getInfoSkola().get(0).getFkInfo().getBrojtelefona() + " /  " + singleTon.getInfoSkola().get(0).getFkInfo().getBrojfaxa());
            }
        }
        fb=findViewById(R.id.fb);
        ig=findViewById(R.id.ig);
        yt=findViewById(R.id.yt);
        ws=findViewById(R.id.ws);




        obr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(SkolaMainActivity.this);
                JsonArrayRequest jar1 = new JsonArrayRequest(Request.Method.GET, "http://192.168.1.7:2556/informisime/obrsk/dajobrsk/"+singleTon.getIdskole() , null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ObjectMapper op = new ObjectMapper();
                        try {
                            SingleTon.getInstance().setObrazovniSkola(
                                    op.readValue(response.toString(), new TypeReference<List<ObrazovniSkola>>() {
                                    })
                            );
                            startActivity(new Intent(SkolaMainActivity.this,ObrazovniSkActivity.class));
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        } catch (JsonProcessingException e) {
                            e.printStackTrace();
                        }
                    }
                }, null);


                queue.getCache().clear();
                queue.add(jar1);
            }
        });











        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(final LinkoviSkola ls: singleTon.getLinkoviSkola()){
                    if(ls.getFkLinka().getNaziv().equals("fb")){
                        checkfb=true;
                        Intent facebookIntent = link(SkolaMainActivity.this,ls.getFkLinka().getLink());
                        startActivity(facebookIntent);
                        break;
                    }

                }
                if(checkfb==false){

                    final AlertDialog alertDialog = new AlertDialog.Builder(SkolaMainActivity.this).create();
                    alertDialog.setMessage("Ova škola nema Facebook straicu");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    alertDialog.cancel();
                                }
                            });
                    alertDialog.show();

                }
            }
        });
        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(final LinkoviSkola ls: singleTon.getLinkoviSkola()){
                    if(ls.getFkLinka().getNaziv().equals("ig")) {
                        checkig=true;
                        Intent facebookIntent = link(SkolaMainActivity.this, ls.getFkLinka().getLink());
                        startActivity(facebookIntent);
                    }

                }
                if(checkig==false){
                    final AlertDialog alertDialog = new AlertDialog.Builder(SkolaMainActivity.this).create();
                    alertDialog.setMessage("Ova škola nema Instagram straicu");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    alertDialog.cancel();
                                }
                            });
                    alertDialog.show();
                }
            }
        });



        gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(final LinkoviSkola ls: singleTon.getLinkoviSkola()) {
                    if(ls.getFkLinka().getNaziv().equals("gps")){
                        float kor1=Float.parseFloat( ls.getFkLinka().getLink().substring(0,ls.getFkLinka().getLink().indexOf(';')));
                        singleTon.setKoordinate1(kor1);
                        float kor2=Float.parseFloat(ls.getFkLinka().getLink().substring(ls.getFkLinka().getLink().indexOf(';')+1));
                        singleTon.setKoordinate2(kor2);
                        startActivity(new Intent(SkolaMainActivity.this,MapsActivity.class));
                    }

                }
                }
        });





















        ws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(final LinkoviSkola ls: singleTon.getLinkoviSkola()){
                    if(ls.getFkLinka().getNaziv().equals("ws")){
                        checkws=true;
                        Intent facebookIntent = link(SkolaMainActivity.this,ls.getFkLinka().getLink());
                        startActivity(facebookIntent);
                        break;
                    }
                }
                if(checkws==false){
                    final AlertDialog alertDialog = new AlertDialog.Builder(SkolaMainActivity.this).create();
                    alertDialog.setMessage("Ova škola nema web sajt ");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    alertDialog.cancel();
                                }
                            });
                    alertDialog.show();
                }
            }
        });
        yt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(final LinkoviSkola ls: singleTon.getLinkoviSkola()){
                    if(ls.getFkLinka().getNaziv().equals("yt")){
                        checkyt=true;
                        Intent facebookIntent = link(SkolaMainActivity.this,ls.getFkLinka().getLink());
                        startActivity(facebookIntent);
                        break;
                    }
                }
                if(checkyt==false){
                    final AlertDialog alertDialog = new AlertDialog.Builder(SkolaMainActivity.this).create();
                    alertDialog.setMessage("Ova škola nema youtube kanal");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    alertDialog.cancel();
                                }
                            });
                    alertDialog.show();
                }
            }
        });







    }

    public static Intent link(Context c, String link ){
        try {
            c.getPackageManager()
                    .getPackageInfo("link", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse(link));
        } catch (Exception e){

            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse(link));
        }
    }

    @Override
    public void onBackPressed() {
        singleTon.setInfoSkola(null);
        singleTon.setLinkoviSkola(null);
        singleTon.setIdskole(null);
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }
}
