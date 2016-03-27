# StretchListView（仿人人车可伸缩的listView）


## 一、概述
仿人人车卖车可伸展滑动的listView，自定义了StretchLayout来包裹上层的布局（listView）和底层的布局（GridLayout），总体思路是，提供了一个对外的接口，来判断最外层的listView是否需要TouchEvent事件，如果不需要就StretchLayout来拦截事件并处理TouchEvent事件，反之正常的listView滑动。现在做的还有些粗糙，后期还会完善。
##二、演示

<p><img src="http://7xrdbm.com1.z0.glb.clouddn.com/StretchListView%E6%BC%94%E7%A4%BA%E5%9B%BE.gif" width="48%" />
<img src="http://7xrdbm.com1.z0.glb.clouddn.com/%E4%BA%BA%E4%BA%BA%E8%BD%A6%E6%BC%94%E7%A4%BA%E5%9B%BE.gif" width="48%" /></p>
