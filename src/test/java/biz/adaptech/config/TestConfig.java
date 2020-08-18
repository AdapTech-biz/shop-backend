package biz.adaptech.config;

import com.google.firebase.auth.FirebaseAuth;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class TestConfig {

    @Bean
    public FirebaseAuth getFirebaseAuth() {
        return Mockito.mock(FirebaseAuth.class);
    }
}
