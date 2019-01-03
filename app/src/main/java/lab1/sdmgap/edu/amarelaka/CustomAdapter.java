package lab1.sdmgap.edu.amarelaka;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Avijit on 8/5/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<WardDataModel> ward;
    private Context context;

    public CustomAdapter(Context context, ArrayList<WardDataModel>ward){
        this.ward = ward;
        this.context = context;
    }
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ward_raw_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.police_station_name.setText(ward.get(position).getWard_police_station_name());
        holder.police_station_number.setText(ward.get(position).getWard_police_station_number());
        holder.fire_service_number.setText(ward.get(position).getWard_fireService());
        Picasso.with(context).load(ward.get(position).getWard_img()).resize(150,150).into(holder.ward_image);
    }

    @Override
    public int getItemCount() {
        return ward.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView police_station_name, police_station_number, fire_service_number;
        private ImageView ward_image;
        public ViewHolder(View view) {
            super(view);

            police_station_name = (TextView) view.findViewById(R.id.police_station_name);
            police_station_number = (TextView) view.findViewById(R.id.police_station_number);
            fire_service_number = (TextView) view.findViewById(R.id.fireService_number);

            ward_image = (ImageView) view.findViewById(R.id.ward_img);

            //to add onclick listener
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, police_station_number.getText()+" is clicked.",Toast.LENGTH_SHORT).show();
        }
    }
}