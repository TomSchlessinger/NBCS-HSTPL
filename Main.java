/*
  This programming language, by Tom Schlessinger was made to prove that it is possible to make a language without every line going to the next automatically. there are no if statements or variables because I didn't think they were necessary to prove my point.
To run, fork this program and write your code in main.nbcs
There are a few rules:
Every line must have a GOTO statement at the end
To end the program you must do GOTO_0
you have to have and average of 1.5 'END' statements per line(eg. 5 lines means you need between 5 and 7 'END statements anywhere in the code' )
there is only adding, no multiplication, no subtraction and it is with additionify]x + y[
the only way to concatenate is with concord]"hello" + " world"[
remember, I made this as a joke, so there are for sure hundreds of bugs

*/

import java.io.IOException;
import java.util.*;
import java.beans.Statement;

class Main {
  //different logical operators: IS_IS(==) ANTIIS (!=) DISAGREE(!) additionally (&&) contrarily(||) HOLIER(>) INFERIOR(<) COOLER(>=) WEAKER(<=)
  public static int getGoto(String line){
    boolean hasTok = false;
    String tok[] = line.split("\\s");//ajfja sofahjof sijfo GOTO_7 -> [ajfja,sofahjof ,sijfo,GOTO_7] --> i need to remove the last token in this list, then take out the GOTO_ to get the return
    for(String i: tok){
      if(i.indexOf("GOTO") == 0){//if theres any token that starts with GOTO(this means that strings can contain GOTO), then do the following code
        
        String finalLine = i.substring(i.indexOf("_") + 1,i.length());
        hasTok = true;        
        return Integer.parseInt(finalLine);
        
      }
      else{
        hasTok = false;
      }
    }
    if(hasTok == false){
      System.out.println("BOZO REMEMBER TO PUT A GOTO STATEMENT!!!");
      System.exit(0);
    }
    return 0;
  }

  public static String getVarVal(String name, Map<String,String> map){//gets the var value in the map
    return map.get(name);
  }
  public static String getParamString(String line){//gets the param if the param should be a string
    int pos1 = line.indexOf("]\"");
    int pos2 = line.indexOf("\"[");
    return line.substring(pos1+2,pos2);
  }
  public static String getParam(String line, Map<String,String> map){//gets the param
    int pos1 = line.indexOf("]");
    int pos2 = line.indexOf("[");
    String bm = "i";
    /*
    additionify(3,i) -> 3 + i
    i -> search the map and if it exists then use it
    */
    if(bm != null){
      try{
        map.get(bm);
      }catch(NullPointerException k){
        System.out.println("declare the variable, dingus pingus");//if you forgot to declare the variable
      }
    }
      
    return line.substring(pos1+1,pos2);
  }
  
  public static HashMap<String,String> runCode (String line, int index, String[] lines, HashMap<String,String> map ){
    int qIndex1 = -1;
    int qIndex2 = -1;
    String[] lineArr = line.split("\\s");
    for(int i = 0; i < lineArr.length;i++){
      if(lineArr[i].equals("\"")){
        int j = i;
        qIndex1=i;
        while(!lineArr[j+1].equals("\"") && j<lineArr.length-1){
          j++;
          qIndex2=j;
        }
      }
      if(qIndex1>qIndex2 && qIndex1>0){
        line = line.substring(0,qIndex1+1) + line.substring(qIndex2,line.length());
      }
      lineArr=line.split("\\s");
    }
    String command = lineArr[0];
      switch(command){
        case "SAY":
          lineArr[0] = "";
          System.out.println(getParamString(line));
          break;
        case "VAR":
          lineArr[0] = "";
          String val = "";
          val = getParam(line,map);
          map.put(lineArr[1],val);
          //System.out.println(map.get(lineArr[1]));
          break;
        case "additionify":
          lineArr[0] = "";
          val = "";
          val = getParam(line,map);
          String add1;
          String[] add2;
          add1 = Arrays.toString( ( val.split("\\s") ) );
          add1 = add1.replace(", +,", " +");
          add1 = add1.replaceAll("[,\\[\\]]", "");
          add2 = add1.split("\\s");
          System.out.println(Integer.parseInt(add2[0]) + Integer.parseInt(add2[2]));
          break;
        case "concord":
          lineArr[0] = "";
          val = "";
          val = getParam(line,map);
          String addString1 = val.substring(val.indexOf('"') + 1 ,val.indexOf("\" + \""));
          String addString2 = val.substring(5+val.indexOf("\" + \""),val.lastIndexOf('"'));
          System.out.println(addString1+addString2);
          break;
        /*case "I_Really_Hate_Myself_Becaues_I_Really_BADly_want_to_code_in_a_worser_inferior_language":
          lineArr[0] = "";
          Statement code()
          break;*/
          
      }
    
    if(getGoto(line)!=0){
      map = runCode(lines[getGoto(line) -1 ], getGoto(line)-1, lines, map) ;
    }
    else{
      System.out.println("\n\nPROGRAM ENDED");
    }
    return map;
  }
  
  public static void main(String[] args) {
    Map<String,String> vars = new HashMap<String,String>();//stores all variables as strings lol
    FileArrayProvider prov = new FileArrayProvider();
      try {
        String[] Hi__FRIEND_NAME_HERE_you_have_to_check_out_this_game__its_the_MOST_innovative_shooter_ive_played_in_years = prov.readLines("config/config2/config3/config4/text.dontreadme");
        String bar = Hi__FRIEND_NAME_HERE_you_have_to_check_out_this_game__its_the_MOST_innovative_shooter_ive_played_in_years[0];
        String bar2 = Hi__FRIEND_NAME_HERE_you_have_to_check_out_this_game__its_the_MOST_innovative_shooter_ive_played_in_years[1];
        System.out.println(bar + "\n\n" + bar2 + "\n") ;
      }catch(IOException e) {//don't delete the 'config' files
        System.out.println("YOU FOOL WHAT HAVE YOU DONE\n");
        System.out.println("YOU FOOL WHAT HAVE YOU DONE\n");
        System.out.println("YOU FOOL WHAT HAVE YOU DONE\n");
        System.out.println("YOU FOOL WHAT HAVE YOU DONE\n");
        System.out.println("YOU FOOL WHAT HAVE YOU DONE\n");
        System.exit(0);
      }
    
      try {//'END' counter code. Why? just because lol
        String[] lines = prov.readLines("main.nbcs");
        int END_MIN = lines.length;
        int END_COUNTER = 0;
        for (String line : lines) {
          StringTokenizer ts = new StringTokenizer(line);
          while(ts.hasMoreTokens()){
            String b = ts.nextToken();
            if(b.equals("END")){
              END_COUNTER++;
            }
          }
      
        }
        
        if(END_COUNTER < END_MIN || END_COUNTER > (int) (1.5*END_MIN)){
          System.out.printf(("NBCS.brain.InsufficientEnds: YOUR PROGRAM DOES NOT HAVE ENOUGH ENDS\n      At: main.nbcs\n      WRITE SOME MORE ENDS. \n      IT DOES NOT MATTER WHERE. \n      WRITE.\n      THEM. \nTHERE MUST BE AT LEAST %d ENDS AND AT MOST %d ENDS"),END_MIN, (int) (1.5*END_MIN) );
          System.exit((int)((END_MIN + 1.5*END_MIN)/2));
        }
        HashMap<String,String> varMap = new HashMap<String,String>();
        varMap = runCode(lines[0], 0, lines, varMap);
        /*for (int i = 0; i<lines.length;i++) {
          runCode(lines[i], i, lines, new HashMap<String,String>());
        }*/

        
      }catch(IOException e) {
        e.printStackTrace();
      }
  }
}   