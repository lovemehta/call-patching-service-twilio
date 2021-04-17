**Call Patching Service**

This service keeps a mapping of customer - nutritionists in the database. 

Whenever a call comes to a company service number bought from twilio (single contact number for the customer service portal), this service checks the customer mapping and redirects the incoming call to the phone number of the concerned nutritionist automatically.

Please edit the application-dev.properties and application-prod.properties with valid twilio credentials.
