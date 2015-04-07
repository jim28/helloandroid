package com.tedneward.example;

import java.beans.*;
import java.util.*;
import java.io.*;


public class Person implements Comparable<Person>{
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;
  private static int numObj;

///*
//   public static void main(String[] args) {
//     List<Person> people = Person.getNewardFamily();
//     Collections.sort(people, new Person.AgeComparator());
//     System.out.println(new Person("Matthew", 15, 0).equals(people.get(0)));
//   }
  
//*/  
  //@override
  public int compareTo(Person p1) {
    return (int)(p1.getSalary()-this.getSalary());
  }

  public Person() {
    this("", 0, 0.0d);
    numObj++;
  }
  
  public Person(String n, int a, double s) {
    this.name = n;
    this.age = a;
    this.salary = s;
    this.ssn = "";
    numObj++;
  }

  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    if(age <=0)
	    throw new IllegalArgumentException("Age small than zero");
    this.age = age;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    if(name == null)
	    throw new IllegalArgumentException("the name is NULL");
    this.name = name;
  }
  
  public double getSalary() {
    return salary;
  }
  public void setSalary(double salary) {
  	this.salary = salary;
  }
  
  public String getSSN() {
    return ssn;
  }
  public void setSSN(String value) {
    String old = ssn;
    ssn = value;
    
    this.pcs.firePropertyChange("ssn", old, value);
    propertyChangeFired = true;
  }

  public boolean getPropertyChangeFired() {
    return propertyChangeFired;
  }
  public void setPropertyChangeFired(boolean property) {
    this.propertyChangeFired = property;
  }

  public double calculateBonus() {
    return salary * 1.10;
  }
  
  public String becomeJudge() {
    return "The Honorable " + name;
  }
  
  public int timeWarp() {
    return age + 10;
  }
  
  public boolean equals(Object other) {
    //System.out.println("equal call");
    if(other instanceof Person)
      return (this.name.equals(((Person)other).getName()) && (this.age == (((Person)other).getAge())));
    else
      return false;
  }
  /*
  public int hashCode() {
    int hash = 17;
    hash = hash*37+this.name.hashCode();
    hash = hash*37+this.age;
    return hash;  
  }
*/

  public String toString() {
    return "[Person name:"+this.name+" age:"+this.age+" salary:"+this.salary+"]";
  }

  public int count() {
    return numObj;
  }

  public static class AgeComparator implements Comparator<Person>{
     //@override     
      public int compare(Person p1, Person p2) {
     	      //ascending order
	         return p1.getAge()-p2.getAge();
     }
  }
  
  static public ArrayList getNewardFamily() {
    ArrayList a1 = new ArrayList();
    a1.add(new Person("Ted",41,250000));
    a1.add(new Person("Charlotte",43,150000));
    a1.add(new Person("Michael",22,10000));
    a1.add(new Person("Matthew",15,0));
    return a1;
  }


  // PropertyChangeListener support; you shouldn't need to change any of
  // these two methods or the field
  //
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  public void addPropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.removePropertyChangeListener(listener);
  }
}
