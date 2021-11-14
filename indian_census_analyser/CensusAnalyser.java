package indian_census_analyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CensusAnalyser {
	public int loadIndiaCensusData(String csvFilepath) throws CensusAnalyserException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvFilepath));
			CsvToBean<IndianCensusCsvFile> csvToBean = new CsvToBeanBuilder(reader).withType(IndianCensusCsvFile.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			Iterator<IndianCensusCsvFile> censusCsvIterator = csvToBean.iterator();
			int numOfEntries = 0;
			while (censusCsvIterator.hasNext()) {
				numOfEntries++;
				IndianCensusCsvFile censusData = censusCsvIterator.next();
			}
			return numOfEntries;
		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		} catch (RuntimeException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
		}
	}
}