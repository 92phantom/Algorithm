package Programmers;

import java.util.concurrent.*;
import java.util.*;

public class Hash_ex_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };
		solution(genres, plays);

	}

	static int[] solution(String[] genres, int[] plays) {
		int[] answer = {};

		ArrayList<Song> songs = new ArrayList<>();

		for (int i = 0; i < genres.length; i++) {

			songs.add(new Song(genres[i], plays[i], i));

		}

		
		
		
		HashMap<String, Integer> playsPerGenres = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {

			String genre = genres[i];
			int play = plays[i];

			if (playsPerGenres.containsKey(genre)) {
				playsPerGenres.replace(genre, playsPerGenres.get(genre) + play);
			} else {
				playsPerGenres.put(genre, play);
			}

		}

		Collections.sort(songs, new Comparator<Song>() {

			@Override
			public int compare(Song s1, Song s2) {

				int playOfGenre1 = playsPerGenres.get(s1.genre);
				int playOfGenre2 = playsPerGenres.get(s2.genre);

				if (s1.genre.equals(s2.genre)) {

					if (s1.play == s2.play) {
						return s1.id - s2.id;
					} else {
						return s2.play - s1.play;
					}

				} else {
					return playOfGenre2 - playOfGenre1;
				}

			}

		});

		ArrayList<Integer> answers = new ArrayList<>();
		HashMap<String, Integer> numberOfSelectedSongsOfGenres = new HashMap<>();

		for (int i = 0; i < songs.size(); i++) {

			String genre = songs.get(i).genre;
			
			
			if(numberOfSelectedSongsOfGenres.containsKey(genre) && numberOfSelectedSongsOfGenres.get(genre) >= 2) 
				continue;
			
			answers.add(songs.get(i).id);
			
			
			if(numberOfSelectedSongsOfGenres.containsKey(genre)) {
                numberOfSelectedSongsOfGenres.put(genre, numberOfSelectedSongsOfGenres.get(genre) + 1);
			}else {
                numberOfSelectedSongsOfGenres.put(genre, 1);

			}
			
		}

		answer = new int[answers.size()];
		
		System.out.println(answers);
		
		for(int i=0; i<answers.size(); i++) {
			answer[i] = answers.get(i);
		}
		
		
		return answer;
	}

	static class Song {
		String genre;
		int play;
		int id;

		public Song(String genre, int play, int id) {
			this.genre = genre;
			this.play = play;
			this.id = id;
		}

	}
}
