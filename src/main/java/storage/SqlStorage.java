package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import exception.StorageException;
import model.ContactType;
import model.Resume;
import sql.ConnectionFactory;
import sql.SqlHelper;

import java.sql.*;
import java.util.*;

/**
 * Created by sergo on 29.09.2017.
 */
public class SqlStorage implements Storage {
    public final SqlHelper sqlHelper;

    public SqlStorage(String dbUrl, String dbUsver, String dbPassword) {
        this.sqlHelper = new SqlHelper(() ->
                DriverManager.getConnection(dbUrl, dbUsver, dbPassword)
        );
    }

    @Override
    public void save(Resume r) {
        sqlHelper.transactionalExecute(conn -> {
            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO resume(uuid, full_name) VALUES (?, ?)")){
                ps.setString(1,r.getUuid());
                ps.setString(2,r.getFullName());
                ps.execute();
            }
            insertContact(conn,r);
            return null;
        });

    }

    @Override
    public void delete(String uuid) {
        sqlHelper.execute("DELETE FROM resume WHERE uuid=?", ps -> {
            ps.setString(1, uuid);
            if (ps.executeUpdate() == 0) {
                throw new NotExistStorageException(uuid);
            }

            return null;
        });
    }

    @Override
    public void update(Resume r) {
        sqlHelper.transactionalExecute(conn -> {
            try (PreparedStatement ps = conn.prepareStatement("UPDATE resume SET full_name = ? WHERE uuid = ?")){
                ps.setString(2,r.getUuid());
                ps.setString(1,r.getFullName());
              if (ps.executeUpdate() != 1){
                  throw new NotExistStorageException(r.getUuid());
              }
            }
            deleteContacts(conn,r);
            insertContact(conn,r);
            return null;
        });
    }

    @Override
    public Resume get(String uuid) {
        return sqlHelper.execute("SELECT * FROM resume r " +
                " LEFT JOIN contacts c " +
                "  ON r.uuid = c.resume_uuid " +
                "WHERE r.uuid =?", ps  ->{
            ps.setString(1, uuid);
            ResultSet rs = ps.executeQuery();
            if (! rs.next()){
                throw new NotExistStorageException(uuid);
            }
           Resume r = new Resume(uuid, rs.getString("full_name"));
            do {
                addContact(rs,r);
            }while (rs.next());

            return r;

        });
//        "    SELECT * FROM resume r " +
//                " LEFT JOIN contacts c " +
//                "        ON r.uuid = c.resume_uuid " +
//                "     WHERE r.uuid =? "
    }

    @Override
    public List<Resume> getAllSorted() {

        return sqlHelper.execute("SELECT * FROM resume r " +
                "LEFT JOIN contacts c ON r.uuid = c.resume_uuid " +
                "ORDER BY full_name, uuid", ps ->{
             ResultSet rs = ps.executeQuery();
            Map<String, Resume> map = new LinkedHashMap<>();
            while (rs.next()){
                String uuid = rs.getString("uuid");
                Resume resume = map.get(uuid);
                if(resume == null){
                    resume = new Resume(uuid,rs.getString("full_name"));
                    map.put(uuid,resume);
                }
                addContact(rs,resume);

            }
            return  new ArrayList<>(map.values());
        });
    }

    @Override
    public int size() {
        return sqlHelper.execute("SELECT COUNT(*) FROM resume", ps -> {
            ResultSet rs = ps.executeQuery();
            return rs.next() ? rs.getInt(1) : 0;
        });
    }

    @Override
    public void clear() {
        sqlHelper.execute("DELETE FROM resume");
    }

    private void insertContact(Connection con, Resume r) throws SQLException{
        try (PreparedStatement ps = con.prepareStatement("INSERT INTO contacts (resume_uuid,type,value) VALUES (?,?,?)")){
            for (Map.Entry<ContactType, String> e: r.getContacts().entrySet()) {
                ps.setString(1,r.getUuid());
                ps.setString(2,e.getKey().name());
                ps.setString(3,e.getValue());
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    private void deleteContacts(Connection connection, Resume resume) {
        sqlHelper.execute("DELETE FROM contacts WHERE resume_uuid = ? ", ps -> {
            ps.setString(1, resume.getUuid());
            ps.execute();
            return null;
        });
    }

    private void addContact(ResultSet rs, Resume r) throws SQLException {
        String value = rs.getString("value");
        if (value != null) {
            r.addContact(ContactType.valueOf(rs.getString("type")), value);
        }
    }
}
