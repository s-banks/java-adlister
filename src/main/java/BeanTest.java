import beans.Author;
import beans.Quote;

import java.util.ArrayList;

public class BeanTest {

	public static void main(String[] args) {

		Author author1 = new Author("Jim", "Dangle");
		Quote quote1 = new Quote("New boot goofin'", author1);

		Author author2 = new Author("Edgar", "Poe");
		Quote quote2 = new Quote("Nevermore", author2);

		ArrayList<Quote> quotes = new ArrayList<>();
		quotes.add(quote1);
		quotes.add(quote2);

		for (Quote quoteList : quotes)
			System.out.println(quoteList.getContent() + ", -" + quoteList.getAuthor().getFirstName() + " " + quoteList.getAuthor().getLastName());

	}
}
