package ng.edu.baze.apptesterdb2020q1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String defaultUserMessage = null;
    private static boolean toggleEnterOnOff  = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void addressUIControls()
    {
        ImageView shootTheDoorObj = findViewById(R.id.shootTheDoor);
    }

    public void allButtonClickHandler(View view)
    {
        switch(view.getId())
        {
            case R.id.shootTheDoor:
                processShowRahButtonClick();
                break;

            case R.id.smallRah:
                navigateToHelloMeUI();
                break;
        }
    }

    private void navigateToHelloMeUI()
    {
        //Add code to navigate to the HelloMe Activity
        //Here we can do other stuff before we jump to hello_me UI
        //e.g. Signal HelloMe.java activity that navigation is
        //from Main Page i.e. activity_main.xml

        //1. Create an object of the Intent class indicate intended
        //  navigation from MainActivity to the Login.java.class
        Intent helloMe = new Intent(MainActivity.this,
                HelloMe.class);
        //2. Use the object to start the LoginActvity.class program
        startActivity(helloMe);
    }

    private void processShowRahButtonClick()
    {
        //Address control with id/userMessage
        TextView userMessageObject = findViewById(R.id.userMessage);
        //
        ImageButton smallRahObject;
        //retrieve the object code using the address contained
        //R.id.smallRah
        smallRahObject = findViewById(R.id.smallRah);

        //Use the object of the ImageButton to make
        // the image visible:
        if (toggleEnterOnOff)
        {
            //if it is on, hide the views
            smallRahObject.setVisibility(View.INVISIBLE);
            toggleEnterOnOff = false;
            //Restore default user message
            userMessageObject.setText(defaultUserMessage);
        }
        else
        {
            //if it is off make the views visible.
            smallRahObject.setVisibility(View.VISIBLE);
            toggleEnterOnOff = true;
            //save default user message
            defaultUserMessage = userMessageObject.getText().toString();
            //modify the default message
            userMessageObject.setText(defaultUserMessage + "\n Yes you are!");
            //** Mission #1 Week 11 (online)
            String toastMessage = "You are really, really visible";
            Toast.makeText(MainActivity.this, toastMessage,
                    Toast.LENGTH_LONG ).show();
            //end Mission #1
        }

    }

}
