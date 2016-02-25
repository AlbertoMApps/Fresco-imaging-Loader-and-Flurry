package appexperts.alberto.com.fresco_imageloader;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.flurry.android.FlurryAgent;
import java.util.List;
import appexperts.alberto.com.fresco_imageloader.adapter.MoviesAdapter;
import appexperts.alberto.com.fresco_imageloader.adapter.VinosAdapter;
import appexperts.alberto.com.fresco_imageloader.api.IMovies;
import appexperts.alberto.com.fresco_imageloader.api.IVinos;
import appexperts.alberto.com.fresco_imageloader.model.Model.VinoModel.Movies.Movie;
import appexperts.alberto.com.fresco_imageloader.model.Model.VinoModel.Vinos.Vino;
import appexperts.alberto.com.fresco_imageloader.util.Constants;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private MoviesAdapter moviesAdapter;
    private VinosAdapter vinosAdapter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        FlurryAgent.init(this, "YZV4JKRZ3S8WQQ2K3DRW");
        // log level brings logcat output
        //movies
//        RestAdapter restAdapter = new RestAdapter.Builder()
//                .setEndpoint(Constants.BASE_URL)
//                .setLogLevel(RestAdapter.LogLevel.FULL)
//                .build();
        //vinos
        RestAdapter restAdapter1 = new RestAdapter.Builder()
                .setEndpoint(Constants.BASE_URL1)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        IVinos iVinos = restAdapter1.create(IVinos.class); //vinos
//        IMovies iMovies = restAdapter.create(IMovies.class); //movies
//        iMovies.getMovies(new Callback<List<Movie>>() {
//            @Override
//            public void success(List<Movie> movies, Response response) {
//
//                dismissDialog();
//
//                Log.i("FrescoTest: ", "Item: " + movies.get(0).getTitle());
//
//                moviesAdapter = new MoviesAdapter( movies, R.layout.row_layout, getApplicationContext());
//                recyclerView.setAdapter(moviesAdapter);
//
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//
//                dismissDialog();
//
//            }
//        });

        iVinos.getVinosInfo(new Callback<List<Vino>>() {
            @Override
            public void success(List<Vino> vinos, Response response) {
                dismissDialog();

                Log.i("Vinos Test: ", "Item: " + vinos.get(0).getTitle().toString());

                vinosAdapter = new VinosAdapter(vinos, R.layout.rowvino_layout, getApplicationContext());
                recyclerView.setAdapter(vinosAdapter);
            }

            @Override
            public void failure(RetrofitError error) {
                dismissDialog();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        //Flurry
        FlurryAgent.onStartSession(this, "YZV4JKRZ3S8WQQ2K3DRW");
    }

    @Override
    protected void onStop() {
        super.onStop();

        dismissDialog();
        FlurryAgent.onEndSession(this);
    }

    public void dismissDialog(){
        if(progressDialog != null){
            progressDialog.dismiss();
        }
    }
}
