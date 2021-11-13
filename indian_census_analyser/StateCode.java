package indian_census_analyser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StateCode {
	public static void main(String[] args) {
		String path = "E:\\CSVFile\\IndiaStateCode - IndiaStateCode.csv";
		String line = "";
		try {

			BufferedReader bufferReader = new BufferedReader(new FileReader(path));
			while ((line = bufferReader.readLine()) != null) {
				String[] values = line.split(",");
				System.out.println("SI.NO:" + values[0] + ",StateName:" + values[1] + ",TIN:" + values[2]
						+ ",StateCode:" + values[3]);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
