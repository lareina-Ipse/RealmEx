package kr.co.chience.realmex.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import kr.co.chience.realmex.R;
import kr.co.chience.realmex.clud.CRUPCurso;
import kr.co.chience.realmex.model.Curso;

public class CursoActivity extends AppCompatActivity {

    private EditText id, name, duraction;
    private Button save, update, delete;
    private Curso curso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);

        curso = new Curso();
        id = findViewById(R.id.cursoId);
        name = findViewById(R.id.cursoName);
        duraction = findViewById(R.id.cursoDc);
        save = findViewById(R.id.salvar);
        update = findViewById(R.id.actualizar);
        delete = findViewById(R.id.borrar);
        configView();

    }

    private void configView() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curso.setName(name.getText().toString());
                curso.setDuration(duraction.getText().toString());
                CRUPCurso.addCurso(id.getText().toString(), curso);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CRUPCurso.updateCursoByName(name.getText().toString());
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CRUPCurso.deleteCursoByName(name.getText().toString());
            }
        });
    }
}
