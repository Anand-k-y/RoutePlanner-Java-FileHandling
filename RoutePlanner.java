package miniproject;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class RoutePlanner {

	RouteInfo []routes= new RouteInfo[5];
	
	public RouteInfo[] readRouteInfos()throws IOException {
		FileReader reader = new FileReader("routes.csv");
		String line;
		Scanner scan = new Scanner(reader);
		int index = 0;
		while(scan.hasNextLine()) {
			line=scan.nextLine();
			String []routeInfoString = line.split(",");
			String from = routeInfoString[0].trim();
			String to = routeInfoString[1].trim();
			String distance = routeInfoString[2].trim();
			String duration = routeInfoString[3].trim();
			String airFare = routeInfoString[4].trim();
			RouteInfo route = new RouteInfo(from, to, distance, duration, airFare);
			routes[index]=route;
			index++;
		}
		  
		return routes;
	}
	
	public void displayRouteDetails(RouteInfo []routes) {
		System.out.printf("%-20s %-20s %-10s %-10s %-10s \n","From","To","Distance","Duration","Airfare");
		System.out.println("---------------------------------------------------------------------------");
		for(RouteInfo route:routes) {
			System.out.printf("%-20s %-20s %-10s %-10s %-10s \n",route.getFrom(),route.getTo(),route.getDistance(),route.getTravelTime(),route.getAirFare());
		
			
		}
//		String[] str = new String[5];
//				str[0]=routes[0].toString();
//
//				System.out.println(str[0]);
//				String[] str1 = new String[5];
//			      str1=str[0].split(",");
//			      System.out.println(str1[1].trim());
//	 
	}
	
	
	public void showDirectFlights(String[] routeInfo, String source) throws IOException {
		RouteInfo routes[] = readRouteInfos();
		int count=0;
		for(RouteInfo route: routes) {
			if(route.getFrom().equalsIgnoreCase(source)) {
				count++;
			}
		}
		int i=0;
		RouteInfo[] direct = new RouteInfo[count];
		for(RouteInfo route: routes) {
			if(route.getFrom().equalsIgnoreCase(source)) {
				direct[i]=route;
				i++;
			}
		}
		
		sortDirectFlights(direct);
		
	}
	
	void sortDirectFlights(RouteInfo[] routes) {
		
	    Arrays.sort(routes,new Comparator<RouteInfo>() {
	     
	     @Override public int compare(RouteInfo o1, RouteInfo o2) { return
	     o1.getTo().compareTo(o2.getTo()); }
	     
	     });
	    displayRouteDetails(routes);
	   
		
	}
	
	public RouteInfo[] removeNull(RouteInfo[] routes)
	 {
	  
	  int i=0;
	  for(RouteInfo route:routes)
	  {
	   if(route!=null)
	    i++;
	  }
	  
	  RouteInfo[] nonNullRoutes=new RouteInfo[i];
	 int j=0;
	  for(RouteInfo route:routes)
	  {
	   if(route!=null)
	   {
	    nonNullRoutes[j]=route;
	    j++;
	   }
	  }
	  
	  return nonNullRoutes;
	 }
	void showAllConnections(String[] routeInfo, String from, String to) throws IOException {
		
		 int counter = 0;
         RouteInfo[] routes= readRouteInfos();
   
   RouteInfo[] directFlights=new RouteInfo[routes.length];
         for(RouteInfo r: routes){
             if(r.getFrom().compareToIgnoreCase(from)==0 && r.getTo().compareToIgnoreCase(to)==0 ){
              directFlights[counter]=r;
                 counter++;
             }
               
             else if(r.getFrom().compareToIgnoreCase(from)==0){
                 for(RouteInfo r1:routes){
                	 
                   if(r.getTo().equalsIgnoreCase(r1.getFrom())) {
                	   
                     for(RouteInfo r2:routes){ 
                       if( r2.getTo().equalsIgnoreCase(to)){
                         directFlights[counter]=r;
                         directFlights[counter+1]=r1;
                         counter=counter+2;
                         break;
                       }
                      
                   }
                   
                   }
                  
                   
                 }
             }
        }     
         if(counter!=0) {
    RouteInfo[] directFlights1= removeNull(directFlights);
    displayRouteDetails(directFlights1);
    }
   else
    System.out.println("no  flights from "+from+"to"+to);
     }
	
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
        Collection<String> items = new ArrayList<String>();
		RoutePlanner obj = new RoutePlanner();
		RouteInfo[] routes = obj.readRouteInfos();
		obj.displayRouteDetails(routes);
		System.out.println("Enter the source to find direct flights: ");
		String source=sc.nextLine();
		obj.showDirectFlights(null, source);
		
		System.out.println("Find All Connections \nEnter source: ");
		source=sc.nextLine();
		System.out.println("Enter Destination: ");
		String dest=sc.nextLine();
		obj.showAllConnections(null, source, dest);
	}
	
}

