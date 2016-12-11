package controllers;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Movie;
import Rating;
import User;
import utils.CSVLoader;
import utils.Serializer;

public class RecommenderAPI {
	
	private Serializer serializer;
	
	private Map<Long,User> userIndex = new HashMap<>();
	private Map<String,Movie> movieIndex = new HashMap<>();
	private Map<String,Rating> ratingIndex = new HashMap<>();
	
	
	public RecommenderAPI(){
	}
	
	public RecommenderAPI(Serializer serializer)
	{
		this.serializer = serializer;
	}
	
	 public User addUser(String firstName, String lastName, String age, String gender, String occupation)
	 {
	 User user = new User (firstName, lastName, age, gender, occupation);
	 userIndex.put(user.userID, user);
	 return user;
	 }
	
	public void removeUser(Long userID){
		UserID userID = new UserID (userID);
		userIndex.put(user.userID, user);
	}
	
	 public Movie addMovie(String title, String year, String url)
	 {
	 Movie movie = new Movie (title, year, url);
	 movieIndex.put(movie.id, movie);
	 return movie;
	 }
	
	public Rating addRating(String userID, String movieID, int rating){
		Rating rating = new Rating (rating);
		ratingIndex.put(rating.rating, rating);
		return rating;
		
	}
	
	public void getMovie(String movieID){
	}
	
	public void getUserRatings(String userID){
	}
	
	public void getUserRecommendations(String userID){
	}
	
	public void getTopTenMovies(){
	}
	
	public void write(){
	}
	
	@SuppressWarnings("unchecked")
	public void load() throws Exception
	{
		serializer.read();
		userIndex = (Map<Long,User>) serializer.pop();
		User.counter = (Long)serializer.pop();
		
	}
	
	void store() throws Exception
	{
		serializer.push(User.counter);
		serializer.push(userIndex);
		serializer.write();
	}
	
	public void prime() throws Exception
	{
		CSVLoader loader = new CSVLoader();
		List <User> users = loader.loadUsers("moviedata_small/users5.dat");
		for (User user : users)
		{
			userIndex.put(user.userID,user);
		}
		
		//load Movies
		List <Movie> movies = loader.loadMovies("moviedata_small/items5.dat");
		for (Movie movie : movies)
		{
			movieIndex.put(movie.movieID, movie);
		}
		//load Ratings
		List <Rating> ratings = loader.loadRatings("moviedate_small/ratings5.dat");
		for (Rating rating : ratings)
		{
			ratingIndex.put(rating.rating, rating);
		}
	}
}
