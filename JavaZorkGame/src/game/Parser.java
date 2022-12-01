package game;

import globals.WT;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Parser {
	
	static HashMap<String, WT> vocab = new HashMap<>();

    static void initVocab() {
    	//OfficeRoom------------------------------
        vocab.put("door", WT.NOUN);
        vocab.put("degree", WT.NOUN);
        vocab.put("psychology-book", WT.NOUN);
        vocab.put("self-control-book", WT.NOUN);
        vocab.put("poetry-book", WT.NOUN);
        vocab.put("desk", WT.NOUN);
        vocab.put("drawer", WT.NOUN);
        vocab.put("batteries", WT.NOUN);
        vocab.put("laptop", WT.NOUN);
        vocab.put("lamp", WT.NOUN);
        vocab.put("paper", WT.NOUN);
        vocab.put("ammunition", WT.NOUN);
        //---------------------------------------
        //LivingRoom-----------------------------
        vocab.put("TV", WT.NOUN); //thing + containerthing
        vocab.put("taboret", WT.NOUN); //container
        vocab.put("tape", WT.NOUN); //treasure
        vocab.put("camera", WT.NOUN); //thing+container
        vocab.put("cable", WT.NOUN);     //treasure
        vocab.put("controler", WT.NOUN); 
        vocab.put("sofa", WT.NOUN); //thing
        vocab.put("photo", WT.NOUN); //treasure
        vocab.put("fishtank", WT.NOUN); //thing
        //---------------------------------------
        //Kitchen--------------------------------
        vocab.put("door", WT.NOUN); //ContainerThing
        vocab.put("fridge",WT.NOUN);          //ContainerThing
        vocab.put("wine", WT.NOUN);  //thing
        vocab.put("fishfood", WT.NOUN);      //
        vocab.put("wife", WT.NOUN);
        vocab.put("dog", WT.NOUN);
        vocab.put("food", WT.NOUN);
        vocab.put("key", WT.NOUN);
        //---------------------------------------
        //BedRoom--------------------------------
        vocab.put("door", WT.NOUN);
        vocab.put("bed", WT.NOUN);
        vocab.put("belt", WT.NOUN);
        vocab.put("jean", WT.NOUN);
        vocab.put("tshirt", WT.NOUN);
        vocab.put("suit", WT.NOUN);
        vocab.put("commode", WT.NOUN);
        vocab.put("closet", WT.NOUN);
        vocab.put("lamp", WT.NOUN);
        vocab.put("gun", WT.NOUN);
        //---------------------------------------
        //BathRoom-------------------------------
        vocab.put("door", WT.NOUN);
        vocab.put("pills", WT.NOUN);
        vocab.put("mirror",WT.NOUN);
        vocab.put("toilet", WT.NOUN);
        vocab.put("lamp", WT.NOUN);
        //---------------------------------------
        //NOUN-----------------------------------
        vocab.put("sign", WT.NOUN);
        vocab.put("slot", WT.NOUN);
        vocab.put("gonorth", WT.VERB);
        vocab.put("gosouth", WT.VERB);
        vocab.put("gowest", WT.VERB);
        vocab.put("goeast", WT.VERB);
        vocab.put("goup", WT.VERB);
        vocab.put("godown", WT.VERB);
        //---------------------------------------
        //VERB-----------------------------------
        vocab.put("go", WT.VERB);
        vocab.put("drink", WT.VERB);
        vocab.put("play", WT.VERB);
        //vocab.put("test", WT.VERB);
        vocab.put("wear", WT.VERB);
        vocab.put("get", WT.VERB);
        vocab.put("i", WT.VERB);
        vocab.put("inventory", WT.VERB);
        vocab.put("take", WT.VERB);
        vocab.put("give", WT.VERB);
        vocab.put("use", WT.VERB);
        vocab.put("sit", WT.VERB);
        vocab.put("drop", WT.VERB);
        vocab.put("put", WT.VERB);
        vocab.put("l", WT.VERB);
        vocab.put("look", WT.VERB);
        vocab.put("open", WT.VERB);
        vocab.put("close", WT.VERB);
        vocab.put("pull", WT.VERB);
        vocab.put("push", WT.VERB);
        vocab.put("q", WT.VERB);
        vocab.put("quit", WT.VERB);
        vocab.put("pee", WT.VERB);
        vocab.put("lookin", WT.VERB);
        vocab.put("lookat", WT.VERB);
        //---------------------------------------
        //ARTICLE--------------------------------
        vocab.put("a", WT.ARTICLE);
        vocab.put("an", WT.ARTICLE);
        vocab.put("the", WT.ARTICLE);
        //---------------------------------------
        //PREPOSITION----------------------------
        vocab.put("in", WT.PREPOSITION);
        vocab.put("into", WT.PREPOSITION);
        vocab.put("at", WT.PREPOSITION);
        vocab.put("on", WT.PREPOSITION);
        //---------------------------------------
    }
    
    static String processVerbNounPrepositionNoun(List<WordAndType> command) {
        WordAndType wt = command.get(0);
        WordAndType wt2 = command.get(1);
        WordAndType wt3 = command.get(2);
        WordAndType wt4 = command.get(3);
        String msg = "";
        
        if ((wt.getWordtype() != WT.VERB) || (wt3.getWordtype() != WT.PREPOSITION)) {
            msg = "Can't do this because I don't understand ho to '" + wt.getWord() + " something " + wt3.getWord() + "' something!";
        } else if (wt2.getWordtype() != WT.NOUN) {
            msg = "Can't do this because '" + wt2.getWord() + "' is not an object!\r\n";
        } else if (wt4.getWordtype() != WT.NOUN) {
            msg = "Can't do this because '" + wt4.getWord() + "' is not an object!\r\n";
        } else {
            switch (wt.getWord() + wt3.getWord()) {
                case "putin":
                case "putinto":
                    msg = AdventureGame.game.putObInContainer(wt2.getWord(), wt4.getWord());
                    break;
                default:
                    msg = "I don't know how to " + wt.getWord() + " " + wt2.getWord() + " " + wt3.getWord() + " " + wt4.getWord() + "!";
                    break;
            }
        }
        return msg;
    }
    
    static String processVerbPrepositionNoun(List<WordAndType> command) {
        // "look at" is the only implemented command of this type
        WordAndType wt = command.get(0);
        WordAndType wt2 = command.get(1);
        WordAndType wt3 = command.get(2);
        String msg = "";
        
        if ((wt.getWordtype() != WT.VERB) || (wt2.getWordtype() != WT.PREPOSITION)) {
            msg = "Can't do this because I don't understand '" + wt.getWord() + " " + wt2.getWord() + "' !";
        } else if (wt3.getWordtype() != WT.NOUN) {
            msg = "Can't do this because '" + wt3.getWord() + "' is not an object!\r\n";
        } else {
            switch (wt.getWord() + wt2.getWord()) {
                case "lookat":
                    msg = AdventureGame.game.lookAtOb(wt3.getWord());
                    break;
                case "lookin":
                    msg = AdventureGame.game.lookInOb(wt3.getWord());
                    break;
                default:
                    msg = "I don't know how to " + wt.getWord() + " " + wt2.getWord() + " " + wt3.getWord() + "!";
                    break;
            }
        }
        return msg;
    }
    
    static String processVerbNoun(List<WordAndType> command) {
        WordAndType wt = command.get(0);
        WordAndType wt2 = command.get(1);
        String msg = "";

        if (wt.getWordtype() != WT.VERB) {
            msg = "Can't do this because '" + wt.getWord() + "' is not a command!";
        } else if (wt2.getWordtype() != WT.NOUN) {
            msg = "Can't do this because '" + wt2.getWord() + "' is not an object!";
        } else {
            switch (wt.getWord()) {
                case "take":
                case "get":
                    msg = AdventureGame.game.takeOb(wt2.getWord());
                    break;
                case "drop":
                    msg = AdventureGame.game.dropOb(wt2.getWord());
                    break;
                case "open":
                    msg = AdventureGame.game.openOb(wt2.getWord());
                    break;
                case "close":
                    msg = AdventureGame.game.closeOb(wt2.getWord());
                    break;
                case "give":
                    msg = AdventureGame.game.giveOb(wt2.getWord());
                    break;
                /*case "go":
                	msg = AdventureGame.game.goOb(wt2.getWord());
                	break;*/
                /*case "drink":
                	msg = AdventureGame.game.drinkOb(wt2.getWord());
                case "pee":
                	msg = AdventureGame.game.peeOb(wt2.getWord());*/
                default:
                    msg += " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }
    
    /*static String processVerb(List<WordAndType> command) {
        WordAndType wt = command.get(0);
        WordAndType wt2 = command.get(1);
        String msg = "";

        if (wt.getWordtype() == WT.VERB||wt2.getWordtype() == WT.NOUN) {
            msg = "Can't do this because '" + wt.getWord() + "' is not a command!";
        } else {
            switch (wt.getWord()) {
                case "go"+"north":
                    AdventureGame.game.goN();
                    break;
                case "go"+"south":
                    AdventureGame.game.goS();
                    break;
                case "go"+"west":
                    AdventureGame.game.goW();
                    break;
                case "go"+"east":
                    AdventureGame.game.goE();
                    break;
                case "go"+"up":
                    AdventureGame.game.goUp();
                    break;
                case "go"+"down":
                    AdventureGame.game.goDown();
                    break;
                case "l":
                case "look":
                    AdventureGame.game.look();
                    break;
                case "inventory":
                case "i":
                    AdventureGame.game.showInventory();
                    break;
               /* case "test":
                    AdventureGame.game.test();
                    break;
                default:
                    msg = wt.getWord() + " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }*/
    
   static String processVerb(List<WordAndType> command) {
        WordAndType wt = command.get(0);
        String msg = "";

        if (wt.getWordtype() != WT.VERB) {
            msg = "Can't do this because '" + wt.getWord() + "' is not a command!";
        } else {
            switch (wt.getWord()) {
                case "gonorth":
                    AdventureGame.game.goN();
                    break;
                case "gosouth":
                    AdventureGame.game.goS();
                    break;
                case "gowest":
                    AdventureGame.game.goW();
                    break;
                case "goeast":
                    AdventureGame.game.goE();
                    break;
                case "goup":
                    AdventureGame.game.goUp();
                    break;
                case "godown":
                    AdventureGame.game.goDown();
                    break;
                case "l":
                case "look":
                    AdventureGame.game.look();
                    break;
                case "inventory":
                case "i":
                    AdventureGame.game.showInventory();
                    break;
               /* case "test":
                    AdventureGame.game.test();
                    break;*/
                default:
                    msg = wt.getWord() + " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }
    
    static String processCommand(List<WordAndType> command) {
        String s = "";
        
        if (command.size() == 0) {
            s = "You must write a command!";
        } else if (command.size() > 4) {
            s = "That command is too long!";
        } else {           
            switch (command.size()) {
                case 1:
                    s = processVerb(command);
                    break;
                case 2:
                    s = processVerbNoun(command);
                    break;
                case 3:
                    s = processVerbPrepositionNoun(command);
                    break;
                case 4:
                    s = processVerbNounPrepositionNoun(command);
                    break;
                default:
                    s = "Unable to process command";
                    break;
            }
        }
        return s;
    }
    
    static String parseCommand(List<String> wordlist) {
        List<WordAndType> command = new ArrayList<>();
        WT wordtype;
        String errmsg = "";
        String msg;

        for (String k : wordlist) {
            if (vocab.containsKey(k)) {
                wordtype = vocab.get(k);
                if (wordtype == WT.ARTICLE) {       // ignore articles             
                } else {
                    command.add(new WordAndType(k, wordtype));
                }
            } else { // if word not found in vocab
                command.add(new WordAndType(k, WT.ERROR));
                errmsg = "Sorry, I don't understand '" + k + "'";
            }
        }
        if (!errmsg.isEmpty()) {
            msg = errmsg;
        } else {
            msg = processCommand(command);
        }
        return msg;
    }
    
    static List<String> wordList(String input) {
        String delims = "[ \t,.:;?!\"']+";
        List<String> strlist = new ArrayList<>();
        String[] words = input.split(delims);

        for (String word : words) {
            strlist.add(word);
        }
        return strlist;
    }

}
