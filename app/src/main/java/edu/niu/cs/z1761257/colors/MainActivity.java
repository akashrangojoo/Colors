package edu.niu.cs.z1761257.colors;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListFragment.OnItemSelectedListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }//end of onCreate


    @Override
    public void onShadeItemSelected(String colorInfo) {
        InformationFragment informationFragment = (InformationFragment)getFragmentManager().findFragmentById(R.id.infoFrament);
        //handle landscape orientation
        if (informationFragment!= null && informationFragment.isInLayout()){
            informationFragment.setText(colorInfo);
        }else { //handle portrait orientation
            Intent intent = new Intent(this,InformationActivity.class);
            intent.putExtra("Information",colorInfo);
            startActivity(intent);
        }
    }
}//end of MainActivity
