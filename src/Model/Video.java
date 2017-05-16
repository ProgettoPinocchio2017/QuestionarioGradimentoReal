package Model;

import java.io.File;
import javafx.scene.media.Media;

/**
 * La classe video serve per istanziare un oggetto di tipo Video ed ha come
 * attributi il path,il nome,e un media ed i vari metodi set e get per gli
 * attributi.
 *
 * @author Manuel
 */
public class Video {

    private String path;
    private String name;
    private Media m;

    /**
     * Questo è il costruttore ,che accetta come parametri 2 Stringhe.
     *
     * @param path,il path è la prima parte del link del video.
     * @param name,il nome è il nome del video,da agigungere al path .
     * *@param m , è un ogetto m di tipo media.
     * @author Manuel.
     */
    public Video(String path, String name) {
        this.path = path;
        this.name = name;
        m = new Media(new File(path + name).toURI().toString());
    }

    /**
     * Il metodo getPath() permette di reperire il path,la prima parte del link
     * del video.
     *
     * @return path;
     * @author Manuel
     */
    public String getPath() {
        return path;
    }

    /**
     * Il metodo setPath() permette di settare il path,la prima parte del link
     * del video,accetta come parametro una stringa.
     *
     * @param path
     * @author Manuel
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Il metodo getName() permette di reperire il nome del video,da aggiungere
     * al path.
     *
     * @return name;
     * @author Manuel
     */
    public String getName() {
        return name;
    }

    /**
     * Il metodo setName() permette di settare il nome del video,accetta come
     * parametro una stringa.
     *
     * @param name
     * @author Manuel
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Il metodo getM() permette di reperire il media,restituisce un oggetto di
     * tipo media.
     *
     * @return m;
     * @author Manuel
     */
    public Media getM() {
        return m;
    }

    /**
     * Il metodo setM() permette di settare il media.
     * @param m
     * @author Manuel

     */
    public void setM(Media m) {
        this.m = m;
    }

}
