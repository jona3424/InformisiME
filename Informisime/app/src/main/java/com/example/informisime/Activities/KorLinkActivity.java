package com.example.informisime.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.informisime.Entities.KorisniLinkovi;
import com.example.informisime.Entities.Ustanove;
import com.example.informisime.R;
import com.example.informisime.SingleTon;

public class KorLinkActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    Context c;
    SingleTon singleTon=SingleTon.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kor_link);







            c=this;
        linearLayout=findViewById(R.id.linlaykorlink);

        for(final KorisniLinkovi kl: singleTon.getKorlink() ){
            final Button btnTag = new Button(c);
            btnTag.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

            btnTag.setTextColor(Color.WHITE);
            btnTag.setGravity(Gravity.CENTER);
            btnTag.setPadding(5,5,5,5);

            btnTag.setWidth(1000);
            btnTag.setText(kl.getNaziv());

            btnTag.setBackgroundColor(Color.parseColor("#36845d"));
            btnTag.setClickable(true);
            Animation animation= AnimationUtils.loadAnimation(this,R.anim.fade_in);
            btnTag.startAnimation(animation);
            btnTag.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animation animation1= AnimationUtils.loadAnimation(c,R.anim.bounce);
                    btnTag.startAnimation(animation1);
                    if(kl.getId().equals(1)){
                        Intent intent = link(KorLinkActivity.this,kl.getLink());
                        startActivity(intent);
                    }
                    if(kl.getId().equals(2)){
                        Intent intent = link(KorLinkActivity.this,kl.getLink());
                        startActivity(intent);
                    }
                    if(kl.getId().equals(3)){
                        Intent intent = link(KorLinkActivity.this,kl.getLink());
                        startActivity(intent);
                    }
                    if(kl.getId().equals(4)){
                        Intent intent = link(KorLinkActivity.this,kl.getLink());
                        startActivity(intent);
                    }
                    if(kl.getId().equals(5)){
                        Intent intent = link(KorLinkActivity.this,kl.getLink());
                        startActivity(intent);
                    }
                    if(kl.getId().equals(6)){
                        Intent intent = link(KorLinkActivity.this,kl.getLink());
                        startActivity(intent);
                    }


                }
            });
            linearLayout.addView(btnTag);


        }





    }
    public static Intent link(Context c,String link ){
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
}
