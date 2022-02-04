# WeddingGuestBook

## Set up 
1. I will create a new database called WeddingGuestBook in postgres and connect to it.


## **Look no further everyone who was at your wedding in the palm of your hand**

![guestbookImage.jpg](/Image/Images/guestbookImage.jpg)

In this project I applied REST API for a Wedding GuestBook  application, which allows users to see who is was at the wedding, some fun things that they can talk to other guest about, and post pictures from the wedding. The user will have to create an account with an email to use this app. The user can update their post or delete a picture or comment they have left.

## Entity Relationship Diagram (ERD):
So my thinking proccess orginally was an app that gives the guest a barcode to scan guest as they come in and automatically fills them into a database. Mitgates wedding crashers can compare the guest you expected to come against who shows up even if someone tells them to download the app. For right now its a social media app for weddings.

![finalerd.jpg](/Image/Images/finalerd.jpg)

## Original ERD Diagram (ERD):
At a later time I would like to add anoter model for users to reply to comments and leave comments on pictures.

![futureERD.jpg](/Image/Images/futureERD.jpg)

## Planning and Timeline
I implemented the MVC design for this project which has a simple approach to it. The user interacts with the view which talks to the controller and the controller talks to the model as you can see in the diagram.
![MVC.jpg](/Image/Images/MVC.jpg)
Timeline :
- Day 1: create all models,packages and repos  
- Day 2 : Create service and controllers 
- Day 3:Create Excetion handling for all endpoints 
- Day 4: configure login and security for all endpoints and fix bugs 