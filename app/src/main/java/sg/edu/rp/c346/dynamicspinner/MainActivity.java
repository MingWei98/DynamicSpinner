package sg.edu.rp.c346.dynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1;
    Spinner spn2;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.buttonUpdate);

        // Initialise the ArrayList
        alNumbers = new ArrayList<>();

        // -- Approach 1: Adding item to ArrayList --
//        alNumbers.add("2");
//        alNumbers.add("4");
//        alNumbers.add("6");

        // -- Approach 2: Adding item to ArrayList --
        //Get the string-array and store as an Array
        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
        //Convert Array to List and add to the ArrayList
        alNumbers.addAll(Arrays.asList(strNumbers));

        // Create an ArrayAdapter using the default Spinner layout and the ArrayList
        aaNumbers = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);

        // Bind the ArrayAdapter to the Spinner
        spn2.setAdapter(aaNumbers);

        // Implement the button onClick() method
        // to load the correct number list when it is clicked

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();

                if (pos == 0){
                    // Approach 1:
//                    alNumbers.add("1");
//                    alNumbers.add("3");
//                    alNumbers.add("5");

                    // Approach 2:
                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                    aaNumbers.notifyDataSetChanged();


                }
                else{
                    // Approach 1:
//                    alNumbers.add("1");
//                    alNumbers.add("3");
//                    alNumbers.add("5");

                    // Approach 2:
                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                    aaNumbers.notifyDataSetChanged();
                }
            }
        });

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        // Code for item 1 selected (even)
                        alNumbers.clear();
                        String[] even = getResources().getStringArray(R.array.even_numbers);
                        alNumbers.addAll(Arrays.asList(even));
                        // Setting the spinner item position (2) == 6 [2,4,6]
                        spn2.setSelection(2);
                        aaNumbers.notifyDataSetChanged();
                        break;

                    case 1:
                        // Code for item 2 selected (odd)
                        alNumbers.clear();
                        String[] odd = getResources().getStringArray(R.array.odd_numbers);
                        alNumbers.addAll(Arrays.asList(odd));
                        // Setting the spinner item position (1) == 3 [1,3,5]
                        spn2.setSelection(1);
                        aaNumbers.notifyDataSetChanged();
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
