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
public class ShippingOrderService {
	
	public static String createShippingOrder(OrderModel message) throws InterruptedException, ExecutionException {
        List<ShippingOrderModel> lists = message.toShippingOrder();
		Firestore db = FirestoreClient.getFirestore();
		for(ShippingOrderModel s:lists) {
			ApiFuture<DocumentReference> addedDocRef = db.collection("shippingOrder").add(s);
	        s.setId(addedDocRef.get().getId());
	        saveShippingOrder(s);
		}
		return "OK";
        
    }

	public static String saveShippingOrder(ShippingOrderModel message) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> future = db.collection("shippingOrder").document(message.getId()).set(message);
        return future.get().getUpdateTime().toString();
    }
	
	public static ShippingOrderModel getShippingOrder(String id) throws InterruptedException, ExecutionException {
		Firestore db = FirestoreClient.getFirestore();
		DocumentReference docRef = db.collection("shippingOrder").document(id);
		// asynchronously retrieve the document
		ApiFuture<DocumentSnapshot> future = docRef.get();
		// block on response
		DocumentSnapshot document = future.get();
		ShippingOrderModel s = null;
		if (document.exists()) {
		  // convert document to POJO
		  s = document.toObject(ShippingOrderModel.class);
		  System.out.println(s);
		  return s;
		} else {
		  System.out.println("No such document!");
		  return null;
		}
	}
	
	
	public static List<ShippingOrderModel> getAllShippingOrder() throws InterruptedException, ExecutionException {
		Firestore db = FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> future =
			    db.collection("shippingOrder").get();
			// future.get() blocks on response
			List<QueryDocumentSnapshot> documents = future.get().getDocuments();
			List<ShippingOrderModel> lists = new ArrayList<ShippingOrderModel>();
			for (DocumentSnapshot document : documents) {
				ShippingOrderModel s = document.toObject(ShippingOrderModel.class);
				lists.add(s);
			  System.out.println(document.getId() + " => " + s);
			}		
			return lists;
	}
	
	public static List<ShippingOrderModel> getShippingOrderByField(String id, String field) throws InterruptedException, ExecutionException {
		Firestore db = FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> future =
			    db.collection("shippingOrder").whereEqualTo(field, id).get();
			// future.get() blocks on response
			List<QueryDocumentSnapshot> documents = future.get().getDocuments();
			List<ShippingOrderModel> lists = new ArrayList<ShippingOrderModel>();
			for (DocumentSnapshot document : documents) {
				ShippingOrderModel s = document.toObject(ShippingOrderModel.class);
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