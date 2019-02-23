import java.io.*;

/**
 * Models hurricane information, including categories.  
 * Works with HurricaneOrganizer, provides object and comparison skeletons.
 * 
 * @author Susan King
 * @author Joshua Zhou
 * 
 * @version January 10, 2010
 * @version January 15, 2019
 */
public class Hurricane
{
    //Instance variables
    private int year;
    private String month;
    private int pressure;
    private int speed;
    private String name;
    private int category;
    
    /**
     * Initializes a Hurricane object with no information.
     */
    public Hurricane( )
    {
        super();
    }

    /**
     * Initializes a Hurricane object with historical information.
     * 
     * @param year      year the hurricane took place
     * @param month     month in String format
     * @param pressure  hurricane's pressure
     * @param speed     hurricane's speed in knots
     * @param name      hurricane's name
     */
    public Hurricane(int year, String month, 
    int pressure, int speed, String name)
    {
        this.year=year;
        this.month=month;
        this.pressure=pressure;
        this.speed=speed;
        this.name=name;
        this.category=determineCategory(speed);
    }

    /**
     * Based upon Saffir/Simpson Hurricane Scale, figures out
     * the category using wind speed in knots.
     * 
     * @param knots     wind speed in knots
     * @return Saffir/Simpson Hurricane Scale category
     */
    public int determineCategory(int knots)
    {
        if(knots<64)
            return 0;
        else if(knots<83)
            return 1;
        else if(knots<96)
            return 2;
        else if(knots<113)
            return 3;
        else if(knots<137)
            return 4;
        else
            return 5;
    }

    //Getters

    /**
     * Returns the name of the hurricane.
     * 
     * @return  hurricane name
     */
    public String getName()
    {
        // replace the following line
        return name;
    }

    /**
     * Returns the month of the hurricane.
     * 
     * @return  hurricane month
     */
    public String getMonth()
    {
        // replace the following line
        return month;
    }

    /**
     * Returns the pressure of the hurricane.
     * 
     * @return  hurricane pressure
     */
    public int getPressure()
    {
        // replace the following line
        return pressure;
    }

    /**
     * Returns the speed of the hurricane.
     * 
     * @return  hurricane speed
     */
    public int getSpeed()
    {
        // replace the following line
        return speed;
    }

    /**
     * Returns the year of the hurricane.
     * 
     * @return  hurricane year
     */
    public int getYear()
    {
        // replace the following line
        return year;
    }

    /**
     * Returns the category of the hurricane.
     * 
     * @return  hurricane category
     */
    public int getCategory()
    {
        // replace the following line
        return determineCategory(speed);
    }

    /**
     * Prints information about the hurricane.
     */
    public void print()
    {
        System.out.println(toString( ));
    }

    /**
     * Returns information about the hurricane.
     * 
     * @return  hurricane information
     */
    public String toString()
    {
        //return "";
        return String.format("%-4d %-5s %-15s %-5d %5d %5d ", 
               year, month, name, determineCategory(speed), speed, pressure);
    }

    /**
     * Compares the year of this Hurricane and the year of Hurricane h.
     * 
     * @param   h   a Hurricane object
     * 
     * @return  >0  if the year of this Hurricane is greater than the year of Hurricane h
     *          <0  if the year of this Hurricane is less than the year of Hurricane h
     *          =0  if the year of this Hurricane is equal to the year of Hurricane h
     */
    public int compareYearTo(Hurricane h)
    {
        return this.year-h.year;
    }

    /**
     * Compares the name of this Hurricane and the name of Hurricane h.
     * 
     * @param   h   a Hurricane object
     * 
     * @return  >0  if the name of this Hurricane is greater than the name of Hurricane h
     *          <0  if the name of this Hurricane is less than the name of Hurricane h
     *          =0  if the name of this Hurricane is equal to the name of Hurricane h
     */
    public int compareNameTo(Hurricane h)
    {
        return this.name.compareTo(h.name);
    }

    /**
     * Compares the pressure of this Hurricane and the pressure of Hurricane h.
     * 
     * @param   h   a Hurricane object
     * 
     * @return  >0  if the pressure of this Hurricane is greater than the pressure of Hurricane h
     *          <0  if the pressure of this Hurricane is less than the pressure of Hurricane h
     *          =0  if the pressure of this Hurricane is equal to the pressure of Hurricane h
     */
    public int comparePressureTo(Hurricane h)
    {
        return this.pressure-h.pressure;
    }

    /**
     * Compares the speed of this Hurricane and the speed of Hurricane h.
     * 
     * @param   h   a Hurricane object
     * 
     * @return  >0  if the speed of this Hurricane is greater than the speed of Hurricane h
     *          <0  if the speed of this Hurricane is less than the speed of Hurricane h
     *          =0  if the speed of this Hurricane is equal to the speed of Hurricane h
     */
    public int compareSpeedTo(Hurricane h)
    {
        return this.speed-h.speed;
    }

    /**
     * Compares the category of this Hurricane and the category of Hurricane h.
     * 
     * @param   h   a Hurricane object
     * 
     * @return  >0  if the category of this Hurricane is greater than the category of Hurricane h
     *          <0  if the category of this Hurricane is less than the category of Hurricane h
     *          =0  if the category of this Hurricane is equal to the category of Hurricane h
     */
    public int compareCategoryTo(Hurricane h)
    {
        return determineCategory(this.speed)-determineCategory(h.speed);
    }
}
