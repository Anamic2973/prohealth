package com.demo1.nestedCollection;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;

import java.io.FileInputStream;
import java.io.IOException;

public class FirestoreService {
    
    private static Firestore firestore;

    public static void initialize() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("sarthakfxproject trial error\\src\\main\\resources\\java-fx-firebase-store-cbbc3-firebase-adminsdk-d7d9t-38a3c64333.json");

        FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder()
            .setProjectId("java-fx-firebase-store-cbbc3")
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build();

        firestore = firestoreOptions.getService();
    }

    public static Firestore getFirestore() {
        return firestore;
    }
}
