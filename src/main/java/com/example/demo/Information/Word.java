package com.example.demo.Information;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


public class Word {

    String word;
    public Double freq_value;

    public Word(String word) {

        this.word = word;
        this.freq_value = 0.0;
    }

    public String get_word() {
        return  this.word;
    }

    public void calculate_freq_value(HashMap<String, Double> one_counts,
                                     HashMap<String, Double> two_counts,
                                     HashMap<String, Double> three_counts,
                                     HashMap<String, Double> four_counts,
                                     HashMap<String, Double> five_counts
                                     ) throws FileNotFoundException {
        Double counter = 0.0;
        counter += one_counts.get(Character.toString(this.get_word().charAt(0)));
        counter += two_counts.get(Character.toString(this.get_word().charAt(1)));
        counter += three_counts.get(Character.toString(this.get_word().charAt(2)));
        counter += four_counts.get(Character.toString(this.get_word().charAt(3)));
        counter += five_counts.get(Character.toString(this.get_word().charAt(4)));
        this.freq_value = counter;

        }

    public static class CustomComperator implements Comparator<Word> {
        @Override
        public int compare(Word w1, Word w2) {
            return w2.freq_value.compareTo(w1.freq_value);

        }

    }



    public boolean allOrangeinWord(List<String> orangeLetters) {

        List<Integer> list = new ArrayList<>();
        for (String letter : orangeLetters) {
            if (word.contains(Character.toString(letter.charAt(0)))){
                list.add(1);
            }
            else {
                list.add(0);
            }
        }
        if (list.contains(0)) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean allOrangeinWord2(List<String> orangeLetters) {
        List<Integer> list4 = new ArrayList<>();
        for (String doub : orangeLetters) {
            if (word.charAt(Integer.parseInt(Character.toString(doub.charAt(1))) - 1) == doub.charAt(0)) {
                list4.add(1);
            } else {
                list4.add(0);
            }
        }
        if (list4.contains(1)) {
            return false;
        }
        else {
            return true;
        }

    }




    public boolean allGreeninWord(List<String> greenLetters) {
        List<Integer> list2 = new ArrayList<>();
        if (String.join("", greenLetters) == "NONE") {
            return true;
        }
        for (String doub : greenLetters) {
            if (word.charAt(Integer.parseInt(Character.toString(doub.charAt(1))) - 1) == doub.charAt(0)) {
                list2.add(1);
            } else {
                list2.add(0);
            }
        }
        if (list2.contains(0)) {
            return false;
        }
        else{
            return true;
        }

    }

    public boolean greyWordFilter(List<String> greyLetters) {
        List<Integer> list3 = new ArrayList<>();
        for (String letter : greyLetters) {
            if (word.contains(letter)){
                list3.add(1);
            }
            else {
                list3.add(0);
            }
        }
        if (list3.contains(1)) {
            return false;
        }
        else {
            return true;
        }

    }


    @Override
    public String toString(){

        return this.get_word();
    }
}

