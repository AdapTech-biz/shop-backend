package biz.adaptech.service;

import biz.adaptech.config.TestConfig;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ContextConfiguration(classes = TestConfig.class)
@SpringBootTest(classes = UserServiceImpl.class)
public class UserServiceTest {
    private UserService userService;

    @Autowired
    private FirebaseAuth mockFirebaseAuth;
    private final String testUid = "abcdefg";
    private final String invalidTestUid = "WRONG";

    @BeforeEach
    public void testSetup() {
        this.userService = new UserServiceImpl(mockFirebaseAuth);
    }

    @Test
    public void generateToken_ValidUid_ProvideToken() throws FirebaseAuthException {
        String expectedToken = "Valid Token";
        when(mockFirebaseAuth.createCustomToken(testUid)).thenReturn(expectedToken);
        String token = this.userService.generateToken(testUid);
        assertThat(token).isEqualTo(expectedToken);
    }

    @Test
    public void generateToken_InvalidUid_ThrowsException() throws FirebaseAuthException {

        when(mockFirebaseAuth.createCustomToken(invalidTestUid)).thenThrow(FirebaseAuthException.class);
        String token = this.userService.generateToken(invalidTestUid);
        assertThat(token).isEqualTo("Invalid UID Provided");

    }
}
