package converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
This is a converter developed in order to convert Roman numbers to Arabic numbers.

The converter uses a map with each unique Roman number sign being the key,
and the Arabic number being the value for the specific key.

Developed by robertb19. 
*/

public class Rome {

	private static Map<Character, Integer> arabicAndRoman = new HashMap<Character, Integer>();

	public static void main(String[] args) {
		fillArabicToRomanMap();
	}

	public static void fillArabicToRomanMap() {
		arabicAndRoman.put('I', 1);
		arabicAndRoman.put('V', 5);
		arabicAndRoman.put('X', 10);
		arabicAndRoman.put('L', 50);
		arabicAndRoman.put('C', 100);
		arabicAndRoman.put('D', 500);
		arabicAndRoman.put('M', 1000);
	}

	public static int getArabicFromRoman(String romanNumber) {

		int result = 0;

		/*
		 * A Roman number list created in order to iterate over all of the
		 * specific characters in the Roman number and then remove them in order
		 * to calculate the final sum
		 */

		List<Character> romanNumberList = new ArrayList<Character>();

		for (int i = 0; i < romanNumber.length(); i++) {
			romanNumberList.add(romanNumber.charAt(i));
		}

		while (romanNumberList.size() > 0) {

			/*
			 * 1st case: if there is only one character left or if the Roman
			 * number is only one character
			 */

			if (romanNumberList.size() == 1) {
				if (arabicAndRoman.containsKey(romanNumberList.get(0))) {
					result += arabicAndRoman.get(romanNumberList.get(0));
					romanNumberList.remove(0);
				}
			}

			if (romanNumberList.size() > 1) {
				for (int i = 0; i <= 0; i++) {

					/*
					 * 2nd case: Iff the number of characters left is more than 1
					 * and if there is a sign before the number which reduces
					 * the value of the specific character eg. the Roman number
					 * "IX" or 9 in Arabic here the value of the number "X" (10
					 * in Arabic) is reduced by 1 to 9 because of the "I"
					 * before.
					 */
					if (arabicAndRoman.get(romanNumberList.get(i + 1)) > arabicAndRoman.get(romanNumberList.get(i))) {
						result += (arabicAndRoman.get(romanNumberList.get(i + 1))
								- arabicAndRoman.get(romanNumberList.get(i)));
						romanNumberList.remove(i + 1);
						romanNumberList.remove(i);

						/*
						 * 3rd case: Iff the number of characters left is more than 1
						 * and if there is no characters before in the Roman number that reduce
						 * the value of the number eg. the Roman number "XVI" or 16 in Arabic notation.
						 * The number "X" is not reduced by any number since there is nothing before it and
						 * the number "V" is not reduced by any number because no smaller Roman number is before it
						 *  
						 */
						
					} else {
						result += arabicAndRoman.get(romanNumberList.get(i));
						romanNumberList.remove(i);
					}

				}
			}

		}

		return result;
	}

}
