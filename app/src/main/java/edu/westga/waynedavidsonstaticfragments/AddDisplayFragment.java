package edu.westga.waynedavidsonstaticfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddDisplayFragment extends Fragment {
    private TextView totalText;
    private double number1;
    private double number2;
    private double total;

    public AddDisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_add_display, container, false);

        this.totalText = (TextView) theView.findViewById(R.id.totalText);

        return theView;
    }

    public void add() {
        this.total = this.number1 + this.number2;
    }

    public void displayTotal() {
        this.totalText.setText(String.valueOf(this.total));
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
