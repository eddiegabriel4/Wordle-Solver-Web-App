package com.example.demo.Information;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class InformationController {

    @RequestMapping("/")
    public String start(Model model) {
        Information information = new Information(null,null, null);
        model.addAttribute(information);
        return "index";
    }

    @RequestMapping("/Error")
    public String start() {
        return "error";
    }

    @RequestMapping("/saveRandom")
    public String saveRandom(Information information, Model model) throws IOException {
        information.uppercase();
        /* information.filter()? */
        information.filter();
        model.addAttribute(information);
        Words words = new Words();
        words.load_words();
        words.count_getter();
        words.frequencies();

        List<String> orangeList = new ArrayList<String>(Arrays.asList(information.get_yellow().split("(?<=\\G..)")));
        List<Word> all_orange_words = words.get_words().stream().filter(w -> w.allOrangeinWord(orangeList) == true).collect(Collectors.toList());
        List<Word> all_orange_words2 = all_orange_words.stream().filter(w -> w.allOrangeinWord2(orangeList) == true).collect(Collectors.toList());
        if (information.get_green() == "") {
            List<String> greyList = new ArrayList<String>(Arrays.asList(information.get_gray().split("")));
            List<Word> FinalWords = all_orange_words2.stream().filter(w -> w.greyWordFilter(greyList) == true).collect(Collectors.toList());
            words.set_words(FinalWords);

        }
        else {
            List<String> greenList = new ArrayList<String>(Arrays.asList(information.get_green().split("(?<=\\G..)")));
            List<Word> greenWords = all_orange_words2.stream().filter(w -> w.allGreeninWord(greenList) == true).collect(Collectors.toList());
            List<String> greyList = new ArrayList<String>(Arrays.asList(information.get_gray().split("")));
            List<Word> FinalWords = greenWords.stream().filter(w -> w.greyWordFilter(greyList) == true).collect(Collectors.toList());
            words.set_words(FinalWords);
        }

        for (Word word : words.get_words()) {
            word.calculate_freq_value(words.one_counts, words.two_counts,
                    words.three_counts, words.four_counts, words.four_counts);
        }
        Collections.sort(words.get_words(), new Word.CustomComperator());
        model.addAttribute(words);
        return "words_final";
    }

}
