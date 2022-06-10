package ru.netology.manager;

import ru.netology.domain.Film;

public class PosterManager {
    private Film[] films = new Film[0];
    private int filmsQuantity = 10;

    public PosterManager() {
    }

    public PosterManager(int filmQuantity) {
        this.filmsQuantity = filmQuantity;
    }

    public void addFilm(Film film) {
        int length = films.length + 1;
        Film[] tmp = new Film[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public Film[] findAll() {
        return films;
    }

    public Film[] findLast() {
        int resultLength;
        if (filmsQuantity > films.length) {
            resultLength = films.length;
        }
        else {
            resultLength = filmsQuantity;
        }
        Film[] result = new Film[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public Film[] removeById(int id) {
        int length = films.length - 1;
        Film[] tmp = new Film[length];
        int index = 0;
        for (Film film : films) {
            if (film.getId() != id) {
                tmp[index] = film;
                index++;
            }
        }
        films = tmp;
        return tmp;
    }

    public Film[] removeAll() {
        Film[] films = new Film[0];
        return films;
    }
}
