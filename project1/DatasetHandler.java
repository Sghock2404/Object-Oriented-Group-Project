package project1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

/**
 * Handles datasets
 * 
 * @author Himaja
 * @author Scott
 * @author Daniel
 */
public class DatasetHandler {

	/**
	 * 
	 * @throws InvalidPathException
	 * @throws IOException
	 */
	public DatasetHandler() throws InvalidPathException, IOException {

		this.setPaths();
		this.db = new HashSet<Dataset>();
		this.loadDB();
	}

	/**
	 * 
	 */
	public void loadDB() throws IOException {

		// Java 11
		if (Files.notExists(dbPath)) {
			System.out.println("DB file \"" + dbPath.toString() + "\" will be created.");
			Files.createFile(dbPath);
		} else {

			final String content = Files.readString(dbPath);

			// array of lines
			final String[] lines = content.split(System.getProperty("line.separator"));
			Dataset d = null;
			for (final String line : lines) {
				final String[] col = line.split(DataAnalysis.DELIMITER);
				if (col.length > 2) {
					try {
						d = new Dataset(col[0], Path.of(col[1]), Long.parseLong(col[2]));
					} catch (NumberFormatException nfe) {
						System.out.println("Rating is not a number");
					}
				}
				if (d != null) {
					db.add(d);
				}
			}
		}

	}

	/**
	 * 
	 * @return
	 */
	public String printDB() {

		String content = "";
		if (db.size() < 1) {
			content = "dataID,RAW_FILE,RATINGS_NO,STAT_FILE\n";
		}
		for (final Dataset d : db) {
			content = content + d.toString() + DataAnalysis.STAT_FILE_TEMPLATE.replace("<dataID>", d.getDataId()) + "\n";

		}
		System.out.println(content);
		return content;
	}

	/**
	 * 
	 * @throws IOException
	 */
	public void saveDB() throws IOException {
		// Java 11
		String content = this.printDB();
		Files.writeString(dbPath, content);
	}

	/**
	 * 
	 * @param dataID
	 * @param k
	 */
	public void printReport(final String dataID, int k) {

		// implement method
	}

	/**
	 * Saves computed statistics into a file
	 * 
	 * @param dataID
	 */
	public void saveStats(final String dataID) {

		// implement method
	}

	////////////////////// PATH HANDLING
	////////////////////// METHODS//////////////////////////////////////
	/**
	 * 
	 */
	public void setPaths() throws InvalidPathException, IOException {
		String workDir = new java.io.File(".").getCanonicalPath();
		this.folderPath = FileSystems.getDefault().getPath(workDir, DataAnalysis.DB_FOLDER);
		this.dbPath = FileSystems.getDefault().getPath(workDir, DataAnalysis.DB_FOLDER, DataAnalysis.DB_FILENAME);
	}

	/**
	 * 
	 * @return
	 * @throws InvalidPathException
	 */
	public Path getDbPath() throws InvalidPathException {
		return this.dbPath;
	}

	/**
	 * 
	 * @return
	 * @throws InvalidPathException
	 */
	public Path getFolderPath() throws InvalidPathException {
		return this.folderPath;
	}

	/**
	 * 
	 * @return int number of dataset entries
	 */
	public int getDataSets() {
		return this.db.size();
	}

	/**
	 * 
	 * @param dataId
	 * @return true if it exists in the datasets already
	 */
	public boolean checkID(String dataID) {

		return this.db.stream().anyMatch(t -> t.getDataId().equals(dataID));
	}

	public Path defineRawPath(String input) throws InvalidPathException, IOException {

		Path pathRaw = FileSystems.getDefault().getPath(folderPath.toString(), input);
		if (!Files.exists(pathRaw)) {
			Files.createFile(pathRaw);
			System.out.println(pathRaw + " created");
		}
		return pathRaw;
	}

	public Path defineStatPath(final String dataID) throws InvalidPathException, IOException {

		String temp = DataAnalysis.STAT_FILE_TEMPLATE.replace("<dataID>", dataID);
		Path pathStat = FileSystems.getDefault().getPath(folderPath.toString(), temp);
		if (!Files.exists(pathStat)) {
			Files.createFile(pathStat);
			System.out.println(pathStat + " created");
		}
		return pathStat;
	}

	public Path defineReportPath(final String dataID) throws InvalidPathException, IOException {

		String temp = DataAnalysis.REPORT_FILE_TEMPLATE.replace("<dataID>", dataID);
		Path pathStat = FileSystems.getDefault().getPath(folderPath.toString(), temp);
		if (!Files.exists(pathStat)) {
			Files.createFile(pathStat);
			System.out.println(pathStat + " created");
		}
		return pathStat;
	}

	/**
	 * 
	 * @param inData
	 * @return false if both loads failed
	 */
	public boolean addDataset(Dataset inData) {

		boolean loaded = false;
		if (Files.exists(inData.getRawFile())) {
			loaded = addRatings(inData);
		}

		try {
			Path statPath = defineStatPath(inData.getDataId());
			if (Files.exists(statPath)) {
				loaded = loaded || addStats(inData);
			}
		} catch (Exception e) {
			System.out.println("Loading statistics failed");
		}

		return loaded;
	}

	/**
	 * Saves computed statistics into a file
	 * 
	 * @param inData
	 */
	public boolean addRatings(Dataset inData) {
		// assume element is initialized with dataID and path to raw data
		// implement method
		return true;
	}

	/**
	 * Saves computed statistics into a file
	 * 
	 * @param inData
	 */
	public boolean addStats(Dataset inData) {
		// assume element is initialized with dataID and path to raw data
		// implement method
		return true;
	}

	/**
	 * 
	 * @param dataID
	 * @return reference to dataset object to be loaded
	 * @throws IOException
	 */
	public Dataset getCollection(String dataID) throws IOException {
		// implement method
		return null;
	}

	/**
	 * 
	 * @param dataID
	 * @return reference to dataset object to be loaded
	 * @throws IOException
	 */
	public Dataset setCollection(String dataID) throws IOException {
		Dataset found = null;
		Iterator<Dataset> value = this.db.iterator();
		while (value.hasNext()) {
			found = value.next();
			if (dataID.contains(found.getDataId())) {
				this.addDataset(found);
				break;
			}
		}
		return found;
	}

	/**
	 * WARNING:you are to replace old record of **dataID** with new one here
	 * 
	 * @param dataID
	 * @param input
	 * @return if the unique identifier is already there or no
	 */
	public boolean addCollection(final String dataID, final String input) {

		// implement method
		return true;
	}

	private final Set<Dataset> db;
	private Path folderPath;
	private Path dbPath;
}
