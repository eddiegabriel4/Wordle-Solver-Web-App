package com.example.demo.Information;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import java.io.*;
import java.util.*;

public class Words {

    List<Word> words;
    public HashMap<String, Double> one_counts = new HashMap<>();
    public HashMap<String, Double> two_counts = new HashMap<>();
    public HashMap<String, Double> three_counts = new HashMap<>();
    public HashMap<String, Double> four_counts = new HashMap<>();
    public HashMap<String, Double> five_counts = new HashMap<>();

    public Words(){

        this.words = null;
        this.one_counts = one_counts;
        this.two_counts = two_counts;
        this.three_counts = three_counts;
        this.four_counts = four_counts;
        this.five_counts = five_counts;
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


    public void count_getter() {
        for (Word word: words) {
            for (int i = 0; i < word.get_word().length(); i++) {
                if (i == 0) {
                    if (one_counts.containsKey(Character.toString(word.get_word().charAt(i)))) {
                        one_counts.put(Character.toString(word.get_word().charAt(i)), one_counts.get(Character.toString(word.get_word().charAt(i))) + 1);
                    } else {
                        one_counts.put(Character.toString(word.get_word().charAt(i)), 1.0);
                    }
                }
                if (i == 1) {
                    if (two_counts.containsKey(Character.toString(word.get_word().charAt(i)))) {
                        two_counts.put(Character.toString(word.get_word().charAt(i)), two_counts.get(Character.toString(word.get_word().charAt(i))) + 1);
                    } else {
                        two_counts.put(Character.toString(word.get_word().charAt(i)), 1.0);
                    }
                }
                if (i == 2) {
                    if (three_counts.containsKey(Character.toString(word.get_word().charAt(i)))) {
                        three_counts.put(Character.toString(word.get_word().charAt(i)), three_counts.get(Character.toString(word.get_word().charAt(i))) + 1);
                    } else {
                        three_counts.put(Character.toString(word.get_word().charAt(i)), 1.0);
                    }
                }
                if (i == 3) {
                    if (four_counts.containsKey(Character.toString(word.get_word().charAt(i)))) {
                        four_counts.put(Character.toString(word.get_word().charAt(i)), four_counts.get(Character.toString(word.get_word().charAt(i))) + 1);
                    } else {
                        four_counts.put(Character.toString(word.get_word().charAt(i)), 1.0);
                    }
                }
                if (i == 4) {
                    if (five_counts.containsKey(Character.toString(word.get_word().charAt(i)))) {
                        five_counts.put(Character.toString(word.get_word().charAt(i)), five_counts.get(Character.toString(word.get_word().charAt(i))) + 1);
                    } else {
                        five_counts.put(Character.toString(word.get_word().charAt(i)), 1.0);
                    }
                }

            }
        }
    }

    public void frequencies() {
        for (String key : one_counts.keySet()){
            Double number = one_counts.get(key)/(2315.0) * 100.0;
            one_counts.put(key, number);
        }
        this.one_counts = one_counts;
        for (String key : two_counts.keySet()){
            Double number = two_counts.get(key)/(2315.0) * 100.0;
            two_counts.put(key, number);
        }
        this.two_counts = two_counts;
        for (String key : three_counts.keySet()){
            Double number = three_counts.get(key)/(2315.0) * 100.0;
            three_counts.put(key, number);
        }
        this.three_counts = three_counts;
        for (String key : four_counts.keySet()){
            Double number = four_counts.get(key)/(2315.0) * 100.0;
            four_counts.put(key, number);
        }
        this.four_counts = four_counts;
        for (String key : five_counts.keySet()){
            Double number = five_counts.get(key)/(2315.0) * 100.0;
            five_counts.put(key, number);
        }
        this.five_counts = five_counts;
    }



    public List<Word> get_words(){
        return this.words;
    }


    public void set_words(List<Word> words) {
        this.words = words;
    }





}
