package ng.edu.baze.apptesterdb2020q1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    private static boolean toggleEnterOnOff  = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void allButtonClickHandler(View view)
    {
        switch(view.getId())
        {
            case R.id.loginButton:
                validateUserCredential();
                break;

            case R.id.register:
                navigateToRegisterUI();
                break;

            case R.id.myComment:
                provideFeedBack();
                break;

            case R.id.restoreButton:
                toggleOnOffDataEntry();
                break;
        }
    }

    private void toggleOnOffDataEntry()
    {
        //Enable access to the ID and password and Token text boxes
        EditText personEmail  =  findViewById(R.id.personEmail);
        //
        EditText password =  findViewById(R.id.password);
        //Toggle on/off visibility
        if (toggleEnterOnOff)
        {
            //if it is on, hide the views
            personEmail.setVisibility(View.INVISIBLE);
            password.setVisibility(View.INVISIBLE);
            toggleEnterOnOff = false;
        }
        else
        {
            //if it is off make the views visible.
            personEmail.setVisibility(View.VISIBLE);
            password.setVisibility(View.VISIBLE);
            toggleEnterOnOff = true;
        }
    }

    private void navigateToRegisterUI()
    {
        //Add code to navigate to the HelloMe Activity
        //Here we can do other stuff before we jump to hello_me UI
        //e.g. Signal HelloMe.java activity that navigation is
        //from Main Page i.e. activity_main.xml

        //1. Create an object of the Intent class indicate intended
        //  navigation from MainActivity to the Login.java.class
        Intent registerMe = new Intent(Login.this,
                Register.class);
        //2. Use the object to start the RegisterActivity.class program
        startActivity(registerMe);
    }

    private void validateUserCredential()
    {

    }

    private void provideFeedBack()
    {

    }


    public void showPasswordCheckBoxHandler(View view)
    {

    }

}
