Feature: Hall Booking
Scenario: Hall is booked for an event

Given Customer open the application
When Customer booking the hall by giving details and clicks the button
|name|contact|halltype|date|
|Steve|8778556442|Banquet hall|20/07/2018|
Then Verifying the booking details
|Hall has been booked|
