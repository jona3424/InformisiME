package com.example.informisime.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.informisime.Entities.CiljeviObrazovnih;
import com.example.informisime.Entities.ObrazovniSkola;
import com.example.informisime.R;
import com.example.informisime.SingleTon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;

import java.util.List;

public class ObrazovniSkActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    Context c;
    SingleTon singleTon=SingleTon.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obrazovni_sk);
        c=this;
        linearLayout=findViewById(R.id.linlayobrsk);
        if(singleTon.getObrazovniSkola().isEmpty()){
            final TextView tw = new TextView(c);
            tw.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

            tw.setTextColor(Color.WHITE);
            tw.setGravity(Gravity.CENTER);
            tw.setPadding(5, 5, 5, 5);
            tw.setTextSize(18);
            tw.setWidth(1000);
            tw.setText("Nema infomacija o obrazovnim programima ove škole");
            tw.setBackgroundColor(Color.parseColor("#36845d"));


            linearLayout.addView(tw);



        }

        else{
        for(final ObrazovniSkola os:singleTon.getObrazovniSkola()){

            Button btnTag=new Button(c);
            btnTag.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

            btnTag.setTextColor(Color.WHITE);
            btnTag.setGravity(Gravity.CENTER);
            btnTag.setPadding(5, 5, 5, 5);

            btnTag.setWidth(1000);
            btnTag.setText("• "+os.getFkObrazovni().getNaziv());

            btnTag.setBackgroundColor(Color.parseColor("#36845d"));
            btnTag.setClickable(false);
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
            btnTag.startAnimation(animation);
            btnTag.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RequestQueue queue3 = Volley.newRequestQueue(ObrazovniSkActivity.this);
                    JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, "http://192.168.1.7:2556/informisime/ciljeviobr/dajciljobr/"+os.getFkObrazovni().getId(), null, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            ObjectMapper op = new ObjectMapper();
                            try {
                                SingleTon.getInstance().setCiljz(
                                        op.readValue(response.toString(), new TypeReference<List<CiljeviObrazovnih>>() {
                                        })
                                );
                                startActivity(new Intent(ObrazovniSkActivity.this,CiljeviActivity.class));
                                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                            } catch (JsonProcessingException e) {
                                e.printStackTrace();
                            }
                        }
                    }, null);

                    queue3.getCache().clear();
                    queue3.add(jar);
                }
            });



            linearLayout.addView(btnTag);
        }}

    }
}
