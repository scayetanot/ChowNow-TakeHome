# ChowNow-TakeHome

Development Choices:

Room, Dagger2, LiveData, Retrofit, Kotlin, Coroutine, MVVM and data binding

The application is currently loading one activity which will display 2 fragments:

- `LocationsListFragment`: This fragment will contain the list of locations for a specific restaurant.
- `LocationsDetailsFragment`: This fragment will contain the detailed information of a specific location.

Hypothesis: Not all data present in the JSON are treated. I have choose some of the data to display on the screen

**High Level Overview.
**
When the application start, the application submit a request to the provided API to pull all the locations information.
When the request is made, the application can choose if we pull the data from remote location or locally from the DB.
For now, the DB is only accessed to create the list of Locations in case internet is down.
So, by default, the application pull the data from the api provided. Once received, the data are saved into the Room DB and send back to the Fragment

When the user click on one of the location, the detail fragment is loaded and the information required are pulled from the RoomDB.

ViewModel<>Fragment use LiveData to communicate.
ViewModel<>Repository use coroutine.

I have choose to store the data into a Database in case the data connection is down, we can decide to pull the data from there.

The repository is in charge or selecting between remote or local data

Use of Dagger is more best practice to do here. It will facilitate the modularity of the code and also testing/mocking

MVVM/data-binding is offering a more flexible way and clean architecture. Data binding prevent also bad import which can happen when using kolin.synthetic

data folder contain all the data class use for the app.

utils contain few Swiss knife methods

**Improvments**:
- Map displayed when Zooming on a specific location is not properly centered. For now, I kept a high view but the pin is correctly located. The boundaries may need to refine
- Landscape/Portrait mode. The layout defined for landscape seems not loading properly.
- On Network Error, the data are pulled from the database. For now, it's done only when no internet connection


