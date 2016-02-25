package appexperts.alberto.com.fresco_imageloader.api;

import java.util.List;

import appexperts.alberto.com.fresco_imageloader.model.Model.VinoModel.Vinos.Vino;
import appexperts.alberto.com.fresco_imageloader.util.Constants;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by alber on 25/02/2016.
 */
public interface IVinos {
    @GET(Constants.VINOS)
    public void getVinosInfo(Callback<List<Vino>> response);
}
