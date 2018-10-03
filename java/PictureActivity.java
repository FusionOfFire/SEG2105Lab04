package ca.fgaud013uottawa.sportprofilmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PictureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
    }

    public void SetTeamIcon(View view){
        //Creating a return intent to pass to the main activity
        Intent returnIntent = new Intent();

        //Figuring out which image was clicker
        ImageView selectedImage = (ImageView) view;

        //Adding stuff to the return intent
        returnIntent.putExtra("imageID", selectedImage.getId());
        setResult(RESULT_OK, returnIntent);

        //Finishing activity and return to main screen!
        finish();
    }

}
