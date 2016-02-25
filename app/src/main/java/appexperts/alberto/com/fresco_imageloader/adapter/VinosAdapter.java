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
import appexperts.alberto.com.fresco_imageloader.model.Model.VinoModel.Vinos.Vino;

/**
 * Created by alber on 25/02/2016.
 */
public class VinosAdapter  extends RecyclerView.Adapter<VinosAdapter.ViewHolder>{


    private List<Vino> vinos;
    private int rowLayout;
    private Context mContext;
    private LayoutInflater inflater;



    public VinosAdapter(List<Vino> vinos, int rowvino_layout, Context applicationContext) {
        this.mContext = applicationContext;
        this.vinos = vinos;
        inflater =  LayoutInflater.from(mContext);
        this.rowLayout = rowvino_layout;
    }

    @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = inflater.inflate(rowLayout, parent, false);
                return new ViewHolder(view);
            }

            @Override
            public void onBindViewHolder(ViewHolder holder, final int position) {

                Uri uri = Uri.parse(vinos.get(position).getImage());
                holder.draweeView.setImageURI(uri);
                holder.txt.setText(vinos.get(position).getTitle());
                holder.txt2.setText( vinos.get(position).getAuthor()  );

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "You clicked on item:" + position, Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public int getItemCount() {
                return vinos.size();
            }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView draweeView;
        public TextView txt, txt2;
        public ViewHolder(View itemView) {
            super(itemView);

            draweeView = (SimpleDraweeView) itemView.findViewById(R.id.img);
            //TODO views indent
            txt = (TextView) itemView.findViewById(R.id.vino_title);
            txt2 = (TextView) itemView.findViewById(R.id.vino_author);

        }
    }

}
