package com.example.mst1.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "collection_1")
public class RandomObject {

    @Id
    private ObjectId id;
    private int entryNo;
    private int collectionNo;
    private String entry;

//    public RandomObject() {
//        super();
//    }
//
//    public RandomObject(int entryNo, int collectionNo, String entry) {
//        super();
//        this.entryNo = entryNo;
//        this.collectionNo = collectionNo;
//        this.entry = entry;
//    }
//
//    public int getEntryNo() {
//        return entryNo;
//    }
//
//    public void setEntryNo(int entryNo) {
//        this.entryNo = entryNo;
//    }
//
//    public int getCollectionNo() {
//        return collectionNo;
//    }
//
//    public void setCollectionNo(int collectionNo) {
//        this.collectionNo = collectionNo;
//    }
//
//    public String getEntry() {
//        return entry;
//    }
//
//    public void setEntry(String entry) {
//        this.entry = entry;
//    }
}
