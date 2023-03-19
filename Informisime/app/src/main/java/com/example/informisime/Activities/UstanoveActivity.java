package com.example.informisime.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import com.example.informisime.Entities.Meni;
import com.example.informisime.Entities.Ustanove;
import com.example.informisime.Entities.ŠkoleUstanova;
import com.example.informisime.R;
import com.example.informisime.SingleTon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;

import java.util.List;

public class UstanoveActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    Context c;
    SingleTon singleTon=SingleTon.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ustanove);














            c=this;
        linearLayout=findViewById(R.id.linlayustanove);

        for(final Ustanove u: singleTon.getUstanove() ){
            final Button btnTag = new Button(c);
            btnTag.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

            btnTag.setTextColor(Color.WHITE);
            btnTag.setGravity(Gravity.CENTER);
            btnTag.setPadding(5,5,5,5);

            btnTag.setWidth(1000);
            btnTag.setText(u.getNaziv());

            btnTag.setBackgroundColor(Color.parseColor("#36845d"));
            btnTag.setClickable(true);
            Animation animation= AnimationUtils.loadAnimation(this,R.anim.fade_in);
            btnTag.startAnimation(animation);
            btnTag.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animation animation1= AnimationUtils.loadAnimation(c,R.anim.bounce);
                    btnTag.startAnimation(animation1);
                    for(int i=0;i<=singleTon.getUstanove().size();i++){
                        if(u.getId()==i){
                            RequestQueue queue3 = Volley.newRequestQueue(UstanoveActivity.this);
                            JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, "http://192.168.1.7:2556/informisime/skust/dajskust/"+ u.getId(), null, new Response.Listener<JSONArray>() {
                                @Override
                                public void onResponse(JSONArray response) {
                                    ObjectMapper op = new ObjectMapper();
                                    try {
                                        SingleTon.getInstance().setSkoleustanova(
                                                op.readValue(response.toString(), new TypeReference<List<ŠkoleUstanova>>() {
                                                })
                                        );
                                        startActivity(new Intent(UstanoveActivity.this, SkoleActivity.class));
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


                }
            });
            linearLayout.addView(btnTag);


        }





}}


