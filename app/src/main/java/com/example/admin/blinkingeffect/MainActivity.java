package com.example.admin.blinkingeffect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity implements Animation.AnimationListener{
    TextView a;
    Button b;
    Animation animFadein,animFadeout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a=(TextView)findViewById(R.id.textview);
        b=(Button)findViewById(R.id.button2);

        //loading the animation in fade in
        animFadein=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        //setting the listner
        animFadein.setAnimationListener(this);
        animFadeout=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        //puting listner to button
        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                a.setVisibility(View.VISIBLE);
        //starting a animation
                a.startAnimation(animFadein);
            }
        });
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if(animFadein==animFadein){

            a.startAnimation(animFadeout);
            animFadeout.start();
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
