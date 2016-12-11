package controllers;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import utils.ToJsonString;

public class Movie
{
 static Long counter = 0l;

 public Long movieID;

 public String title;
 public String year;
 public String url;
 public Movie(String title, String year, String url)
 {
 this.id = counter++;
 this.title = title;
 this.year = year;
 this.url = url;
 }

 @Override
 public String toString()
 {
 return new ToJsonString(getClass(), this).toString();
 }

 @Override
 public int hashCode()
 {
 return Objects.hashCode(this.id, this.title, this.year, this.url);
 }

 @Override
 public boolean equals(final Object obj)
 {
 if (obj instanceof Movie)
 {
 final Movie other = (Movie) obj;
 return Objects.equals(title, other.title)
 && Objects.equals(year, other.year)
 && Objects.equals(url, other.url);
 }
 else
 {
 return false;
 }
 }
}