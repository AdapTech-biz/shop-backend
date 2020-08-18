package biz.adaptech;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ShopBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopBackendApplication.class, args);

	}

	@Bean
	public FirebaseAuth getFirebaseAuth() {
		return FirebaseAuth.getInstance();
	}

	@Bean
	public Firestore connectToFireStore() {
		return FirestoreClient.getFirestore();

	}

}
