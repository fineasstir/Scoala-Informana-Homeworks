import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Shooter implements Comparable<Shooter> {

	private String number;
	private String name;
	private String country;
	private Date time;
	private List<String> shoots;

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");

	@Override
	public int compareTo(Shooter o) {
		return this.getFinalTime().compareTo(o.getFinalTime());
	}

	public Shooter(String number, String name, String country, String time, List<String> shoots) {
		this.number = number;
		this.name = name;
		this.country = country;
		try {
			this.time = simpleDateFormat.parse(time);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.shoots = shoots;
	}

	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public Date getTime() {
		return time;
	}

	public List<String> getShoots() {
		return shoots;
	}

	public Date getFinalTime() {
		long timeAsMillis = time.getTime();

		for (String str : shoots) {
			timeAsMillis += 10000 * calculateMissedShoots(str);
		}

		return new Date(timeAsMillis);
	}

	private int calculateMissedShoots(String shoots) {
		String[] tokens = shoots.split("");
		int sum = 0;
		for (String token : tokens) {
			if (token.equals("o")) {
				sum++;
			}
		}

		return sum;
	}

	@Override
	public String toString() {
		return "Shooter{" + "number='" + number + '\'' + ", name='" + name + '\'' + ", country='" + country + '\''
				+ ", time=" + simpleDateFormat.format(getFinalTime()) + ", shoots=" + shoots + '}' + "\n";
	}
}
