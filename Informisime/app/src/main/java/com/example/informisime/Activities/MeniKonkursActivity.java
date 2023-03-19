package com.example.informisime.Activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.informisime.DownloadTask;
import com.example.informisime.Entities.Meni;
import com.example.informisime.Entities.Menikonkurs;
import com.example.informisime.Entities.Škole;
import com.example.informisime.R;
import com.example.informisime.SingleTon;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MeniKonkursActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    Context c;
    SingleTon singleTon=SingleTon.getInstance();
    DownloadManager downloadManager;
    String naziv ="";
    File file=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meni_konkurs);

        if( Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},1);

        }




            c=this;
        linearLayout=findViewById(R.id.linlaymenikonk);

        for(final Menikonkurs mk: singleTon.getMenikonkurs() ) {
            final Button btnTag = new Button(c);
            btnTag.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

            btnTag.setTextColor(Color.WHITE);
            btnTag.setGravity(Gravity.CENTER);
            btnTag.setPadding(5, 5, 5, 5);

            btnTag.setWidth(1000);
            btnTag.setText(mk.getNaziv());

            btnTag.setBackgroundColor(Color.parseColor("#36845d"));
            btnTag.setClickable(true);


            // remove this when prijava is needed

            if(btnTag.getText().equals("Prijava")) {
                btnTag.setVisibility(View.GONE);
            }
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
            btnTag.startAnimation(animation);
            btnTag.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animation animation1 = AnimationUtils.loadAnimation(c, R.anim.bounce);
                    btnTag.startAnimation(animation1);
                    if(mk.getId().equals(1)) {
                        RequestQueue queue = Volley.newRequestQueue(MeniKonkursActivity.this);
                        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.1.7:2556/informisime/files/dajoblmodalb/7",
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        naziv=response;

//                                         file = new File( Environment.getExternalStorageDirectory().getAbsolutePath() + naziv);
//                                            System.out.println("bilostanekisamodaznamraspoerd");
//                                            String authorities = getApplicationContext().getPackageName() + ".provider";
//
//
//                                            Intent intent1 = new Intent(Intent.ACTION_VIEW);
//                                            Uri uri2 = FileProvider.getUriForFile(c, authorities, file);
//                                            intent1.setDataAndType(uri2, "application/msword");
//                                            intent1.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//
//
//                                            try {
//                                                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//                                                startActivity(intent1);
//                                            } catch (ActivityNotFoundException e) {
//                                                Toast.makeText(MeniKonkursActivity.this, "Nemate aplikaciju za otvaranje ovog dokumenta", Toast.LENGTH_LONG).show();
//
//                                            }

                                            downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                                            Uri uri = Uri.parse("http://192.168.1.7:2556/downloadFile/7");
                                            DownloadManager.Request request = new DownloadManager.Request(uri);
                                            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                                            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,naziv);
                                            Long reference = downloadManager.enqueue(request);

                                            registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
                                        }

                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                            }
                        });

                        queue.add(stringRequest);

                    }
                    if(mk.getId().equals(2)){
                        setContentView(R.layout.minbrpoena);
                    }
                    if(mk.getId().equals(3)){
                                RequestQueue queue = Volley.newRequestQueue(MeniKonkursActivity.this);
                                StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.1.7:2556/informisime/files/dajoblmodalb/8",
                                        new Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                naziv=response;
                                                downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                                                Uri uri = Uri.parse("http://192.168.1.7:2556/downloadFile/8");
                                                DownloadManager.Request request = new DownloadManager.Request(uri);
                                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                                                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,naziv);
                                                Long reference = downloadManager.enqueue(request);

                                                registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
                                            }

                                        }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                    }
                                });

                                queue.add(stringRequest);

                        }

                    if(mk.getId().equals(4)){
                        AlertDialog.Builder builder= new AlertDialog.Builder(c);
                        builder.setMessage("Odaberite prijavu koju želite da preuzmete:");
                        builder.setCancelable(true);
                        builder.setNeutralButton("Popunjena prijava", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                RequestQueue queue = Volley.newRequestQueue(MeniKonkursActivity.this);
                                StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.1.7:2556/informisime/files/dajoblmodalb/3",
                                        new Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                naziv=response;
                                                downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                                                Uri uri = Uri.parse("http://192.168.1.7:2556/downloadFile/3");
                                                DownloadManager.Request request = new DownloadManager.Request(uri);
                                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                                                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,naziv);
                                                Long reference = downloadManager.enqueue(request);

                                                registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
                                            }

                                        }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                    }
                                });

                                queue.add(stringRequest);
                            }
                        });
                        builder.setPositiveButton("Prazna prijava", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                RequestQueue queue = Volley.newRequestQueue(MeniKonkursActivity.this);
                                StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.1.7:2556/informisime/files/dajoblmodalb/10",
                                        new Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                naziv=response;
                                                downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                                                Uri uri = Uri.parse("http://192.168.1.7:2556/downloadFile/10");
                                                DownloadManager.Request request = new DownloadManager.Request(uri);
                                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                                                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,naziv);
                                                Long reference = downloadManager.enqueue(request);

                                                registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
                                            }

                                        }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                    }
                                });

                                queue.add(stringRequest);
                            }
                        });
                        AlertDialog alertDialog=builder.create();
                        alertDialog.show();

                    }


                    if(mk.getId().equals(5)){
                        AlertDialog.Builder builder= new AlertDialog.Builder(c);
                        builder.setMessage("Kriterijumi gimnazija se rezlikuju od kriterijuma ostalih srednjih skola.Odaberite koje kriterijume želite da preuzmete:");
                        builder.setCancelable(true);
                        builder.setNeutralButton("Gimnazija", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                RequestQueue queue = Volley.newRequestQueue(MeniKonkursActivity.this);
                                StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.1.7:2556/informisime/files/dajoblmodalb/4",
                                        new Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                naziv=response;
                                                downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                                                Uri uri = Uri.parse("http://192.168.1.7:2556/downloadFile/4");
                                                DownloadManager.Request request = new DownloadManager.Request(uri);
                                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                                                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,naziv);
                                                Long reference = downloadManager.enqueue(request);

                                                registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
                                            }

                                        }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                    }
                                });

                                queue.add(stringRequest);
                            }
                        });
                        builder.setPositiveButton("Srednje škole", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                RequestQueue queue = Volley.newRequestQueue(MeniKonkursActivity.this);
                                StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.1.7:2556/informisime/files/dajoblmodalb/2",
                                        new Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                naziv=response;
                                                downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                                                Uri uri = Uri.parse("http://192.168.1.7:2556/downloadFile/2");
                                                DownloadManager.Request request = new DownloadManager.Request(uri);
                                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                                                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,naziv);
                                                Long reference = downloadManager.enqueue(request);

                                                registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
                                            }

                                        }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                    }
                                });

                                queue.add(stringRequest);
                            }
                        });
                        AlertDialog alertDialog=builder.create();
                        alertDialog.show();

                    }
                    if(mk.getId().equals(6)){
                        AlertDialog.Builder builder= new AlertDialog.Builder(c);
                        builder.setMessage("Vrednovanje gimnazija se rezlikuju od vrednovanja ostalih srednjih skola.Odaberite koje vrednovanje želite da preuzmete:");
                        builder.setCancelable(true);
                        builder.setNeutralButton("Gimnazija", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                RequestQueue queue = Volley.newRequestQueue(MeniKonkursActivity.this);
                                StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.1.7:2556/informisime/files/dajoblmodalb/1",
                                        new Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                naziv=response;
                                                downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                                                Uri uri = Uri.parse("http://192.168.1.7:2556/downloadFile/1");
                                                DownloadManager.Request request = new DownloadManager.Request(uri);
                                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                                                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,naziv);
                                                Long reference = downloadManager.enqueue(request);

                                                registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
                                            }

                                        }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                    }
                                });

                                queue.add(stringRequest);
                            }
                        });
                        builder.setPositiveButton("Srednje škole", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                RequestQueue queue = Volley.newRequestQueue(MeniKonkursActivity.this);
                                StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.1.7:2556/informisime/files/dajoblmodalb/6",
                                        new Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                naziv=response;
                                                downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                                                Uri uri = Uri.parse("http://192.168.1.7:2556/downloadFile/6");
                                                DownloadManager.Request request = new DownloadManager.Request(uri);
                                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                                                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,naziv);
                                                Long reference = downloadManager.enqueue(request);

                                                registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
                                            }

                                        }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                    }
                                });

                                queue.add(stringRequest);
                            }
                        });
                        AlertDialog alertDialog=builder.create();
                        alertDialog.show();

                    }
                    if(mk.getId().equals(7)){
                        AlertDialog.Builder builder= new AlertDialog.Builder(c);
                        builder.setMessage("Rangiranje gimnazija se rezlikuju od rangiranja ostalih srednjih skola.Odaberite koje rangiranje želite da preuzmete:");
                        builder.setCancelable(true);
                        builder.setNeutralButton("Gimnazija", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                RequestQueue queue = Volley.newRequestQueue(MeniKonkursActivity.this);
                                StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.1.7:2556/informisime/files/dajoblmodalb/11",
                                        new Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                naziv=response;
                                                downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                                                Uri uri = Uri.parse("http://192.168.1.7:2556/downloadFile/11");
                                                DownloadManager.Request request = new DownloadManager.Request(uri);
                                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                                                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,naziv);
                                                Long reference = downloadManager.enqueue(request);

                                                registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
                                            }

                                        }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                    }
                                });

                                queue.add(stringRequest);
                            }
                        });
                        builder.setPositiveButton("Srednje škole", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                RequestQueue queue = Volley.newRequestQueue(MeniKonkursActivity.this);
                                StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.1.7:2556/informisime/files/dajoblmodalb/5",
                                        new Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                naziv=response;
                                                downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                                                Uri uri = Uri.parse("http://192.168.1.7:2556/downloadFile/5");
                                                DownloadManager.Request request = new DownloadManager.Request(uri);
                                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                                                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,naziv);
                                                Long reference = downloadManager.enqueue(request);

                                                registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
                                            }

                                        }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                    }
                                });

                                queue.add(stringRequest);
                            }
                        });
                        AlertDialog alertDialog=builder.create();
                        alertDialog.show();

                    }

                }
            });

            linearLayout.addView(btnTag);

        }

    }
    BroadcastReceiver onComplete=new BroadcastReceiver() {
        public void onReceive(Context ctxt, Intent intent) {
            Toast.makeText(ctxt, "Preuzimanje je zavrseno ", Toast.LENGTH_SHORT).show();
//            String authorities = getApplicationContext().getPackageName() + ".provider";
//
//
//            Intent intent1 = new Intent(Intent.ACTION_VIEW);
//            Uri uri2 = FileProvider.getUriForFile(c, authorities, file);
//            intent1.setDataAndType(uri2, "application/msword");
//            intent1.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//
//
//            try {
//                startActivity(intent1);
//            } catch (ActivityNotFoundException e) {
//                Toast.makeText(MeniKonkursActivity.this, "Nemate aplikaciju za otvaranje ovog dokumenta", Toast.LENGTH_LONG).show();
//
//            }
        }
    };

}
