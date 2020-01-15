package kr.co.chience.realmex.clud;

import io.realm.Realm;
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
                realmProfesor.setEmail(profesor.getEmail());
                realmProfesor.setEmail(profesor.getEmail());
            }
        });
    }
}
