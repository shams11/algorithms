package com.shams.designpatterns;

import java.util.ArrayList;
import java.util.List;

interface Subject {

  void register(Observer obj);
  void unRegister(Observer obj);
  void notifyObservers();
}

class DeliveryData implements Subject {

  private List<Observer> observers;
  private String location;

  public DeliveryData() {
    this.observers = new ArrayList<>();
  }

  @Override
  public void register(Observer obj) {
    observers.add(obj);
  }

  @Override
  public void unRegister(Observer obj) {
    observers.remove(obj);
  }

  @Override
  public void notifyObservers() {
    for(Observer obj : observers) {
      obj.update(location);
    }
  }

  // This method will be called by the delivery person, whenever there is change in the
  // location info
  public void locationChanged() {
    this.location = getLocation();
    notifyObservers();
  }

  private String getLocation() {
    // Ideally this will be actual coordinates
    return "current location where the product is";
  }
}

// Observer
interface Observer {
  // To make it generic, we can call location as data
   void update(String location);
}

// Observers

class Seller implements Observer {
  private String location;

  @Override
  public void update(String location) {
    this.location = location;
    showLocation();
  }

  private void showLocation() {
    System.out.println("Notification at seller - current location : " + location);
  }
}

// Observer

class User implements Observer {

  private String location;

  @Override
  public void update(String location) {
    this.location = location;
    showLocation();
  }

  private void showLocation() {
    System.out.println("Notification at User - current location : " + location);
  }
}

// Observers

class DeliverWareCentre implements Observer {
  private String location;

  @Override
  public void update(String location) {
    this.location = location;
    showLocation();
  }

  private void showLocation() {
    System.out.println("Notification at Warehouse - current location : " + location);
  }
}

// Test
class ObserverPatternTest {
  public static void main(String[] args) {
    DeliveryData topic = new DeliveryData();

    Observer obj1 = new Seller();
    Observer obj2 = new User();
    Observer obj3 = new DeliverWareCentre();

    topic.register(obj1);
    topic.register(obj2);
    topic.register(obj3);

    // Ideally there will be different api's exposed to update location changed
    topic.locationChanged();
  }
}
