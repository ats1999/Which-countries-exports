package test;

import edu.duke.*;
import org.apache.commons.csv.*;
public class WhichCountryExports {
	
	void countryInfo(CSVParser parser,String country) {
		/*
		 * This method prints the information about the country specified by the parameter country
		 * if there is no such country it simply prints "NOT FOUND"
		 * @param parser,country
		 */
		String export="";
		
		// Generating records
		for(CSVRecord record:parser) {
			 export=record.get("Country");
		
			 //if record contains specified country in the argument then print info..
			if(export.contains(country)) {
				System.out.println(record.get("Country")+":"+record.get("Exports")+","+record.get("Value (dollars)"));
			}
		}
	}
	
	void listExportersTwoProducts(CSVParser parser,String exportItem1 ,String exportItem2) {
	/*
	 * This method list the companies who have both exportItem1 and exportItem2 as 
	 * their exports
	 */
		String export="";
		for(CSVRecord record:parser) {
			 export=record.get("Exports");
			
			 // if any particular records contains both items as export then print country
			if(export.contains(exportItem1)&&export.contains(exportItem2))
				System.out.println(record.get("Country"));
			
		}
	}
	
	int numberOfExporters(CSVParser parser,String exportItem) {
		
		/*
		 * This method returns the number of countries that export exportItem. 
		 * @param exportItem 
		 * @return integer
		 */
		String export="";
		int count=0;
		for(CSVRecord record:parser) {
			 export=record.get("Exports");
		
			 // if records contains particular item then count
			if(export.contains(exportItem)) {
				count++;
			}
		}
		return count;
	}
	
	void bigExporters(CSVParser parser,String amount) {
		/*
		 * This method prints the names of countries and their Value amount for all countries whose Value (dollars) string is longer than the amount string. 
		 */
		String export="";
		for(CSVRecord record:parser) {
			 export=record.get("Value (dollars)");
		
			 // compare the length of argument string with the record string
			if(export.length()>amount.length()) {
				System.out.println(record.get("Country")+"  "+record.get("Value (dollars)"));
			}
		}
		
	}
	
	public static void main(String[] args) {
		WhichCountryExports obj=new WhichCountryExports();
		
		FileResource fr=new FileResource("exportdata.csv");
		CSVParser parser=fr.getCSVParser();
		
		//System.out.println("Country information");
		//obj.countryInfo( parser,"Nauru");
		//System.out.println();
		
		/*System.out.println("List of Exporters of Two Products");
		parser=fr.getCSVParser();
		obj.listExportersTwoProducts(parser,"diamonds" ,"gold");
		System.out.println();
		*/
		
		/*parser=fr.getCSVParser();
		int i=obj.numberOfExporters(parser,"sugar");
		System.out.println("Number of exporters is: "+i);
		System.out.println();
		*/
		
		//System.out.println("Big Exporters   ..........");
		parser=fr.getCSVParser();
		obj.bigExporters(parser,"$999,999,999,999");
	}

}
