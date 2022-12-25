package com.example.learningapp.firebase;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.learningapp.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FirebaseManager {


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference user_ref = database.getReference("app_user");
    private FirebaseAuth mAuth;

    public void addDatabase(User user) {
        String key = user_ref.push().getKey();
        user_ref.child(key).setValue(user, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {

            }
        });

    }
    public interface RetriveAllUserListener{
        public void getAllUser(ArrayList <User> users);
    }
    public void getAlUser(RetriveAllUserListener retriveUserListener) {
        ArrayList<User>arrayList=new ArrayList<>();
        user_ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Iterable<DataSnapshot> snapshotIterable = snapshot.getChildren();
                 Log.d("myrequest",snapshot.toString());
                for (DataSnapshot aSnapshotIterable : snapshotIterable) {

                    try {
                        User value = aSnapshotIterable.getValue(User.class);
                        value.setId(aSnapshotIterable.getKey());
                        arrayList.add(value);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                retriveUserListener.getAllUser(arrayList);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                retriveUserListener.getAllUser(new ArrayList<>());
            }
        });


    }
    public interface RetriveUserListener{
        public void getUser(User user);
    }
    public void getMyUserInfo(String userEmail,RetriveUserListener retriveUserListener) {

        user_ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Iterable<DataSnapshot> snapshotIterable = snapshot.getChildren();
                 Log.d("myrequest",snapshot.toString());
                for (DataSnapshot aSnapshotIterable : snapshotIterable) {

                    try {
                        User value = aSnapshotIterable.getValue(User.class);
                        value.setId(aSnapshotIterable.getKey());
                      if(value.getEmail().equals(userEmail)){
                          retriveUserListener.getUser(value);
                          break;
                      }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                retriveUserListener.getUser(null);
            }
        });


    }

    public FirebaseUser getCurrentUser() {
        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() == null) return null;
        else return mAuth.getCurrentUser();

    }
}
