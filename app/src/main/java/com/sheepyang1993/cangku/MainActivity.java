package com.sheepyang1993.cangku;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sheepyang1993.sheepcommon.activity.CommMainTabActivity;
import com.sheepyang1993.sheepcommon.fragment.BlankFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends CommMainTabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initData() {

    }

    @Override
    public List<Fragment> initFragment() {
        setToolbarTitle(getString(R.string.fragment_one_title));
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(BlankFragment.newInstance(getString(R.string.fragment_one_title), getString(R.string.fragment_one_content)));
        fragmentList.add(BlankFragment.newInstance(getString(R.string.fragment_two_title), getString(R.string.fragment_two_content)));
        fragmentList.add(BlankFragment.newInstance(getString(R.string.fragment_three_title), getString(R.string.fragment_three_content)));
        fragmentList.add(BlankFragment.newInstance(getString(R.string.fragment_four_title), getString(R.string.fragment_four_content)));
        return fragmentList;
    }
}
