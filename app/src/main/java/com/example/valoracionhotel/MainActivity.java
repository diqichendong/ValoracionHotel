package com.example.valoracionhotel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener {

    private List<RatingBar> rtBars;
    private List<TextView> lblStars;
    private TextView lblMedia;
    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rtBars = new ArrayList<>();
        rtBars.add(findViewById(R.id.rt1));
        rtBars.add(findViewById(R.id.rt2));
        rtBars.add(findViewById(R.id.rt3));
        rtBars.add(findViewById(R.id.rt4));
        rtBars.add(findViewById(R.id.rt5));
        rtBars.add(findViewById(R.id.rt6));
        rtBars.add(findViewById(R.id.rt7));

        lblStars = new ArrayList<>();
        lblStars.add(findViewById(R.id.lblStars1));
        lblStars.add(findViewById(R.id.lblStars2));
        lblStars.add(findViewById(R.id.lblStars3));
        lblStars.add(findViewById(R.id.lblStars4));
        lblStars.add(findViewById(R.id.lblStars5));
        lblStars.add(findViewById(R.id.lblStars6));
        lblStars.add(findViewById(R.id.lblStars7));

        lblMedia = findViewById(R.id.lblMedia);

        btnReset = findViewById(R.id.btnReset);

        for (RatingBar rb : rtBars) {
            rb.setOnRatingBarChangeListener(this);
        }

        btnReset.setOnClickListener(v -> reset());
    }

    @Override
    public void onRatingChanged(RatingBar rb, float rating, boolean fromUser) {
        double suma = 0;

        for (int i = 0; i < lblStars.size(); i++) {
            suma += rtBars.get(i).getRating();
            lblStars.get(i).setText((int) rtBars.get(i).getRating() + "");
        }

        lblMedia.setText(String.format("%.2f", suma / rtBars.size()));
    }

    private void reset() {
        for (RatingBar rb : rtBars) {
            rb.setRating(0);
        }
    }
}