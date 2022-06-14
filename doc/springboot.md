
springboot 



##https://www.bilibili.com/video/BV1XL411P7R1?p=3 手写spring 框架


@Overridepublic void refresh() throws BeansException, IllegalStateException { synchronized (this.startupShutdownMonitor) {  
// 第一步:刷新前的预处理   prepareRefresh();  
//第二步: 获取BeanFactory并注册到 BeanDefitionRegistry  ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();  
// 第三步:加载BeanFactory的预准备工作(BeanFactory进行一些设置，比如context的类加载器等)  prepareBeanFactory(beanFactory);  try {    
// 第四步:完成BeanFactory准备工作后的前置处理工作     postProcessBeanFactory(beanFactory);    
// 第五步:实例化BeanFactoryPostProcessor接口的Bean     invokeBeanFactoryPostProcessors(beanFactory);    
// 第六步:注册BeanPostProcessor后置处理器，在创建bean的后执行     registerBeanPostProcessors(beanFactory);    
// 第七步:初始化MessageSource组件(做国际化功能;消息绑定，消息解析);     initMessageSource();    
// 第八步:注册初始化事件派发器     initApplicationEventMulticaster();    
// 第九步:子类重写这个方法，在容器刷新的时候可以自定义逻辑     onRefresh();    
// 第十步:注册应用的监听器。就是注册实现了ApplicationListener接口的监听器    registerListeners();    
//第十一步:初始化所有剩下的非懒加载的单例bean 初始化创建非懒加载方式的单例Bean实例(未设置属性)    finishBeanFactoryInitialization(beanFactory);    //第十二步: 完成context的刷新。主要是调用LifecycleProcessor的onRefresh()方法，完成创建    finishRefresh();    }  ……} 




Bean的作用域：


1.单例

2.prototype

3.request

4.session

5.global-session




Bean的生命周期

1.实例化

2.属性赋值

3.初始化
	BeanPostProcessor
	init_method

4.销毁


ApplicationContextAware(获取容器上下文，可以getBean.  classPath)

BeanPostProcessor (后置处理器)


##循环依赖问题

1.懒加载 

2.三级缓存



SpringBootApplication注解：

1.Configuration

2.EnableAutoConfiguration

3.ComponentScan



Spring Mvc

一次请求过程：

1.浏览器请求，请求dispatchservlet

2.dispatchservlet 找到对应的handlerMaping

3.选择对应的HandlerAdaptor,执行业务逻辑。

4.完成后，得到modelAndView.

5.ViewResolver 根据view,找到实际渲染的view.

6. dispatch 把 model 结合 view ,视图渲染。

7. 把view 返回请求者



spring 设计模式

https://mp.weixin.qq.com/s?spm=ata.21736010.0.0.70df75367cb4sc&__biz=Mzg2OTA0Njk0OA==&mid=2247485303&idx=1&sn=9e4626a1e3f001f9b0d84a6fa0cff04a&chksm=cea248bcf9d5c1aaf48b67cc52bac74eb29d6037848d6cf213b0e5466f2d1fda970db700ba41&token=255050878&lang=zh_CN%23rd

0.单例模式

1.工厂模式

2.代理设计模式

3.模板方法模式

4.观察者模式

spring 的 event的事件模型


5.访问者模式

lombok的注解实现方式，抽象语法树的访问








