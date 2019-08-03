package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

interface Drawable{  
    public void draw();  
} 

interface Addable{  
    int add(int a,int b);  
} 

class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        super();  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
}  

public class Lambda {

	public static void main(String[] args) {
		
		        int width=10;  
		  
		        //without lambda, Drawable implementation using anonymous class  
		        Drawable d=new Drawable(){  
		            public void draw(){System.out.println("Drawing "+width);}  
		        };  
		        d.draw();  
		        
		      //with lambda  
		        Drawable d2=()->{  
		            System.out.println("Drawing "+width);  
		        };  
		        d2.draw(); 
		        
		     // Multiple parameters in lambda expression  
		        Addable ad1=(a,b)->(a+b);  
		        System.out.println(ad1.add(10,20)); 
		        
		     //   In Java lambda expression, if there is only one statement, 
		     // you may or may not use return keyword. You must use return keyword when lambda expression contains multiple statements.
		        
		        Addable ad2=(a,b)->{return (a+b);};  
		        System.out.println(ad2.add(100,200)); 
		        
		        // foreach
		        
		        List<String> list=new ArrayList<String>();  
		        list.add("ankit");  
		        list.add("mayank");  
		        list.add("irfan");  
		        list.add("jai");  
		          
		        list.forEach(  
		            (count)->System.out.println(count)  
		        );  
		        
		        // runnable - we are implmenting run method this way
		        
		      //Thread Example without lambda  
		        Runnable r1=new Runnable(){  
		            public void run(){  
		                System.out.println("Thread1 is running...");  
		            }  
		        };  
		        Thread t1=new Thread(r1);  
		        t1.start();  
		        //Thread Example with lambda  
		        Runnable r2=()->{  
		                System.out.println("Thread2 is running...");  
		        };  
		        Thread t2=new Thread(r2);  
		        t2.start();  
		        
		        List<Product> products=new ArrayList<Product>();  
		          
		        //Adding Products  
		        products.add(new Product(1,"HP Laptop",25000f));  
		        products.add(new Product(3,"Keyboard",300f));  
		        products.add(new Product(2,"Dell Mouse",150f));  
		          
		        System.out.println("Sorting on the basis of name...");  
		  
		        // implementing lambda expression to sort 
		        Collections.sort(products,(first,second)->{  
		        return first.name.compareTo(second.name);  
		        });  
		        
		        products.forEach(  
			            (product)->System.out.println(product.name)  
			        );  
		        
		        // using lambda to filter data  
		        Stream<Product> filtered_products = products.stream().filter(product -> product.price > 200);  
		          
		        // using lambda to iterate through collection  
		        filtered_products.forEach(  
		                product -> System.out.println(product.name+": "+product.price)  
		        );  
		        
		    }  


	}

