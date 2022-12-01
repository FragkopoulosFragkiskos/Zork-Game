package game;


import java.util.*;     // required for ArrayList
import gameobjects.Actor;
import gameobjects.ContainerThing;
import gameobjects.Room;
import gameobjects.Thing;
import gameobjects.ThingList;
import gameobjects.Treasure;
import globals.Test;
import gameobjects.Wife;
import globals.Dir;


public class Game implements java.io.Serializable {
	
	 private ArrayList<Room> map; // the map - an ArrayList of Rooms    
	 private Actor player;  // the player - provides 'first person perspective'  
	 private Wife wife_character;
	 //private Wife wife_character;
	 private String obname;

	 public Game() {
		 Parser.initVocab();
		 initGame();
	    }
	 
	 private void initGame() {
	        this.map = new ArrayList<Room>();
	        // --- construct a new adventure ---

	        ThingList LivingRoomList = new ThingList("LivingRoomList");
	        ThingList KitchenList = new ThingList("KitchenList");
	        ThingList BedRoomList = new ThingList("BedRoomList");
	        ThingList OfficeRoomList = new ThingList("OfficeRoomList");
	        ThingList BathRoomList = new ThingList("BathRoomList");
	        ThingList playerlist = new ThingList("playerlist");
	        ThingList wife_characterlist = new ThingList("wife_characterlist");
	        
	        Room LivingRoom = new Room();
	        Room Kitchen = new Room();
	        Room BedRoom = new Room();
	        Room OfficeRoom = new Room();
	        Room BathRoom = new Room();
	        
	        // openable = false;
	        // isopen = true;
	        
	        
	        LivingRoomList.add(new ContainerThing("TV", "It's a 50 inch television, too heavy to take it",true, true, true, true,new ThingList("LivingRoomList"), LivingRoom));
	        LivingRoomList.add(new Thing("deskside_table","wood",true,true, LivingRoom));
	        LivingRoomList.add(new ContainerThing("video_camera","it's empty",true,true,true,true,new ThingList("LivingRoomList"), LivingRoom));
	        LivingRoomList.add(new Treasure("video_tape", "talkng about deja vu things", 1, LivingRoom));
	        LivingRoomList.add(new Treasure("cable","2 metres long",1, LivingRoom));
	        LivingRoomList.add(new Thing("remote_control","no batteries",true,true, LivingRoom));
	        LivingRoomList.add(new Thing("sofa","it's dusty",true,true, LivingRoom));
	        LivingRoomList.add(new Thing("photo","i have no memory of this face",true,true, LivingRoom));
	        LivingRoomList.add(new Thing("fish_tank","there's a goldfish",true,true, LivingRoom));
	        
	        
	        
	        KitchenList.add(new ContainerThing("door","an old wooden door",false,false,true,false,new ThingList("KitchenList"), Kitchen));
	        KitchenList.add(new ContainerThing("fridge","it's empty",false,false,true,false,new ThingList("KitchenList"), Kitchen));
	        KitchenList.add(new Thing("wine","is it half empty or is it half full?",true,true, Kitchen));
	        KitchenList.add(new ContainerThing("fishfood","i should feed the goldfish",true,true,true,true,new ThingList("KitchenList"), Kitchen));
	        KitchenList.add(new Thing("dog","wagging his tail*",true,true, Kitchen));
	        KitchenList.add(new ContainerThing("food","it's sealed,feed the dog",true,true,true,true,new ThingList("KitchenList"), Kitchen));
	        KitchenList.add(new Treasure("key","office key",1, Kitchen));
	        
	        
	        BedRoomList.add(new ContainerThing("door", "an old wooden door", true,false,false,false,new ThingList("BedRoom"),BedRoom));
	        BedRoomList.add(new Thing("bed", "looks comfy", true, true,BedRoom));
	        BedRoomList.add(new Treasure("belt","it's made of leather",1, BedRoom));
	        BedRoomList.add(new Treasure("jean","it's my favorite color", 1 ,BedRoom));
	        BedRoomList.add(new Treasure("tshirt", " a wite tshirt", 1,BedRoom));
	        BedRoomList.add(new Treasure("suit","it's elegant",1, BedRoom));
	        BedRoomList.add(new Thing("commode","there is a combination lock on it", false,false, BedRoom));
	        BedRoomList.add(new ContainerThing("closet","it's full of clothes",false,false,true,false,new ThingList("BedRoomList"), BedRoom));
	        BedRoomList.add(new Thing("lamp","i should turn on the light",false,false , BedRoom));
	        BedRoomList.add(new ContainerThing("gun","it is empty, maybe i should fill it",false,false,true,false,new ThingList("BedRoomList") , BedRoom));
	        
	        BathRoomList.add(new ContainerThing("door", "its moisty", false,false,true,false,new ThingList("BathRoomList"),BathRoom));
	        BathRoomList.add(new Treasure("pills", "i remember i take three of those, should i take them?", 1,BathRoom));
	        BathRoomList.add(new Thing("mirror", "why are there three reflections?", false,false,BathRoom));
	        BathRoomList.add(new Thing("toilet", "looks dirty", false,false,BathRoom));
	        BathRoomList.add(new Thing("lamp", "i should turn on the light", false,false,BathRoom));
	        
	        OfficeRoomList.add(new ContainerThing("door", "it is made of metal", false,false,true,false,new ThingList("OfficeRoomList"),OfficeRoom));
            OfficeRoomList.add(new Thing("degree", "looks like it's my wife's", false,false,OfficeRoom));
            OfficeRoomList.add(new Treasure("psychology-book", "Thinking Fast and Slow by Daniel Kahneman",1,OfficeRoom));
            OfficeRoomList.add(new Treasure("self-control-book", "The Marshmallow Test by Walter Mischell",1,OfficeRoom));
            OfficeRoomList.add(new Treasure("poetry-book", "Tales of Horror by Edgar Allan Poe",1,OfficeRoom));
            OfficeRoomList.add(new ContainerThing("desk", "it's very heavy. There's a laptop on it",true,true,true,true,new ThingList("OfficeRoomList") ,OfficeRoom));
            OfficeRoomList.add(new ContainerThing("drawer", "there is a pack of batteries", false,false,true,false,new ThingList("OfficeRoomList"),OfficeRoom));
            OfficeRoomList.add(new ContainerThing("batteries", "triple A", true,true,true,true,new ThingList("OfficeRoomList"),OfficeRoom));
            OfficeRoomList.add(new ContainerThing("laptop", "looks promising", true,true,true,true,new ThingList("OfficeRoomList"),OfficeRoom));
            OfficeRoomList.add(new ContainerThing("lamp", "i should turn on the light", false,false,true,false,new ThingList("OfficeRoomList"),OfficeRoom));
            OfficeRoomList.add(new Treasure("paper", "584",1,OfficeRoom));
            OfficeRoomList.add(new ContainerThing("ammunition", "nine mm bullets",true,true,true,true,new ThingList("OfficeRoomList") ,OfficeRoom));
            
            
            
            //                                                    NORTH,        SOUTH,     EAST,         WEST       UP    DOWN
            
            BedRoom.init("BedRoom","comfortable place to sleep",  null,       BathRoom,    null,       LivingRoom,  null, null, BedRoomList);
            LivingRoom.init("LivingRoom","a nice place to chill", OfficeRoom, null,        BedRoom,    Kitchen,     null, null, LivingRoomList);
            BathRoom.init("BathRoom","a nice place to chill",     null,       BedRoom,     null,       OfficeRoom,  null, null, BathRoomList);
            Kitchen.init("Kitchen","a nice place to chill",       null,       null,        LivingRoom, null,        null, null, KitchenList);
            OfficeRoom.init("OfficeRoom","a nice place to chill", null,       LivingRoom,  BathRoom,   null,        null, null, OfficeRoomList);
            
            map.add(LivingRoom);
            map.add(BedRoom);
            map.add(Kitchen);
            map.add(BathRoom);
            map.add(OfficeRoom);

            // create player and set location
            player = new Actor("player", "a chaotic psychopath game-player", playerlist, BedRoom);
            wife_character = new Wife("wife_character", "a lovely Lady", wife_character, Kitchen, KitchenList, Kitchen);
        }

        // access methods     

        public String putObInContainer(String obname, String containername) {
            return player.putInto(obname, containername);
        }

        public String openOb(String obname) {
            return player.openOb(obname);
        }

        public String closeOb(String obname) {
            return player.closeOb(obname);
        }
        
        public String giveOb(String word) {
			return player.giveOb(obname);
		}

        String takeOb(String obname) {
            String retStr;
            
            retStr = player.take(obname);
            return retStr;
        }

        String dropOb(String obname) {
            String retStr;
            
            retStr = player.drop(obname);
            return retStr;
        }
        
        
        

        void movePlayerTo(Dir dir) {                
            if (player.moveTo(dir)) {
                look();            
            } else {
                showStr("No Exit!");
            }
        }
         

        void goN() {
            movePlayerTo(Dir.GONORTH);
        }

        void goS() {
            movePlayerTo(Dir.GOSOUTH);
        }

        void goW() {
            movePlayerTo(Dir.GOWEST);
        }

        void goE() {
            movePlayerTo(Dir.GOEAST);
        }

        void goUp() {
            movePlayerTo(Dir.GOUP);
        }

        void goDown() {
            movePlayerTo(Dir.GODOWN);
        }

        void look() {
            showStr("You are in the " + player.describeLocation());
        }

        // utility method to display string if not empty
        // stripping any trailing newlines
        void showStr(String s) {
            if (s.endsWith("\n")) {
                s = s.substring(0, s.length() - 1);
            }
            if (!s.isEmpty()) {
                System.out.println(s);
            }
        }

        void showInventory() {
            showStr(player.inventory());
        }

        String lookAtOb(String obname) {
            return player.lookAt(obname);
        }

        String lookInOb(String obname) {
            return player.lookIn(obname);
        }
        
        /*String drinkOb(String obname) {
			
			return player.pee(obname);
		}*/

        public void showIntro() {
            String s;

            s = "You have arrived in your house\n"
                    + "voices come from your bedroom,\n"
            		+ "you run at it and you see two copies of yourself.\n"
                    + "you faint, you wake up on your bed.\n"
                    + "What do you want to do?\n"
                    + "Enter: lookin,north, south, west, east, up, down\n"
                    + "or q to quit.";
            showStr(s);
            look();
        }

        public String runCommand(String inputstr) {
            List<String> wordlist;
            String s;
            String lowstr;

            s = "ok";
            lowstr = inputstr.trim().toLowerCase();
            
            if (!lowstr.equals("q")) {
                if (lowstr.equals("")) {
                    s = "You must enter a command";
                } else {
                    wordlist = Parser.wordList(lowstr);
                    s = Parser.parseCommand(wordlist);
                }
            }
            return s;
        }

        // Test..... BEGIN
        void showTest(String s) {
            showStr("> " + s);
            showStr(runCommand(s));
        }
}