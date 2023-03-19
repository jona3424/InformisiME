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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.informisime.Entities.Meniobrazovni;
import com.example.informisime.Entities.Oblasti;
import com.example.informisime.R;
import com.example.informisime.SingleTon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;

import java.util.List;

public class MeniObrazovniActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    Context c;
    SingleTon singleTon=SingleTon.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meni_obrazovni);







            c=this;
        linearLayout=findViewById(R.id.linlaymeniobr);

        for(final Meniobrazovni mo: singleTon.getMeniobrazovni() ) {
            final Button btnTag = new Button(c);
            btnTag.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

            btnTag.setTextColor(Color.WHITE);
            btnTag.setGravity(Gravity.CENTER);
            btnTag.setPadding(5, 5, 5, 5);

            btnTag.setWidth(1000);
            btnTag.setText(mo.getNaziv());

            btnTag.setBackgroundColor(Color.parseColor("#36845d"));
            btnTag.setClickable(true);








            Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
            btnTag.startAnimation(animation);
            btnTag.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animation animation1 = AnimationUtils.loadAnimation(c, R.anim.bounce);
                    btnTag.startAnimation(animation1);

                    RequestQueue queue3 = Volley.newRequestQueue(MeniObrazovniActivity.this);
                    JsonArrayRequest jar = new JsonArrayRequest(Request.Method.GET, "http://192.168.1.7:2556/informisime/oblasti/all", null, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            ObjectMapper op = new ObjectMapper();
                            try {
                                SingleTon.getInstance().setOblasti(
                                        op.readValue(response.toString(), new TypeReference<List<Oblasti>>() {
                                        })
                                );
                                singleTon.setPamtiodabraniop(mo.getId());
                                startActivity(new Intent(MeniObrazovniActivity.this, OblastiActivity.class));
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

        }





    }
}
