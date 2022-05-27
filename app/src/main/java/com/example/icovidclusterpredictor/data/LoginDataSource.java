package com.example.icovidclusterpredictor.data;

import androidx.annotation.NonNull;

import com.example.icovidclusterpredictor.data.model.LoggedInUser;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that handles user authentication.
 */
public class LoginDataSource {
    private static LoggedInUser loggedInUser =new LoggedInUser();
    public static LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }
    public static void setLoggedInUser(LoggedInUser loggedInUser) {
        LoginDataSource.loggedInUser = loggedInUser;
    }
    public Boolean login(String username, String password) {
        try {
            LoggedInUser user= LoginDataSource.getLoggedInUser();
            if (getLoggedInUser().getUserEmail().equals(username) && getLoggedInUser().getPassword().equals(password))
            {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    // register a test user
    public void register() {
        // create  user
        getLoggedInUser().setName("Ahmed");
        getLoggedInUser().setUserEmail("admin@icovid.com");
        getLoggedInUser().setPassword("123456");
        // ini Db connection
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // create a map entry
        Map<String, Object> appuser = new HashMap<>();
        appuser.put("name", "Ahmed");
        appuser.put("email", "admin@icovid.com");
        appuser.put("password", "123456");

// Add the user to
        db.collection("users")
                .add(appuser)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        // TODO: call when user onSuccess
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // TODO: call when user onFailed
                    }
                });
    }
    public void logout() {
        // TODO: call when user loggedout
    }
}
