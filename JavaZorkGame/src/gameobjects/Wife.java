package gameobjects;

import java.util.Map;
import globals.Dir;
import globals.ThingAndThingHolder;
import gameobjects.Room;

@SuppressWarnings("serial")
public class Wife extends ThingHolder implements java.io.Serializable {
	

	//  private Room location; // the Room where the Person is at present
    /*public Wife(String aName, String aDescription, ThingList tl, Room aRoom) {
        super(aName, aDescription, tl, aRoom); // init super class       
    }*/

    private static ThingList tl;
	private static ThingHolder aRoom;

	public Wife(String aName, String aDescription, Wife wife_character, Room kitchen, ThingList tl, ThingHolder aRoom) {
    	super(aName, aDescription, tl, aRoom);
	}

	public void setLocation(Room Kitchen) {
        setContainer(Kitchen);
    }

    public Room getLocation() {
        return (Room) getContainer();
    }

    public String describeLocation() {
        return ((Room) getContainer()).describe();
    }
    
    public String giveOb(String obname) {
    	String s;
        ThingAndThingHolder t_th;
        Thing t;

        t_th = this.findThing(obname);
        if (t_th == null) {
            s = "You didn't give the " + obname + ".";
        } else {
            t = t_th.getThing();
            transferOb(t, t_th.getThingHolder(), this.getLocation());
            s = obname + " gave!";
        }
		return s;
	}
    
    
    
    public Boolean moveTo(Dir dir) {
        Room r; 
        Room exit;
        Boolean moved = false;

        r = getLocation();
        switch (dir) {
            case GONORTH:
                exit = r.getN();
                break;
            case GOSOUTH:
                exit = r.getS();
                break;
            case GOEAST:
                exit = r.getE();
                break;
            case GOWEST:
                exit = r.getW();
                break;
            case GOUP:
                exit = r.getUp();
                break;
            case GODOWN:
                exit = r.getDown();
                break;
            default:
                exit = null; // noexit - stay in same room
                break;
        }
        if (exit != null) {
            setLocation(exit);
            moved = true;
        }
        return moved;
    }
    

}
