package indian_census_analyser;

import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyserTest {
	private static final String INDIA_CENSUS_CSV_FILEPATH = "E:\\CSVFile/IndiaStateCensusData.csv";
	private static final String INDIA_CENSUS_WRONGEXTENSION = "E:\\CSVFile/IndiaStateCensusData.txt";
	private static final String WRONG_FILE_PATH = "E:\\CSVFile/IndiaStateCensusData.csv";
	private static final String INDIA_CENSUS_CSV_WRONGDELIMITER = "E:\\CSVFile/IndiaStateCensusDataWrongDelimiter.csv";
	private static final String STATE_CODE_CSV = "E:\\CSVFile/IndiaStateCode.csv";
	private static final String WRONG_STATE_CODE_CSV_FILE = "E:\\CSVFile/IndiaStateCode.csv";
	private static final String STATECODECSV_WRONGDELIMITER = "E:\\CSVFile/IndiaStateCodeWrongDelimiter.csv";
	private static final String STATE_CODE_WRONGEXTENSION = "E:\\CSVFile/IndiaStateCode.txt";

	@Test
	public void givenIndiaCensusCsvFile_ReturnsCorrectRecords() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILEPATH);
			Assert.assertEquals(29, numOfRecords);
		} catch (CensusAnalyserException e) {
		}
	}

	@Test
	public void givenWrongIndiaCensusCsvFile_ReturnsException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaCensusData(WRONG_FILE_PATH);
			Assert.assertEquals(29, numOfRecords);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}

	@Test
	public void givenWrongType_ReturnsCustomException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_WRONGEXTENSION);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONGFILEEXTENSION, e.type);
		}
	}

	@Test
	public void givenWrongDelimiter_ReturnCustomException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_WRONGDELIMITER);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES, e.type);
		}
	}

	@Test
	public void givenIncorrectCsvHeader_ShouldReturnCustomException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_WRONGDELIMITER);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES, e.type);
		}
	}

	@Test
	public void givenStateCodeFile_ReturnsCorrectRecords() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadStateCodeData(STATE_CODE_CSV);
			Assert.assertEquals(37, numOfRecords);
		} catch (CensusAnalyserException e) {
		}
	}

	@Test
	public void givenWrongStateCodePath_ReturnsCustomException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadStateCodeData(WRONG_STATE_CODE_CSV_FILE);
			Assert.assertEquals(37, numOfRecords);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}

	@Test
	public void givenStateCodeWrongDelimiter_ReturnCustomException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaCensusData(STATECODECSV_WRONGDELIMITER);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES, e.type);
		}
	}

	@Test
	public void givenWrongHeadersForStateCodeCsv_ReturnsCustomeException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadStateCodeData(STATECODECSV_WRONGDELIMITER);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES, e.type);
		}
	}

	@Test
	public void givenWrongExtension_ReturnsCustomException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadStateCodeData(STATE_CODE_WRONGEXTENSION);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONGFILEEXTENSION, e.type);
		}
	}
}