package ru.aleksandr.services;

import lombok.RequiredArgsConstructor;
import ru.aleksandr.repositories.EngRuRepositoryImpl;

@RequiredArgsConstructor
public class EngRuService {
    private final EngRuRepositoryImpl engRuRepository;

}
