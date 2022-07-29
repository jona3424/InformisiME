package com.example.informisime.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.informisime.Entities.CiljeviObrazovnih;
import com.example.informisime.R;
import com.example.informisime.SingleTon;

public class CiljeviActivity extends AppCompatActivity {


    LinearLayout linearLayout;
    Context c;
    SingleTon singleTon=SingleTon.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciljevi);

        c=this;
        linearLayout=findViewById(R.id.linlayciljz);

        System.out.println(singleTon.getCiljz()+" zasto to ne pise");
            if(singleTon.getCiljz().isEmpty()){
                final TextView tw = new TextView(c);
                tw.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

                tw.setTextColor(Color.WHITE);
                tw.setGravity(Gravity.CENTER);
                tw.setPadding(5, 5, 5, 5);
                tw.setTextSize(18);
                tw.setWidth(1000);
                tw.setText("Trenutno nema informacija o ciljevima za ovaj obrazovni program");
                tw.setBackgroundColor(Color.parseColor("#36845d"));


                linearLayout.addView(tw);

            }
            else {
                for (final CiljeviObrazovnih co : singleTon.getCiljz()) {
                    final TextView tw = new TextView(c);
                    tw.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

                    tw.setTextColor(Color.WHITE);
                    tw.setGravity(Gravity.CENTER);
                    tw.setPadding(5, 5, 5, 5);
                    tw.setTextSize(18);
                    tw.setWidth(1000);
                    tw.setText(co.getFkCiljevi().getNaziv());
                    System.out.println(co.getFkCiljevi().getNaziv());
                    tw.setBackgroundColor(Color.parseColor("#36845d"));


                    linearLayout.addView(tw);

                }

            }


        }
    }
