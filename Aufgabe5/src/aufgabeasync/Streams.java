package aufgabeasync;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		List<Person> ps = getPersons();
		Supplier<Stream<Person>> supplier = ps::stream;

		// count number of data items
		System.out.println("### count number of data items ###");
		System.out.println("Size: " + supplier.get().count());

		// find persons with name Chen
		System.out.println("\n### find persons with name Chen ###");
		Stream<Person> stream2 = supplier.get().filter(p -> p.getName().contains("Chen"));
		stream2.forEach(System.out::println);

		// make list of names from persons that are >=18 years
		System.out.println("\n### make list of names from persons that are >=18 years ###");
		Stream<Person> stream3 = supplier.get().filter(p -> p.getAge() >= 18);
		stream3.forEach(System.out::println);

		// find youngest person
		System.out.println("\n### find youngest person ###");
		Optional<Person> stream4 = supplier.get().min(Comparator.comparing(Person::getAge));
		stream4.ifPresent(System.out::println);

		// find oldest person
		System.out.println("\n### find oldest person ###");
		Optional<Person> stream5 = supplier.get().max(Comparator.comparing(Person::getAge));
		stream5.ifPresent(System.out::println);
	}
	
	public static List<Person> getPersons() {
		//System.out.println(Streams.class.getResource("data.csv").getFile());
		
		List<Person> ret = new ArrayList<>();
		
		try(Scanner r = new Scanner(new File(Streams.class.getResource("data.csv").getFile()));) {
			SimpleDateFormat df = new SimpleDateFormat("dd.MM.yy");
			while(r.hasNextLine()) {
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
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
}
