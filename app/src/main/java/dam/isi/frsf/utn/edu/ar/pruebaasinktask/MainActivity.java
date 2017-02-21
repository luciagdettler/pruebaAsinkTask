package dam.isi.frsf.utn.edu.ar.pruebaasinktask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.ExecutionException;

import dam.isi.frsf.utn.edu.ar.pruebaasinktask.domain.User;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private User miusuariologeado;
    public static TextView email;
    public static TextView contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=(TextView) findViewById(R.id.email);
        contra=(TextView) findViewById(R.id.contraseña);



        try {
            miusuariologeado = new AsinTaskFirebase().execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }


}
