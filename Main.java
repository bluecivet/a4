import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Main
{

    public static void main(String[] args)
    {
	   int userOption = getOption();

	   switch(userOption)
       {
           case 0: showTime(); break;

           case 1: showCurrentTime(); break;

           case 2: showMessage("see you !","exit"); break;

           default: break;

       }
    }


    //////////////////////////////////////////////////////////////////////////


    public static int getOption()
    {
        String[] option = {"enter a time", "show the current time", "cancle"};

        return JOptionPane.showOptionDialog
                (
                        null,
                        "choose a option",
                        "choose a option",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        option,
                        option[0]
                );
    }


    ///////////////////////////////////////////////////////////////////////////////

    public static void showMessage(String message, String title)
    {
        JOptionPane.showMessageDialog
                (
                        null,
                        message,
                        title,
                        JOptionPane.PLAIN_MESSAGE
                );
    }

    ////////////////////////////////////////////////////////////////////////////////


    //--------------------------------------------------------------------------------------

    public static void showTime()
    {
        String userInput = getTime();
        if(userInput == null)
        {
            showMessage("see you!","exit");
            return;
        }
        showMessage(userInput,"title");
    }


    /////////////////////////////////////////////////////////////////////////////////////


    public static String getTime()
    {
        String information = "please enter a time and please follow the format hh:mm";
        String userInput;
        boolean isValid;
        do
        {
            userInput = JOptionPane.showInputDialog
                    (
                            null,
                            information,
                            "enter a message",
                            JOptionPane.PLAIN_MESSAGE
                    );

            if(userInput == null)
            {
                return null;
            }

            isValid = checkVaild(userInput);

            if(isValid)
            {
                return userInput;
            }
            else
            {
                continue;
            }
        }
        while(true);

    }


    ///////////////////////////////////////////////////////////////////////////////


    public static boolean checkVaild(String userInput)
    {
        userInput = userInput.trim();

        for(int i = 0; i < userInput.length(); i++)   // check every character in the string
        {
            char c = userInput.charAt(i);

            if((c < '0' || c > '9') && c != ':')   // illegal character
            {
                showMessage("wrong format","error");
                return false;
            }
        }

        // after checking every character check the format

        String[] input = userInput.split(":");

        if(input.length != 2)   // if the number are in separate into 2 set like 1:30 into 1 and 30
        {
            showMessage("worng format","error");
            return false;
        }

        if(input[0].equals("") || input[1].equals(""))      // if one of the input are empty string
        {
            showMessage("wrong format","error");
            return false;
        }

        //check if the number are in range of 0 to 60
        int hour = Integer.parseInt(input[0]);
        int min = Integer.parseInt(input[1]);
        if(hour > 60 || min > 60)
        {
            showMessage("the number incorrecct", "error");
            return false;
        }

        return true;  // if it pass all the case above
    }


    //------------------------------------------------------------------------------------------












    //------------------------------------------------------------------------------------------


    public static void showCurrentTime()
    {

    }


    //------------------------------------------------------------------------------------------


    public static void setFrame(JFrame jf)
    {
        jf.setSize(500,500);
        jf.setLocation(300,300);
        jf.setTitle("clock");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
