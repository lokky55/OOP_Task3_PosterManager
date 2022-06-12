package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.PosterManager;

public class PosterManagerTest {

    private PosterManager manager = new PosterManager();
    private Film first = new Film(1, "Bloodshot", "action",2020);
    private Film second = new Film(2, "Onward", "cartoon", 2020);
    private Film third = new Film(3, "Hotel Belgrad", "comedy", 2020);
    private Film fourth = new Film(4, "The Gentlemen", "criminal", 2019);
    private Film fifth = new Film(5, "The Invisible Man", "thriller", 2020);
    private Film sixth = new Film(6, "Gladiator", "adventures", 2000);

    @BeforeEach
    public void setUp() {
        manager.addFilm(first);
        manager.addFilm(second);

    }
    @Test
    public void shouldAddFilm() {
        manager.addFilm(third);
        Film[] actual = manager.findAll();
        Film[] expected = {first, second, third};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastFilm() {
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        Film[] actual = manager.findLast();
        Film[] expected = {sixth, fifth, fourth, third, second, first};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowFiveLastFilms() {
        PosterManager manager = new PosterManager(5);
        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        Film[] actual = manager.findLast();
        Film[] expected = {sixth, fifth, fourth, third, second};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowOnlyOne() {
        PosterManager manager = new PosterManager(1);
        manager.addFilm(first);
        manager.addFilm(second);
        Film[] actual = manager.findLast();
        Film[] expected = {second};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveFilm() {
        Film[] actual = manager.removeById(1);
        Film[] expected ={second};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        Film[] actual = manager.removeAll();
        Film[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
}
