package edu.westga.waynedavidsonstaticfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataEntryFragment extends Fragment {
    private EditText number1;
    private EditText number2;
    private DataEntryListener listener;

    interface DataEntryListener{
        void onDataEntry(double number1, double number2);
    }

    public DataEntryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_data_entry_fragent, container, false);
        this.number1 = (EditText) theView.findViewById(R.id.editTextNumber1);
        this.number2 = (EditText) theView.findViewById(R.id.editTextNumber2);

        final Button multiplyButton = (Button) theView.findViewById(R.id.button);
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                multiplyButtonClicked(v);
            }
        });
        return theView;
    }

    public double getNumber1() {
        return Double.parseDouble(this.number1.getText().toString());
    }

    public double getNumber2() {
        return Double.parseDouble(this.number2.getText().toString());
    }

    private void multiplyButtonClicked(View v) {
        double number1 = Double.parseDouble(this.number1.getText().toString());
        double number2 = Double.parseDouble(this.number2.getText().toString());

        listener.onDataEntry(number1, number2);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (DataEntryListener)context;
    }
}
