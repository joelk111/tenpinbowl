package models;

/**
 * Frame
 * 
 * This is a class to model the bowling of a frame. It is only used for
 * prototyping the game itself and not needed for production.
 * 
 * @author joel kass
 *
 */
public class Frame {

	private int firstThrow;
	private int secondThrow;
	private int thirdThrow;
	private boolean isStrike;
	private boolean isSpare;
	private int score;
	private int frameInx;

	
	public Frame(int firstThrow, int secondThrow) {
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}

	public Frame() {

	}

	public int getFrameInx() {
		return frameInx;
	}

	public void setFrameInx(int frameInx) {
		this.frameInx = frameInx;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getFirstThrow() {
		return firstThrow;
	}

	public void setFirstThrow(int firstThrow) {
		this.firstThrow = firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}

	public void setSecondThrow(int secondThrow) {
		this.secondThrow = secondThrow;
	}

	public int getThirdThrow() {
		return thirdThrow;
	}

	public void setThirdThrow(int thirdThrow) {
		this.thirdThrow = thirdThrow;
	}

	public boolean isStrike() {
		return isStrike;
	}

	public void setStrike(boolean isStrike) {
		this.isStrike = isStrike;
	}

	public boolean isSpare() {
		return isSpare;
	}

	public void setSpare(boolean isSpare) {
		this.isSpare = isSpare;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + firstThrow;
		result = prime * result + frameInx;
		result = prime * result + (isSpare ? 1231 : 1237);
		result = prime * result + (isStrike ? 1231 : 1237);
		result = prime * result + score;
		result = prime * result + secondThrow;
		result = prime * result + thirdThrow;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Frame other = (Frame) obj;
		if (firstThrow != other.firstThrow)
			return false;
		if (frameInx != other.frameInx)
			return false;
		if (isSpare != other.isSpare)
			return false;
		if (isStrike != other.isStrike)
			return false;
		if (score != other.score)
			return false;
		if (secondThrow != other.secondThrow)
			return false;
		if (thirdThrow != other.thirdThrow)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Frame [firstThrow=" + firstThrow + ", secondThrow=" + secondThrow + ", thirdThrow=" + thirdThrow
				+ ", isStrike=" + isStrike + ", isSpare=" + isSpare + ", score=" + score + ", frameInx=" + frameInx
				+ "]";
	}

}