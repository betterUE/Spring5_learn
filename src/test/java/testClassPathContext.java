import org.junit.Test;
import com.test.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testClassPathContext {
    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        //这种方式创建的对象，需要强制转换
        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
    }

    @Test
    public void test2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //这种方法创建的对象，不需要强制转换
        Person person = ctx.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void test3(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //配置文件中定义的bean class,只能有一个是 Person 类型，
        Person bean = ctx.getBean(Person.class);
        System.out.println(bean);
    }

    @Test
    public void test4(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取所有bean的名称，也就是定义的id
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println(beanDefinitionNames[i]);
        }
    }

    @Test
    public void test5(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //根据 bean class 类型，获取所有的 id 值
        String[] beanNamesForType = ctx.getBeanNamesForType(Person.class);
        for (int i = 0; i < beanNamesForType.length; i++) {
            System.out.println(beanNamesForType[i]);
        }
    }

}
