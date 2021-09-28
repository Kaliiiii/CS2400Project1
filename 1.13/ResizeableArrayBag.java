import java.util.Arrays;

public final class ResizeableArrayBag<T> implements BagInterface<T>
{
    private T[] itemArray; 
    private static final int DEFAULT_CAPACITY = 4;
    private int thisCapacity; 
    private int numberOfItems;

    public ResizeableArrayBag()
    {
        this(DEFAULT_CAPACITY);
    }
   
    // Extra constructor; creates and initializes an empty Bag
    public ResizeableArrayBag(int capacity)
    {
        thisCapacity = capacity;
        numberOfItems = 0;
        @SuppressWarnings("unchecked") // says don't pick on me for casting types
        T [] tempBag = (T []) new Object[capacity];
        // ( ) says doesn't look like an item type but it is
        itemArray = tempBag;      
       
    }

    public int getCurrentSize()
    {
        return numberOfItems;      
    }

    public int getCapacity()
    {
        return thisCapacity;
    }


    public boolean isEmpty()
    {      
        return numberOfItems == 0;
    }

    public boolean isFull()
    {
        if (thisCapacity == numberOfItems)
        {
            return true;
        }  
        return false;      
    }
    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfItems];
        for (int index = 0; index < numberOfItems; index++)
            result[index] = itemArray[index];
        return result;
    }
    public void clear()
    {
        for (int index = 0; index < numberOfItems; index++)
            itemArray[index] = null;
        numberOfItems = 0;  
    }
    public int getFrequencyOf(T anItem)
    {
        int counter = 0;
        for (int index = 0; index < numberOfItems; index++)
        {
            if (itemArray[index].equals(anItem))
            {
                counter++;
            }
        }
        return counter;      
    }
    public boolean contains(T anItem)
    {
        if (isEmpty()) return false;
        else
        {
            int k = 0;
            while (k < numberOfItems)
            {
                if (itemArray[k] == anItem)
                    return true;
                k++;
            }
        }
        return false;   
    }
    public boolean remove(T anItem)
    {
       int k = 0;
       while (k < numberOfItems)
       {
           if (itemArray[k].equals(anItem))
           {
               if (k < numberOfItems)
               {  
                   itemArray[k] = itemArray[numberOfItems-1];
                   itemArray[numberOfItems-1] = null;
                   numberOfItems--;
                   return true;
               }  
           }
           k++;
       }
       return false;
    }
    public T remove() {
        return null;
    }
    public void resize(int newCapacity)
    {
        if (thisCapacity > newCapacity)
        {  
            return;
        }      
        else
        {  
            itemArray = Arrays.copyOf(itemArray, newCapacity);
            thisCapacity = newCapacity;
        }  
    }
    public boolean add(T newItem)
    {
        if (isFull())
        {
            resize(2 * thisCapacity);
            itemArray[numberOfItems] = newItem;
            numberOfItems++;
            return true;
        }  
        else
        {
            itemArray[numberOfItems] = newItem;
            numberOfItems++;
            if (isFull())
            {
                return true;
            }
            else
            {
                return false;
            }  
        }
    }

    @Override
    public BagInterface <T> union(BagInterface<T> otherBag) {   
		BagInterface <T> result = new ResizeableArrayBag < >();
		T[] thisArray = this.toArray();
		T[] otherArray = otherBag.toArray();
		for (T elem : thisArray) 
		{
			result.add(elem);
		}
		for (T elem : otherArray) 
		{
			result.add(elem);
		}
		return result;   
	}
    @Override
	public BagInterface <T> intersection(BagInterface < T > otherBag) {   
		BagInterface <T> result = new ResizeableArrayBag < >();
		T[] thisArray = this.toArray();
		T[] otherArray = otherBag.toArray(); 
		for (T elemA : thisArray) 
		{
			for (T elemB : otherArray) 
			{
				if(elemA.equals(elemB))
				{
					result.add(elemB);
				}
			}  			
		}   
		return result;
	}
    @Override
	public BagInterface <T> difference(BagInterface < T > otherBag) {   
		BagInterface <T> result = new ResizeableArrayBag < >();
		T[] thisArray = this.toArray();
		T[] otherArray = otherBag.toArray(); 
		for (T elem : thisArray) 
		{
		   result.add(elem);
		}
		for (T elem : otherArray) 
		{
		   if(result.contains(elem))
			  result.remove(elem);
		}
		return result;
	}
}
