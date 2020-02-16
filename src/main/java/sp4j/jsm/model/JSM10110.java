package sp4j.jsm.model;

public class JSM10110 {

	private int exerciseIdx;
	private String exerciseName;
	private String exerciseParts;
	private String exercisePictures;
	private String exerciseVideo;
	private String howtoExercise;
	private String caution;
	private int repetition;
	private int setCount;
	private int restTime;
	
	public int getExerciseIdx() {
		return exerciseIdx;
	}
	public void setExerciseIdx(int exerciseIdx) {
		this.exerciseIdx = exerciseIdx;
	}
	public String getExerciseName() {
		return exerciseName;
	}
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}
	public String getExerciseParts() {
		return exerciseParts;
	}
	public void setExerciseParts(String exerciseParts) {
		this.exerciseParts = exerciseParts;
	}
	public String getExercisePictures() {
		return exercisePictures;
	}
	public void setExercisePictures(String exercisePictures) {
		this.exercisePictures = exercisePictures;
	}
	public String getExerciseVideo() {
		return exerciseVideo;
	}
	public void setExerciseVideo(String exerciseVideo) {
		this.exerciseVideo = exerciseVideo;
	}
	public String getHowtoExercise() {
		return howtoExercise;
	}
	public void setHowtoExercise(String howtoExercise) {
		this.howtoExercise = howtoExercise;
	}
	public String getCaution() {
		return caution;
	}
	public void setCaution(String caution) {
		this.caution = caution;
	}
	public int getRepetition() {
		return repetition;
	}
	public void setRepetition(int repetition) {
		this.repetition = repetition;
	}
	public int getSetCount() {
		return setCount;
	}
	public void setSetCount(int setCount) {
		this.setCount = setCount;
	}
	public int getRestTime() {
		return restTime;
	}
	public void setRestTime(int restTime) {
		this.restTime = restTime;
	}
	
	@Override
	public String toString() {
		return "JSM10110 [exerciseIdx=" + exerciseIdx + ", exerciseName=" + exerciseName + ", exerciseParts="
				+ exerciseParts + ", exercisePictures=" + exercisePictures + ", exerciseVideo=" + exerciseVideo
				+ ", howtoExercise=" + howtoExercise + ", caution=" + caution + ", repetition=" + repetition
				+ ", setCount=" + setCount + ", restTime=" + restTime + "]";
	}
	
}
