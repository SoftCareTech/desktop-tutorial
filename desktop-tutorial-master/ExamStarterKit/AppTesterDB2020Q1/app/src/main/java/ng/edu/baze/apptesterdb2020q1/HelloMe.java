package ng.edu.baze.apptesterdb2020q1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HelloMe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_me);
    }

    public void allButtonClickHandler(View view)
    {
        switch(view.getId())
        {
            case R.id.mustLogin:
                navigateToLogin();
                break;

            case R.id.updateProfile:
                updateDatabase();
                break;

            case R.id.validateEntry:
                validateUserEntry();
                break;
            case R.id.me:
                adminOperations();
                break;
        }
    }

    private void navigateToLogin()
    {
        //Add code to navigate to the HelloMe Activity
        //Here we can do other stuff before we jump to hello_me UI
        //e.g. Signal HelloMe.java activity that navigation is
        //from Main Page i.e. activity_main.xml

        //1. Create an object of the Intent class indicate intended
        //  navigation from MainActivity to the Login.java.class
        Intent logMeIn = new Intent(HelloMe.this,
                Login.class);
        //2. Use the object to start the LoginActvity.class program
        startActivity(logMeIn);
    }

    private void updateDatabase()
    {

    }

    private void validateUserEntry()
    {

    }

    public void whatsAppCheckBoxHandler(View view)
    {

    }

    public void showPasswordCheckBoxHandler(View view)
    {

    }
    private void adminOperations()
    {

        //  navigation from HelloMe.java to the MeThing.java
        Intent adminOperations = new Intent(this,
                MeThings.class);
        // starting the MeThings.class program
        startActivity(adminOperations);
    }

}
