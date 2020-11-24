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
public class ShippingOptionService {
	
	public static String createShippingOption(ShippingOptionModel message) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<DocumentReference> addedDocRef = db.collection("shippingOption").add(message);
        message.setId(addedDocRef.get().getId());
        return saveShippingOption(message);
    }

	public static String saveShippingOption(ShippingOptionModel message) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> future = db.collection("shippingOption").document(message.getId()).set(message);
        return future.get().getUpdateTime().toString();
    }
	
	public static ShippingOptionModel getShippingOption(String id) throws InterruptedException, ExecutionException {
		Firestore db = FirestoreClient.getFirestore();
		DocumentReference docRef = db.collection("shippingOption").document(id);
		// asynchronously retrieve the document
		ApiFuture<DocumentSnapshot> future = docRef.get();
		// block on response
		DocumentSnapshot document = future.get();
		ShippingOptionModel s = null;
		if (document.exists()) {
		  // convert document to POJO
		  s = document.toObject(ShippingOptionModel.class);
		  System.out.println(s);
		  return s;
		} else {
		  System.out.println("No such document!");
		  return null;
		}
	}
	
	
	public static List<ShippingOptionModel> getAllShippingOption() throws InterruptedException, ExecutionException {
		Firestore db = FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> future =
			    db.collection("shippingOption").get();
			// future.get() blocks on response
			List<QueryDocumentSnapshot> documents = future.get().getDocuments();
			List<ShippingOptionModel> lists = new ArrayList<ShippingOptionModel>();
			for (DocumentSnapshot document : documents) {
				ShippingOptionModel s = document.toObject(ShippingOptionModel.class);
				lists.add(s);
			  System.out.println(document.getId() + " => " + s);
			}		
			return lists;
	}
	
	
	public static List<ShippingOptionModel> getShippingOptionByField(String id, String field) throws InterruptedException, ExecutionException {
		Firestore db = FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> future =
			    db.collection("shippingOption").whereEqualTo(field, id).get();
			// future.get() blocks on response
			List<QueryDocumentSnapshot> documents = future.get().getDocuments();
			List<ShippingOptionModel> lists = new ArrayList<ShippingOptionModel>();
			for (DocumentSnapshot document : documents) {
				ShippingOptionModel s = document.toObject(ShippingOptionModel.class);
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