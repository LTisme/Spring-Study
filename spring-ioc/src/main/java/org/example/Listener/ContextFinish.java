package org.example.Listener;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

/**
 * @Date: 2023/9/12
 * @Author: Administrator
 * @ClassName: ContextFinish
 * @Description: 容器自带一些标准事件，比如容器加载完毕事件，会在容器加载完毕后自动发布，所以这里做一个监听，在容器加载完毕时会自动触发
 */

public class ContextFinish {

    @EventListener
    public void load(ContextRefreshedEvent event){
        System.out.println("Container now is all loaded.");
    }
}
