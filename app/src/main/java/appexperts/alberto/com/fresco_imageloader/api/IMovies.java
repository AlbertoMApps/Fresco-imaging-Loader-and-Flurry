package appexperts.alberto.com.fresco_imageloader.api;

import java.util.List;

import appexperts.alberto.com.fresco_imageloader.model.Model.VinoModel.Movies.Movie;
import appexperts.alberto.com.fresco_imageloader.util.Constants;
import retrofit.Callback;
import retrofit.http.GET;

public interface IMovies {

    @GET(Constants.MOVIES)
    public void getMovies(Callback<List<Movie>> response);

}
