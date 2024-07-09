package com.demo1.nestedCollection;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;

import java.util.concurrent.ExecutionException;

public class FirestoreCRUD {
    
    private static Firestore firestore = FirestoreService.getFirestore();

    // Create a user
    public static void createUser(User user) throws ExecutionException, InterruptedException {
        DocumentReference docRef = firestore.collection("users").document(user.getUsername());
        ApiFuture<WriteResult> result = docRef.set(user);
        System.out.println("Update time : " + result.get().getUpdateTime());
    }

    // Read a user
    public static void readUser(String username) throws ExecutionException, InterruptedException {
        DocumentReference docRef = firestore.collection("users").document(username);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            System.out.println("User data: " + document.getData());
        } else {
            System.out.println("No such document!");
        }
    }

    // Update a user
    public static void updateUser(User user) throws ExecutionException, InterruptedException {
        DocumentReference docRef = firestore.collection("users").document(user.getUsername());
        ApiFuture<WriteResult> result = docRef.set(user);
        System.out.println("Update time : " + result.get().getUpdateTime());
    }

    // Delete a user
    public static void deleteUser(String username) throws ExecutionException, InterruptedException {
        DocumentReference docRef = firestore.collection("users").document(username);
        ApiFuture<WriteResult> writeResult = docRef.delete();
        System.out.println("Update time : " + writeResult.get().getUpdateTime());
    }

    //Add questionnaire data
    
}
