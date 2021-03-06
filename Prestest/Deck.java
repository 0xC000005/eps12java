
import java.util.*;
public class Deck
{
    private Input MyInput;
    private ArrayList<Card> CardList,Sort,Ans;
    private Card tempCard;
    public static final int SHUFFLE = 1000;
    public static final String[] SUITS={"Heart","Diamonds","Spades","Clubs"};
    public static final String[] DESC={"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    public static final int[] VALUE={11,2,3,4,5,6,7,8,9,10,10,10,10};
    

    public Deck()
    {
       MyInput=new Input();
       CardList=new ArrayList<Card>();
       Sort=new ArrayList<Card>();
       Ans=new ArrayList<Card>();
       tempCard=new Card();
       loadDeck();
       shuffle();
       main();
    }
       
    public void loadDeck()
    {
        for(int s=0;s<4;s++)
            for(int d=0;d<13;d++)
            {
                Card tempCard = new Card();
                tempCard.setSuit(SUITS[s]);
                if(SUITS[s].equals("Heart"))
                {
                    tempCard.setWeight(4);
                }
                else if(SUITS[s].equals("Diamonds"))
                {
                    tempCard.setWeight(3);
                }
                else if(SUITS[s].equals("Spades"))
                {
                    tempCard.setWeight(2);
                }
                else
                {
                    tempCard.setWeight(1);
                }
                tempCard.setDescription(DESC[d]);
                tempCard.setValue(VALUE[d]);
                addCard(tempCard);
            }
    }
    
    public void swap(int num1,int num2)
    {
        Card tempCard=CardList.get(num1);
        CardList.set(num1,CardList.get(num2));
        CardList.set(num2,tempCard);
        
    }
    
    public void shuffle()
    {
        int num1,num2;
        Random randomGenerator = new Random();
        
        for (int x = 1; x<=SHUFFLE;x++){
            do {
                num1 = (randomGenerator.nextInt(52));// number from 0-51
                num2 = (randomGenerator.nextInt(52));// 1 number less than value
            } while( num1 == num2);
            swap(num1,num2);
        }
    }
     
    public void addCard(Card cardToAdd)
    {
        CardList.add(cardToAdd);
    }
    
    public void takeCard()
    {
        if(CardList.isEmpty())
        {
            System.out.println("------------ERROR:THERE_IS_NO_CARD_REMAIN------------");
        }
        else take();
        
    }
    
    public Card take()
    {
        Card temp=CardList.get(0);
        CardList.remove(0);
        return temp;   
    }
    
    public void  showDeck()
    {   
        for(Card element:CardList){
            System.out.println(element.getDescription()+" of "+element.getSuit());
        }
    }
    
    public void main()
    {
        System.out.print("How many cards would you like:  ");
        int num=MyInput.getInt();
        System.out.println("The cards are: ");
        for(int i=0;i<num;++i)
        {
            Sort.add(take());
        }
        int maxValue=2,count=0,counter=0;
        String maxDis="Clubs ";
        
        while(Sort.size()!=0)
        {
           // System.out.println("count:"+count);
           //System.out.println("maxValue:"+maxValue);
            Card tempCard=Sort.get(count);
            
            if(tempCard.getValue()<=maxValue)
            {
                System.out.println(tempCard.getDescription()+" of "+tempCard.getSuit());
                counter++;
                Sort.remove(count);
                count=0;
            }
            
            count++;
            if(count>=Sort.size())
            {
                count=0;
                maxValue++;
            }
        }
    }
}
