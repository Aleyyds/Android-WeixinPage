package ricardo.ale.fragmentmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btn);
        button.setOnClickListener(this);

        Button button2 = findViewById(R.id.btn2);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
                Bundle bundle = new Bundle();
                bundle.putString("message","人民万岁");
                BlankFragment1 bf = new BlankFragment1();
                bf.setArguments(bundle);
                bf.setCallback(new IFragmentCallback() {
                    @Override
                    public void sendMsgToActivity(String msg) {
                        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public String getMsgFromActivity(String msg) {
                        return "hello, I'm from activity";
                    }
                });
                replaceFragment(bf);
                break;
            case R.id.btn2:
                replaceFragment(new ItemFragment());
        }
    }

    //  动态切换fragment
    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentlayout, fragment);
        fragmentTransaction.commit();
    }
}