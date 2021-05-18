import org.json.simple.*;
import org.json.simple.parser.*;
import java.net.*;
import java.util.Map;
import java.io.*;

    public class VirusCheckerRequest
    {
        private String Website;
        private String File;
        private String units;
        private int mode;

        //API connection constants
        private static final String URL = "https://www.virustotal.com/v2/url/report?";
        private static final String API_KEY = "4d46b331c34cce7537f557538b5259014c5e7adb246ee589e4eda65c8f953aeb";

        //Mode constants
        public static final int ZIP_CODE = 1;
        public static final int CITY_STATE = 2;

        public String validateURL(String URL)
        {
            //check for valid length first
            if (URL.length() != 5)
            {
                return "Invalid Length: Zip Code must be exactly 5 digits";
            }

            //if we survive the parseInt() method without an exception we have all digits
            try
            {
                Integer.parseInt(URL);
            }
            catch(Exception e)
            {
                return "Invalid characters: Zip Code must include digits only!";
            }

            //null will signify no error so succussful validation
            return null;
        }

        public String setURL(String URL)
        {
            String valid = validateURL(URL);

            if(valid == null)
            {
                this.URL = URL;
            }

            return valid;
        }

        public String validateCityState(String cityState)
        {
            return null;
        }

        public String setFile(String file)
        {
            String valid = validateCityState(file);

            if(valid == null)
            {
                this.File = File;
            }
            return valid;
        }


        public void getWeather() throws Exception
        {

            //create a string representing the url with the appropriate parameters
            String requestURL = URL + "apikey=" + API_KEY;
            if(this.mode == ZIP_CODE)
            {
                //requestURL = URL + "?zip=" + zipCode;
            }
            else
            {
                //requestURL = URL + "?q=" + cityState;
            }

            //add the unit and api key
            requestURL += "&resource=" + units;

            URL url = new URL(requestURL);
            System.out.println(requestURL);

            //this is the request to our URL and it returns an text input stream that we can read from
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));

            JSONParser parser = new JSONParser();
            JSONObject weatherData = (JSONObject) parser.parse(in);

            Map mainWeatherData = (Map)weatherData.get("main");
            Double temperature = (Double)mainWeatherData.get("temp");

            //build the response object and return it
            //WeatherFetcherResponse response = new WeatherFetcherResponse(temperature);
            //return response;
        }

    }
}
//Hello