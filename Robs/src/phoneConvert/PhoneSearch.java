package phoneConvert;

import java.util.Scanner;

public class PhoneSearch
{

    public static void main(String[] args)
    {

        System.out.print("Enter you alpha number: ");
        Scanner input = new Scanner(System.in);
        String phoneAlpha = input.next();
        
        phoneAlpha = phoneAlpha.substring(0, 7).toUpperCase();
        
        phoneAlpha = phoneAlpha.replaceAll("A|B|C", "2");
        phoneAlpha = phoneAlpha.replaceAll("D|E|F", "3");
        phoneAlpha = phoneAlpha.replaceAll("G|H|I", "4");
        phoneAlpha = phoneAlpha.replaceAll("J|K|L", "5");
        phoneAlpha = phoneAlpha.replaceAll("M|N|O", "6");
        phoneAlpha = phoneAlpha.replaceAll("P|Q|R|S", "7");
        phoneAlpha = phoneAlpha.replaceAll("T|U|V", "8");
        phoneAlpha = phoneAlpha.replaceAll("W|X|Y|Z", "9");

        System.out.println("Your converted phone number is: " + phoneAlpha);
        input.close();
    }

}
