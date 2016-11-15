I have used RxJava as specified along with Retrofit2 for network calls and Butterknife for view binding.

My approach was to use concatmap to concatenate the objects received from the `Starship` endpoint of the API and to call the api recursively until the next field in the API response was null. I have added comments in the more important portions of the code to provide a few more details to whoever reviews the code. 

I have also paid some attention to the UI/UX. The recyclerview loads with an animation and data retrieved from the API is saved (by implementing Parcelable) when the phone is rotated so additional network calls are not made is such a situation.

[Screenshot Here](Demo_Screenshot.png)

Since the challenge mentioned a suggested time of 3 hours I decided not to implement the solution using an architecture pattern like MVP which would have taken some more time. Some other improvements would include adding testcases and using Dagger2.  