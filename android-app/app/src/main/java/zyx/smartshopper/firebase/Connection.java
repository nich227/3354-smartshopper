package zyx.smartshopper.firebase;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Connection {
    private final String TAG = "SS-Fire";
    private FirebaseFirestore firestore;

    public Connection() {

    }

    public void createConnection() {
        firestore = FirebaseFirestore.getInstance();
    }

    public void writeData(String collectionPath, String key, String value) {
        // Create a new user with a first and last name
        Map<String, Object> data = new HashMap<>();
        data.put(key, value);

        // Add a new document with a generated ID
        firestore.collection(collectionPath)
                .add(data)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }


}
