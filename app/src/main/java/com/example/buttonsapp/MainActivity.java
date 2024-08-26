package com.example.buttonsapp;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Enable edge-to-edge display

        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            ConstraintLayout cl = findViewById(R.id.main);
            TextView tv = findViewById(R.id.label);
            tv.setText("Jag heter Alrik!"); // Setting text on a TextView

            Button b = findViewById(R.id.button);
            Button b2 = new Button(MainActivity.this);
            b2.setX(300);
            b2.setY(400);
            cl.addView(b2); // Adding button to the main layout

            b.setText("Click here!!!"); // Setting text on Button 1
            b2.setText("dont click!"); // Setting text on Button 2

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "HEJSAN", Toast.LENGTH_LONG).show();
                    Log.d("Alrik", "Click!!!");
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Clicked button 2!", Toast.LENGTH_SHORT).show();
                    Log.d("Alrik", "Button 2 Clicked!");
                }
            });

            b.setBackgroundColor(Color.rgb(255, 255, 0)); // Setting background color for Button 1
            Log.i("Alrik", "" + Color.red(Color.YELLOW)); // Logging color information
            String text = "Hello, world!";
            Log.println(Log.DEBUG, "Alrik", text); // System.out.println equivalent
            Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show(); // Show a Toast with text
            return insets;
        });


    }
}
