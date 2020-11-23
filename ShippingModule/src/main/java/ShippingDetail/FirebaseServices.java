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
public class FirebaseServices {
	
	public static String createShippingOrder(Order message) throws InterruptedException, ExecutionException {
        List<ShippingOrder> lists = message.toShippingOrder();
		Firestore db = FirestoreClient.getFirestore();
		for(ShippingOrder s:lists) {
			ApiFuture<DocumentReference> addedDocRef = db.collection("shippingOrder").add(s);
	        s.setId(addedDocRef.get().getId());
	        saveShippingOrder(s);
		}
		return "OK";
        
    }

	public static String saveShippingOrder(ShippingOrder message) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> future = db.collection("shippingOrder").document(message.getId()).set(message);
        return future.get().getUpdateTime().toString();
    }
	
	public static ShippingOrder getShippingOrder(String id) throws InterruptedException, ExecutionException {
		Firestore db = FirestoreClient.getFirestore();
		DocumentReference docRef = db.collection("shippingOrder").document(id);
		// asynchronously retrieve the document
		ApiFuture<DocumentSnapshot> future = docRef.get();
		// block on response
		DocumentSnapshot document = future.get();
		ShippingOrder s = null;
		if (document.exists()) {
		  // convert document to POJO
		  s = document.toObject(ShippingOrder.class);
		  System.out.println(s);
		  return s;
		} else {
		  System.out.println("No such document!");
		  return null;
		}
	}
	
	
	public static List<ShippingOrder> getAllShippingOrder() throws InterruptedException, ExecutionException {
		Firestore db = FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> future =
			    db.collection("shippingOrder").get();
			// future.get() blocks on response
			List<QueryDocumentSnapshot> documents = future.get().getDocuments();
			List<ShippingOrder> lists = new ArrayList<ShippingOrder>();
			for (DocumentSnapshot document : documents) {
				ShippingOrder s = document.toObject(ShippingOrder.class);
				lists.add(s);
			  System.out.println(document.getId() + " => " + s);
			}		
			return lists;
	}
	
	public static List<ShippingOrder> getShippingOrderByField(String id, String field) throws InterruptedException, ExecutionException {
		Firestore db = FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> future =
			    db.collection("shippingOrder").whereEqualTo(field, id).get();
			// future.get() blocks on response
			List<QueryDocumentSnapshot> documents = future.get().getDocuments();
			List<ShippingOrder> lists = new ArrayList<ShippingOrder>();
			for (DocumentSnapshot document : documents) {
				ShippingOrder s = document.toObject(ShippingOrder.class);
				lists.add(s);
			  System.out.println(document.getId() + " => " + s);
			}		
			return lists;
	}

	public static String deleteShippingOrder(String id) throws InterruptedException, ExecutionException {
		Firestore db = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> writeResult = db.collection("shippingOrder").document(id).delete();
		return writeResult.get().getUpdateTime().toString();
	}
}