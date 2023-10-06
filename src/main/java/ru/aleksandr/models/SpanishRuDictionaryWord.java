package ru.aleksandr.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SpanishRuDictionaryWord {
    private String spanishWord;
    private String ruWord;
    private static final String pattern = "[A-Z, a-z]";

    public void setSpanishWord(String spanishWord) throws IllegalArgumentException {
        if (spanishWord.length() != 4 && !spanishWord.matches(pattern)) {
            throw new IllegalArgumentException("Word must be 4 characters long and should contain only latin letters");
        }
        this.spanishWord = spanishWord;
    }
}
