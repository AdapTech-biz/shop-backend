package biz.adaptech.service;

import biz.adaptech.model.InventoryItem;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.cloud.FirestoreClient;

import java.util.List;

public interface UserService {

    String generateToken(String uid);

}
