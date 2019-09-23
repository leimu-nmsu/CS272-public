import java.util.Arrays;

public class Employee implements Cloneable{
	
	/* Instance Variables */
	private String name;
	private int no;
	private int age;
	private String state;
	private int zip;
	private int[] advisor;
	
	/* One no-argument constructor for initializing instance variables */
	public Employee() {
		name = null;
		no = 0;
		age = 0;
		state = null;
		zip = 0;
		//advisor = new int[]{0,0,0};
		advisor=null;
	}

	/* One copy constructor */
    public Employee(Object obj) {
    	if((obj!=null)&&(obj instanceof Employee)) {
    		Employee loc = (Employee) obj;
    		this.name = new String(loc.name);
    		this.no = loc.no;
    		this.age = loc.age;
    		this.state = new String(loc.state);
    		this.zip = loc.zip;
    		this.advisor = loc.advisor;
    	}   	
    }
    
    /* get methods */
    public String getname() {
    	return this.name;
    }
 
    public int getno() {
    	return this.no;
    }
    
    public int getage() {
    	return this.age;
    }
    
    public String getstate() {
    	return this.state;
    }
    
    public int getzip() {
    	return this.zip;
    }
    
    public int[] getadvisor() {
    	return this.advisor;
    }
    
    
    /* set methods */
    public void setname(String pname) {
    	this.name = pname;
    }
    
    public void setno(int pno) {
    	this.no = pno;
    }
    
    public void setage(int page) {
    	this.age = page;
    }
    
    public void setstate(String pstate) {
    	this.state = pstate;
    }
    
    public void setzip(int pzip) {
    	this.zip = pzip;
    }
    
    public void setadvisor(int[] padvisor) {
    	int inumber=padvisor.length;
    	for (int i=0;i<inumber;i++) {
    		this.advisor[i]=padvisor[i];
    	}
    }	
    	
    /* toString() methods */
    public String toString() {
    	int ladvisor = advisor.length;
    	if (ladvisor == 1) {
    		return name+" "+no+" "+age+" "+state+" "+zip+" "+advisor[0];
    	}else if (ladvisor == 2) {
    		return name+" "+no+" "+age+" "+state+" "+zip+" "+advisor[0]+" "+advisor[1];
    	}else {
    		return name+" "+no+" "+age+" "+state+" "+zip+" "+advisor[0]+" "+advisor[1]+" "+advisor[2];
    	}
    }

    /* equals method */
    public boolean equals(Object obj) {
    	if((obj!=null)&&(obj instanceof Employee)) {
    	Employee loc = (Employee) obj;
    	return (loc.no == no);
    	}
    	else
    		return false;
    }	
    
    /* Create a new method to check if an integer array contains a certain integer value  */
    public static boolean check(final int[] array, final int v) {
    	boolean result = false;
    	for(int i : array) {
    		if(i == v) {
    			result = true;
    			break;
    		}
    	}
    	return result;
    }
    
    
    public static int[] getAllAdvisors(Employee e1, Employee e2) {
    	int[] dif = new int[6]; 
    	int count = 0;
    	int[] first = e1.getadvisor();
    	int[] second = e2.getadvisor();
    	int x = first.length;
    	int y = second.length;
    	if ((e1 != null)&&(e2 != null)) {
    		for(int i = 0; i < x; i++) {
    			if(Employee.check(second, first[i]) == false) { /* call the check method created  */
    				dif[count] = first[i];
    				count=count + 1;
    			}
    		}
            
    		for(int j = 0; j < y; j++) {
    			if(Employee.check(first, second[j]) == false) {/* call the check method created  */
    				dif[count] = second[j];
    				count=count + 1;
    			}
    		}
    	}
    	int[] dis = new int[count];
    	for(int k = 0; k < count; k++) {
			dis[k]=dif[k];
		}
    	return dis;
    	}
    	
    	
	
public static void main(String[] args) { /* main method*/
	/* Create employee 1 */
	Employee t1 = new Employee();
	t1.setname("Zhang Peng");
	t1.setno(11);
	t1.setage(22);
	t1.setstate("NM");
	t1.setzip(88001);
	t1.advisor= new int[2];
	t1.advisor[0]= 8;
	t1.advisor[1]= 10;
	
	
	/* Create employee 2 */
	Employee t2 = new Employee();
	t2.setname("Mu Lei");
	t2.setno(14);
	t2.setage(21);
	t2.setstate("OH");
	t2.setzip(36005);
	t2.advisor= new int[3];
	t2.advisor[0]= 11;
	t2.advisor[1]= 10;
	t2.advisor[2]= 12;
	
	/* Create employee 3 */
	Employee t3 = new Employee();
	t3.setname("Hu Lei");
	t3.setno(11);
	t3.setage(26);
	t3.setstate("OH");
	t3.setzip(36009);
	t3.advisor= new int[3];
	t3.advisor[0]= 11;
	t3.advisor[1]= 14;
	t3.advisor[2]= 17;
	
	/* Print the information of the three employees */
	System.out.println(t1);
	System.out.println(t2);
	System.out.println(t3);
	
	/* Check equality based on employee no */
	System.out.println("t1.equal(t2)?: "+t1.equals(t2));
	System.out.println("t1.equal(t3)?: "+t1.equals(t3));
	
	/* Print advisor lists of employees */
	System.out.println("employee 1's advisors: "+Arrays.toString(t1.getadvisor()));
	System.out.println("employee 2's advisors: "+Arrays.toString(t2.getadvisor()));
	System.out.println("employee 3's advisors: "+Arrays.toString(t3.getadvisor()));
	
	/* Find the distinct advisors between employee 1 and employee 3*/
	System.out.println();
	System.out.println("The DISTINCT advisor between employee 1 and employee 3:");
  	System.out.println(Arrays.toString(Employee.getAllAdvisors(t1, t3)));
  	
  	/* Find the distinct advisors between employee 1 and employee 2*/
  	System.out.println();
	System.out.println("The DISTINCT advisor between employee 1 and employee 2:");
  	System.out.println(Arrays.toString(Employee.getAllAdvisors(t1, t2)));
	
	}
    }



