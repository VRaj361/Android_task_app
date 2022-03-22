package com.example.taskapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class All extends AppCompatActivity {
    Button youtube,camera,click_image,click_gallery,click_alert,click_custom_alert,btn_click_custom_btn,click_custom_toast;
    TextView fname_custom_alert;
    ImageView imageView;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);
        youtube=findViewById(R.id.open_youtube);
        camera=findViewById(R.id.open_camera);
        imageView=findViewById(R.id.img_read);
        click_image=findViewById(R.id.click_image);
        click_gallery=findViewById(R.id.click_gallery);
        click_alert=findViewById(R.id.click_alert);
        click_custom_alert=findViewById(R.id.click_custom_alert);
        click_custom_toast=findViewById(R.id.click_custom_toast);

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https:www.youtube.com/"));
                startActivity(intent);
            }
        });//youtube open
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,12);
            }
        });//camera
        click_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.astrology_img);
            }
        });//click evert and get image directly using drawable folder image
        click_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent();
                i.setAction(Intent.ACTION_PICK);
                i.setType("image/*");//image set
                startActivityForResult(i,121);//request code must be same in onactivityview method

            }
        });
        click_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(All.this);
                builder.setTitle("MyTaskApp");
                builder.setIcon(R.color.teal_200);
                builder.setMessage("Are you sure to leave?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(All.this, "Yes it clicked", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(All.this, "No it not clicked", Toast.LENGTH_SHORT).show();
                }
            });//negative reply
            builder.setNeutralButton("Finish", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });//give the condition for exit or finish the task


        builder.show();

            }
        });//alert

        //custom alert
        click_custom_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
            LayoutInflater layoutInflater=getLayoutInflater();
            View view1=layoutInflater.inflate(R.layout.custom_alert_raw,null);

            btn_click_custom_btn=view1.findViewById(R.id.submit_custom);
            fname_custom_alert=view1.findViewById(R.id.email_custom);
            AlertDialog.Builder builder=new AlertDialog.Builder(All.this);
            AlertDialog alertDialog=builder.create();
                alertDialog.setView(view1);

                btn_click_custom_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(alertDialog.isShowing()){
                        alertDialog.dismiss();
                    }
                    email=fname_custom_alert.getText().toString();
                    Toast.makeText(All.this, email, Toast.LENGTH_SHORT).show();


                }
            });
            alertDialog.show();

            }

        });

        //customtoast
        click_custom_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=getLayoutInflater();
                View view1=inflater.inflate(R.layout.custom_toas_raw,null);
                TextView textView=(TextView) view1.findViewById(R.id.custom_toast_text);
                if(email!=null){
                    textView.setText(email);
                }
                Toast toast=new Toast(All.this);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(view1);
                toast.show();


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==12 &&resultCode==RESULT_OK){
            Bitmap bitmap=(Bitmap)data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);

        }//camera capture image
        if(requestCode==121&&resultCode==RESULT_OK){
            Uri uri=data.getData();
            imageView.setImageURI(uri);
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.account_astrology);
        builder.setTitle("For Exit");
        builder.setMessage("Are you sure to leave? Y/N");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(All.this, "no it not clicked", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    //    public void click_alert(View view){
//        AlertDialog.Builder builder=new AlertDialog.Builder(this);
//        builder.setTitle("MyTaskApp");
//        builder.setIcon(R.color.teal_200);
//        builder.setMessage("Are you sure to leave?");
//        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(All.this, "Yes it clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
//        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(All.this, "No it not clicked", Toast.LENGTH_SHORT).show();
//            }
//        });//negative reply
//        builder.setNeutralButton("Finish", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.dismiss();
//            }
//        });//give the condition for exit or finish the task
//
//
//
//
//        builder.show();
//
//
//
//    }



}