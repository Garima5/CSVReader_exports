
/**
 * Write a description of csvReaderCountry here.
 * Prrogram to read record files of exports of countries and retrieve data using CSV reader
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class csvReaderCountry {
    public void listexporters(CSVParser parser,String exportOfInterest)
    {//prints the countries that export the product
        
        for(CSVRecord record:parser)
        {
            String export=record.get("Exports");
            if(export.contains(exportOfInterest))
            {
        
             String country=record.get("Country");
             System.out.println(country);    
             
        
        
            }
        }
    }  
    public int numberOfExporters(CSVParser parser,String exportOfInterest)
    {
        //returns number of countries that export the product
        int sum=0;
        for(CSVRecord record:parser)
        {
            String export=record.get("Exports");
            if(export.contains(exportOfInterest))
            {      
             sum=sum+1;          
        
        
            }
        }
        return sum;
    }  
    public void bigExporters(CSVParser parser,String value)
    {
        //prints the countries whose exports are greater than the speciifed value
        int sum=0;
        
        for(CSVRecord record:parser)
        {
            String value1=record.get("Value (dollars)");
            
            if(value1.contains(value))
            {
        
             String country=record.get("Country");
             System.out.println(country+value1);    
             sum=sum+1;
             System.out.println("Total Countries with big exports : "+sum);
             
        
        
            }
        }
        
    }  
   
    public void listExportersTwoProducts (CSVParser parser,String exportOfInterest1,String exportOfInterest2){
        //prints the countirs that export both the products
        for(CSVRecord record:parser)
        {
            String export=record.get("Exports");
            if(export.contains(exportOfInterest1)&&export.contains(exportOfInterest2) )
            {
        
             String country=record.get("Country");
             System.out.println(country);    
             
        
        
            }
        }
        
        
    }
    public String countryInfo(CSVParser parser,String country)
    {
        //returns all the products exported by the country
        int flag=0;
        String exports="",value="";
        for(CSVRecord record:parser)
        {
            String country1=record.get("Country");
            if (record.get("Country").equals(country))
            {
        
              exports=record.get("Exports");
              
             flag=1;
             break;
            
        
            }
            
        }
        if(flag==1)
        {
            
            return country+":"+exports+":";
        }
            else
            {
                return "Not Found";
            }
        
        
    }
    public void WhoExports()
    {
        //returns list of countries who export the product
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();
        listexporters(parser,"gold");
        
    }
    public void tester()
    {
        //Returns the name of countries that export the products
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();
        listExportersTwoProducts(parser,"cotton","flowers");
        
    }
     public void tester_number()
    {
        //returns number of countries that export the product
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();
        int sum=numberOfExporters(parser,"cocoa");
        System.out.println(sum);
        
    }
    public void tester_country()
    {
        //returns the resources exported by the country
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();
        String info=countryInfo(parser,"India");
        System.out.println(info);
        
    }
}