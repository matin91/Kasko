package com.rocklobstre.kasko.data.repositories.datasource;

import com.rocklobstre.kasko.data.entities.BucketEntity;
import com.rocklobstre.kasko.firebase.RxFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Matin on 24/02/2017.
 */

public class BucketDataSourceRemote extends BaseFirebaseDataSource {

    /**
     * The target node for a given service
     */
    private DatabaseReference childReference = null;

    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;

    @Inject
    public BucketDataSourceRemote(FirebaseAuth firebaseAuth, FirebaseDatabase firebaseDatabase) {
        this.firebaseDatabase = firebaseDatabase;
        this.firebaseAuth = firebaseAuth;
    }

    public DatabaseReference getChildReference() {
        if (childReference == null) {
            this.childReference = this.firebaseDatabase.
                    getReference()
                    .child(FIREBASE_CHILD_KEY_USERS)
                    .child(this.firebaseAuth.getCurrentUser().getUid());
        }

        return childReference;
    }

    /**
     * Allows to get the {@link BucketEntity}
     * @return
     */
    public Observable<BucketEntity> getBucket() {
        return RxFirebase.getObservable(getChildReference(), BucketEntity.class);
    }
}
