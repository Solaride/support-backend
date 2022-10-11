package serial;

import com.fazecast.jSerialComm.SerialPort;

import java.util.Arrays;

public class SerialHandler{

  public static void main(String[] args) {
    System.out.println(Arrays.toString(SerialPort.getCommPorts()));
  }

}
