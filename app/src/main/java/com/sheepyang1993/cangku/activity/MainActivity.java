package com.sheepyang1993.cangku.activity;

import android.support.v4.app.Fragment;

import com.sheepyang1993.cangku.R;
import com.sheepyang1993.sheepcommon.activity.BaseTabActivity;
import com.sheepyang1993.sheepcommon.fragment.BlankFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseTabActivity {

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

    @Override
    protected void initData() {

    }
}
