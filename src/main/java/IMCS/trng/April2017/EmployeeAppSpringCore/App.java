package IMCS.trng.April2017.EmployeeAppSpringCore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import IMCS.trng.April2017.EmployeeAppSpringCore.EmployeeServiceImplementation.EmployeeServiceImplementation;

import IMCS.trng.April2017.EmployeeAppSpringCore.config.ApplicationConfiguration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
        ApplicationContext appContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        EmployeeServiceImplementation employeeService = appContext.getBean(EmployeeServiceImplementation.class);
        employeeService.findAllEmployees();
    }
}
