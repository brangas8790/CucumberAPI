Feature: Error Booking
Scenario Outline: Error is displayed when giving incorrect date details

Given Customer open the given application
When Customer booking the hall by giving details "<name>" "<contact>" "<halltype>" "<date>" and clicks Book the hall button
Then Verifying the booking "<details>"

Examples:
|name|contact|halltype|date|details|
|Yaswanth|9577855644|Function hall|20/13/2018|Input format error|
|Yaswanth|9577855644|Function hall|32/12/2018|Input format error|
|Yaswanth|9577855644|Function hall|20/12/201|Input format error|
|Yaswanth|9577855644|Function hall|date|Invalid Input|