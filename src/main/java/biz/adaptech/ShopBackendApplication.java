package biz.adaptech;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


@SpringBootApplication
public class ShopBackendApplication {

	public static void main(String[] args) {
		try {
			InputStream serviceAccount = new FileInputStream(System.getenv("FIREBASE_CRED"));
		GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);

		if (FirebaseApp.getApps().isEmpty()) {
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(credentials)
					.build();
			FirebaseApp.initializeApp(options);
		}
		} catch (IOException exception) {

		}
		SpringApplication.run(ShopBackendApplication.class, args);

	}


	@Bean
	public FirebaseAuth getFirebaseAuth() {
		return FirebaseAuth.getInstance();
	}

	@Bean
	public Firestore getFirestore() {
		return FirestoreClient.getFirestore();

	}

}
