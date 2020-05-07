package ng.edu.baze.apptesterdb2020q1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MeThings extends AppCompatActivity   {
    ArrayList<User> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_things);

       users =new  ArrayList<User>();
        users.add(new User("Defaul user","09065745324","faith@gmail.com"));
        RecyclerView userView = findViewById(R.id.users);
        UserAdapter productAdapter = new UserAdapter(users, this
        );
        userView.setAdapter(productAdapter);
        userView.setLayoutManager(new GridLayoutManager(this,1));
         findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog popup= new Dialog(MeThings.this );
                popup.setContentView(R.layout.user_add );

                popup.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popup.dismiss();
                    }
                });

                popup.findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        users.add(new User(((TextView)popup.findViewById(R.id.name)).getText().toString(),
                                ((TextView)popup.findViewById(R.id.phone)).getText().toString(),
                                ( (TextView)popup.findViewById(R.id.email)).getText().toString()));
                        popup.dismiss();
                    }
                });
                popup.show();
            }
        });


    }



}
