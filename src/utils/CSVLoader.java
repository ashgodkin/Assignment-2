package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CSVLoader{
	public <User> List<User> loadUsers(String filename) throws Exception{
		File usersFile = new File(Filename);
		In inUsers = new In(usersFile);
		
		String delims = "[|]";
		List<User> users = new ArrayList<User>();
		while (!inUsers.isEmpty())
		{
			String userDetails = inUsers.readLine();
			String[] userTokens = userDetails.split(delims);
			if (userTokens.length == 7)
			{
				String id = userTokens[0];
				String firstName = userTokens[1];
				String secondName = userTokens[2];
				String age = userTokens[3];
				String gender = userTokens[4];
				String occupation = userTokens[6];
				
				users.add(new User(firstName, secondName, age, gender, occupation ));
			}
			else
			{
				throw new Exception("Invalid member length: " + userTokens.length);
			}
		}
		return users;
	}
	
	public <Movie> List<Movie> loadMovies(String filename) throws Exception{
		File moviesFile = new File(Filename);
		In inMovies = new In(moviesFile);
		
		String delims = "[|]";
		List<Movie> movies = new ArrayList<Movie>();
		while (!inMovies.isEmpty())
		{
			String movieDetails = inMovies.readLine();
			String[] movieTokens = movieDetails.split(delims);
			if (movieTokens.length == 5)
			{
				String id = movieTokens[0];
				String title = movieTokens[1];
				String year = movieTokens[2];
				String url = movieTokens[4];
				
				movies.add(new Movie(title, year, url));
			}
			else
			{
				throw new Exception("Invalid member length: " + movieTokens.length);
			}
		}
		return movies;
	}
	}
	
	public <Rating> List<Rating> loadRatings(String filename) throws Exception{
		File ratingsFile = new File(Filename);
		In inRatings = new In(ratingsFile);
		
		String delims = "[|]";
		List<Rating> ratings = new ArrayList<Rating>();
		while (!inRatings.isEmpty())
		{
			String ratingDetails = inRatings.readLine();
			String[] ratingTokens = ratingDetails.split(delims);
			if (ratingTokens.length == 3)
			{
				String id = ratingTokens[0];
				String rating = ratingTokens[1];
				
			ratings.add(new Rating(rating));
			}
			else
			{
				throw new Exception("Invalid member length: " + ratingTokens.length);
			}
		}
		return ratings;
	}
	}
