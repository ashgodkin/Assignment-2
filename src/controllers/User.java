package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import utils.ToJsonString;

import static com.google.common.base.Objects;

public class User 
{
  public Map<Long, User> users = new HashMap<>();
 
  public String firstName;
  public String lastName;
  public String age;
  public String gender;
  public String occupation;
  public List<Rating> ratings = new ArrayList<>();
  
  static Long counter = 0l;
  
  public Long userID;
  //...

  public User()
  {
  }

  public User(String firstName, String lastName, String age, String gender, String occupation)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.gender = gender;
    this.occupation = occupation;
    this.userID = counter++;
  }
  
  @Override  
  public int hashCode()  
  {  
     return Objects.hashCode(this.firstName, this.lastName, this.age, this.gender, this.occupation);  
  }  
  
  @Override
  public String toString()
  {
    return new ToJsonString(getClass(), this).toString();
  }
  
  	@Override
  	public boolean equals(final Object obj) {
  		if (obj instanceof User) {
  			final User other = (User) obj;
  			return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
  					&& Objects.equals(gender, other.gender) && Objects.equals(age, other.age)
  					&& Objects.equals(occupation, other.occupation) && Objects.equals(ratings, other.ratings);
  		} else {
  			return false;
  		}
  
  	}
  
  
}