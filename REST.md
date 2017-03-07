#Weather ReSTful Web-Services.
##Cloud-Computing Assignment-2
The project is developed using J2EE (dynamic web project) in eclipse. All the weather information is stored in daily.csv and the data is accessed in java. The project is developed using rest api-which is implemented through jersey framework. 
The methods implemented in the project are 
•	GET,
•	POST 
•	DELETE.
 The outputs are tested using the URLS below
###1) http://52.43.97.106/weather/webapi/temp/historical 
Here GET method is used and takes no input. The output lists all dates present from the csv database in JSON format.  Returns json array containing all dates in weather data.
Method:
  `GET`
Output Parameters:
JSONArray[JSONObject{"DATE":Date String(yyyyMMdd)}]
Success Response:
Code: 200 <br />
Content: `[   {"DATE": "20130101"},{"DATE": "20130102"} ]`
Error Response:
Code: 404 NOT FOUND <br />

###2)http://52.43.97.106/weather/webapi/temp/historical /YYYYMMDD –
GET method is used and this takes util.date as input .The output lists the data regarding the particular date and displayed in JSON format, if no data is found for that date 404 error is returned.  Returns json array containing all dates in weather data
Method:
`GET`
Input Parameters:
Pass Date as a path parameter as shown in above URL
Output Parameters:
  JSONObject{"DATE":Date int(yyyyMMdd), "TMAX": Double, "TMIN": Double}
Success Response:
Code: 200 <br />
Content:  `{   "DATE": "20150712", "TMAX": 85.5, "TMIN": 67.5 }`
Error Response:
Code: 404 NOT FOUND <br />
###3)http://52.43.97.106/weather/webapi/temp/historical 
POST method is used and this takes input from client-body (Form Parameters are to be given in order to insert a new date. Content-type: application/x-www-form-urlencoded ) 
Sample Request Body: {"DATE": "20180101", "TMAX": 57.0, "TMIN": 24.0 }
Method:
`POST`
Input Parameters:
JSONObject{"DATE":Date int(yyyyMMdd), "TMAX": Double, "TMIN": Double}
Sample Input Parameters:
{ "DATE": "20180101", "TMAX": 75.5, "TMIN": 60.5 }  
Output Parameters:
JSONObject{"DATE":Date int(yyyyMMdd)}
Success Response:
Code: 201 <br />
Content: `{   "DATE": "20180101" }`
Error Response:
Code: 500 INTERNAL SERVER ERROR <br />
###4) http://52.43.97.106/weather/webapi/temp/historical
DELETE method is used. This takes date as input and deletes the record with given date from database and returns a string “success”, if there is no data with that date, 404 status code is returned.  Returns json object containing date whose data is deleted.
URL
http://52.43.97.106/weather/webapi/temp/historical/{DATE(yyyyMMdd)}  
SAMPLE URL
http://52.43.97.106/weather/webapi/temp/historical/20170101
Method:
`DELETE`
Input Parameters:
Pass Date as a path parameter as shown in above URL
Output Parameters:
JSONObject{"DATE":Date int(yyyyMMdd)}
Success Response:
Code: 200 <br />
Content: `{ "DATE": "20150712" }`
Error Response:
Code: 404 NOT FOUND <br />
###MADE USE OF:
Eclipse neon EE, Java Rest full Web services, XAMPP.
###DEPLOYEMENT:
Deployed the project in Amazon EC2 Windows instance



