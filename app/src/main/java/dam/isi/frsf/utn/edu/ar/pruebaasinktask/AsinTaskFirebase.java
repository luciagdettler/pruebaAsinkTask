package dam.isi.frsf.utn.edu.ar.pruebaasinktask;

import android.os.AsyncTask;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import dam.isi.frsf.utn.edu.ar.pruebaasinktask.domain.User;

/**
 * Created by Usuario on 13/2/2017.
 */
public class AsinTaskFirebase extends AsyncTask<Void,Integer,User> {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private User user;

        @Override
        protected User doInBackground(Void... params) {

            buscarUsuario();
            /*DatabaseReference firebaseReference = database.getReference("users").child("0");
            firebaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    user = dataSnapshot.getValue(User.class);

                }

                @Override
                public void onCancelled(DatabaseError firebaseError) {
                    //NADA
                }
            });*/


            return user;

        }


        public void buscarUsuario(){

            DatabaseReference firebaseReference = database.getReference("users").child("0");
            firebaseReference.addChildEventListener(new ChildEventListener() {

                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    user = dataSnapshot.getValue(User.class);
                }


                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

        });




        }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(User user) {
        //super.onPostExecute();
        MainActivity.email.setText(user.getEmail());
        MainActivity.contra.setText(user.getPassword());
        Log.d("fechaActual", "Email: "+user.getEmail() +" pass: " + user.getPassword());
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(User user) {
        super.onCancelled(user);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

}