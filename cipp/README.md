---
title: 'CIPP'
date: 2021-02-03
author: 王雅军
---

### 校园信息发布平台（CIPP）
### Campus Information Publishing Platform



#### 待解决问题
- 用户注册失败未给提示信息, return map Vue未接受到 (已解决)

   原代码:
   
   ```
  this.$message.error(res.data.message);
  ```
  
  改用:
  
  改用:
  
  ```
  that.$message.error(res.data.message);
  ```
  
  
  

#### 待优化完善问题

- 用户注册模式单一，后期添加短信方式

#### 代码待优化问题
- dao层代码优化，考虑使用MyBatis-plus或者MyBatis Generate,将sql语句转移到xml中

#### 问题记录
- Vue项目启动访问本地Json出错，检查target等路径是否错误，因为Vue本地启动的端口可能不是10001，要注意启动时的端口信息
​```asp
'/bdapi': {
    		 target: 'http://localhost:10001/',  //目标接口域名
    		 changeOrigin: true,  //是否跨域
    		 pathRewrite: {
    			'^/bdapi': '/static/json'   ,//重写接口
    			}
    	  }
  
  ```
  
  ```
