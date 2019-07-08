package bawei.com.cher.di.IConstans;

import bawei.com.cher.data.Bean;

/*
 *@Auther:张亚军
 *@Date: 2019/7/8
 *@Time:10:49
 *@Description:15901514581
 * */public interface IConstansHome {
    /**
     * V层
     */
    public interface IViewHome{
         public void showHome(Bean bean);

     }

    /**
     * P层
     */
    public interface IPresenterHome<IViewHome>{
         public void attachHoem(IViewHome iViewHome);
         public void detachHome();
         public void getResultHome(int page);
     }
    /**
     * M层
     */
    public interface IModelHome{
        public void resultHome(int page,CallBackHome callBackHome);
        public interface CallBackHome{
            public void reponsHome(Bean bean);
        }
    }
}
