package ca.fgaud013uottawa.sportprofilmanager;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * @Description : Program made for Lab 04 of SEG2105
 * @author      : Frédérick Gaudet - 8035208
 * @date        : 02 October 2018
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_CANCELED) return;

        //Getting the Avatar Image we show to our users
        ImageView avatarImage = (ImageView)findViewById(R.id.avatarImage);

        //Figuring out the correct image
        String drawableName = "ic_logo_00";
        switch (data.getIntExtra("imageID", R.id.img00)){
            case R.id.img00:
                drawableName = "ic_logo_00";
                break;
            case R.id.img01:
                drawableName = "ic_logo_01";
                break;
            case R.id.img02:
                drawableName = "ic_logo_02";
                break;
            case R.id.img03:
                drawableName = "ic_logo_03";
                break;
            case R.id.img04:
                drawableName = "ic_logo_04";
                break;
            case R.id.img05:
                drawableName = "ic_logo_05";
                break;
            default:
                drawableName = "ic_logo_00";
                break;
        }

        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        avatarImage.setImageResource(resID);
    }

    public void OnOpenInGoogleMaps(View view){
        EditText teamAddres = (EditText)findViewById(R.id.locationEdit);

        //Create a Uri from an intent string. Use the result to create an intent
        Uri gmmInteUri = Uri.parse("http://maps.google.co.in/maps?q=" + teamAddres.getText());

        //Create an intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmInteUri);

        //Make the intent explicit by setting Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");

        //Attempt to start an activity that can handle the intent
        startActivity(mapIntent);
    }

    public void OnSetAvatarButton(View view){
        //Application context and Activity
        Intent intent = new Intent(getApplicationContext(), PictureActivity.class);

        startActivityForResult(intent,0);
    }
}
