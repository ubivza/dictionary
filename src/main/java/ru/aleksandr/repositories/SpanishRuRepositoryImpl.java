package ru.aleksandr.repositories;

import ru.aleksandr.models.SpanishRuDictionaryWord;

import java.io.*;
import java.util.*;

public class SpanishRuRepositoryImpl implements SpanishRuRepository, Cacheable {
    private final Properties properties;
    private final String FILE_NAME = "src/main/resources/dictionary2.properties";
    private Map<String, String> cacheMap = new HashMap<>();


    public SpanishRuRepositoryImpl() {
        this.properties = new Properties();
        try(InputStream in = new FileInputStream(FILE_NAME)) {
            properties.load(in);

            cacheMap.putAll((Map) properties);

            properties.clear();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No such properties file");
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong");
        }
    }


    public Map<String, String> getAll() {
        return cacheMap;
    }

    public String getByKey(String s) {
        if (!cacheMap.containsKey(s))
            return "Key not found, try again";
        return cacheMap.get(s);
    }

    public boolean save(String s) {
        String[] valueToSave = s.trim().split(" - ", 2);
        SpanishRuDictionaryWord word = new SpanishRuDictionaryWord();
        word.setSpanishWord(valueToSave[0]);
        word.setRuWord(valueToSave[1]);

        cacheMap.put(word.getSpanishWord(), word.getRuWord());
        return true;
    }

    public boolean update(String s) {
        String[] valueToUpdate = s.trim().split(" - ", 2);

        if (cacheMap.containsKey(valueToUpdate[0])) {
            cacheMap.put(valueToUpdate[0], valueToUpdate[1]);
            return true;
        }
        return false;
    }

    public boolean deleteByKey(String s) {
        if (cacheMap.containsKey(s)) {
            cacheMap.remove(s);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void saveCacheToMemory() {
        try(OutputStream out = new FileOutputStream(FILE_NAME)) {
            properties.putAll(cacheMap);
            properties.store(out, null);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No such properties file while saving");
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong while saving properties file");
        }
    }
}
