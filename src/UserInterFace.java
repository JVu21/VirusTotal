import java.util.Scanner;

public class UserInterFace {

        private Scanner input;

    public UserInterFace()
    {
        input = new Scanner(System.in);
    }

    /**
     * @return
     */
    public String inputMode()
    {
        System.out.println("Enter the desired mode:");
        System.out.println("1) Url");
        System.out.println("2) File");
        System.out.println("Enter Q to quit");
        System.out.println();
        String mode = input.nextLine();

        return mode;
    }


    /**
     * @return
     */
    public String inputURL()
    {
        System.out.println("Enter a valid URL:");
        System.out.println();
        String URL = input.nextLine();
        return URL;
    }

    /**
     * @return
     */
    public String inputfile()
    {
        System.out.println("Upload File :");
        System.out.println();
        String file = input.nextLine();
        return file;
    }

    public String validateURL(String URL)
    {
        String validURL = null;
        if(URL.equals("1"))
        {
            validURL = VirusCheckerRequest.URL;
        }

        return validURL;
    }

    public void displayURLErrorMessage()
    {
        String errorURL = "URL is not valid";
        displayErrorMessage(errorURL);
    }

    public void displayFileErrorMessage()
    {
        String errorFile = "File is not valid";
        displayErrorMessage(errorFile);
    }


    public void displayErrorMessage(String msg)
    {
        System.out.println("************ERROR************");;
        System.out.println(msg);
    }

    public void displayVirusTotalFile(String statusFile)
    {
        System.out.println("Status of File: " + statusFile);
        System.out.println();
    }

    public void displayVirusTotalURL(String statusURL)
    {
        System.out.println("Status of URL: " + statusURL);
        System.out.println();
    }
}
