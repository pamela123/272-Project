package Servlets;

public class DataBean {
	private String creationYear;
	private String totalAnswers;
	private String totalQuestions;
	private String creationHour;
	private String tags;
	private String mostScoredQuestion;
	private String score;
	private String favouriteQuestion;
	private String favouriteCount;
	private String overviewQuestions;
	
	public String getCreationYear() {
		return creationYear;
	}
	public void setCreationYear(String creationYear) {
		this.creationYear = creationYear;
	}
	public String getTotalAnswers() {
		return totalAnswers;
	}
	public void setTotalAnswers(String totalAnswers) {
		this.totalAnswers = totalAnswers;
	}
	public String getTotalQuestions() {
		return totalQuestions;
	}
	public void setTotalQuestions(String totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	public String getCreationHour() {
		return creationHour;
	}
	public void setCreationHour(String creationHour) {
		this.creationHour = creationHour;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getMostScoredQuestion() {
		return mostScoredQuestion;
	}
	public void setMostScoredQuestion(String mostScoredQuestion) {
		this.mostScoredQuestion = mostScoredQuestion;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getFavouriteQuestion() {
		return favouriteQuestion;
	}
	public void setFavouriteQuestion(String favouriteQuestion) {
		this.favouriteQuestion = favouriteQuestion;
	}
	public String getFavouriteCount() {
		return favouriteCount;
	}
	public void setFavouriteCount(String favouriteCount) {
		this.favouriteCount = favouriteCount;
	}
	public String getOverviewQuestions() {
		return overviewQuestions;
	}
	public void setOverviewQuestions(String overviewQuestions) {
		this.overviewQuestions = overviewQuestions;
	}
}
