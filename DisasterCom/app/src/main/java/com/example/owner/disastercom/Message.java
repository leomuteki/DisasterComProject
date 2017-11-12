package com.example.owner.disastercom;

import java.util.ArrayList;
/**
 * Created by calva on 11/11/2017.
 */

public class Message {
    public ArrayList<String> pathToSender;
    public String message;
    public String myID;
    public String goal;
    public ArrayList<String> visitedDevices; //Index 0 is sender device
    //constructors
    public void Message(String message, String myID, String goal){
        this.message = message;
        visitedDevices = new ArrayList<String>();
        visitedDevices.add(myID);
        this.goal = goal;
    }
    public void Message(byte[] encodedMessage, String myID){
        this.message = message;
        visitedDevices = new ArrayList<String>();
        visitedDevices.add(myID);
    }
    //functions
    public byte[] encode(){
        ArrayList<byte[]> workingArray = new ArrayList<byte[]>();

        byte inputGoalArray[] = goal.getBytes();
        workingArray.add(inputGoalArray);
        byte inputMessageArray[] = message.getBytes();
        workingArray.add(inputMessageArray);
        for (String visitedStr : visitedDevices) {
            workingArray.add(visitedStr.getBytes());
        }

        // Get the total size of the output array including start signals and end signals
        int outputArraySize = 0;
        for (byte[] curEncodedString : workingArray) {
            outputArraySize += curEncodedString.length + 2;
        }
        byte[] outputArray = new byte[outputArraySize];
        int outputArrayIndex = 0;
        for (byte[] curEncodedString : workingArray) {
            // Add a start signal for the current encoded string
            outputArray[outputArrayIndex] = 0x0;
            outputArrayIndex++;
            // Fill in current Byte[]
            for (byte curByte : curEncodedString){
                outputArray[outputArrayIndex] = curByte;
                outputArrayIndex++;
            }
            // Insert ending signal for the end of the currently encoded string
            outputArray[outputArrayIndex] = 0xf;
            outputArrayIndex++;
        }
        return outputArray;
    }
    public byte[] decode(){
        //ignore first byte and goal bytes
        //read and output message bytes
        //convert final bytes to pathToSender
        byte[] outputByteArray = new byte[10];
        return outputByteArray;
    }
}