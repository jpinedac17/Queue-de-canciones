package queueHandler;

import umg.edu.gt.data_structure.queue.manual.QueueLinked;

public class SpotifySimulator {

    private QueueLinked<Song> highPriorityQueue;
    private QueueLinked<Song> normalQueue;
    private int totalSongsPlayed;
    private int totalPlayTime;

    public SpotifySimulator() {
        highPriorityQueue = new QueueLinked<>();
        normalQueue = new QueueLinked<>();
    }

    public void addSong(Song song) {
        if (song.getPriority() == 1) {
            highPriorityQueue.enqueue(song);
        } else {
            normalQueue.enqueue(song);
        }
    }

    public void play() {
        System.out.println("[LOG] Starting playlist...");

        while (!highPriorityQueue.isEmpty() || !normalQueue.isEmpty()) {

            Song currentSong;

            if (!highPriorityQueue.isEmpty()) {
                currentSong = highPriorityQueue.dequeue();
            } else {
                currentSong = normalQueue.dequeue();
            }

            playSong(currentSong);
        }

        System.out.println("[LOG] Playlist finished.");
        System.out.println("[LOG] Total songs played: " + totalSongsPlayed);
        System.out.println("[LOG] Total play time: " + totalPlayTime + "s");
    }

    private void playSong(Song song) {
        System.out.println("[LOG] Now playing: " + song);

        for (int i = 1; i <= song.getDuration(); i++) {
            System.out.println("Playing... " + i + "s / " + song.getDuration() + "s");
            try {
                Thread.sleep(1000); // simula 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        totalSongsPlayed++;
        totalPlayTime += song.getDuration();
        System.out.println("[LOG] Finished: " + song.getTitle());
        System.out.println();
    }
}	