package ru.aleksandr.view;

import ru.aleksandr.repositories.EngRuRepositoryImpl;

import java.util.Scanner;

public class EngRuView {
    private final EngRuRepositoryImpl engRuRepository = new EngRuRepositoryImpl();

    public void show() {
        for (String s : engRuRepository.getAll()) {
            System.out.println(s);
        }
    }

    public void showByWord(String word) {
        System.out.println(engRuRepository.getByKey(word));
    }

    public void deleteByWord(String wordTodelete) {
        engRuRepository.deleteByKey(wordTodelete);
        System.out.println("Слово " + wordTodelete + " успешно удалено!");
    }

    public void addWord(String wordToAdd) {
        engRuRepository.save(wordToAdd);
        System.out.println("Слово " + wordToAdd + " успешно добавлено!");
    }
}
