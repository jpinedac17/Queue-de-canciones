package queueHandler;

public class Song {
	// Atributos
	private String title;
	private String artist;
	private int duration;
	private int priority;
	
	// Constructor
	Song(String title, String artist, int duration, int priority) {
		this.title = title;
		this.artist = artist;
		
		if (duration < 5 || duration > 30) {
			throw new IllegalArgumentException("La duracion debe ser entre 5s a 20s");
		}
		this.duration = duration;
		this.priority = priority;
	}
	
	// Getters
	public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    public int getPriority() {
        return priority;
    }
    
    @Override
    public String toString() {
        return title + " - " + artist + " (" + duration + "s)";
    }
}
