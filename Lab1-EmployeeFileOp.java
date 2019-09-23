package myprogram;

import java.io.*; 

public class EmployeeFileOp {

	
    public static void main(String[] args) { 
    	
    	int icount=0;
    	String line = "";
    	try { 
            File csv = new File("D:\\eclipse-workspace\\myprogram\\core_dataset.csv"); 
            BufferedReader br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) {  
            	icount++; 
            } 
            System.out.println(icount);
         //   System.out.println(line);
            br.close();

        } catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    	
    	
    	String[][] employeematrix = new String[icount][6];
    	String rline = new String("");
    	int i=0;
    	try { 
            File csv = new File("D:\\eclipse-workspace\\myprogram\\core_dataset.csv"); 
            BufferedReader br = new BufferedReader(new FileReader(csv));
            while ((rline = br.readLine()) != null) {
            	if (i==0) {
            		String[] data = rline.split(",");
            		employeematrix[i][0]=data[0];
                	employeematrix[i][1]=data[1];
                	employeematrix[i][2]=data[2];
                	employeematrix[i][3]=data[3];
                	employeematrix[i][4]=data[5];
                	employeematrix[i][5]=data[6];
                	System.out.println(employeematrix[i][0]+" "+employeematrix[i][1]+" "+employeematrix[i][2]+
                			" "+employeematrix[i][3]+" "+employeematrix[i][4]+" "+employeematrix[i][5]);
            	} else {
            		String[] data = rline.split(",");
            		StringBuffer sb = new StringBuffer(data[0]);
            		sb.append(data[1]);
            		String name = sb.toString();
            		employeematrix[i][0]=name;
            		employeematrix[i][1]=data[2];
                	employeematrix[i][2]=data[3];
                	employeematrix[i][3]=data[4];
                	employeematrix[i][4]=data[6];
                	employeematrix[i][5]=data[7];
                	System.out.println(employeematrix[i][0]+" "+employeematrix[i][1]+" "+employeematrix[i][2]+
                			" "+employeematrix[i][3]+" "+employeematrix[i][4]+" "+employeematrix[i][5]);
            	}
            	
            	i++;
            }         
            br.close();

        } catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } catch (IOException e) {  
            e.printStackTrace(); 
        } 
    	
    	
    	try {    		
            File csv = new File("D:\\eclipse-workspace\\myprogram\\young_employee.csv"); 
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
            bw.write("Employee Name"+","+"Employee Number"+","+"State"+","+"Zip"+","+"Age"+","+"Sex");
            for (int count=1; count<icount;count++) {
            //	System.out.println(employeematrix[count][5]);
            	int age =Integer.parseInt(employeematrix[count][4]);
            //	System.out.println(age);
            	if (age<=30) {
            		bw.newLine();
            		bw.write(employeematrix[count][0]+","+employeematrix[count][1]+","+employeematrix[count][2]+
                			","+employeematrix[count][3]+","+employeematrix[count][4]+","+employeematrix[count][5]);
            	}
            	
     
            }
       
            bw.close(); 
        } catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
  
             
        } 
     } 