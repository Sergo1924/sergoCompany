package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Created by sergo on 16.08.2017.
 */
public class SortedResumeStorage implements  Storage {
    public static final int MAX_LENTH = 10000;
    private Resume[] storage = new Resume[MAX_LENTH];
    private int size = 0;


    @Override
    public void save(Resume r) {
        if (size == MAX_LENTH) {
            System.out.println("Storage overflow!");
            return;
        }
        //intelij idea advice set final
        final int index = getIndex(r.getUuid());
        if (index < 0) {
            //http://codereview.stackexchange.com/questions/36221/binary-search-for-inserting-in-array#answer-36239
            int insertIdx = -index - 1;
            System.arraycopy(storage, insertIdx, storage, insertIdx + 1, size - insertIdx);
            storage[insertIdx] = r;
            size++;
            return;
        }
        System.out.println("Sorry! but resume whith uuid " + r.getUuid() + " already exist!");
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            int numMoved = size - index - 1;
            if (numMoved > 0) {
                System.arraycopy(storage, index + 1, storage, index, numMoved);
            }
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
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

}
