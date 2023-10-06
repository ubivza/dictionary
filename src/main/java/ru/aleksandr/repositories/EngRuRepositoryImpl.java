package ru.aleksandr.repositories;

import ru.aleksandr.models.EngRuDictWord;

import java.io.*;
import java.util.*;

public class EngRuRepositoryImpl implements EngRuRepository {
    private final Properties prop;
    private final String FILE_NAME = "src/dictionary1.properties";
    private InputStream in;

    public EngRuRepositoryImpl() {
        this.prop = new Properties();
        try {
            in = new FileInputStream(FILE_NAME);
            prop.load(in);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No such properties file");
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong");
        }
    }


    public List<String> getAll() {
        //переписать, не работает
        List<String> words = new ArrayList<>();
        while (prop.propertyNames().hasMoreElements()) {
            String key = (String) prop.propertyNames().nextElement();
            words.add(key + " - " + prop.getProperty(key));
        }
        return words;
    }

    public String getByKey(String s) {
        return prop.getProperty(s, "Key not found, try again");
    }

    public void save(String s) {
        String[] valueToSave = s.trim().split(" - ", 2);
        EngRuDictWord word = new EngRuDictWord();
        word.setEnglishWord(valueToSave[0]);
        word.setRuWord(valueToSave[1]);
        prop.setProperty(word.getEnglishWord(), word.getRuWord());
        try {
            prop.store(new FileOutputStream(FILE_NAME), null);
        } catch (IOException e) {
            throw new RuntimeException("No such properties file found to save");
        }
    }

    public void update(String s) {
        //сделаю позже
    }

    public void deleteByKey(String s) {
        prop.remove(s);
        try {
            prop.store(new FileOutputStream(FILE_NAME), null);
        } catch (IOException e) {
            throw new RuntimeException("No such properties file found to delete");
        }
    }
}
