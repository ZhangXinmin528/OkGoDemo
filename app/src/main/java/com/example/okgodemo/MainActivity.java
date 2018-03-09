package com.example.okgodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.okgodemo.callback.MultiJsonCallback;
import com.example.okgodemo.callback.SimapleJsonCallback;
import com.example.okgodemo.model.ModelA;
import com.example.okgodemo.model.ModelB;
import com.example.okgodemo.model.ModelC;
import com.example.okgodemo.model.UserInfo;
import com.example.okgodemo.response.LazyResponse;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mResultTv;//运行结果
    private ProgressBar mLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_typeA).setOnClickListener(this);
        findViewById(R.id.btn_typeB).setOnClickListener(this);
        findViewById(R.id.btn_typeC).setOnClickListener(this);
        findViewById(R.id.btn_typeD).setOnClickListener(this);

        mResultTv = (TextView) findViewById(R.id.tv_result);
        mLoading = (ProgressBar) findViewById(R.id.loading);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_typeA:
//                getDataAInSimple();
                getDataAMultiple();
                break;
            case R.id.btn_typeB:
//                getDataBInSimple();
                getDataBMultiple();
                break;
            case R.id.btn_typeC:
//                getDataCInSimple();
                getDataCMultiple();
                break;
            case R.id.btn_typeD:
                getDataD();
                break;
        }
    }

    /**
     * 获取数据类型A
     */
    private void getDataAInSimple() {
        OkGo.<ModelA>get("https://easy-mock.com/mock/59c2251ee0dc663341b18beb/OkGoTest/DataTypeA")
                .execute(new SimapleJsonCallback<ModelA>() {

                    @Override
                    public void onStart(Request<ModelA, ? extends Request> request) {
                        super.onStart(request);
                        mLoading.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onSuccess(Response<ModelA> response) {
                        ModelA model = response.body();
                        if (model != null) {
                            mResultTv.setText(model.toString());
                        }
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        mLoading.setVisibility(View.GONE);
                    }
                });
    }

    /**
     * 获取数据类型A
     */
    private void getDataAMultiple() {
        OkGo.<LazyResponse<UserInfo>>get("https://easy-mock.com/mock/59c2251ee0dc663341b18beb/OkGoTest/DataTypeA")
                .execute(new MultiJsonCallback<LazyResponse<UserInfo>>() {

                    @Override
                    public void onStart(Request<LazyResponse<UserInfo>, ? extends Request> request) {
                        super.onStart(request);
                        mLoading.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onSuccess(Response<LazyResponse<UserInfo>> response) {
                        LazyResponse lazyResponse = response.body();
                        if (lazyResponse != null) {
                            mResultTv.setText(lazyResponse.toString());
                        }
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        mLoading.setVisibility(View.GONE);
                    }
                });
    }

    /**
     * 获取数据类型B
     */
    private void getDataBInSimple() {
        OkGo.<ModelB>get("https://easy-mock.com/mock/59c2251ee0dc663341b18beb/OkGoTest/DataTypeB")
                .execute(new SimapleJsonCallback<ModelB>() {
                    @Override
                    public void onStart(Request<ModelB, ? extends Request> request) {
                        super.onStart(request);
                        mLoading.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onSuccess(Response<ModelB> response) {
                        ModelB model = response.body();
                        if (model != null) {
                            mResultTv.setText(model.toString());
                        }
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        mLoading.setVisibility(View.GONE);
                    }
                });
    }

    /**
     * 获取数据类型B
     */
    private void getDataBMultiple() {
        OkGo.<LazyResponse<List<UserInfo>>>get("https://easy-mock.com/mock/59c2251ee0dc663341b18beb/OkGoTest/DataTypeB")
                .execute(new MultiJsonCallback<LazyResponse<List<UserInfo>>>() {
                    @Override
                    public void onStart(Request<LazyResponse<List<UserInfo>>, ? extends Request> request) {
                        super.onStart(request);
                        mLoading.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onSuccess(Response<LazyResponse<List<UserInfo>>> response) {
                        LazyResponse lazyResponse = response.body();
                        if (lazyResponse != null) {
                            mResultTv.setText(lazyResponse.toString());
                        }
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        mLoading.setVisibility(View.GONE);
                    }
                });
    }

    /**
     * 获取数据类型C
     */
    private void getDataCInSimple() {
        OkGo.<ModelC>get("https://easy-mock.com/mock/59c2251ee0dc663341b18beb/OkGoTest/DataTypeC")
                .execute(new SimapleJsonCallback<ModelC>() {

                    @Override
                    public void onStart(Request<ModelC, ? extends Request> request) {
                        super.onStart(request);
                        mLoading.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onSuccess(Response<ModelC> response) {
                        ModelC info = response.body();
                        if (info != null) {
                            mResultTv.setText(info.toString());
                        }
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        mLoading.setVisibility(View.GONE);
                    }
                });
    }

    /**
     * 获取数据类型C
     */
    private void getDataCMultiple() {
        OkGo.<LazyResponse<UserInfo>>get("https://easy-mock.com/mock/59c2251ee0dc663341b18beb/OkGoTest/DataTypeC")
                .execute(new MultiJsonCallback<LazyResponse<UserInfo>>() {

                    @Override
                    public void onStart(Request<LazyResponse<UserInfo>, ? extends Request> request) {
                        super.onStart(request);
                        mLoading.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onSuccess(Response<LazyResponse<UserInfo>> response) {
                        LazyResponse lazyResponse = response.body();
                        if (lazyResponse != null) {
                            mResultTv.setText(lazyResponse.toString());
                        }
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        mLoading.setVisibility(View.GONE);
                    }
                });
    }

    /**
     * 获取数据类型D
     */
    private void getDataD() {
        OkGo.<String>get("https://easy-mock.com/mock/59c2251ee0dc663341b18beb/OkGoTest/DataTypeD")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                    }
                });
    }


}
