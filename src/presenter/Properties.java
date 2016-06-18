package presenter;

import java.io.Serializable;

public class Properties implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5446648390847167773L;

	private String mazeGenerator;
	private String solveAlgorithm;
	private Integer maxNumOfThreads;
	private String runtimeEnv;
	
	public Properties() {
		mazeGenerator = "MyMaze3dGenerator";
		solveAlgorithm = "DFS";
		maxNumOfThreads = 2;
		runtimeEnv = "GUI";
       
	}

	public Properties(String mazeGenerator, String solveAlgorithm,String runtimeEnv, Integer maxNumOfThreads) {
		super();
		this.mazeGenerator = mazeGenerator;
		this.solveAlgorithm = solveAlgorithm;
		this.maxNumOfThreads = maxNumOfThreads;
		this.runtimeEnv = runtimeEnv;

	}


	public String getMazeGenerator() {
		return mazeGenerator;
	}

	public void setMazeGenerator(String mazeGenerator) {
		this.mazeGenerator = mazeGenerator;
	}

	public String getSolveAlgorithm() {
		return solveAlgorithm;
	}

	public void setSolveAlgorithm(String solveAlgorithm) {
		this.solveAlgorithm = solveAlgorithm;
	}

	public Integer getMaxNumOfThreads() {
		return maxNumOfThreads;
	}

	public void setMaxNumOfThreads(Integer maxNumOfThreads) {
		this.maxNumOfThreads = maxNumOfThreads;
	}

	public String getRuntimeEnv() {
		return runtimeEnv;
	}

	public void setRuntimeEnv(String runtimeEnv) {
		this.runtimeEnv = runtimeEnv;
	}

}
