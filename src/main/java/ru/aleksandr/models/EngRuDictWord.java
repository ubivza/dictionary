package ru.aleksandr.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class EngRuDictWord implements Serializable {
    private String englishWord;
    private String ruWord;
}
