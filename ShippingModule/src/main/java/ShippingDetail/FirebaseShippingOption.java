package ShippingDetail;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.core.Path;

@Service
public class FirebaseShippingOption {
	
	public static String createShippingOption(ShippingOption message) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<DocumentReference> addedDocRef = db.collection("shippingOption").add(message);
        message.setId(addedDocRef.get().getId());
        return saveShippingOption(message);
    }

	public static String saveShippingOption(ShippingOption message) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> future = db.collection("shippingOption").document(message.getId()).set(message);
        return future.get().getUpdateTime().toString();
    }
	
	public static ShippingOption getShippingOption(String id) throws InterruptedException, ExecutionException {
		Firestore db = FirestoreClient.getFirestore();
		DocumentReference docRef = db.collection("shippingOption").document(id);
		// asynchronously retrieve the document
		ApiFuture<DocumentSnapshot> future = docRef.get();
		// block on response
		DocumentSnapshot document = future.get();
		ShippingOption s = null;
		if (document.exists()) {
		  // convert document to POJO
		  s = document.toObject(ShippingOption.class);
		  System.out.println(s);
		  return s;
		} else {
		  System.out.println("No such document!");
		  return null;
		}
	}
	
	
	public static List<ShippingOption> getAllShippingOption() throws InterruptedException, ExecutionException {
		Firestore db = FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> future =
			    db.collection("shippingOption").get();
			// future.get() blocks on response
			List<QueryDocumentSnapshot> documents = future.get().getDocuments();
			List<ShippingOption> lists = new ArrayList<ShippingOption>();
			for (DocumentSnapshot document : documents) {
				ShippingOption s = document.toObject(ShippingOption.class);
				lists.add(s);
			  System.out.println(document.getId() + " => " + s);
			}		
			return lists;
	}
	
	
	public static List<ShippingOption> getShippingOptionByField(String id, String field) throws InterruptedException, ExecutionException {
		Firestore db = FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> future =
			    db.collection("shippingOption").whereEqualTo(field, id).get();
			// future.get() blocks on response
			List<QueryDocumentSnapshot> documents = future.get().getDocuments();
			List<ShippingOption> lists = new ArrayList<ShippingOption>();
			for (DocumentSnapshot document : documents) {
				ShippingOption s = document.toObject(ShippingOption.class);
				lists.add(s);
			  System.out.println(document.getId() + " => " + s);
			}		
			return lists;
	}

	public static String deleteShippingOption(String id) throws InterruptedException, ExecutionException {
		Firestore db = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> writeResult = db.collection("shippingOption").document(id).delete();
		return writeResult.get().getUpdateTime().toString();
	}
	
}