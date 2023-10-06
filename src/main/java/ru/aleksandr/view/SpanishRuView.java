package ru.aleksandr.view;

import lombok.RequiredArgsConstructor;
import ru.aleksandr.repositories.SpanishRuRepositoryImpl;

@RequiredArgsConstructor
public class SpanishRuView {
    private final SpanishRuRepositoryImpl spanishRuRepository = new SpanishRuRepositoryImpl();

    public void show() {
        spanishRuRepository.getAll();
    }

    public void showByWord(String word) {
        System.out.println(spanishRuRepository.getByKey(word) + "\n");
    }

    public void deleteByWord(String wordTodelete) {
        spanishRuRepository.deleteByKey(wordTodelete);
        System.out.println("Слово " + wordTodelete + " успешно удалено!" + "\n");
    }

    public void addWord(String wordToAdd) {
        spanishRuRepository.save(wordToAdd);
        System.out.println("Слово " + wordToAdd + " успешно добавлено!" + "\n");
    }
}
