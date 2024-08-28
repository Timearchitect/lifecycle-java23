package se.gritacademy.lifecycle;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
   private String[] sa;


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Alrik", "onStart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Alrik", "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Alrik", "onDestroy: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Alrik", "onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Alrik", "onResume: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Alrik", "onRestart: ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.textView3);
        ImageView iv = findViewById(R.id.stariv);
        Button b = findViewById(R.id.change);


        b.setOnClickListener( (e)-> {
            Toast.makeText(MainActivity.this,"Byt sida",Toast.LENGTH_LONG).show();

            Intent a2= new Intent(MainActivity.this,MainActivity2.class);
            startActivity( a2 );

         }
        );



        sa = getResources().getStringArray(R.array.system);

        tv.setText(sa[1]);
        tv.setTextColor(getResources().getColor(R.color.purple));
        tv.setTextColor(getResources().getColor(R.color.purple,getTheme()));
        tv.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.purple));
        iv.setAlpha(0.2f);
        iv.setRotationY(20);
        iv.setImageResource(R.drawable.moon);

        Typeface typeface = ResourcesCompat.getFont(MainActivity.this, R.font.wickedgrit);
        tv.setTypeface(typeface);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}