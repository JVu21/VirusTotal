public class VirusTotal {
        public static void main(String[] args) throws Exception
        {
            UserInterFace  ui = new UserInterFace();
            VirusCheckerRequest req = new VirusCheckerRequest();

            while (true)
            {
                String mode = ui.inputMode();
                if(mode.toUpperCase().equals("Q"))
                {
                    //exit state!
                    break;
                }
                else if(mode.equals("1") )
                {
                    zipCodePath(ui, req);
                }
                else if(mode.equals("2") )
                {
                    cityStatePath(ui, req);
                }

                unitSelectionPath(ui, req);

                //Done with inputs so go fetch some weather
                VirusCheckerRequest response = req.getWeather();
                ui.displayWeatherData(response.getTemp());
            }
        }

        public static void zipCodePath(UserInterFace ui, VirusCheckerRequest req)
        {
            //set the mode on the request which will determine how the url is constructed
            req.setMode(VirusCheckerRequest.ZIP_CODE);
            //TODO: refactor so the validation loop is handled in the UserInterface
            boolean validZip = false;
            while (!validZip)
            {
                String zip = ui.inputZipCode();
                String result = req.setZipCode(zip);
                if (result == null)
                {
                    //this means that the zip passed validation
                    //so end the while loop
                    validZip = true;
                }
                else
                {
                    ui.displayErrorMessage(result);
                }

            }
        }

        public static void cityStatePath(UserInterFace ui, VirusCheckerRequest req)
        {
            //set the mode on the request which will determine how the url is constructed
            req.setMode(VirusCheckerRequest.CITY_STATE);

            boolean validCityState = false;
            while (!validCityState)
            {
                String cityState = ui.inputCityState().replaceAll("\\s", "");
                String result = req.setFile(cityState);
                if (result == null)
                {
                    //this means that the city/state passed validation
                    //so end the while loop
                    validCityState = true;
                }
                else
                {
                    ui.displayErrorMessage(result);
                }
            }
        }

        public static void unitSelectionPath(UserInterFace ui, VirusCheckerRequest req)
        {
            boolean validUnits = false;
            while (!validUnits)
            {
                String unitsInput = ui.inputUnits();
                String units = ui.validateUnits(unitsInput);

                if( units != null)
                {
                    String result = req.setUnits(units);
                    if (result == null)
                    {
                        //this means that the unit passed validation
                        //so end the while loop
                        validUnits = true;
                    } else
                    {
                        ui.displayErrorMessage(result);
                    }
                }
            }
        }

    }
}
