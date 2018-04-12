# mockmvctest-ofspringboot-withmybatismapper

## this is a test demo for spring mock mvc.

* components of the project is below:

    >spring boot 2.0.0 Release
    
    >mybatis-spring-boot-starter 1.3.2
    
    >mybatis-spring-boot-starter-test 1.3.2
    
* 当前存在的问题 problems
    >can not test Service layer
    
    >can not process integration test, because exception [Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required] this is mybatis could't find by spring boot test.

    > spring mock mvc 的@WebMvcTest测试，无法自动注入mybatis的文件。
    
    >异常信息为：Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required  这就导致无法进行controller的集成测试。因为service层中会调用者mapper文件实现数据库操作。
 
    >service层测试暂时没有找到合适的实现方法   


*临时方案
>Mapper文件通过mybatis-spring-boot-starter-test进行单元测试，可以成功。代码中已经有示例

>controller中通过@AutoConfigureMybatis可以实现controller层调用service层的测试，但无法获取真实的数据库数据。

   