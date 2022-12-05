package ricardo.ale.fragmentandviewpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager2 viewPager;

    private LinearLayout llChat, llContacts, llFind, llProfile;
    private ImageView ivChat, ivContacts, ivFind, ivProfile, ivCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPage();
        initTabView();
    }

    // 处理UI更新
    private void initTabView() {
        llChat = findViewById(R.id.id_tab_weixin);
        llChat.setOnClickListener(this);

        llContacts = findViewById(R.id.id_tab_concat);
        llContacts.setOnClickListener(this);

        llFind = findViewById(R.id.id_tab_find);
        llFind.setOnClickListener(this);

        llProfile = findViewById(R.id.id_tab_profile);
        llProfile.setOnClickListener(this);

        ivChat = findViewById(R.id.tab_iv_weixin);
        ivContacts = findViewById(R.id.tab_iv_concat);
        ivFind = findViewById(R.id.tab_iv_find);
        ivProfile = findViewById(R.id.tab_iv_profile);

        ivChat.setSelected(true);  //
    }

    private void initPage() {

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(BlankFragment.newInstance("微信聊天"));
        fragmentList.add(BlankFragment.newInstance("通讯录"));
        fragmentList.add(BlankFragment.newInstance("发现"));
        fragmentList.add(BlankFragment.newInstance("我"));

        viewPager = findViewById(R.id.id_viewPage);
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), getLifecycle(), fragmentList);
        viewPager.setAdapter(adapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void changeTab(int position) {
        switch (position) {
            case 0:
                ivChat.setSelected(true);
                break;
            case 1:
                ivContacts.setSelected(true);
                break;
            case 2:
                ivFind.setSelected(true);
                break;
            case 3:
                ivProfile.setSelected(true);
                break;
        }
    }

    @Override
    public void onClick(View view) {
        changeTab(view.getId());
    }
}