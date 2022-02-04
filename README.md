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

In this project I created:
- 5 models
- 3 service classes
- 5 repository interface classes
- 2 controller classes 
- 15 endpoints 2 of them are public for the user to register and login

# Endpoints

| ENDPOINT | FUNCTIONALITY | PUBLIC |
| --- | :--- |:--- |
| POST _/api/posts/{postId}/comment_ | POST new comment | NO |
| GET _/api/posts/{postId}/comment_ | GET all comments on post | NO |
| GET _/api/posts/{postId}/comment_{commentId}/ | Get one comment on post | NO |
| DEL _/api/posts/{postId}/comment/{commentId}_ | DELETE comment on post | NO |
| POST _/api/posts/{postId}/photo_ | POST new photo | NO |
| GET _/api/posts/{postId}/photo_ | GET all photos on post | NO |
| GET _/api/posts/{postId}/photo/{photoId}_ | GET one photo on post | NO |
| DEL _/api/posts/{postId}/photo/{photoId}_ | DELETE a photo on post | NO |
| GET _/api/posts/_ | GET all post | NO |
| POST _/api/posts/_ | POST create post | NO |
| GET _/api/posts/{postId}/_ | GET post | NO |
| PUT _/api/posts/{postId}/_ | UPDATE post | YES |
| DEL _/api/posts/{postId}/_ | DELETE post | YES|

# Machineries Used

 - Post man : help serialize endpoints
 - postGres/pgAdmin4 : create database and also help visualize tables
 - SpringBoot : where all the magic happend, what I use to build everything
 - Intellji/JAVA : program I used to build database
 - Mavaen : what I used for my dependencies
 - StackFlow : help for debugging
 - Youtube: learn about annotations and JWT
 - Json Web Tokens (JWT) : what I used for authentication

 # User Stories
<Type of user>As a wedding guest
<TASK>I want to be able to make a post. 
<GOAL> so that I can interact with other guest.
ACCEPTANCE CRITERIA
<GIVEN> Given I’m in the role of logged in bride/groom.
<WHEN> when I open the app I’m able to reply to a comment that a guest left.
<THEN> the app saves my comment and the app shows comment.

<As> a wedding guest
<I Want> to be able to create an account
<So that> the couple knows who I am.
ACCEPTANCE CRITERIA
<GIVEN> Given I am in the role of unregistered user/wedding guest
<WHEN> I open the app there is a place for me enter my email, username and password.
<THEN> the app saves my credentials and I am able to login into the account.


<As> a signed in user/wedding guest
<I Want> to be able to post comments and post pictures
<So that> the couple can see what an amazing time I had.
ACCEPTANCE CRITERIA
<GIVEN> Given I’m in the role of logged in wedding guest
<WHEN> when I open the app I’m able to post a comment or a picture.
<THEN> the app saves my comment or picture and the app shows my picture or comment.

1. As a user I can get all comments on a post.
1. As a user I can  login into my account.
1. As a user I can delete a post.
1. As a user I can delete a comment.
1. As a user I can delete a photo.
1. As a user I can post a photo.


