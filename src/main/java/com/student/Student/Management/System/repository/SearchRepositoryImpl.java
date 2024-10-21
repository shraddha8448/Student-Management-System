package com.student.Student.Management.System.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.student.Student.Management.System.modal.Student;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository{

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Student> findByText(String text) {

        final List<Student> studentList = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("studentDB");
        MongoCollection<Document> collection = database.getCollection("StudentInfo");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("index", "default")
                                .append("text",
                                        new Document("query", text)
                                                .append("path", Arrays.asList("courses"))))));

        result.forEach(doc -> studentList.add(converter.read(Student.class,doc)));

        return studentList;
    }
}
