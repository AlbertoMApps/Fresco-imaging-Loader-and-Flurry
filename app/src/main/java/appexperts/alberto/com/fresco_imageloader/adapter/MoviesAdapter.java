package appexperts.alberto.com.fresco_imageloader.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import appexperts.alberto.com.fresco_imageloader.R;
import appexperts.alberto.com.fresco_imageloader.model.Model.VinoModel.Movies.Movie;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder>{

    private List<Movie> movies;
    private int rowLayout;
    private Context mContext;
    private LayoutInflater inflater;

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context ) {
        this.mContext = context;
        this.movies = movies;
        inflater =  LayoutInflater.from(context);
        this.rowLayout = rowLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(rowLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Uri uri = Uri.parse(movies.get(position).getImage());
        holder.draweeView.setImageURI(uri);
        holder.title.setText(movies.get(position).getTitle());
        holder.rating.setText(movies.get(position).getRating()+"");
        holder.year.setText(movies.get(position).getReleaseYear()+"");
        holder.genre.setText(movies.get(position).getGenre().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "You clicked on item:" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView draweeView;
        public TextView title, rating, year, genre;
        public ViewHolder(View itemView) {
            super(itemView);

            draweeView = (SimpleDraweeView) itemView.findViewById(R.id.icon_movie);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            rating = (TextView) itemView.findViewById(R.id.tv_rating);
            year = (TextView) itemView.findViewById(R.id.tv_year);
            genre = (TextView) itemView.findViewById(R.id.tv_genre);

        }
    }
}
