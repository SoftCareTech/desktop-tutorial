package ng.edu.baze.apptesterdb2020q1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
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

    @Override
    protected void onResume() {
        super.onResume();
        //
        checkIfUserIsLogin();
        //
        Toast.makeText(MainActivity.this, "From Hello Me or Login, ONRESUME",
                Toast.LENGTH_LONG ).show();
    }
    private  void   checkIfUserIsLogin(){
        //Address Baze u rock TextView control @idmyNameIs
        TextView  myNameIs = findViewById(R.id.myNameIs);
        //retrieve loggedIn user name from Login.java class field
        if(Login.loginUser!=null&&Login.loginUser.length()>0){
            myNameIs.setText(Login.loginUser);
        }
    }
 public void popup(View view){
        final Dialog popup= new Dialog(this );
        popup.setContentView(R.layout.popup );
        popup.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              popup.dismiss();
            }
        });
        String name=" Non";
       ImageView popImageView = popup.findViewById(R.id.image_view);
       switch(view.getId())
       {
           case R.id.hotRod1: {
               name = "acura_rdx_2019";
               popImageView.setImageResource(R.drawable.acura_rdx_2019);
               break;
           }
           case R.id.hotRod2: {
               name = "  alfa_romeo_stelvio_quadrifoglio_2020";
               popImageView.setImageResource(R.drawable.alfa_romeo_stelvio_quadrifoglio_2020);
               break;
           }

           case R.id.hotRod3: {
               name = "amg_g_65_suv_v8_2019";
               popImageView.setImageResource(R.drawable.amg_g_65_suv_v8_2019);
               break;
           }
           case R.id.hotRod4:
               name="aston_martin_db10";
               popImageView.setImageResource(R.drawable.aston_martin_db10);
               break;
           case R.id.hotRod5:
               name="bmw_i8_2019";
               popImageView.setImageResource(R.drawable.bmw_i8_2019);
               break;
       }
       ((TextView)popup.findViewById(R.id.name)).setText(name);
       popup.show();



   }
}
