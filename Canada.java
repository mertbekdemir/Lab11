/**
 * Class Canada3 contains the provinces and territories, and their population.
 *
 * @author  Joe Developer
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Iterator;
public class Canada
{
    private ArrayList<ProvinceTerritory> provinces;

    public final static int NUM_OF_PROVINCES    = 13;
    public final static int NO_SUCH_PROVINCE    = -1;

    public static final int AB = 0;
    public static final int BC = 1;
    public static final int MB = 2;
    public static final int NB = 3;
    public static final int NL = 4;
    public static final int NT = 5;
    public static final int NS = 6;
    public static final int NU = 7;
    public static final int ON = 8;
    public static final int PE = 9;
    public static final int QC = 10;
    public static final int SK = 11;
    public static final int YT = 12;

    /** 
     *  Create provinces and territories in Canada3
     */
    public Canada()
    {
        provinces = new ArrayList<ProvinceTerritory>();

        provinces.add(new ProvinceTerritory ("Alberta" , 3645257));
        provinces.add(new ProvinceTerritory ("British Columbia" , 4400057));
        provinces.add(new ProvinceTerritory ("Manitoba" , 1208268));
        provinces.add(new ProvinceTerritory ("New Brunswick" , 751171));
        provinces.add(new ProvinceTerritory ("Newfoundland and Labrador" , 514536));
        provinces.add(new ProvinceTerritory ("Northwest Territories" , 41462));
        provinces.add(new ProvinceTerritory ("Nova Scotia" , 921727));
        provinces.add(null);
        provinces.add(new ProvinceTerritory ("Nunavut" , 31906));
        provinces.add(new ProvinceTerritory ("Ontario" , 12851821));
        provinces.add(new ProvinceTerritory ("Prince Edward Island" , 140204));
        provinces.add(new ProvinceTerritory ("Quebec" , 7903001));
        provinces.add(new ProvinceTerritory ("Saskatchewan" , 1033381));
        provinces.add(new ProvinceTerritory ("Yukon", 33897 ));
    }  

    /** 
     *  Gets the total population of Canada3
     *  
     *  @return totalPopulation Total population of provinces and territories in Canada3
     */
    public int getTotalPopulation()
    {
        int totalPopulation = 0;
        
        Iterator<ProvinceTerritory> it = provinces.iterator();
        
        while(it.hasNext()) {
            ProvinceTerritory province = it.next();
            
            if (province != null) {
                totalPopulation +=  province.getPopulation();
            }
        }

        return totalPopulation;
    }

    /**
     * Finds the province with the lowest population.
     * 
     * @return  Name of the province or territory with the lowest population
     */
    public String getLowestPopulation()
    {
        int     lowestPopulation = Integer.MAX_VALUE;
        String  smallestProvince = "";
        
        Iterator<ProvinceTerritory> it = provinces.iterator();
        
        while(it.hasNext()) {
            ProvinceTerritory province = it.next();
            
            if (province != null && province.getPopulation() < lowestPopulation)
            {
                lowestPopulation = province.getPopulation();
                smallestProvince = province.getName();
            }
        }  

        return smallestProvince;
    }
    
    /**
     * Finds the province with the highest population.
     * 
     * @return  Name of the province or territory with the lowest population
     */
    public String getHighestPopulation()
    {
        int     largestPopulation = 0;
        String  largestProvince = "";
        
        Iterator<ProvinceTerritory> it = provinces.iterator();
        
        while(it.hasNext()) {
            ProvinceTerritory province = it.next();
            
            if (province != null && province.getPopulation() > largestPopulation)
            {
                largestPopulation = province.getPopulation();
                largestProvince = province.getName();
            }
        }  

        return largestProvince;
    }

    /**
     * Gets the population of a specific province.
     * 
     * @return  Population of the province or territory
     * @param   province    Name of the province or territory
     */
    public int getPopulation(String provinceName)
    {
        Iterator<ProvinceTerritory> it = provinces.iterator();
        
        if (provinceName == null || provinceName.equals(""))
            throw new IllegalArgumentException("Invalid Province");
            
        while(it.hasNext()) {
            ProvinceTerritory province = it.next();
            
            if (province != null && province.getName().equalsIgnoreCase(provinceName))
            {
                return province.getPopulation();
            }
        }  
        
        return NO_SUCH_PROVINCE;
    }

    /** 
     * Determines if the province/territory is in Canada3.
     * 
     * @return  Whether there is a province or territory with the given name
     * @name    Name of the province or territory
     */
    public boolean isProvinceInCanada(String name)
    {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Invalid name");
        }
        Iterator<ProvinceTerritory> it = provinces.iterator();
        
        boolean isProvinceInCanada = false;

        while(it.hasNext())
        {
            ProvinceTerritory province = it.next();
            
            if (province != null && province.getName().equalsIgnoreCase(name))
            {
                isProvinceInCanada = true;
            }
        }

        return isProvinceInCanada;
    }

    /** 
     * Gets all provinces with populations between the given range
     * 
     * @param min Minimum population
     * @param max Maximum population
     */
    public String[] getProvincesWithPopulationBetween(int min, int max) {
     
        String[] matches;
        Iterator<ProvinceTerritory> it = provinces.iterator();
        
        int numMatches = 0;
        while (it.hasNext()) {
            ProvinceTerritory province = it.next();
            
            if (province != null && province.getPopulation() >= min && province.getPopulation() <= max) {
                numMatches++;
            }
        }
        
        if (numMatches > 0) {
            matches = new String[numMatches];
        } else {
            return null;
        }
        
        int index = 0;
        it = provinces.iterator();
        while (it.hasNext()) {
            ProvinceTerritory province = it.next();
            
            if (province != null && province.getPopulation() >= min && province.getPopulation() <= max) {
                matches[index] = province.getName();
                index++;
            }
        }
        
        return matches;
    }
    
    /**
     * Gets all province names that contain the given substring.
     * 
     * @param   substring   Substring to search for in the name of province or territory
     * @return  Array of provinces or territories names with the substring in their names
     */
    public String[] getProvincesNamesWhoseNameContains(String substring)
    {
        Iterator<ProvinceTerritory> it = provinces.iterator();
        
        if (substring == null || substring.equals("")) {
            throw new IllegalArgumentException("Invalid string");
        }
        
        int j = 0;
        int numOfProvContainingString = 0;
        String[] containingString;
        
        while(it.hasNext()) {
            
            ProvinceTerritory province = it.next();
            
            if (province != null && province.getName().toLowerCase().contains(substring.toLowerCase()))
            {
                numOfProvContainingString++;
            }
        }

        if (numOfProvContainingString > 0)
        {
            containingString = new String[numOfProvContainingString];
        }
        else {
            return null;
        }
        
        it = provinces.iterator();
        
        while(it.hasNext()) {
            
            ProvinceTerritory province = it.next();
            
            if (province != null && province.getName().toLowerCase().contains(substring.toLowerCase()))
            {
                containingString[j] = province.getName();
                j++;
            }
        }

        return containingString;
    }
    
    
    /**
     * Gets all province names that contain the given substring.
     * 
     * @param   substring   Substring to search for in the name of province or territory
     * @return  Array of provinces or territories names with the substring in their names
     */
    public ProvinceTerritory[] getProvincesWhoseNameContains(String substring)
    {
        if (substring == null || substring.equals("")) {
            throw new IllegalArgumentException("Invalid string");
        }
        Iterator<ProvinceTerritory> it = provinces.iterator();
        int j = 0;
        int numOfProvContainingString = 0;
        ProvinceTerritory[] containingProv;
        
        while(it.hasNext())
        {
            ProvinceTerritory province = it.next();
            
            if (province != null && province.getName().toLowerCase().contains(substring.toLowerCase()))
            {
                numOfProvContainingString++;
            }
        }

        if (numOfProvContainingString > 0)
        {
            containingProv = new ProvinceTerritory[numOfProvContainingString];
        }
        else {
            return null;
        }
  
        it = provinces.iterator();
        
        while(it.hasNext())
        {
            ProvinceTerritory province = it.next();
            
            if (province != null && province.getName().toLowerCase().contains(substring.toLowerCase()))
            {
                containingProv[j] = province;
                j++;
            }
   
        }

        return containingProv;
    }
    
    /**
     * Gets all provinces that contain the given substring.
     * 
     * @param   substring   Substring to search for in the name of province or territory
     * @return  Array of provinces or territories with the substring in their names
     */
    public ArrayList<String> getMoreProvincesWhoseNameContains(String substring)
    {    
        if (substring == null || substring.equals("")) {
            throw new IllegalArgumentException("Invalid string");
        }
        
        ArrayList<String> matches = new ArrayList<String>();
        Iterator<ProvinceTerritory> it = provinces.iterator();
        
        while(it.hasNext()) {
            ProvinceTerritory province = it.next();
            
            if (province != null && province.getName().toLowerCase().contains(substring.toLowerCase()))
            {
                matches.add(province.getName());
            }
        }            
        
        return matches;
    }
    
    /**
     * Gets all provinces that starts with the given letter.
     * 
     * @param   letter  Letter by which province or territory name starts with
     * @return  Array containing the provinces or territories whose name start with a specific letter
     */
    public ArrayList<String> getProvincesWhoseNameStartsWith(char letter)
    {
        if (letter == ' ' || letter == '\0') {
            throw new IllegalArgumentException("Invalid letter");
        }
            
        ArrayList<String> matches = new ArrayList<String>();
        Iterator<ProvinceTerritory> it = provinces.iterator();
        
        while(it.hasNext()) {
            ProvinceTerritory province = it.next();
            if (province != null && province.getName().toLowerCase().charAt(0) == Character.toLowerCase(letter))
            {
                matches.add(province.getName());
            }
        }            
        
        return matches;
    }
}


