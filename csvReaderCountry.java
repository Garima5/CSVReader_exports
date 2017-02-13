/**
 * Program that reads data from different countries to gives reports on different exports
 * 
 *
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class csvRead {

 public void listexporters(CSVParser parser, String exportOfInterest) {

  for (CSVRecord record: parser) {
   String
   export = record.get("Exports");
   if (
    export.contains(exportOfInterest)) {

    String country = record.get("Country");
    System.out.println(country);



   }
  }
 }
 public int numberOfExporters(CSVParser parser, String exportOfInterest) {
  int sum = 0;
  for (CSVRecord record: parser) {
   String
   export = record.get("Exports");
   if (
    export.contains(exportOfInterest)) {

    sum = sum + 1;



   }
  }
  return sum;
 }
 public void bigExporters(CSVParser parser, String value) {
  int sum = 0;
  //double v=Double.parseDouble(value);
  for (CSVRecord record: parser) {
   String value1 = record.get("Value (dollars)");

   if (value1.contains(value)) {

    String country = record.get("Country");
    System.out.println(country + value1);
    sum = sum + 1;
    System.out.println("Total Countries with big exports : " + sum);



   }
  }

 }

 public void listExportersTwoProducts(CSVParser parser, String exportOfInterest1, String exportOfInterest2) {
  for (CSVRecord record: parser) {
   String
   export = record.get("Exports");
   if (
    export.contains(exportOfInterest1) &&
    export.contains(exportOfInterest2)) {

    String country = record.get("Country");
    System.out.println(country);



   }
  }


 }
 public String countryInfo(CSVParser parser, String country) {
  int flag = 0;
  String exports = "", value = "";
  for (CSVRecord record: parser) {
   String country1 = record.get("Country");
   if (record.get("Country").equals(country)) {

    exports = record.get("Exports");

    flag = 1;
    break;



   }

  }
  if (flag == 1) {
   //return country+":"+exports+":"+value;
   return country + ":" + exports + ":";
  } else {
   return "Not Found";
  }


 }
 public void WhoExports() {
  FileResource fr = new FileResource();
  CSVParser parser = fr.getCSVParser();
  listexporters(parser, "gold"); //Gives the countries that export gold

 }
 public void tester() {
  FileResource fr = new FileResource();
  CSVParser parser = fr.getCSVParser();
  listExportersTwoProducts(parser, "cotton", "flowers"); //Gives list of countries that export cotton and flower

 }
 public void tester_number() {
  FileResource fr = new FileResource();
  CSVParser parser = fr.getCSVParser();
  int sum = numberOfExporters(parser, "cocoa");
  System.out.println(sum); //Gives number of countries that export cococoa

 }
 public void tester_country() {
  FileResource fr = new FileResource();
  CSVParser parser = fr.getCSVParser();
  String info = countryInfo(parser, "India");
  System.out.println(info);

 }

}
