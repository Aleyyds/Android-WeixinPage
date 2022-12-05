package ricardo.ale.fragmentandviewpage2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager2 viewPager;
    private LinearLayout lChar, lContacts, lFind, lProfile;
    private ImageView ivChar, ivContact, ivProfile, ivFind, ivCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPage();
        initTabView();
    }

    private void initTabView() {
        lChar = findViewById(R.id.id_btn_weixin);
        lChar.setOnClickListener(this);
        lContacts = findViewById(R.id.id_btn_contact);
        lContacts.setOnClickListener(this);

        lFind = findViewById(R.id.id_btn_find);
        lFind.setOnClickListener(this);

        lProfile = findViewById(R.id.id_btn_profile);
        lProfile.setOnClickListener(this);


        ivChar = findViewById(R.id.tab_iv_weixin);
        ivContact = findViewById(R.id.id_iv_concat);
        ivFind = findViewById(R.id.tab_iv_find);
        ivProfile = findViewById(R.id.tab_iv_profile);

        ivChar.setSelected(true);
        ivCurrent = ivChar;

    }

    private void initPage() {
        List<Fragment> fragmentList = new ArrayList<>();

        fragmentList.add(BlankFragment.newInstance("微信"));
        fragmentList.add(BlankFragment.newInstance("通讯录"));
        fragmentList.add(BlankFragment.newInstance("发现"));
        fragmentList.add(BlankFragment.newInstance("我"));

        viewPager = findViewById(R.id.id_viewpager);
        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager()
                , getLifecycle(), fragmentList);
        viewPager.setAdapter(pagerAdapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            /**
             * 滚动效果
             * @param position
             * @param positionOffset
             * @param positionOffsetPixels
             */
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            /**
             * 按钮选择
             * @param position
             */
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

    // viewPage滚动，导航栏随之滚动
    private void changeTab(int position) {
        ivCurrent.setSelected(false);
        switch (position) {
            case R.id.id_btn_weixin:
                viewPager.setCurrentItem(0);
            case 0:
                ivChar.setSelected(true);
                ivCurrent = ivChar;

                break;
            case R.id.id_btn_contact:
                viewPager.setCurrentItem(1);
            case 1:
                ivContact.setSelected(true);
                ivCurrent = ivContact;
                break;
            case R.id.id_btn_find:
                viewPager.setCurrentItem(2);
            case 2:
                ivFind.setSelected(true);
                ivCurrent = ivFind;
                break;
            case R.id.id_btn_profile:
                viewPager.setCurrentItem(3);
            case 3:
                ivProfile.setSelected(true);
                ivCurrent = ivProfile;
                break;
        }
    }

    @Override
    public void onClick(View view) {
        changeTab(view.getId());
    }
}