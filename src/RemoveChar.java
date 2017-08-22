import java.util.ArrayList;

/**
 * Write a method which will remove any given character from a String? 
 * 
 * planning
 * ---------
 * removeChar(String s, char c)
 * ArrayList = new string
 *for(loop)
 * new_c = s.charAt(i)
 * if new_c!=c
 * { new_string.add(new_c)}
 * 
 * return String.join("", new_string)
 */
public class RemoveChar
{
    public static String removeChar(String s, char c)
    {
        String new_string = "";
        
        int loop = s.length();
        for(int i = 0; i<loop; i++)
        {
            char new_c = s.charAt(i);
            if(new_c != c)
            {
                new_string += new_c;
            }
        }
        
        return new_string;
        
    }
    public static void main(String[] args)
    {
        String test = "How are you?";
        char exclude = 'o';
        
        System.out.println("Original: " + test);
        System.out.println("'" + exclude + "' removed: " + removeChar(test, exclude));
    }
}
