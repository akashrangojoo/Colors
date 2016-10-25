package edu.niu.cs.z1761257.colors;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Pravin on 3/31/16.
 */
public class InformationActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }
        setContentView(R.layout.fragment_information);
        Intent intent = getIntent();
        String shadeInfo = intent.getStringExtra("Information");
        TextView infoTV = (TextView)findViewById(R.id.colorInfoTextView);
        infoTV.setText(shadeInfo);

        Button returnBtn = (Button)findViewById(R.id.returnButton);
        returnBtn.setVisibility(View.VISIBLE);
    }//end of onCreate

    public void goBack(View view){
        finish();
        view.setVisibility(View.INVISIBLE);
    }
}//enf of InformaitonActivity
