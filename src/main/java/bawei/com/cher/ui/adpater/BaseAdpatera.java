package bawei.com.cher.ui.adpater;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import bawei.com.cher.R;
import bawei.com.cher.data.Bean;

/*
 *@Auther:张亚军
 *@Date: 2019/7/8
 *@Time:11:31
 *@Description:15901514581
 * */   public class BaseAdpatera extends BaseQuickAdapter<Bean.DataBean,BaseViewHolder> {
    public BaseAdpatera(int layoutResId, @Nullable List<Bean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Bean.DataBean item) {
              helper.setText(R.id.text,item.getText());
        ImageView view = helper.getView(R.id.image);
        Glide.with(mContext).load(item.getImage1()).into(view);
    }
}
