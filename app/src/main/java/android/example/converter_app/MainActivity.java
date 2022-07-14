package android.example.converter_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView mSecondaryTitle;
    EditText mEnterInches;
    Button mConverterButton;
    TextView mResults;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        setUpOnClickListener();



    }

    private void setUpOnClickListener() {
        mConverterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double givenInches = convertToMeters();
                displayResults(givenInches);
            }
        });
    }


    private double convertToMeters(){

        /*
        Converts the inches to meters
         */

        String sInches = mEnterInches.getText().toString();

        double dResult;

        if (sInches.isEmpty()){
            dResult = 0.00;
            Toast.makeText(this,"Please enter a measurement",Toast.LENGTH_LONG).show();
        }
        else{
            int iInches = Integer.parseInt(sInches);
            dResult = iInches/39.97;

        }

        return dResult;


    }

    private void displayResults(double measurement) {

        /*
        displays the results in the result textView
         */


        DecimalFormat formatter = new DecimalFormat("0.00");
        String formattedResults = formatter.format(measurement);

        mResults.setText("          Results = " + formattedResults + "m");
    }

    private void findViews() {

        mSecondaryTitle = findViewById(R.id.secondaryTitle);
        mEnterInches = findViewById(R.id.enterInches);
        mConverterButton = findViewById(R.id.converterButton);
        mResults = findViewById(R.id.results);
    }
}