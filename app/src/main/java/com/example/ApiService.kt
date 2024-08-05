import com.example.myapplication.MyData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers(
        "x-rapidapi-key: 426c0c6563msha9d750e287dea8bp1b65d0jsne06b9238c74b",
        "x-rapidapi-host: deezerdevs-deezer.p.rapidapi.com"
    )
    @GET("search")
    fun getData(@Query("q") query: String): Call<MyData>  // Expecting a single MyData object
}
