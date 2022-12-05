package ricardo.ale.viewpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager = findViewById(R.id.viewpage);
        ViewPage2Adapter viewPage2Adapter = new ViewPage2Adapter();
        viewPager.setAdapter(viewPage2Adapter);

    }
}