package cs272lab3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class EmployeeSet implements Cloneable{
	
	/* define instance variables */
	private String[] data;
	private int manyItems;
	
	/* A no-argument constructor for initializing */
	public EmployeeSet()
	{
		final int INITIAL_CAPACITY = 10;
		manyItems = 0;
		data = new String[INITIAL_CAPACITY];
	}
	
	public EmployeeSet(int initialCapacity)
	{
		if(initialCapacity < 0)
			throw new IllegalArgumentException
			("initialCapacity is negative: " + initialCapacity);
		manyItems = 0;
		data = new String[initialCapacity];
	}
	
	/* A method to add one Employee object to a collection */
	public void add(String element)
	{
		if (manyItems == data.length)
		{
			ensureCapacity(manyItems*2 + 1);
		}
		data[manyItems] = element;
		manyItems++;
	}
	
	/* A copy constructor */
    public EmployeeSet(Object obj) {
    	if((obj!=null)&&(obj instanceof EmployeeSet)) {
    		EmployeeSet loc = (EmployeeSet) obj;
    		this.manyItems = loc.manyItems;
    		for(int x = 0; x < manyItems; x++) 
    		{
    			this.data[x] = new String(loc.data[x]);
    		}
    		
    	}   	
    }
    
    /* A method of ensureCapacity */
    private void ensureCapacity(int minimumCapacity)
    {
    	String[] biggerArray;
    	if (data.length < minimumCapacity)
    	{
    		biggerArray = new String[minimumCapacity];
    		System.arraycopy(data,0,biggerArray,0,manyItems);
    		data = biggerArray;
    	}
    }
    
    
    
    /* define a Employee class which will be used to test remove and check methods */
    static class Employee {
    	
    	/* Instance Variables */
    	private String name;
    	private int no;

    	/* One no-argument constructor for initializing instance variables */
    	public Employee() {
    		name = null;
    		no = 0;
    	}

        public void setname(String pname) {
        	this.name = pname;
        }
        
        public void setno(int pno) {
        	this.no = pno;
        }
        
        public String getname() {
        	return this.name;
        }
     
        public int getno() {
        	return this.no;
        }
        
        public String toString() {
        	return name+" "+no;
        }
      
    }
        	
    /* a check method to determine whether a no belongs to a certain employee */
    public static boolean check(final String employeestring, final int no) {
    	String[] employ = employeestring.split(",");
    	boolean result = false;
    	if (Integer.parseInt(employ[2]) == no)
    	{
    		result = true;
    	}
    	return result;
    }
    
    /* a contain method to determine whether a certain employee belongs to the bag based on his/her no */
    public boolean contains(Employee a) {
    	boolean check = false;
    	if((a!=null)&&(a instanceof Employee)) {
    		for(int y = 0 ; y < manyItems; y++) {
    			if(EmployeeSet.check(data[y], a.no) == true) { /* call the check method */
    				check = true;
    				break;
    			}
    		}
    	}
    return check;	
    }
    
    
    /* A method to return the actual number of elements in the collection */
    public int size()
    {
    	return manyItems;
    }
    
    /* A method to return the capacity of the collection */
    public int getCapacity()
    {
    	return data.length;
    }
    
    /* A method to find the index of an employee who has the no entered */
    public int findindex(final String[] employeedata, final int no) {
    	int index = 0;
    	int[] nolist = new int[employeedata.length];
    	for(int i = 0; i < employeedata.length; i++) {
    		String[] employlist = employeedata[i].split(",");
    		nolist[i]=Integer.parseInt(employlist[2]);
    	}
    	
    	for(int i = 0; i < employeedata.length; i++) {
    		if(nolist[i] == no) {
    			index = i;
    		}
    	}
    return index;	
    }
    
    /* A remove method to remove an employee based on the no entered */
    public boolean remove(int eno) {
    	int index = 0;
    	while((index < manyItems)&&(index != eno))
    		index++;
    	if(index == manyItems)
    		return false;
    	else
    	{
    		manyItems--;
    		data[index] = data[manyItems];
    		return true;
    	}	
    }
    
    /* sort the ons of all the employee */
    public int[] order(final String[] employeedataa) {
    	int[] nolistt = new int[employeedataa.length];
    	for(int i = 0; i < employeedataa.length; i++) {
    		String[] employlist = employeedataa[i].split(",");
    		nolistt[i]=Integer.parseInt(employlist[2]);
    	}
    	Arrays.sort(nolistt);
    	return nolistt; 
    }
    
          

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Create three EmployeeSets */
		EmployeeSet a = new EmployeeSet(); /* will hold all the employee information from the given CSV file */
		EmployeeSet removetest = new EmployeeSet(); /* will be used for testing the remove method */
		EmployeeSet oddered = new EmployeeSet(); /* will hold all the employee information with an ascending no  */
		
		
		String rline = new String("");
    	int i=0;
    	
    	/* Open the CSV file and store all the information in sets a and removetest */ 
    	try { 
            File csv = new File("D:\\eclipse-workspace\\cs272lab3\\core_dataset.csv"); 
            BufferedReader br = new BufferedReader(new FileReader(csv));
            while ((rline = br.readLine()) != null) {
            	if (i==0) {
            	} else {
            		a.add(rline);
            		removetest.add(rline);
            	}
            	i++;
            }
            br.close(); 
    	}catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
    	
    	/* Create two Employee objects */
    	Employee t1 = new Employee(); /* For testing the contains method  */
    	t1.setname("Zhang Peng");
    	t1.setno(11);
    	
    	Employee t2 = new Employee(); /* For testing the contains method and remove method */
    	t2.setname("Zhang Hai");
    	t2.setno(1406068403);
    	
    	/* Print the two Employee objects  */
    	System.out.println("The two created Employees are:");
    	System.out.println(t1);
    	System.out.println(t2);
    	System.out.println();
    	

    	System.out.println("The size of Employee bag a:");
      	System.out.println(a.size());
      	System.out.println();
      	
      	/* Determine the index of a certain employee who has the same no as the Employee object needed to be removed*/
      	int find = 0;
      	String[] ddata = new String[a.size()];
      	for(int j=0;j<a.size();j++) {
      		ddata[j] = a.data[j];
      	}      	
      	find = removetest.findindex(ddata,t2.getno());
      	/* The index of the employee whose no is 1406068403*/
      	System.out.println("The index of the employee whose no is (t2) 1406068403 is: ");
      	System.out.println(find);
      	System.out.println();
      	removetest.remove(find);
      	System.out.println("The size of Employee bag removetest after remove t2:");
      	System.out.println(removetest.size());
      	System.out.println();
      	System.out.println("Does set a contain t1:");
      	System.out.println(a.contains(t1));
      	System.out.println();
      	System.out.println("Does set a contain t2:");
      	System.out.println(a.contains(t2));
      	
      	String[] ddataa = new String[a.size()];
      	for(int t=0;t<a.size();t++) {
      		ddataa[t] = a.data[t];
      	}
      	int[] orderedno = a.order(ddataa);
      	for(int m=0;m<a.size();m++) {
      		int orderedindex = 0;
      		orderedindex = a.findindex(ddata, orderedno[m]);
      		oddered.add(ddata[orderedindex]);
      	}
      	
      	/* Creat a new csv file named removed_employee to store the employee list with t2 removed*/
      	try {    		
            File csv = new File("D:\\eclipse-workspace\\cs272lab3\\removed_employee.csv"); 
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
            bw.write("Employee Name"+","+"Employee Number"+","+"State"+","+"Zip"+","+"Age"+","+"Sex"+","+"MaritalDesc"+","+"CitizenDesc"+","+"Hispanic/Latino"+","+"RaceDesc"+","+"Date of Birth"+","+"Data of Termination"+","+"Reason For Term"+","+"Employment Status"+","+"Department"+","+"Position"+","+"Pay Rate"+","+"Manager Name"+","+"Employee Source"+","+"Performance Score");
            for (int count=0; count<removetest.size();count++) {
            		bw.newLine();
            		bw.write(removetest.data[count]);
            	}
           bw.close(); 
        } catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
      	
      	/* Creat a new csv file named ordered_employee to store the employee list with an ascending no*/
      	try {    		
            File csv = new File("D:\\eclipse-workspace\\cs272lab3\\ordered_employee.csv"); 
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
            bw.write("Employee Name"+","+"Employee Number"+","+"State"+","+"Zip"+","+"Age"+","+"Sex"+","+"MaritalDesc"+","+"CitizenDesc"+","+"Hispanic/Latino"+","+"RaceDesc"+","+"Date of Birth"+","+"Data of Termination"+","+"Reason For Term"+","+"Employment Status"+","+"Department"+","+"Position"+","+"Pay Rate"+","+"Manager Name"+","+"Employee Source"+","+"Performance Score");
            for (int count=0; count<a.size();count++) {
            		bw.newLine();
            		bw.write(oddered.data[count]);
            	}
           bw.close(); 
        } catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
      	
    }
}
