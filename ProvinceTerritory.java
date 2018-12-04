/**
 * ProvinceTerritory - holds the name and population of a province
 * or territory
 *
 * @author Mike Mulder
 * @version 1.0
 */
public class ProvinceTerritory
{
    private String name;
    private int population;
    
    /**
     * Constructor of a ProvinceTerritory
     * 
     * @param name Name of the province or territory
     * @param population Poulation of the province or territory
     */
    public ProvinceTerritory(String name, int population) {
        setName(name);
        setPopulation(population);
    }
    
    /**
     * @param name Name of the province or territory
     */
    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid name");
        }
    }
    
    /**
     * @param population Population of the province or territory
     */
    public void setPopulation(int population) {
        if (population >= 0) {
            this.population = population;
        } else {
            throw new IllegalArgumentException("Invalid population");
        }
    }
    
    /**
     * @return the name of the province or territory
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * @return the population of the province or territory
     */
    public int getPopulation() {
        return this.population;
    }
}
