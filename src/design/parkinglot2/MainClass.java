package design.parkinglot2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by mukulbudania on 2/12/16.
 */
public class MainClass {
    private static CommandExecutor commandExecutor;
    static {
        commandExecutor = new CommandExecutor(new ParkingLot());
    }
    public static void main(String[] args){
        switch (args.length){
            case 0:
                Scanner in = new Scanner(System.in);
                while(in.hasNext()){
                    String line = in.nextLine().trim();
                    if(! "".equals(line)){
                        System.out.println(commandExecutor.execute(CommandParser.parse(line)));
                    }
                }
                break;
            case 1:
                BufferedReader br = null;
                String sCurrentLine;
                try{
                    br = new BufferedReader(new FileReader(args[0]));
                    while ((sCurrentLine = br.readLine()) != null){
                        if(! "".equals(sCurrentLine.trim()))
                        System.out.println(commandExecutor.execute(CommandParser.parse(sCurrentLine)));
                    }
                } catch (IOException e) {
                    System.out.println("Couldn't read file");
                } finally {
                    try {
                        if (br != null) br.close();
                    } catch (IOException ex) {
                        System.out.println("Couldn't close file");
                    }
                }
                break;
            default:
                System.out.println("Errors:\nWrong number of Arguments given\n");
                System.out.println(UsageHelper.getUsage("Main"));
        }
    }
}
