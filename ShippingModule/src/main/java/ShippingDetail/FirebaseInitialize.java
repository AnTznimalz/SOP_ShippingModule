package ShippingDetail;

import java.io.File;
import java.io.FileInputStream;
import java.security.cert.CertificateEncodingException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseInitialize {
	
	Logger logger = LoggerFactory.getLogger(FirebaseInitialize.class);
	
	@PostConstruct
	public static void initialize() {
		File f = new File("serviceAccountKey.json");
		if (f.isFile() && f.canRead()) {
			System.out.println("------------------------------");
		}
		System.out.println("---------******************--------------------");
		try {
			FileInputStream serviceAccount = new FileInputStream("serviceAccountKey.json");
						
					FirebaseOptions options = new FirebaseOptions.Builder()
					  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
					  .setDatabaseUrl("https://fir-demo-8920f.firebaseio.com")
					  .build();

					FirebaseApp.initializeApp(options);
			        Firestore db = FirestoreClient.getFirestore();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}