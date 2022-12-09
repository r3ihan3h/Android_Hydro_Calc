package com.example.reihaneh_a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getCanonicalName();
    TextView header_title;
    TextView onPeakUsage;
    TextView offPeakUsage;
    TextView midPeakUsage;
    TextView hydroConsumption;
    TextView hydroConsumptionV;
    TextView onPeakCharge;
    TextView onPeakChargeV;
    TextView offPeakCharge;
    TextView offPeakChargeV;
    TextView midPeakCharge;
    TextView midPeakChargeV;
    TextView totalRegCharge;
    TextView totalRegChargeV;
    TextView hst;
    TextView hstV;
    TextView provencialRebate;
    TextView provencialRebateV;
    TextView totalBill;
    TextView totalBillV;
    EditText txt_inp1;
    EditText txt_inp2;
    EditText txt_inp3;
    EditText txt_inp4;



    Button bt_clc;
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_clc = findViewById(R.id.bt_clc);

        //refrence to UI
        header_title = findViewById(R.id.header_title);
        onPeakUsage = findViewById(R.id.tv_onPeakUsage);
        offPeakUsage = findViewById(R.id.tv_offPeakUsage);
        midPeakUsage = findViewById(R.id.tv_midPeakUsage);
        hydroConsumption = findViewById(R.id.tv_hydroConsumption);
        hydroConsumptionV = findViewById(R.id.tv_hydroConsumptionV);
        onPeakCharge = findViewById(R.id.tv_onPeakCharge);
        onPeakChargeV = findViewById(R.id.tv_onPeakChargeV);
        offPeakCharge = findViewById(R.id.tv_offPeakCharge);
        offPeakChargeV = findViewById(R.id.tv_offPeakChargeV);
        midPeakCharge = findViewById(R.id.tv_midPeakCharge);
        midPeakChargeV = findViewById(R.id.tv_midPeakChargeV);
        totalRegCharge = findViewById(R.id.tv_totalRegCharge);
        totalRegChargeV = findViewById(R.id.tv_totalRegChargeV);
        hst = findViewById(R.id.tv_hst);
        hstV = findViewById(R.id.tv_hstV);
        provencialRebate = findViewById(R.id.tv_provencialRebate);
        provencialRebateV = findViewById(R.id.tv_provencialRebateV);
        totalBill = findViewById(R.id.tv_totalBill);
        totalBillV = findViewById(R.id.tv_totalBillV);


        txt_inp1 = findViewById(R.id.text_input1);
        txt_inp2 = findViewById(R.id.text_input2);
        txt_inp3 = findViewById(R.id.text_input3);

        bt_clc.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                double onPeakCharge = 0;
                double offPeakCharge = 0;
                double midPeakCharge = 0;
                double hydrocharge = 0;
                double hstcharge = 0;
                double proCharge = 0;
                double RegChargeT = 0;
                double on_peak = Double.parseDouble(txt_inp1.getText().toString());
                double off_peak = Double.parseDouble(txt_inp2.getText().toString());
                double mid_peak= Double.parseDouble(txt_inp3.getText().toString());

                if (onPeakUsage.getText().equals("On-peak usage")) {
                    onPeakCharge = on_peak * 0.132;
                    onPeakChargeV.setText(String.valueOf("$" + onPeakCharge));

                }

                if (offPeakUsage.getText().equals("Off-peak usage")) {
                    offPeakCharge = off_peak * 0.065;
                    offPeakCharge = (double) Math.round(offPeakCharge * 100d) / 100d;
                    offPeakChargeV.setText(String.valueOf("$" + offPeakCharge));
                }


                if (midPeakUsage.getText().equals("Mid-peak usage")) {
                    midPeakCharge = mid_peak * 0.094;
                    midPeakCharge = (double) Math.round(midPeakCharge * 100d) / 100d;
                    midPeakChargeV.setText(String.valueOf("$" + midPeakCharge));

                }


                if (hydroConsumption.getText().equals("Hydro Consumption Charges")) {

                    hydrocharge = (double) Math.round((onPeakCharge + offPeakCharge + midPeakCharge) * 1000d) / 1000d;
                    hydroConsumptionV.setText(String.valueOf("$" + hydrocharge));
                }

                if (hst.getText().equals("HST")) {
                    hstcharge = (double) Math.round((hydrocharge * 0.13) * 100d) / 100d;
                    hstV.setText((String.valueOf("$" + hstcharge)));
                }
                if (provencialRebate.getText().equals("Provencial Rebate")) {
                    proCharge = (double) Math.round((hydrocharge * 0.08) * 100d) / 100d;
                    provencialRebateV.setText((String.valueOf("$" + proCharge)));
                }

                if (totalRegCharge.getText().equals("Total Regulatory Charges")) {
                    RegChargeT = (double) Math.round(hstcharge - proCharge);
                    totalRegChargeV.setText(String.valueOf("$" + RegChargeT));
                }
                if (totalBill.getText().equals("Total Bill amount To Pay")) {
                    double BillT =(double) Math.round( hydrocharge + RegChargeT);
                    totalBillV.setText((String.valueOf("$" + BillT)));
                }

            }

        });
    }

}