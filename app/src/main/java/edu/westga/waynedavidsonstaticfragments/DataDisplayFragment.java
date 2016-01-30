package edu.westga.waynedavidsonstaticfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataDisplayFragment extends Fragment {
    private TextView productText;
    private double number1;
    private double number2;
    private double product;

    private DataDisplayListener listener;

    interface DataDisplayListener{
        void onDataDisplay();
    }

    public DataDisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_data_display, container, false);

        final Button addButton = (Button) theView.findViewById(R.id.button2);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addButtonClicked(v);
            }
        });

        this.productText = (TextView) theView.findViewById(R.id.productText);

        return theView;
    }

    private void addButtonClicked(View v) {
        listener.onDataDisplay();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (DataDisplayListener)context;
    }

    public void multiply() {
        this.product = this.number1 * this.number2;
    }

    public void displayProduct() {
        this.productText.setText(String.valueOf(this.product));
    }

    public double getNumber1(){
        return number1;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public double getNumber2(){
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }
}
