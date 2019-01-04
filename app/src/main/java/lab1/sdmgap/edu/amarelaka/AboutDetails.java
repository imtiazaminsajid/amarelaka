package lab1.sdmgap.edu.amarelaka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutDetails extends AppCompatActivity {

    private TextView pStationName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_details);

        pStationName = findViewById(R.id.pStationName);

        Intent intent=getIntent();

        String police_stationName = intent.getExtras().getString("PoliceStationName");

        pStationName.setText(police_stationName);

    }
}
