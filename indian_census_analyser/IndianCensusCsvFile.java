package indian_census_analyser;

import com.opencsv.bean.CsvBindByName;

public class IndianCensusCsvFile {

	@CsvBindByName(column = "State", required = true)
	public String state;

	@CsvBindByName(column = "Population", required = true)
	public int population;

	@CsvBindByName(column = "AreaInSqKm", required = true)
	public int areaInSqKm;

	@CsvBindByName(column = "DensityPerSqKm", required = true)
	public int densityPerSqKm;

	public IndianCensusCsvFile() {
	}

	public IndianCensusCsvFile(String state, int population, int areaInSqKm, int densityPerSqKm) {
		this.state = state;
		this.population = population;
		this.areaInSqKm = areaInSqKm;
		this.densityPerSqKm = densityPerSqKm;
	}
}
