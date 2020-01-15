package kr.co.chience.realmex.clud;

import io.realm.Realm;
import kr.co.chience.realmex.model.Curso;
import kr.co.chience.realmex.model.Profesor;

public class CRUPCurso {

    public final static void addCurso(final String id, final Curso curso) {
        int profesorId = Integer.parseInt(id);
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Profesor profesorRealm = realm.where(Profesor.class).equalTo("id", Integer.parseInt(id)).findFirst();
        profesorRealm.getCursos().add(curso);
        realm.insertOrUpdate(profesorRealm);

        realm.commitTransaction();
    }

    public final static void updateCursoByName(String name) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Curso curso = realm.where(Curso.class).equalTo("name", name).findFirst();
        curso.setName("Realm Android");
        realm.insertOrUpdate(curso);
        realm.commitTransaction();
    }

    public final static void deleteCursoByName(String name) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Curso curso = realm.where(Curso.class).equalTo("name", name).findFirst();
        curso.deleteFromRealm();
        realm.commitTransaction();
    }


}
