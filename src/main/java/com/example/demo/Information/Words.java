package com.example.demo.Information;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Words {

    List<Word> words;

    public Words(){

        this.words = null;
    }

    public void load_words() throws IOException {
        String key_name = "words.txt";
        String bucket_name = "all-words";

        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
        S3Object object = s3.getObject(new GetObjectRequest(bucket_name, key_name));
        InputStream objectData = object.getObjectContent();
        List<Word> WORDS = new ArrayList<>();
        Scanner scan = new Scanner(new InputStreamReader(object.getObjectContent()));
        while (scan.hasNextLine()) {
            Word word = new Word(scan.nextLine().toUpperCase(Locale.ROOT));
            WORDS.add(word);
        }
        objectData.close();
        scan.close();
        this.set_words(WORDS);
    }



    public List<Word> get_words(){
        return this.words;
    }


    public void set_words(List<Word> words) {
        this.words = words;
    }





}
