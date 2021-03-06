/**
 * Created by pumba30 on 15.01.2015.
 */
public class Song implements Comparable<Song> {
    String title;
    String artist;
    String rating;
    String bpm;

    public Song(String title, String artist, String rating, String bpm) {
        this.title = title;
        this.artist = artist;
        this.rating = rating;
        this.bpm = bpm;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getRating() {
        return rating;
    }

    public String getBpm() {
        return bpm;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public int compareTo(Song song) {
        return title.compareTo(song.getTitle());
    }

    //переопределив методы equals() и hashCode() уберем дубликаты объектов Song
    //из множества HashSet

    //переопределим метол equals()
    @Override
    public  boolean equals(Object Song){
        Song aSong = (Song) Song;
        return  getTitle().equals(aSong.getTitle());
    }

    //переопределим метод hashCode
    public int hashCode(){
        return title.hashCode();
    }


}
