##### 1、背景

​		基于chrome浏览器定制化插件开发，实现代码注入。



##### 2、实现步骤

  1. 新建一个自定义文件夹<img src=".\chrome插件开发.assets\image-20220310100032425.png" alt="image-20220310100032425" style="zoom:100%;" />

     

     

  2. 在当前文件夹下面建立一个 `manifest.json` 文件(这个文件用于chrome识别自定义插件的基本信息)<img src=".\chrome插件开发.assets\image-20220310100321922.png" alt="image-20220310100321922" style="zoom:50%;" />

     

  3. 打开 `manifest.json` 文件，在其中写入以下内容并保存

     ```javascript
     {
         "name": "Chrome Pop",           // 插件名称
         "version": "1.0",               // 插件版本
         "description": "Chrome pop.",   // 插件描述
         "manifest_version": 2,          // 清单版本，必须是2或者3
         "content_scripts": [{
             "matches": ["<all_urls>"],  // 匹配所有地址
             "js": ["pop.js"],           // 注入的代码文件名和路径，如果有多个，则依次注入
             "all_frames": true,         // 允许将内容脚本嵌入页面的所有框架中
             "permissions": ["tabs"],    // 权限申请，tabs 表示标签
             "run_at": "document_start"  // 代码注入的时间
         }]
     }
     ```

     

  4. 如上述内容所示，现在chrome会读取和加载 `pop.js` 中的脚本内容到页面

     

  5. 现在我们在当前目录下新建一个为 `pop.js` 文件<img src="D:\Projects\Document\chrome插件\chrome插件开发.assets\image-20220310101321735.png" style="zoom:80%;" />

     

  6. 编辑 `pop.js` 文件，写入我们自定义的脚本内容。eg: 此次我们让chrome打开每一个页面进行一次时间弹窗效果

     ```javascript
     var pop = function() {
         'use strict';
         alert(new Date());
     }
     var hook_tab = document.createElement('script');
     hook_tab.textContent = '(' + pop + ')()';
     (document.head || document.documentElement).appendChild(hook_tab);
     hook_tab.parentNode.removeChild(script);
     ```

     

  7. 将我们的上面定义的`pop`文件夹直接拖入到打开的chrome的扩展页面中，开启开关，这个错误提示表示当前的版本号不建议使用，本次演示可以忽略<img src=".\chrome插件开发.assets\image-20220310110134247.png" style="zoom:80%;" />

     

  8. 打开新的chrome页面查看效果<img src=".\chrome插件开发.assets\image-20220310110349401.png" style="zoom:80%;" />

##### 3、总结

​		可以基于chrome的插件开发进行许多自动化的功能实现，如若有一个系统是我们每天都需要用，但每一天登录频率过高。可以基于url路径配置进行监听到指定页面实现自动登录效果。

​		本次只是一个简单的演示，感兴趣的可以围绕这这个入口进行开发和扩展提高自己效率的功能插件。