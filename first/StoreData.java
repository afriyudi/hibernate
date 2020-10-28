package com.javatpoint.mypackage;  
  
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import com.javatpoint.mypackage.Employee;
import java.util.List;
import java.util.Iterator; 
  
import org.hibernate.HibernateException; 

public class StoreData {  

 public List<Employee> listEmployees1( ){
     
    
      

      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      List<Employee> tmp=null;
      
      try {
         tx = session.beginTransaction();
         List employees = session.createQuery("FROM Employee").list(); 
          tmp= session.createQuery("FROM Employee").list();
         System.out.println("000");

         for (Iterator iterator = employees.iterator(); iterator.hasNext();){
 System.out.println("001");
            Employee employee = (Employee) iterator.next(); 
             try{
            // tmp.add(employee);
               } catch(Exception ee){ee.printStackTrace();}
             System.out.print("id: " + employee.getId()); 
            System.out.print("First Name: " + employee.getFirstName()); 
            System.out.print("  Last Name: " + employee.getLastName()); 

             
         }  
          
         tx.commit();
      } 
        catch (HibernateException e) {
System.out.println( "error");
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close();

      }
      return tmp; 
   }



public static void main(String[] args) {  
      
      StoreData dao=new StoreData();
      List<Employee> emp=dao.listEmployees1( );
     System.out.println(emp);
      emp.forEach(x -> System.out.println(x.getId()+" "+x.getFirstName()+" "+x.getLastName()));

 
}  

} 
