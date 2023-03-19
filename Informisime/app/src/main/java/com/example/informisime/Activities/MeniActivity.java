package com.example.informisime.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.informisime.Entities.Centri;
import com.example.informisime.Entities.KorisniLinkovi;
import com.example.informisime.Entities.Meni;
import com.example.informisime.Entities.Menikonkurs;
import com.example.informisime.Entities.Meniobrazovni;
import com.example.informisime.Entities.Ustanove;
import com.example.informisime.Entities.UčeničkiDomovi;
import com.example.informisime.R;
import com.example.informisime.SingleTon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;

import java.util.List;

public class MeniActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    Context c;
    SingleTon singleTon=SingleTon.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meni);




        c=this;
        linearLayout=findViewById(R.id.linlaybr);

        for(final Meni m: singleTon.getMeni() ){
            final Button btnTag = new Button(c);
            btnTag.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

            btnTag.setTextColor(Color.WHITE);
            btnTag.setGravity(Gravity.CENTER);
            btnTag.setPadding(5,5,5,5);

            btnTag.setWidth(1000);
            btnTag.setText(m.getNaziv());


                btnTag.setBackgroundColor(Color.parseColor("#36845d"));
                btnTag.setClickable(true);
            Animation animation= AnimationUtils.loadAnimation(this,R.anim.fade_in);
            btnTag.startAnimation(animation);
            btnTag.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animation animation1= AnimationUtils.loadAnimation(c,R.anim.bounce);
                    btnTag.startAnimation(animation1);
                    if(m.getId().equals(1)){
                    RequestQueue queue = Volley.newRequestQueue(MeniActivity.this);
                    JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, "http://192.168.1.7:2556/informisime/ustanove/all", null, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            ObjectMapper op = new ObjectMapper();
                            try {
                                SingleTon.getInstance().setUstanove(
                                        op.readValue(response.toString(), new TypeReference<List<Ustanove>>() {
                                        })
                                );
                                startActivity(new Intent(MeniActivity.this, UstanoveActivity.class));
                                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                            } catch (JsonProcessingException e) {
                                e.printStackTrace();
                            }
                        }
                    }, null);


                    queue.getCache().clear();
                    queue.add(jar);
                    }
                    if(m.getId().equals(2)){
                        Intent intent = link(MeniActivity.this);
                        startActivity(intent);
                    }
                    if(m.getId().equals(3)){
                        RequestQueue queue1 = Volley.newRequestQueue(MeniActivity.this);
                        JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, "http://192.168.1.7:2556/informisime/menikonk/all", null, new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                ObjectMapper op = new ObjectMapper();
                                try {
                                    SingleTon.getInstance().setMenikonkurs(
                                            op.readValue(response.toString(), new TypeReference<List<Menikonkurs>>() {
                                            })
                                    );
                                    startActivity(new Intent(MeniActivity.this, MeniKonkursActivity.class));
                                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                                } catch (JsonProcessingException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, null);


                        queue1.getCache().clear();
                        queue1.add(jar);
                    }
                    if(m.getId().equals(4)){
                        RequestQueue queue1 = Volley.newRequestQueue(MeniActivity.this);
                        JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, "http://192.168.1.7:2556/informisime/meniobr/all", null, new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                ObjectMapper op = new ObjectMapper();
                                try {
                                    SingleTon.getInstance().setMeniobrazovni(
                                            op.readValue(response.toString(), new TypeReference<List<Meniobrazovni>>() {
                                            })
                                    );
                                    startActivity(new Intent(MeniActivity.this, MeniObrazovniActivity.class));
                                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                                } catch (JsonProcessingException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, null);


                        queue1.getCache().clear();
                        queue1.add(jar);

                    }
                    if (m.getId().equals(5)){
                        RequestQueue queue1 = Volley.newRequestQueue(MeniActivity.this);
                        JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, "http://192.168.1.7:2556/informisime/ucedom/all", null, new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                ObjectMapper op = new ObjectMapper();
                                try {
                                    SingleTon.getInstance().setUcdom(
                                            op.readValue(response.toString(), new TypeReference<List<UčeničkiDomovi>>() {
                                            })
                                    );
                                    startActivity(new Intent(MeniActivity.this, DomoviActivity.class));
                                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                                } catch (JsonProcessingException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, null);


                        queue1.getCache().clear();
                        queue1.add(jar);
                    }
                    if (m.getId().equals(6)){
                        RequestQueue queue2 = Volley.newRequestQueue(MeniActivity.this);
                        JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, "http://192.168.1.7:2556/informisime/centri/all", null, new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                ObjectMapper op = new ObjectMapper();
                                try {
                                    SingleTon.getInstance().setCentri(
                                            op.readValue(response.toString(), new TypeReference<List<Centri>>() {
                                            })
                                    );
                                    startActivity(new Intent(MeniActivity.this, CentriActivity.class));
                                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                                } catch (JsonProcessingException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, null);


                        queue2.getCache().clear();
                        queue2.add(jar);
                    }
                    if (m.getId().equals(7)){
                        RequestQueue queue3 = Volley.newRequestQueue(MeniActivity.this);
                        JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, "http://192.168.1.7:2556/informisime/korlink/all", null, new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                ObjectMapper op = new ObjectMapper();
                                try {
                                    SingleTon.getInstance().setKorlink(
                                            op.readValue(response.toString(), new TypeReference<List<KorisniLinkovi>>() {
                                            })
                                    );
                                    startActivity(new Intent(MeniActivity.this, KorLinkActivity.class));
                                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                                } catch (JsonProcessingException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, null);


                        queue3.getCache().clear();
                        queue3.add(jar);
                    }
                }
            });




            linearLayout.addView(btnTag);
        }
  }
    public void onBackPressed(){
        final AlertDialog.Builder b= new AlertDialog.Builder(MeniActivity.this);
        b.setMessage("Da li ste sigurni da želite da izađete iz aplikacije?");
        b.setCancelable(true);
        b.setNegativeButton("DA", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        b.setPositiveButton("NE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });
        AlertDialog alertDialog =b.create();
        alertDialog.show();



    }
    public static Intent link(Context c ){
        try {
            c.getPackageManager()
                    .getPackageInfo("https://upisi.edu.me/#/loginPage", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://upisi.edu.me/#/loginPage"));
        } catch (Exception e){

            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://upisi.edu.me/#/loginPage"));
        }
    }

}
