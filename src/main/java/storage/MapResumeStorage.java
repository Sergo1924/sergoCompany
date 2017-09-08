package storage;

import model.Resume;

import java.io.IOException;
import java.util.*;

/**
 * Created by sergo on 30.08.2017.
 */
public class MapResumeStorage extends AbstractStorage<Resume>{
    public MapResumeStorage() throws IOException, InterruptedException {
    }

    private Map<String, Resume> map = new TreeMap<>();

    @Override
    protected Resume getSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void doUpdate(Resume r, Resume resume) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected boolean isExist(Resume resume) {
        return resume != null;
    }

    @Override
    protected void doSave(Resume r, Resume resume) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Resume resume) {
        return (Resume) resume;
    }

    @Override
    protected void doDelete(Resume resume) {
        map.remove(((Resume) resume).getUuid());
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(map.values());
    }

//    @Override
//    public Resume[] getAll() {
//        return new Resume[0];
//    }

    @Override
    public int size() {
        return map.size();
    }
}
