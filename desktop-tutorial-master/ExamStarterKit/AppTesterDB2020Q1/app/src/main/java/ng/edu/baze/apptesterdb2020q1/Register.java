package ng.edu.baze.apptesterdb2020q1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void allButtonClickHandler(View view)
    {
        switch(view.getId())
        {

            case R.id.register: {
                // calling processRegisterButtonClick method for question 1
                String   toastMessage="calling processRegisterButtonClick method for question 1";
                Toast.makeText(Register.this, toastMessage,
                        Toast.LENGTH_LONG ).show();
                processRegisterButtonClick ();
            }
                break;


 }
    }

    public void processRegisterButtonClick ()
    {

    }
}
