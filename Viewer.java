/**
 * this class s to user ClockComponent and Clock and DitialClock to let user enter a time then display a clock picture
 * the class let user input a time and check is the time that input is valid or not then draw a clock out
 */



import javax.swing.JOptionPane;
import javax.swing.JFrame;



public class Viewer
{

    public static void main(String[] args)
    {
	   int userOption = getOption();   //let user choose an option

	   switch(userOption)
       {
           case 0: showTime(); break;   // user input time

           case 1: showCurrentTime(); break;

           case 2: showMessage("see you !","exit"); break;   // exit the program

           default: break;

       }
    }


    //////////////////////////////////////////////////////////////////////////

    /**
     * the method will let user to choose a option
     * @return int type that show the user input
     */

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

    /**
     * the method will show the dialog in the window
     * @param message a String type that the message needed to show
     * @param title  a String type that the tile of the dialog
     */
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
    //                          user input time

    /**
     * this method is the process of which let user input time and show the clock
     * the user need the input the time format like HH:MM
     */

    public static void showTime()
    {
        String userInput = getTime();

        if(userInput == null)   // if user choose cancel
        {
            showMessage("see you!","exit");
            return;   // end the method
        }

        //in the input correct
        String[] times = userInput.split(":"); // split in hour and minutes
        int hour = Integer.parseInt(times[0]);
        int min = Integer.parseInt(times[1]);
        JFrame frame = new JFrame();   // frame
        setFrame(frame);
        ClockComponent clock = new ClockComponent(hour,min);  // the picture
        frame.add(clock);   // add the picture to the frame
        frame.setVisible(true);
    }


    /////////////////////////////////////////////////////////////////////////////////////

    /**
     * the method will let the user enter a time in a dialog window
     * and check it if the input is not valid than the user have to enter again
     * @return String type show the correct user input
     */

    public static String getTime()
    {
        String information = "please enter a time and please follow the format hh:mm";
        String userInput;
        boolean isValid;   // check the input

        do
        {
            userInput = JOptionPane.showInputDialog
                    (
                            null,
                            information,
                            "enter a message",
                            JOptionPane.PLAIN_MESSAGE
                    );

            if(userInput == null)  // if user choose cancel
            {
                return null;
            }

            isValid = checkVaild(userInput);  // check valid or not

            if(isValid)
            {
                return userInput;  // if valid then return the user input
            }
            else
            {
                continue;  // if not valid then input again
            }
        }
        while(true);

    }


    ///////////////////////////////////////////////////////////////////////////////

    /**
     * check if the user input valid or not the only correct format is hh:mm (hh and mm are number)
     * other character in not acceptable
     * hh should not greater that 24 and mm should not greater than 60
     * @param userInput the input that need to check
     * @return true for valid input false for not valid input
     */

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
        if(hour > 23 || min > 59)
        {
            showMessage("the number incorrecct", "error");
            return false;
        }

        return true;  // if it pass all the case above
    }


    //------------------------------------------------------------------------------------------











//                        the show time method
    //------------------------------------------------------------------------------------------

    /**
     * the method is the process of that show the current time of the clock when user choose show current time option
     */

    public static void showCurrentTime()
    {
       JFrame frame = new JFrame();     // create frame
       setFrame(frame);
       ClockComponent clock = new ClockComponent();   // clock picture that show the clock
       frame.add(clock);
       frame.setVisible(true);
    }


    //------------------------------------------------------------------------------------------

    /**
     * the method  will set up the frame
     * @param jf the frame that need to set up
     */

    public static void setFrame(JFrame jf)
    {
        jf.setSize(800,700);   // frame size
        jf.setLocation(300,100);  // where to show
        jf.setTitle("clock");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
