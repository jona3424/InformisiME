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

import com.example.informisime.Entities.Ustanove;
import com.example.informisime.Entities.UčeničkiDomovi;
import com.example.informisime.R;
import com.example.informisime.SingleTon;

public class DomoviActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    Context c;
    SingleTon singleTon=SingleTon.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domovi);





            c=this;
        linearLayout=findViewById(R.id.linlaydomovi);

        for(final UčeničkiDomovi ud: singleTon.getUcdom() ){
            final Button btnTag = new Button(c);
            btnTag.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

            btnTag.setTextColor(Color.WHITE);
            btnTag.setGravity(Gravity.CENTER);
            btnTag.setPadding(5,5,5,5);

            btnTag.setWidth(1000);
            btnTag.setText(ud.getNaziv());

            btnTag.setBackgroundColor(Color.parseColor("#36845d"));
            btnTag.setClickable(true);
            Animation animation= AnimationUtils.loadAnimation(this,R.anim.fade_in);
            btnTag.startAnimation(animation);
            btnTag.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animation animation1= AnimationUtils.loadAnimation(c,R.anim.bounce);
                    btnTag.startAnimation(animation1);
                    singleTon.setKoordinate1(Float.parseFloat(ud.getKoordinate().substring(0,ud.getKoordinate().indexOf(';'))));
                    singleTon.setKoordinate2(Float.parseFloat(ud.getKoordinate().substring(ud.getKoordinate().indexOf(';')+1)));
                    startActivity(new Intent(DomoviActivity.this,MapsActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


                }
            });
            linearLayout.addView(btnTag);


        }

    }
}
