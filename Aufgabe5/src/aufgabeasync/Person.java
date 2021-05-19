package aufgabeasync;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Person 
{
	private String name;
	private String email;
	private String city;
	private String zip;
	private String company;
	private String phone;
	private int pin;
	private Date birthday;
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public String getCity() 
	{
		return city;
	}
	
	public void setCity(String city) 
	{
		this.city = city;
	}
	
	public String getZip() 
	{
		return zip;
	}
	
	public void setZip(String zip) 
	{
		this.zip = zip;
	}
	
	public String getCompany() 
	{
		return company;
	}
	
	public void setCompany(String company) 
	{
		this.company = company;
	}
	
	public String getPhone() 
	{
		return phone;
	}
	
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}
	
	public int getPin() 
	{
		return pin;
	}
	
	public void setPin(int pin) 
	{
		this.pin = pin;
	}
	
	public Date getBirthday() 
	{
		return birthday;
	}
	
	public void setBirthday(Date birthday) 
	{
		this.birthday = birthday;
	}
	
	public int getAge()
	{
		LocalDate today = LocalDate.now();          
		Period p = Period.between(birthday.toInstant()
			.atZone(ZoneId.systemDefault()).toLocalDate(), today);
		return p.getYears();
	}

	public String toString() 
	{
		return "Person [name=" + name + ", email=" + email + ", city=" + city + ", zip=" + zip + ", company=" + company
			+ ", phone=" + phone + ", pin=" + pin + ", birthday=" + birthday + "]";
	}
	
}
