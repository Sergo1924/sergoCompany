package storage;

import model.Resume;

/**
 * Created by sergo on 16.08.2017.
 */
public class ResumeStorage implements Storage {
    public static final int MAX_LENTH = 10000;
    private Resume[] storage = new Resume[MAX_LENTH];
    private int size = 0;


    @Override
    public void save(Resume r) {
        if (size == MAX_LENTH) {
            System.out.println("storage.Storage overflow!");
            return;
        }
        if (getIndex(r.getUuid()) < 0) {
            storage[size] = r;
            size++;
            return;
        }
        System.out.println("Sorry! but resume whith uuid " + r.getUuid() + " already exist!");
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) { // extract  to variable
            //storage[index] = null;
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            return;
        }
        System.out.println("Sorry! but resume whith uuid " + uuid + " is absent!");
    }

    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            storage[index] = r;
            return;
        }
        System.out.println("Sorry! but resume whith uuid " + r.getUuid() + " is absent!");
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        }
        System.out.println("Sorry! but resume whith uuid " + uuid + " is absent!");
        return null;
    }

    @Override
    public Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        for (int i = 0; i < size; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;

    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
