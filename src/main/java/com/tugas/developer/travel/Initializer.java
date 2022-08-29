package com.tugas.developer.travel;

import com.tugas.developer.travel.model.Event;
import com.tugas.developer.travel.model.Group;
import com.tugas.developer.travel.model.GroupRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

@Component
class Initializer implements CommandLineRunner {

    private final GroupRepository repository;

    public Initializer(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Arnes Travel", "Lorem Travel", "Ipsum Travel",
                "Cipaganti").forEach(name ->
                repository.save(new Group(name))
        );

        Group djug = repository.findByName("Arnes Travel");
        Event e = Event.builder().title("Testiing")
                .description("Testing")
                .build();
        djug.setEvents(Collections.singleton(e));
        repository.save(djug);

        repository.findAll().forEach(System.out::println);
    }
}
