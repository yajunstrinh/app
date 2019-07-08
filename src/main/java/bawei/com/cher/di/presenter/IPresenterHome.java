package bawei.com.cher.di.presenter;

import bawei.com.cher.data.Bean;
import bawei.com.cher.di.IConstans.IConstansHome;
import bawei.com.cher.di.model.IModelHome;

/*
 *@Auther:张亚军
 *@Date: 2019/7/8
 *@Time:10:55
 *@Description:15901514581
 * */public class IPresenterHome implements IConstansHome.IPresenterHome<IConstansHome.IViewHome> {
     IConstansHome.IViewHome iViewHome;
    private IModelHome iModelHome;

    @Override
    public void attachHoem(IConstansHome.IViewHome iViewHome) {
             this.iViewHome=iViewHome;
        iModelHome = new IModelHome();
    }

    @Override
    public void detachHome() {
        iModelHome=null;
    }

    @Override
    public void getResultHome(int page) {
          iModelHome.resultHome(page,new IConstansHome.IModelHome.CallBackHome() {
              @Override
              public void reponsHome(Bean bean) {
                  iViewHome.showHome(bean);
              }
          });
    }
}
