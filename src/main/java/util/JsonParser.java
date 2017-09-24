package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Section;

import java.io.Reader;
import java.io.Writer;

/**
 * Created by sergo on 19.09.2017.
 */
public class JsonParser {
    private static Gson GSON = new GsonBuilder().registerTypeAdapter(Section.class,new JsonSectionAdater()).create();

    public static <T> T read(Reader reader, Class<T>clazz){
        return GSON.fromJson(reader, clazz);
    }
    public static <T> void write(T object, Writer writer){
        GSON.toJson(object, writer);
    }
}
