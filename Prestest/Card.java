
/**
 * Write a description of class Card here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Card
{
    // instance variables - replace the example below with your own
    private String suit;
    private int value,weight;
    private String description; 
    /**
     * Constructor for objects of class Card
     */
    public Card()
    {
        // initialise instance variables

    }
    
    public void Card(String _description,String _suit,int _value,int _weight)
    {
        setDescription( _description);
        setSuit(_suit);
        setValue(_value);
        setWeight(_weight);
    }
    
    public void setDescription(String _description)
    {
        description=_description;
    }
    public String getDescription()
    {
        return description;
    }
    
    public void setSuit(String _suit)
    {
        suit=_suit;
    }
    public String getSuit()
    {
        return suit;
    }
    
    public void setValue(int _value)
    {
        value=_value;
    }
    public int getValue()
    {
        return value;
    }
    
    public void setWeight(int _weight)
    {
        weight=_weight;
    }
    public int getWeight()
    {
        return weight;
    }
    
}

