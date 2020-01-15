package kr.co.chience.realmex.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import kr.co.chience.realmex.R;
import kr.co.chience.realmex.clud.CRUPProfesor;
import kr.co.chience.realmex.model.Profesor;

public class MainActivity extends AppCompatActivity {

    private EditText nombre, email;
    private Button save;
    private Profesor profesor;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance();
        configView();
    }

    private void configView() {
        profesor = new Profesor();
        nombre = findViewById(R.id.nombre);
        email = findViewById(R.id.email);
        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profesor.setName(nombre.getText().toString());
                profesor.setEmail(nombre.getText().toString());
                CRUPProfesor.addProfesor(profesor);
            }
        });
    }
}
