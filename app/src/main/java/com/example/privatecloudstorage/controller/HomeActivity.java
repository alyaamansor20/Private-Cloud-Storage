package com.example.privatecloudstorage.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.privatecloudstorage.Fragment1;
import com.example.privatecloudstorage.Fragment2;
import com.example.privatecloudstorage.MainAdapter;
import com.example.privatecloudstorage.R;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {
    //initialization
    TabLayout tabLayout;
    ViewPager viewPager;

    private String mSelectedGroupName;
    private String mSelectedGroupKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //put the grou name in action bar
        Bundle bundle = getIntent().getExtras();
        if(bundle == null)
            finish();
        mSelectedGroupName = bundle.getString("selectedGroupName");
        mSelectedGroupKey = bundle.getString("selectedGroupKey");
        getSupportActionBar().setTitle(mSelectedGroupName);

        //assign variables
        tabLayout=findViewById(R.id.tab_Layout);
        viewPager=findViewById(R.id.view_pager);

        //ArrayList<String>arrayList=new ArrayList();
        //arrayList.add("Shared Files");
        //arrayList.add("Group Members");
        tabLayout.setupWithViewPager(viewPager);

        MainAdapter mainAdapter=new MainAdapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mainAdapter.addFragment(new Fragment1(),"SHARED FILES");
        mainAdapter.addFragment(new Fragment2(),"MEMBERS");

        viewPager.setAdapter(mainAdapter);

        //prepareViewPagger(viewPager,arrayList);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.setting_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Item 1 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "Item 2 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "Item 3 selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}