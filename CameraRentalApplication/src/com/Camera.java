package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Camera {

   //Attributes
   private static int nextCameraId = 1;
   private int cameraId;
   private String brand;
   private String model;
   private double perDayRentalAmount;


   //Constructors
   public Camera(String brand, String model, double perDayRentalAmount) {
      this.cameraId = nextCameraId++;
      this.brand = brand;
      this.model = model;
      this.perDayRentalAmount = perDayRentalAmount;
   }

   public String toString() {
      return String.format("%-10s %-15s %-15s", brand, model, perDayRentalAmount);
   }


   //Methods
   public int getCameraId() {

      return cameraId;
   }

   public Object getBrand() {

      return brand;
   }

   public Object getModel() {

      return model;
   }

   public double getPerDayRentalAmount() {

      return perDayRentalAmount;
   }

}

class User {
   private String username;
   private String password;
   private Wallet wallet;
   private List<Camera> rentedCameras;

   public User(String username, String password, double initialBalance) {
      this.username = username;
      this.password = password;
      this.wallet = new Wallet(initialBalance);
      this.rentedCameras = new ArrayList<>();
   }

   public String getUsername() {
      return username;
   }

   public String getPassword() {
      return password;
   }

   public Wallet getWallet() {
      return wallet;
   }

   public List<Camera> getRentedCameras() {
      return rentedCameras;
   }
}

class Wallet {
   private double balance;

   public Wallet(double balance) {
      this.balance = balance;
   }

   public double getBalance() {
      return balance;
   }

   public void addFunds(double amount) {
      balance += amount;
      System.out.println("Funds added successfully. New balance: " + balance);
   }
}

