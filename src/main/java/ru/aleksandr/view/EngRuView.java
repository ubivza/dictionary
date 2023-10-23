package ru.aleksandr.view;

import ru.aleksandr.repositories.EngRuRepositoryImpl;

import java.util.Map;


public class EngRuView {
    private final EngRuRepositoryImpl engRuRepository = new EngRuRepositoryImpl();

    public void show() {
        for (Map.Entry<String, String> map : engRuRepository.getAll().entrySet()) {
            System.out.println(map.getKey() + " - " + map.getValue());
        }
        System.out.println();
    }

    public void showByWord(String word) {
        System.out.println(word + " - " + engRuRepository.getByKey(word) + "\n");
    }

    public void deleteByWord(String wordTodelete) {
        if (engRuRepository.deleteByKey(wordTodelete)) {
            System.out.println("Слово " + wordTodelete + " успешно удалено!" + "\n");
        } else {
            System.out.println("Слово " + wordTodelete + " не было удалено" + "\n");
        }
    }

    public void addWord(String wordToAdd) {
        if (engRuRepository.save(wordToAdd)) {
            System.out.println("Слово " + wordToAdd + " успешно добавлено!" + "\n");
        } else {
            System.out.println("Слово " + wordToAdd + " не было добавлено!" + "\n");
        }
    }

    public void updateWord(String wordToUpdate) {
        if (engRuRepository.update(wordToUpdate)) {
            System.out.println("Слово " + wordToUpdate + " успешно обновлено!" + "\n");
        } else {
            System.out.println("Слово " + wordToUpdate + " не было обновлено!" + "\n");
        }
    }

    public void exitService() {
        engRuRepository.saveCacheToMemory();
    }
}
