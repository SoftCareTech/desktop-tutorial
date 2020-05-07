package ng.edu.baze.apptesterdb2020q1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter< UserAdapter.UserView> {
    public UserAdapter(ArrayList<User> users, Context context) {
        this.users = users;
        this.context = context;
    }
     
    String TAG = "market";
    ArrayList<User> users ;
    Context context;
    @NonNull
    @Override
    public UserView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_view , parent , false);
        UserView productView=new UserView(view);
        return productView;
    }

    @Override
    public void onBindViewHolder(@NonNull final UserView holder, final int position) {
        Log.d(TAG,"something added");

        holder.name.setText(users.get(position).getName()
        );
        holder.email.setText(users.get(position).getEmail());
        holder.phone.setText(users.get(position).getPhone());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog comfirmDelete = new Dialog(context);
                String title = "Comfirm Delete" ;
                String message ="Do sure you wnt to remove "+ users.get(position).getName()+"?";
                String button1String = "No";
                String button2String = "Yes";
                AlertDialog.Builder ad = new AlertDialog.Builder(context);
                ad.setTitle(title);
                ad.setCancelable(false);;

                ad.setMessage(message);
                ad.setPositiveButton(
                        button1String,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int arg1) {

                            }
                        }
                );
                ad.setNegativeButton(
                        button2String,
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int arg1) {
                                users.remove(position);
                                notifyItemRemoved(position);
                            }
                        }
                );ad.show();


            }
        });

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog popup= new Dialog(context );
                popup.setContentView(R.layout.user_add );
                popup.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popup.dismiss();
                    }
                });

                ((TextView)popup.findViewById(R.id.name)).setText(users.get(position).getName());
                ((TextView)popup.findViewById(R.id.phone)).setText(users.get(position).getPhone());
                ((TextView)popup.findViewById(R.id.email)).setText(users.get(position).getEmail());
                ((Button)popup.findViewById(R.id.add)).setText("commit edit");

                ((TextView)popup.findViewById(R.id.title)).setText("Edit "+users.get(position).getName());

                popup.findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        users.remove(position);
                        users.add(position,new User(((TextView)popup.findViewById(R.id.name)).getText().toString(),
                                ((TextView)popup.findViewById(R.id.phone)).getText().toString(),
                                ( (TextView)popup.findViewById(R.id.email)).getText().toString()));
                        notifyItemChanged(position);
                        popup.dismiss();
                    }
                });
                popup.show();
            }


        });



    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public  class UserView extends RecyclerView.ViewHolder{
        TextView name;
        TextView email;
        TextView phone;
        Button edit;
        Button delete;

        public UserView (@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.name);
            email=itemView.findViewById(R.id.email);
            phone=itemView.findViewById(R.id.phone);
            edit=itemView.findViewById(R.id.edit);
            delete=itemView.findViewById(R.id.delete);
        }
    }
}
