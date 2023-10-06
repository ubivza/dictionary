package ru.aleksandr.repositories;

import ru.aleksandr.models.SpanishRuDictionaryWord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SpanishRuRepositoryImpl implements SpanishRuRepository{
    private final Properties prop;
    private final String FILE_NAME = "src/dictionary2.properties";
    private InputStream in;

    public SpanishRuRepositoryImpl() {
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
        List<String> words = new ArrayList<>();
        PrintWriter ps = new PrintWriter(System.out);
        prop.list(ps);
        ps.flush();
        return null;
    }

    public String getByKey(String s) {
        return prop.getProperty(s, "Key not found, try again");
    }

    public void save(String s) {
        String[] valueToSave = s.trim().split(" - ", 2);
        SpanishRuDictionaryWord word = new SpanishRuDictionaryWord();
        word.setSpanishWord(valueToSave[0]);
        word.setRuWord(valueToSave[1]);
        prop.setProperty(word.getSpanishWord(), word.getRuWord());
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
