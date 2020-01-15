package kr.co.chience.realmex.clud;

import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import kr.co.chience.realmex.model.Profesor;

public class CRUPProfesor {

    private final static int calculateIndex() {
        Realm realm = Realm.getDefaultInstance();
        Number currentIdNum = realm.where(Profesor.class).max("id");
        int nextId;
        if (currentIdNum == null) {
            nextId = 0;
        } else {
            nextId = currentIdNum.intValue() + 1;
        }
        return nextId;
    }

    public final static void addProfesor(final Profesor profesor) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                int index = CRUPProfesor.calculateIndex();
                Profesor realmProfesor = realm.createObject(Profesor.class, index);
                realmProfesor.setName(profesor.getName());
                realmProfesor.setEmail(profesor.getEmail());

            }
        });
    }

    public final static List<Profesor> getAllProfesor() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Profesor> profesors = realm.where(Profesor.class).findAll();
        for (Profesor profesor: profesors) {
            Log.e("TAG", " id ::: " + profesor.getId() + " nombre ::: " + profesor.getName() + " email ::: " + profesor.getEmail());
            for (int i=0; i<profesor.getCursos().size(); i++) {
                Log.e("TAG", " id ::: " + profesor.getId() + " nombre ::: " + profesor.getName() + " email ::: " + profesor.getEmail());
            }
        }
        return profesors;
    }

    public final static Profesor getProfesorByName(String name) {
        Realm realm = Realm.getDefaultInstance();
        Profesor profesor = realm.where(Profesor.class).equalTo("name", name).findFirst();

        if (profesor != null) {
            Log.e("TAG", " id ::: " + profesor.getId() + " nombre ::: " + profesor.getName() + " email ::: " + profesor.getEmail());
        }
        return profesor;
    }

    public final static void updateProfesorById(int id) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Profesor profesor = realm.where(Profesor.class).equalTo("id", id).findFirst();
        profesor.setName("alberto");
        realm.insertOrUpdate(profesor);
        realm.commitTransaction();

        if (profesor != null) {
            Log.e("TAG", " id ::: " + profesor.getId() + " nombre ::: " + profesor.getName() + " email ::: " + profesor.getEmail());
        }
    }

    public final static void deleteProfesorById(int id) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Profesor profesor = realm.where(Profesor.class).equalTo("id", id).findFirst();
        profesor.deleteFromRealm();
        realm.commitTransaction();

        if (profesor != null) {
            Log.e("TAG", " id ::: " + profesor.getId() + " nombre ::: " + profesor.getName() + " email ::: " + profesor.getEmail());
        }
    }

    public final static void deleteAllProfesor() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<Profesor> profesor = realm.where(Profesor.class).findAll();
        realm.deleteAll();
        realm.commitTransaction();

        Log.e("TAG", "데이터가 모두 삭제 되었습니다.");
    }
}
