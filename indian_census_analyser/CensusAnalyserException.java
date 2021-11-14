package indian_census_analyser;

public class CensusAnalyserException extends Exception {

	enum ExceptionType {
		CENSUS_FILE_PROBLEM, CSV_FILE_INTERNAL_ISSUES, WRONGFILEEXTENSION
	}

	ExceptionType type;

	public CensusAnalyserException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}
}