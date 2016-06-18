package presenter;

import java.io.Serializable;

public class Properties implements Serializable {

	

	/**
	 * 
	 */
	
	/*
	 * DFS = 0 / BFS = 1 / breadthfs = 2
	 * GUI = 0 / CLI = 1
	 * Simple  = 0 / Advanced = 1 
	 * 
	 */
	
	private static final long serialVersionUID = 5446648390847167773L;
	private Integer mazeGenerator;
	private Integer solveAlgorithm;
	private Integer maxNumOfThreads;
	private Integer runtimeEnv;
	
	public Properties() {
		mazeGenerator = 1;
		solveAlgorithm = 2;
		maxNumOfThreads = 3;
		runtimeEnv = 0;
       
	}

	public Properties(Integer mazeGenerator, Integer solveAlgorithm,Integer runtimeEnv, Integer maxNumOfThreads) {
		super();
		this.mazeGenerator = mazeGenerator;
		this.solveAlgorithm = solveAlgorithm;
		this.maxNumOfThreads = maxNumOfThreads;
		this.runtimeEnv = runtimeEnv;

	}


	public Integer getMazeGenerator() {
		return mazeGenerator;
	}

	public void setMazeGenerator(Integer mazeGenerator) {
		this.mazeGenerator = mazeGenerator;
	}

	public Integer getSolveAlgorithm() {
		return solveAlgorithm;
	}

	public void setSolveAlgorithm(Integer solveAlgorithm) {
		this.solveAlgorithm = solveAlgorithm;
	}

	public Integer getMaxNumOfThreads() {
		return maxNumOfThreads;
	}

	public void setMaxNumOfThreads(Integer maxNumOfThreads) {
		this.maxNumOfThreads = maxNumOfThreads;
	}

	public Integer getRuntimeEnv() {
		return runtimeEnv;
	}

	public void setRuntimeEnv(Integer runtimeEnv) {
		this.runtimeEnv = runtimeEnv;
	}

}
