package queueHandler;
import umg.edu.gt.data_structure.queue.manual.QueueLinked;

public class Main {
	public static void main(String[] args) {
        
        SpotifySimulator simulator = new SpotifySimulator();

        Song s1 = new Song("Song A", "Artist A", 5, 2);
        Song s2 = new Song("Song B", "Artist B", 14, 1);
        Song s3 = new Song("Song C", "Artist C", 6, 2);

        simulator.addSong(s1);
        simulator.addSong(s2);
        simulator.addSong(s3);

        simulator.play();
	}
}
