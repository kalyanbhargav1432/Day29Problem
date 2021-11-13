package indian_census_analyser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CensusAnalyser {
	public static void main(String[] args) {
		String path = "E:\\CSVFile\\IndiaStateCensusData - IndiaStateCensusData.csv";
		String line = "";
		try {

			BufferedReader bufferReader = new BufferedReader(new FileReader(path));
			while ((line = bufferReader.readLine()) != null) {
				String[] values = line.split(",");
				System.out.println("State:" + values[0] + ",Population:" + values[1] + ",AreaInSqKm:" + values[2]
						+ ",DensityPerSqKm:" + values[3]);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}