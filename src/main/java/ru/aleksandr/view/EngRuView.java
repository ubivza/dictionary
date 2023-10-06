package ru.aleksandr.view;

import ru.aleksandr.repositories.EngRuRepositoryImpl;

import java.util.Scanner;

public class EngRuView {
    private final EngRuRepositoryImpl engRuRepository = new EngRuRepositoryImpl();

    public void show() {
        engRuRepository.getAll();
    }

    public void showByWord(String word) {
        System.out.println(engRuRepository.getByKey(word) + "\n");
    }

    public void deleteByWord(String wordTodelete) {
        engRuRepository.deleteByKey(wordTodelete);
        System.out.println("Слово " + wordTodelete + " успешно удалено!" + "\n");
    }

    public void addWord(String wordToAdd) {
        engRuRepository.save(wordToAdd);
        System.out.println("Слово " + wordToAdd + " успешно добавлено!" + "\n");
    }
}
