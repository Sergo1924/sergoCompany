package storage;

import model.Resume;

import java.util.List;

/**
 * Created by sergo on 16.08.2017.
 */
public interface Storage {
    void save(Resume r);
    void delete(String uuid);
    void update(Resume r);
    Resume get(String uuid);
    List<Resume> getAllSorted();
    int size();
    void clear();
}
