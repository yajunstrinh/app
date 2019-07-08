package bawei.com.cher.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.header.WaterDropHeader;
import com.scwang.smartrefresh.header.WaveSwipeHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.footer.FalsifyFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import bawei.com.cher.R;
import bawei.com.cher.data.Bean;
import bawei.com.cher.di.IConstans.IConstansHome;
import bawei.com.cher.di.presenter.IPresenterHome;
import bawei.com.cher.ui.adpater.BaseAdpatera;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IConstansHome.IViewHome {

    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.sfl)
    SmartRefreshLayout sfl;
    private IPresenterHome iPresenterHome;
    private BaseAdpatera baseAdpatera;
    private int page=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        iPresenterHome = new IPresenterHome();
        iPresenterHome.attachHoem(this);
        iPresenterHome.getResultHome(page);



        sfl.setRefreshHeader(new WaveSwipeHeader(this));
        sfl.setRefreshFooter(new BallPulseFooter(this));
        sfl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                    page=1;
iPresenterHome.getResultHome(page);
                sfl.finishRefresh();
            }
        });
        sfl.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                iPresenterHome.getResultHome(page);
                sfl.finishLoadMore();
            }
        });
    }

    @Override
    public void showHome(Bean bean) {
        List<Bean.DataBean> data = bean.getData();

        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, true);
            recycleView.setLayoutManager(manager);
            baseAdpatera = new BaseAdpatera(R.layout.adpater,data);
            recycleView.setAdapter(baseAdpatera);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iPresenterHome.detachHome();
    }
}
