package Projects;
import java.io.*;
public class InvalidHotelName extends Exception implements Serializable {
	public InvalidHotelName(String message) {
		super(message);
	}
}
