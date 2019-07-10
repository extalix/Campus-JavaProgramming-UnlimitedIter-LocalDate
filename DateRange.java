import java.util.Iterator;
import java.time.LocalDate;
import java.util.NoSuchElementException;

public class DateRange implements Iterable<LocalDate> {
	private LocalDate a, b;
	
	public DateRange(LocalDate a, LocalDate b) {
		this.a = a;
		this.b = b;
	}
	
	public LocalDate getA() {
		return this.a;
	}
	
	public LocalDate getB() {
		return this.b;
	}
	
	public Iterator<LocalDate> iterator() {
		return new DateRangeIterator(getA(), getB());
	}
	
	public boolean contains(LocalDate i) {
		DateRange k = new DateRange(getA(), getB());
		for (LocalDate j: k) {
			if (j.equals(a)) return true;
		}
		return false;
	}
	
	public boolean overlap(DateRange i) {
		DateRange j = new DateRange(getA(),getB());
		if (j.getA().isAfter(i.getB()) || j.getB().isBefore(i.getA())) return false;
		return true;
	}
}

class DateRangeIterator implements Iterator<LocalDate> {
	private LocalDate a,b,c;
	
	public DateRangeIterator(LocalDate a, LocalDate b) {
		this.a = a;
		this.b = b;
		this.c = a;
	}
	
	public boolean hasNext() {
		if (this.c.plusDays(1).isAfter(this.b)) return false;
		return true;
	}
	
	public LocalDate next() {
		if (!hasNext()) throw new NoSuchElementException();
		LocalDate c = this.c;
		this.c = this.c.plusDays(1);
		return c;
	}
}