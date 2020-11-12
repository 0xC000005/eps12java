/**
 * @author m04.zhang
 * @version 2020-11-12
 * @project Final 2020 in IntelliJ
 * @description
 */
public class LP {
    // instance variables - replace the example below with your own
    private String artist;
    private String title;
    private String genre;
    private Double value;

    public LP(String artist, String title, String genre, double value) {
        setArtist(artist);
        setTitle(title);
        setGenre(genre);
        setValue(value);
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
