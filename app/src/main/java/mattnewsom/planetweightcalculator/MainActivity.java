package mattnewsom.planetweightcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button mButton;
    EditText mEdit;
    Planet mPlanet;

    public static ArrayList storePlanetsArray(double mass) {
        ArrayList<Double> mPlanetList = new ArrayList<>();


        mPlanetList.add(0, Planet.MERCURY.surfaceWeight(mass));
        mPlanetList.add(1, Planet.VENUS.surfaceWeight(mass));
        mPlanetList.add(2, Planet.EARTH.surfaceWeight(mass));
        mPlanetList.add(3, Planet.MARS.surfaceWeight(mass));
        mPlanetList.add(4, Planet.JUPITER.surfaceWeight(mass));
        mPlanetList.add(5, Planet.SATURN.surfaceWeight(mass));
        mPlanetList.add(6, Planet.URANUS.surfaceWeight(mass));
        mPlanetList.add(7, Planet.NEPTUNE.surfaceWeight(mass));

        return mPlanetList;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void calcbutton(View view) {
        mButton = (Button) findViewById(R.id.calcButt);
        mEdit = (EditText) findViewById(R.id.massInput);
        ArrayList displayArray;

        if (mEdit.getText().toString().matches("")) {
            Toast.makeText(this, "Enter a number, fool. This is no time for the philosophical interpretation of mass.", Toast.LENGTH_LONG).show();
            return;
        }

        Double mass;
        double earthWeight = Double.parseDouble(mEdit.getText().toString());
        mass = earthWeight / Planet.EARTH.surfaceGravity();

        displayArray = storePlanetsArray(mass);
        setContentView(R.layout.data_display);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.data_display);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);

        RecyclerView.Adapter<MyAdapter.ViewHolder> mAdapter = new MyAdapter(displayArray);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }


}
