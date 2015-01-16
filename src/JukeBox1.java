import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by pumba30 on 15.01.2015.
 */
public class JukeBox1 {
    //в списке храним названия песен
    List<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {
        new JukeBox1().go();

    }

    //метод, который загружает файлы и выводид содержимое songList
    public void go() {
        getSongs();
        System.out.println(songList);

        //Отсортируем
        Collections.sort(songList);
        System.out.println(songList);

        ArtistCompare artistCompare = new ArtistCompare();
        Collections.sort(songList, artistCompare);
        System.out.println(songList);

        HashSet<Song> songHashSet = new HashSet<Song>();
        //добавим весь список множество songHashSet
        songHashSet.addAll(songList);
        System.out.println(songHashSet);

    }

    //считываем файла
    void getSongs() {
        try {
            File file = new File("C:\\Users\\pumba30\\IdeaProjects\\JukeBox1\\src\\SongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //разбиваем строку на  лексемы с помощью метода split() по "/"
    //и добавляем объект в songList
    void addSong(String lineToParce) {
        String[] tokens = lineToParce.split("/");
        //создаем новый объект Song с помощью четырех лексем
        //и добавляем объект в список
        Song song = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(song);
    }

    public class ArtistCompare implements java.util.Comparator<Song>{

        @Override
        public int compare(Song one, Song two) {
            return one.getArtist().compareTo(two.getArtist());
        }
    }


}



