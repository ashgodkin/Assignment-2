package controllers;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import User;


public class Main
{
 public RecommenderAPI likeMovies;
 @Command(description="Add a new User")
 public void addUser (@Param(name="first name") String firstName, @Param(name="last name") String lastName,
 @Param(name="age") String age, @Param(name="gender") String gender, @Param(name="occupation") String occupation)
 {
 likeMovies.addUser(firstName, lastName, age, gender, occupation);
 }

 @Command(description="Delete a User")
 public void removeUser (@Param(name="id") Long id)
 {
 likeMovies.removeUser(userID);
 }
 @Command(description="Add a Movie")
 public void addMovie (@Param(name="title") String title, @Param(name="year") String year, @Param(name="url") String url)
 {
 likeMovies.addMovie(title, year, url);
 }
 public static void main(String[] args) throws Exception
 {
 Main main = new Main();
 Shell shell = ShellFactory.createConsoleShell("lm", "Welcome to likemovie - ?help for instructions", main);
 shell.commandLoop();
 main.likeMovies.store();
 }
}