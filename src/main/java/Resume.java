/**
 * Created by sergo on 16.08.2017.
 */
public class Resume {

    //unique identifier
    private String uuid;
    //see you later!
    //private String fullName;

    public Resume(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return uuid;
    }
}
