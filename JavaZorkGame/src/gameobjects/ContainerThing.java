package gameobjects;

public class ContainerThing extends ThingHolder implements java.io.Serializable {
	
	 private boolean openable;
	    private boolean isopen;

	    // By default ContainerThings are open but not openable -
	    
	    public ContainerThing(String aName, String aDescription, ThingList tl,
	            ThingHolder aContainer) {
	        super(aName, aDescription, tl, aContainer);
	        openable = false;
	        isopen = true;        
	    }

	    // alternative constructor sets isopen and openable (e.g. something with lid)
	    
	    public ContainerThing(String aName, String aDescription,
	            boolean canTake, boolean canMove, boolean canOpen, boolean isOpen,
	            ThingList tl, ThingHolder aContainer) {
	        super(aName, aDescription, canTake, canMove, tl, aContainer);
	        openable = canOpen;
	        isopen = isOpen;
	    }

	    public boolean isOpenable() {
	        return openable;
	    }

	    public void setOpenable(boolean openable) {
	        this.openable = openable;
	    }

	    public boolean isOpen() {
	        return isopen;
	    }

	    // --- actions on a Container
	    @Override
	    public String open() {
	        String s;

	        if (!openable) {
	            s = "Can't open " + getName();                       // px: false
	        } else {           
	            if (isopen) {
	                s = "The " + getName() + " is already open.";    // px: false
	            } else {
	                isopen = true;
	                s = "You open the " + getName();                 // px: true
	            }
	        }
	        return s;
	    }

	    @Override
	    public String close() {
	        String s;

	        if (!openable) {
	            s = "Can't close " + getName();                      // px: false
	        } else {
	            if (isopen) {
	                isopen = false;
	                s = "You close the " + getName();                // px: true
	            } else {
	                s = "The " + getName() + " is already closed.";  // px: false
	            }
	        }
	        return s;
	    }

	    @Override
	    public String describe() {
	        String s;
	        
	        s = super.describe();
	        if (openable) {
	            if (isopen) {
	                s += " (open)";
	            } else {
	                s += " (closed)";
	            }
	        }
	        if (isopen) {
	            if (getThings().size() > 0) {
	                s += "\nThere is something in it.";
	            }
	        }
	        return s;
	    }

}
