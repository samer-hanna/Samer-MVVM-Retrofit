package com.example.retrofitmvvm.ui.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.retrofitmvvm.R;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {
    TextView tvSummary, tvLink;
    //ImageView myImage1, myImage2, myImage3;
    Button btnLink;
    ImageSlider slider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if (getIntent().hasExtra("image1") && getIntent().hasExtra("image2") &&
                getIntent().hasExtra("image3") && getIntent().hasExtra("summary") &&
                getIntent().hasExtra("link")){

            String image1 = getIntent().getStringExtra("image1");
            String image2 = getIntent().getStringExtra("image2");
            String image3 = getIntent().getStringExtra("image3");
            String summary = getIntent().getStringExtra("summary");
            String link = getIntent().getStringExtra("link");

            setImage(image1, image2, image3, summary, link);

        }
    }

    private void setImage(String image1, String image2, String image3, String summary, String link){

        tvSummary = findViewById(R.id.tvSummary);
        tvSummary.setText(summary);
        tvLink = findViewById(R.id.tvLink);
        tvLink.setText("link: " + link);

        slider = findViewById(R.id.slider);
        List<SlideModel> imageSlider = new ArrayList<>();
        imageSlider.add(new SlideModel(image1));
        imageSlider.add(new SlideModel(image2));
        imageSlider.add(new SlideModel(image3));
        slider.setImageList(imageSlider, true);

        /*
        myImage1 = findViewById(R.id.image1);
        myImage2 = findViewById(R.id.image2);
        myImage3 = findViewById(R.id.image3);

        Glide.with(this)
                .load(image1)
                .into(myImage1);
        Glide.with(this)
                .load(image2)
                .into(myImage2);
        Glide.with(this)
                .load(image3)
                .into(myImage3);

         */
    }



    public void goLink(View view){

        //download
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getIntent().getStringExtra("link")));
        startActivity(intent);
    }


}