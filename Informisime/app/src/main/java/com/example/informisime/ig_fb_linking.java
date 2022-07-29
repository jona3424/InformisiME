package com.example.informisime;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class ig_fb_linking {


    public static Intent openfb(Context c ){
        try {
            c.getPackageManager()
                    .getPackageInfo("com.facebook.elektropg", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/elektropg/?ref=page_internal"));
        } catch (Exception e){

            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/elektropg/?ref=page_internal"));
        }
    }
}




//    Intent facebookIntent = openfb(MainActivity.this);
//    startActivity(facebookIntent);