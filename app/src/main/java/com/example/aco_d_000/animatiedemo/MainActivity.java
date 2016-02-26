package com.example.aco_d_000.animatiedemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    ImageView bartIMG, homerIMG;
    SeekBar seekBar;
    RadioGroup buttonGroup;
    RadioButton fadeButton, translateButton, rotateButton;
    boolean bartOnScreen;
    long duration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bartIMG = (ImageView) findViewById(R.id.bartIMG);
        homerIMG = (ImageView) findViewById(R.id.homerIMG);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        buttonGroup = (RadioGroup) findViewById(R.id.radioGroup);
        fadeButton = (RadioButton) findViewById(R.id.fadeButton);
        translateButton = (RadioButton) findViewById(R.id.translateButton);
        rotateButton = (RadioButton) findViewById(R.id.rotateButton);
        if(fadeButton.isChecked()){
            homerIMG.animate().alpha(0f).setDuration(0l);
        }
        else if(translateButton.isChecked()){
            homerIMG.animate().translationX(-1000l).setDuration(0l);
        }
        else{
            homerIMG.animate().scaleX(0f).scaleY(0f).setDuration(0l);
        }
        bartOnScreen = true;
    }

    public void checkRadioButtons(){
        buttonGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bartOnScreen) {
                    if (fadeButton.isChecked()) {
                        homerIMG.animate().translationX(0f).setDuration(0l);
                        homerIMG.animate().scaleX(1f).scaleY(1f).setDuration(0l);
                        homerIMG.animate().alpha(0f).setDuration(0l);
                    } else if (translateButton.isChecked()) {
                        homerIMG.animate().alpha(1f).setDuration(0l);
                        homerIMG.animate().scaleX(1f).scaleY(1f).setDuration(0l);
                        homerIMG.animate().translationX(-1000l).setDuration(0l);
                    } else {
                        homerIMG.animate().alpha(1f).setDuration(0l);
                        homerIMG.animate().translationX(0f).setDuration(0l);
                        homerIMG.animate().scaleX(0f).scaleY(0f).setDuration(0l);
                    }
                }
                else{
                    if (fadeButton.isChecked()) {
                        bartIMG.animate().translationX(0f).setDuration(0l);
                        bartIMG.animate().scaleX(1f).scaleY(1f).setDuration(0l);
                        bartIMG.animate().alpha(0f).setDuration(0l);
                    } else if (translateButton.isChecked()) {
                        bartIMG.animate().alpha(1f).setDuration(0l);
                        bartIMG.animate().scaleX(1f).scaleY(1f).setDuration(0l);
                        bartIMG.animate().translationX(1000l).setDuration(0l);
                    } else {
                        bartIMG.animate().alpha(1f).setDuration(0l);
                        bartIMG.animate().translationX(0f).setDuration(0l);
                        bartIMG.animate().scaleX(0f).scaleY(0f).setDuration(0l);
                    }
                }
            }
        });
    }

    public void animate(View v){
        checkRadioButtons();
        duration = seekBar.getProgress();
        if(fadeButton.isChecked()){
            fade();
        }
        else if(translateButton.isChecked()){
            translate();
        }
        else {
            rotate();
        }

        bartOnScreen = !bartOnScreen;


    }

    private void fade(){
        if(bartOnScreen){
            bartIMG.animate().alpha(0f).setDuration(duration);
            homerIMG.animate().alpha(1f).setDuration(duration);
        }
        else{
            bartIMG.animate().alpha(1f).setDuration(duration);
            homerIMG.animate().alpha(0f).setDuration(duration);
        }
    }

    private void translate(){
        if(bartOnScreen){
            bartIMG.animate().translationX(1000l).setDuration(duration);
            homerIMG.animate().translationX(0f).setDuration(duration);
        }
        else{
            bartIMG.animate().translationX(0f).setDuration(duration);
            homerIMG.animate().translationX(-1000l).setDuration(duration);
        }
    }

    private void rotate(){
        if(bartOnScreen){
            bartIMG.animate().rotation(720f).scaleX(0f).scaleY(0f).setDuration(duration);
            homerIMG.animate().rotation(-720f).scaleX(1f).scaleY(1f).setDuration(duration);
        }
        else {
            bartIMG.animate().rotation(-720f).scaleX(1f).scaleY(1f).setDuration(duration);
            homerIMG.animate().rotation(720f).scaleX(0f).scaleY(0f).setDuration(duration);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
