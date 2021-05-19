package aufgabeasync;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Streams 
{
	public static void main(String[] args) 
	{
		List<Person> ps = getPersons();
		
		System.out.println(ps.size());
		
		// count number of data items
		
		// find persons with name Chen 
	
		// make list of names from persons that are >=18 years
		
		// find youngest person
	
		// find oldest person
	}
	
	public static List<Person> getPersons()
	{
		//System.out.println(Streams.class.getResource("data.csv").getFile());
		
		List<Person> ret = new ArrayList<Person>();
		
		try(Scanner r = new Scanner(new File(Streams.class.getResource("data.csv").getFile()));)
		{
			SimpleDateFormat df = new SimpleDateFormat("dd.MM.yy");
			while(r.hasNextLine()) 
			{
				String data = r.nextLine();
				StringTokenizer stok = new StringTokenizer(data, ",");
				String name = stok.nextToken();
				String email = stok.nextToken();
				String city = stok.nextToken();
				String zip = stok.nextToken();
				String company = stok.nextToken();
				String phone = stok.nextToken();
				String pin = stok.nextToken();
				String bday = stok.nextToken();
				Person p = new Person();
				p.setName(name);
				p.setEmail(email);
				p.setCity(city);
				p.setZip(zip);
				p.setCompany(company);
				p.setPhone(phone);
				p.setPin(Integer.parseInt(pin));
				p.setBirthday(df.parse(bday));
				ret.add(p);
				//System.out.println(data);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ret;
	}
}
