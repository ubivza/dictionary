package ru.aleksandr.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class EngRuDictWord {
    private String englishWord;
    private String ruWord;
    private static final String pattern = "[0-9]";

    public void setEnglishWord(String word) {
        if (word.length() != 5 && !word.matches(pattern)) {
            throw new IllegalArgumentException("Word must be 5 characters long and should contain only numbers");
        }
        this.englishWord = word;
    }
}
