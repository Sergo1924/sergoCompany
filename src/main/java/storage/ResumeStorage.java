package storage;

import model.Resume;

import java.io.IOException;

/**
 * Created by sergo on 16.08.2017.
 */
public class ResumeStorage extends AbstractArrayStorage {
//    public ResumeStorage() throws IOException, InterruptedException {
//    }

    @Override
    protected void fillDeletedElement(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected void insertElement(Resume r, int index) {
        storage[size] = r;
    }

    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
