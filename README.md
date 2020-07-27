# VMWare Travel Application 
## (Path Forward Returnship Project)

### Summary
This project consists of providing a REST API service for weather information using Spring Boot.  It has a minimal number of 
endpoints. It currently supports adding one weather data at a time, and deleting all the information.  It is also able to
return all the data recorded or data corresponding to a specific date.

This service does not use a database but rather an in-memory datastructure.  It is a 3-tier app split into model, view, and controller.
It has a set of test cases to ensure edge cases and happy paths are working.  It also has a custom exception to provide the 
user with a clear error message and code.

### Specfication
**Each weather data is a JSON entry with the following keys:**

- id: This is the unique weather data ID.
- date: This is the weather data record date given in the format yyyy-MM-dd.
- location: The place for which the weather data was recorded. The location itself is a JSON object consisting of the following fields:
    - lat: The latitude (up to four decimal places) of the location.
    - lon: The longitude (up to four decimal places) of the location.
    - city: This is the city name.
    - state: This is the state name.
- temperature: This is an array of 24 float values (up to one decimal place), describing the hourly temperature (in F) for the given location.


**Sample JSON weather data object**

    {
        "id": 1231,
        "date": "2020-05-11",
        "location": {
            "lat": 8.0223,
            "lon": 10.3349,
            "city": "Boulder",
            "state": "Colorado"
        },
        "temperature": [
            0.0,
            12.1,
            111.1,
            100.9,
            12412.8,
            1349.0,
            123.9,
            1341.2,
            109.2,
            19.2,
            12.9,
            1241.0,
            100.3,
            12.3,
            134.1,
            1341.2,
            1241.1,
            12.2,
            124.2,
            124.3,
            12.3,
            123.1,
            124.3,
            4423.1
        ]
    }
    
### Requirements
**The REST service should implement the following:**

1. **Adding new weather data:** The service should be able to add a new weather data by the POST request at /weather. The weather JSON is sent in the request body. If weather data with the same ID already exists then the HTTP response code should be 400; otherwise, the response code should be 201.
2. **Returning all the weather data:** The service should be able to return the JSON array of all the weather data by the GET request at /weather. The HTTP response code should be 200. The JSON array should be sorted in ascending order of weather data ID.
3. **Returning the weather data filtered by date:** The service should be able to return the JSON array of all the weather data recorded on the given date by the GET request at /weather?date={date}.
4. **Erasing all the weather data:** The service should be able to erase all the weather data by the DELETE request at /erase. The HTTP response code should be 200.



