package biz.adaptech.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private FirebaseAuth firebaseAuth;

    public UserServiceImpl(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }

    @Override
    public String generateToken(String uid) {

        String token;
        try {
            token = this.firebaseAuth.createCustomToken(uid);

        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            token = "Invalid UID Provided";
        }

        return token;
    }




}
