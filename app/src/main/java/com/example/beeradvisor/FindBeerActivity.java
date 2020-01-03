package com.example.beeradvisor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;

import static com.example.beeradvisor.R.layout.activity_find_beer;

public class FindBeerActivity extends AppCompatActivity {
    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_find_beer);
    }

    public void onClickFindBeer(View view){
        // get a reference to the textview
        TextView brands = (TextView) findViewById(R.id.brands);
        // get a refernce to the spinner
        Spinner color = (Spinner) findViewById(R.id.color);
        //get the selected item in the spinner
        String beerType = String.valueOf(color.getSelectedItem());
        //get the list of beers
        List<String> brandsList =expert.getBrands(beerType);
        //build a string using the values in the list
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand : brandsList){
            brandsFormatted.append(brand).append('\n');
        }
        // display the beers
        brands.setText(brandsFormatted);

    }
}
