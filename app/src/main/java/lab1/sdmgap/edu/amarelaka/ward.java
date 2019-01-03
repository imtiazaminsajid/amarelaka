package lab1.sdmgap.edu.amarelaka;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import lab1.sdmgap.edu.amarelaka.R;

public class ward extends Fragment {

    private final String policeStation[] = {
            "Gulshan",
            "Mohakhali",
            "Banani",
            "Korail"
    };

    private final String policeStationNumber[] = {
            "01677006082",
            "01515209606",
            "01715533712",
            "01720278202"
    };

    private final String fireServiceNumber[] = {
            "01977006082",
            "01315209606",
            "01215533712",
            "01420278202"
    };

    private final String ward_image[] = {
            "https://vignette2.wikia.nocookie.net/peridot0/images/2/28/Pink_frosted_sprinkled_donut.png",
            "http://vignette4.wikia.nocookie.net/logopedia/images/d/d8/Andorid-2.3-Gingerbread-logo.png",
            "http://www.pngmart.com/files/4/Android-PNG-Photos.png",
            "http://goodereader.com/blog/uploads/images/android-froyo.png"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_ward, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Ward");
        initViews();
    }

    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)getView().findViewById(R.id.wardRecycleView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList ward = prepareData();
        CustomAdapter adapter = new CustomAdapter(getContext(),ward);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList prepareData(){
        ArrayList ward = new ArrayList<>();
        for(int i=0;i<policeStation.length;i++){
            WardDataModel wardDataModel = new WardDataModel();
            wardDataModel.setWard_police_station_name(policeStation[i]);
            wardDataModel.setWard_fireService(fireServiceNumber[i]);
            wardDataModel.setWard_police_station_number(policeStationNumber[i]);
            wardDataModel.setWard_img(ward_image[i]);
            ward.add(wardDataModel);
        }
        return ward;
    }
}
