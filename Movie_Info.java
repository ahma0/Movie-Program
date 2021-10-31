package movie;

public class Movie_Info {		//영화 정보 저장
	
	private String name;
	private String genre;
	private double ratio;
	private int audience;
	private double ratioSum;
	
	Movie_Info(String name, String genre, int ratioSum, int ratio) {
		this.name = name;
		this.genre = genre;
		this.ratioSum = ratioSum;
		this.ratio = ratio;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setAudience(int audience) {
		this.audience = audience;
	}
	
	public int getAudience() {
		return audience;
	}
	
	public void setRatioSum(int ratioSum) {
		this.ratioSum = ratioSum;
	}
	
	public void setRatio(int ratio) {
			this.ratio = (double)(ratioSum + ratio)/audience;
	}
	
	public void getInfo() {
		System.out.println(name + " " + genre + " " + ratio);
	}
}
