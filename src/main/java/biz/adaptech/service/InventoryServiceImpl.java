package biz.adaptech.service;

import biz.adaptech.model.InventoryItem;
import biz.adaptech.utils.DatabaseConstants;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class InventoryServiceImpl implements InventoryService {

    private final Firestore firestore;

    @Autowired
    public InventoryServiceImpl(Firestore firestore) {
        this.firestore = firestore;
    }

    @Override
    public List<InventoryItem> getItemsByBrand(String brandName) {

        List<InventoryItem> inventoryItems = new ArrayList<>();

        CollectionReference reference = this.firestore.collection(DatabaseConstants.COLLECTION_FOOTWEAR)
                .document(DatabaseConstants.DOCUMENT_BRANDS)
                .collection(brandName);
        ApiFuture<QuerySnapshot> future = reference.get();
        try {
            inventoryItems = future.get().toObjects(InventoryItem.class);
        } catch (ExecutionException | InterruptedException exception) {

        }
        return inventoryItems;
    }

    @Override
    public List<InventoryItem> getAllItems() {


        List<InventoryItem> inventoryItems = new ArrayList<>();

        Iterable<CollectionReference> collectionReferences = this.firestore.collection(DatabaseConstants.COLLECTION_FOOTWEAR)
                .document(DatabaseConstants.DOCUMENT_BRANDS).listCollections();

        for (CollectionReference collectionReference : collectionReferences) {
            ApiFuture<QuerySnapshot> future = collectionReference.get();
            try {
                List<QueryDocumentSnapshot> documents = future.get().getDocuments();
                List<InventoryItem> tempList = documents.stream()
                        .map((document) -> document.toObject(InventoryItem.class))
                        .collect(Collectors.toList());
                inventoryItems.addAll(tempList);


            } catch (InterruptedException | ExecutionException exception) {

            }
        }
        return inventoryItems;
    }
}
