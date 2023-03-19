#Browse Theaters of a movie in a city including show timing
**GET /demo/movie/:id/theaters**
----
Returns theaters including show timing.
* **URL Params**  
  *Required:* `id=[integer]`  
  *Required:* `cityId=[integer]`  
  *Required:* `showDate=[date (yyyy-MM-dd)]`
* **Data Params**  
  None
* **Headers**  
  Content-Type: application/json
* **Success Response:**
* **Code:** 200  
  **Content:**
```
{
    "active": boolean,
    "theaters": [
        {
            "id": integer,
            "active": boolean,
            "name": string,
            "address": string,
            "cityName": string,
            "showTimes": [
                time(HH:mm)
            ]
        }
    ]
}
```
* **Error Response:**
    * **Code:** 400 
      **Content:** `{ error : exceptional message }`  
      OR
    * **Code:** 404  
      **Content:** `{ error : "Error occurred in getTheaterShows: No Record Found!!" }`

#Book movie tickets by selecting a theatre, timing, and preferred seats for the day
**POST /demo/booking**
----
Book ticket of preferred seat.
* **URL Params**  
  None
* **Data Params**  
```
{
    "noOfSeats": integer,
    "theaterId": integer,
    "cityId": integer,
    "showDate": date(2023-03-23),
    "showTime": time(19:00),
    "seats": [
        {
            "row": string,
            "col": integer,
            "seatType": enum
        },
        {
            "row": string,
            "col": integer,
            "seatType": enum
        }
    ]
}
```
* **Headers**  
  Content-Type: application/json  
* **Success Response:**
* **Code:** 200  
  **Content:**
```
{
    "bookingNumber": string,
    "noOfSeats": integer,
    "theaterId": integer,
    "cityId": integer,
    "showDate": date(2023-03-23),
    "showTime": time(19:00),
    "seats": [
        {
            "row": string,
            "col": integer,
            "seatType": enum
        },
        {
            "row": string,
            "col": integer,
            "seatType": enum
        }
    ]
}
```
* **Error Response:**
    * **Code:** 400  
      **Content:** `{ error : exceptional message }`  

#Create show for the day     
**POST /demo/theater/:theaterId/shows**
----
Book show of the theater.
* **URL Params**  
  *Required:* `theaterId=[integer]`  
* **Headers**  
  Content-Type: application/json
* **Data Params**
```
{
    "showDate": date(2023-04-09),
    "showTimeIds": [
        integer,
        integer
    ]
}
```
* **Success Response:**
* **Code:** 200  
  **Content:**  
```
{
    "id": integer
    "showDate": date(2023-04-09),
    "showTimeIds": [
        integer,
        integer
    ]
}
```
* **Error Response:**
    * **Code:** 400  
      **Content:** `{ error : exceptional message }`

#Update show for the day
**PUT /demo/theater/:theaterId/shows**
----
Update theater shows
* **URL Params**  
  *Required:* `theaterId=[integer]`  
* **Data Params**
```
{
    "showDate": date(2023-04-09),
    "showTimeIds": [
        integer,
        integer
    ]
}
```
* **Headers**  
  Content-Type: application/json  
* **Success Response:**
* **Code:** 200  
  **Content:**  
```
{
    "id": integer
    "showDate": date(2023-04-09),
    "showTimeIds": [
        integer,
        integer
    ]
}
```
* **Error Response:**
    * **Code:** 400  
      **Content:** `{ error : exceptional message }`

#Delete show for the day
**DELETE /demo/theater/:theaterId/shows/:showDate**
----
Deletes the specified user.
* **URL Params**  
  *Required:* `theaterId=[integer]`  
  *Required:* `showDate=[date(yyyy-MM-dd)]`
* **Data Params**  
  None
* **Headers**  
  Content-Type: application/json  
* **Success Response:**
    * **Code:** 200  
      **Content:** `"Shows Successfully Deleted!"`
* **Error Response:**
    * **Code:** 400  
      **Content:** `{ error : exceptional message }`

#Bulk Booking
**POST /demo/bulk/booking**
----
Bulk ticket booking.
* **URL Params**  
  None
* **Data Params**  
```
[
    {
    "noOfSeats": integer,
    "theaterId": integer,
    "cityId": integer,
    "showDate": date(2023-03-23),
    "showTime": time(19:00),
    "seats": [
        {
            "row": string,
            "col": integer,
            "seatType": enum
        },
        {
            "row": string,
            "col": integer,
            "seatType": enum
        }
      ]
    },
    {
    "noOfSeats": integer,
    "theaterId": integer,
    "cityId": integer,
    "showDate": date(2023-03-23),
    "showTime": time(19:00),
    "seats": [
        {
            "row": string,
            "col": integer,
            "seatType": enum
        },
        {
            "row": string,
            "col": integer,
            "seatType": enum
        }
      ]
    }
]
```
* **Headers**  
  Content-Type: application/json
* **Success Response:**
    * **Code:** 200  
      **Content:** `"Successfully booked all the tickets"`
* **Error Response:**
    * **Code:** 400  
      **Content:** `{ error : exceptional message }`

#Bulk Cancel Booking
**PUT /demo/bulk/booking**
----
Bulk cancel bookings.
* **URL Params**  
  None
* **Data Params**  
```
[
    {
        "bookingNumber": string
    },
    {
        "bookingNumber": string
    }
]
```
* **Headers**  
  Content-Type: application/json
* **Success Response:**
    * **Code:** 200  
      **Content:** `"Successfully cancelled all the tickets"`
* **Error Response:**
    * **Code:** 400  
      **Content:** `{ error : exceptional message }`