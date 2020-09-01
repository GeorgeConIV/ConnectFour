package MoveLogic;

import GameLogic.Coordinates;

import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManipulator
{
    Scanner scanner = new Scanner(System.in);
    Scanner fileScan = null;

    List<String> stringList = new ArrayList<>();

    Path inputFile;
    Path outputFile;

    String filePath;
    String pathNoFile;
    String fileName = "defaultProgramName";


    //Regex used for finding file name in file inputFile, used for file creation and consistency
    String regex = "(.+\\\\)*(.+)[.](.+)";
    Pattern nameRegex = Pattern.compile(regex);
    Matcher matcher;

    //used for loop control when invalid inputFile exists
    boolean invalidPath;

    public FileManipulator(String file)
    {
        initFileScanner(file);
    }
    public FileManipulator()
    {
        initFileScanner("lol");
    }

    /**
     * Initializes the file scanner, asks the user to input file path
     */
    public void initFileScanner(String filetoload)
    {
        filePath = "G:/Programming/Java/ConnectFour/nextMove.dat";
        System.out.println("Getting file: " + filePath);

    }

    public List<String> getListOfCommandsWhitespaceDelimited()
    {
        while(fileScan.hasNextLine())
        {
            String toBeStored = fileScan.nextLine();
            stringList.add(toBeStored);
        }

        return stringList;
    }

    public void writeNewCoordinates(Coordinates coord)
    {
        outputFile = Paths.get(filePath);
        try
        {
            Files.write(outputFile, coord.getWriteable(), StandardCharsets.UTF_8);
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.out.println("Something went wrong while writing to the text file");
        }
    }

    public Coordinates readNewCoordinates()
    {
        List<String> coordsString = new ArrayList<>();
        try
        {
            inputFile = Paths.get("G:/Programming/Java/ConnectFour/humanMove.dat");
            fileScan = new Scanner(inputFile);
            System.out.println("Loaded file");
        }
        catch (IOException e)
        {
            System.out.println("ERROR: File not found");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        while(fileScan.hasNextLine())
        {
            coordsString.add(fileScan.nextLine());
        }

        return new Coordinates(Integer.parseInt(coordsString.get(0)), Integer.parseInt(coordsString.get(1)));
    }







    /**
     * This method will find the file name (without .extension) and file path using a regex
     *
     * @return fileName - the name of the file without extension
     */
    public String getFileNameFromCurrentPath()
    {
        try
        {
            matcher = nameRegex.matcher(filePath);      //grabs the file name
            matcher.find();
            fileName = matcher.group(2);
            pathNoFile = matcher.group(1);
        }
        catch(IllegalStateException e)
        {
            System.out.println("File does not follow format.");
            fileName = "defaultLexerName";
        }
        return fileName;
    }

    public Path getInputFile()
    {
        return inputFile;
    }

    public Path getOutputFile()
    {
        return outputFile;
    }

    public String getFileName()
    {
        return fileName;
    }

}