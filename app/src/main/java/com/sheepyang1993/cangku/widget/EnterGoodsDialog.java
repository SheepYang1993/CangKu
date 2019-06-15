package com.sheepyang1993.cangku.widget;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sheepyang1993.cangku.R;
import com.sheepyang1993.cangku.adapter.EnterGoodsAdapter;
import com.sheepyang1993.sheepcommon.debug.DebugUtils;
import com.sheepyang1993.sheepcommon.utils.DialogUtil;
import com.sheepyang1993.sheepcommon.utils.ListUtil;
import com.sheepyang1993.sheepcommon.widget.BaseDialog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comsheepyang1993.sheepbmobcangku.api.GoodsApiHelper;
import comsheepyang1993.sheepbmobcangku.callback.Callback;
import comsheepyang1993.sheepbmobcangku.model.GoodsModel;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2019/6/11
 * 入库编辑弹窗
 */
public class EnterGoodsDialog extends BaseDialog {

    private final Activity mActivity;
    private Button btnCreateEnterList, btnEnterGoods;
    private EditText edtCreateEnterList;
    private RecyclerView recyclerview;
    private EnterGoodsAdapter mAdapter;

    public EnterGoodsDialog(@NonNull Activity activity) {
        super(activity);
        mActivity = activity;
    }

    @Override
    protected void initView(@NonNull Context context) {
        setContentView(R.layout.dialog_edit_goods);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(mActivity));
        mAdapter = new EnterGoodsAdapter();
        recyclerview.setAdapter(mAdapter);
        btnEnterGoods = findViewById(R.id.btnEnterGoods);
        edtCreateEnterList = findViewById(R.id.edtCreateEnterList);
        btnCreateEnterList = findViewById(R.id.btnCreateEnterList);
        btnCreateEnterList.setOnClickListener(v -> {
            createEnterList();
        });
        btnEnterGoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterGoods();
            }
        });
        if (DebugUtils.isShowDebugInfo()) {
            String text = "9058,灰橘,39*12:42.5*34:43*19\n" +
                    "9059,红黑,39*12:42.5*34:43*19\n" +
                    "1058,蓝色,39*12:42.5*34:43*19\n" +
                    "9258,白粉,39*12:42.5*34:43*19\n" +
                    "1238,灰分,39*12:42.5*34:43*19\n" +
                    "3218,黑白,39*12:42.5*34:43*19\n" +
                    "9548,棕色,39*12:42.5*34:43*19\n" +
                    "8768,灰粽,39*12:42.5*34:43*19";
            edtCreateEnterList.setText(text);
        }
    }

    private void enterGoods() {
        List<GoodsModel> list = mAdapter.getData();
        if (ListUtil.isEmpty(list)) {
            DialogUtil.showToastInfoDialog(mActivity, "请生成入库清单");
            return;
        }
        List<GoodsModel> updateList = new ArrayList<>();
        List<GoodsModel> createList = new ArrayList<>();
        for (GoodsModel model : list) {
            if (TextUtils.isEmpty(model.getBmobId())) {
                createList.add(model);
            } else {
                updateList.add(model);
            }
        }
        if (ListUtil.isEmpty(createList)) {
            GoodsApiHelper.updateGoods(updateList, new Callback<GoodsModel>() {
                @Override
                public void onStart() {

                }

                @Override
                public void onSuccess(GoodsModel data) {
                    DialogUtil.showToastSuccessDialog(mActivity, "入库成功");
                }

                @Override
                public void onError() {
                    DialogUtil.showToastFailDialog(mActivity, "入库失败\n请核对数据后再次入库");
                }

                @Override
                public void onFinish() {

                }
            });
        } else {
            GoodsApiHelper.addGoods(createList, new Callback<List<GoodsModel>>() {
                @Override
                public void onStart() {
                    DialogUtil.showLoadingDialog(mActivity, "正在入库...");
                }

                @Override
                public void onSuccess(List<GoodsModel> data) {
                    GoodsApiHelper.updateGoods(updateList, new Callback<GoodsModel>() {
                        @Override
                        public void onStart() {

                        }

                        @Override
                        public void onSuccess(GoodsModel data) {
                            DialogUtil.showToastSuccessDialog(mActivity, "入库成功");
                        }

                        @Override
                        public void onError() {
                            DialogUtil.showToastFailDialog(mActivity, "入库失败\n请核对数据后再次入库");
                        }

                        @Override
                        public void onFinish() {

                        }
                    });
                }

                @Override
                public void onError() {
                    DialogUtil.showToastFailDialog(mActivity, "入库失败\n请核对数据后再次入库");
                }

                @Override
                public void onFinish() {

                }
            });
        }
    }

    /**
     * 创建入库清单
     */
    private void createEnterList() {
        String text = edtCreateEnterList.getText().toString();
        if (TextUtils.isEmpty(text)) {
            DialogUtil.showToastFailDialog(mActivity, "请输入[入库文本]");
            return;
        }
        DialogUtil.showLoadingDialog(mActivity, "正在生成入库清单...");
        List<GoodsModel> list = parseGoodsList(text);
        checkCreated(list, new Callback<List<GoodsModel>>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(List<GoodsModel> data) {
                for (GoodsModel model : list) {
                    for (GoodsModel serverModel : data) {
                        if (model.equals(serverModel)) {
                            model.setBmobId(serverModel.getBmobId());
                            break;
                        }
                    }
                }
                DialogUtil.showToastSuccessDialog(mActivity, "生成入库清单成功");
                Collections.sort(list);
                mAdapter.setNewData(list);
            }

            @Override
            public void onError() {
                DialogUtil.showToastFailDialog(mActivity, "生成入库清单失败");
            }

            @Override
            public void onFinish() {

            }
        });
    }

    /**
     * 解析文本获取货品清单
     *
     * @param text
     * @return
     */
    private List<GoodsModel> parseGoodsList(String text) {
        List<GoodsModel> list = new ArrayList<>();
        String[] goodsArray = text
                .replace(" ", "")
                .replace("\t", "")
                .replace("，", ",")
                .replace("：", ":")
                .split("\n");
        for (String goods : goodsArray) {
            String[] item = goods.split(",");
            String modelId = item[0];
            String color = item[1];
            String[] sizeNumberArray = item[2].split(":");
            for (String sizeItem : sizeNumberArray) {
                String[] detail = sizeItem.split("[*]");
                String size = detail[0];
                String number = detail[1];
                GoodsModel model = new GoodsModel();
                model.setModelId(modelId);
                model.setColor(color);
                model.setSize(size);
                model.setNumber(Integer.valueOf(number));
                list.add(model);
            }
        }
        return list;
    }

    /**
     * 检查数据库是否已经创建了该型号的数据，没有就要新建
     *
     * @param list
     * @return
     */
    private void checkCreated(List<GoodsModel> list, Callback<List<GoodsModel>> callback) {
        GoodsApiHelper.checkCreated(list, callback);
    }
}
