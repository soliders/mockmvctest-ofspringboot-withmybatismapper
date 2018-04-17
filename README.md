# mockmvctest-ofspringboot-withmybatismapper

## this is a test demo of use spring mock mvc to integration test controller with real DB.

* basic components of the project is below:

    >spring boot 2.0.0 Release
    
    >mybatis-spring-boot-starter 1.3.2
    
    >mybatis-spring-boot-starter-test 1.3.2

* explain

   >@AutoConfigureMybatis
   
   when you want to use spring mock mvc to integration test controller with real db, and you use mybatis to manipulate db, you shoud use this annotation to import basic mybatis test components.
   The @MybatisTest annotation couldn't use together with @WebMvcTest, if you use together, the exception **java.lang.IllegalStateException: Configuration error: found multiple declarations of @BootstrapWith for test class** will be appear. 
   
   >@Import(TestServiceImpl.class)
   
   with this annotation you can use the real service which include real operations of the real db, and 
   your integration test will be **JUnit <-> MockMvc <-> DispatcherServlet <-> Controller <-> Service <-> Mapper <-> DB**
   
   you wouldn't use the @MockBean of [SpringBoot offical recommended ](https://spring.io/guides/gs/testing-web/) if you use that annotation ,you integration test will be JUnit <-> MockMvc <-> DispatcherServlet <-> Controller ~~<-> Service <-> Mapper <-> DB~~
   
   >@SpyBean
   
   you can also don't use the @Import(xxx.class) in integration test, you can use the spring boot feature, the annotation
   @SpyBean. With @SpyBean, if you don't stubbing the specific method, it will use the real method of the really service. So, if your integration
   test include a real Service Class, you can you @SpyBean in field to include the real Service Class.just like this:

```java
@SpyBean
private NameServiceImpl nameServiceImpl;
```
   
   
   >@WebMvcTest(TestController.class)
    
    With this annotation, Spring Boot only instantiation the specific controller on the web layer, not instantiating the whole context.
    So you can improve you working efficiency, because you don't  need to wait long time when you test you code. If no integration test, when you want to test you code,you must running the whole project, if 
    the project is big enough, once initiating will be take a long time to wait.  
   
* references

[Spring Boot Reference Guide about MockBean](https://docs.spring.io/spring-boot/docs/2.0.1.RELEASE/reference/htmlsingle/#boot-features-testing-spring-boot-applications-mocking-beans)

[Spring Boot, Getting Started Testing the Web Layer](https://spring.io/guides/gs/testing-web/)

[Exception which appeared in my testing, it already solved.](https://github.com/mybatis/spring-boot-starter/issues/227)


  
 * Special Thanks （特别感谢）：
  https://github.com/kazuki43zoo